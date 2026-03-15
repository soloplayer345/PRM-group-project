package com.example.recipeapp.ui.shoppingList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recipeapp.data.dynamic_data.shopping.Shopping;
import com.example.recipeapp.data.static_data.Products;
import com.example.recipeapp.data.static_data.StaticIngredient;
import com.example.recipeapp.ui.BaseRecipeAndroidViewModel;
import com.example.recipeapp.util.FutureHelper;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListViewModel extends BaseRecipeAndroidViewModel {

    private final MutableLiveData<List<Integer>> productList = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<StaticIngredient>> ingredientList = new MutableLiveData<>(new ArrayList<>());
    private final LiveData<List<Shopping>> shoppingList;
    private final MutableLiveData<List<Boolean>> completeList = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<Boolean> checkStatePage = new MutableLiveData<>(true);
    private final Products products = new Products();

    public ShoppingListViewModel(@NonNull Application application) {
        super(application);
        shoppingList = container.getShoppingRepository().selectShopping();
    }

    public LiveData<List<Integer>> getProductList() {
        return productList;
    }

    public LiveData<List<StaticIngredient>> getIngredientList() {
        return ingredientList;
    }

    public LiveData<List<Shopping>> getShoppingList() {
        return shoppingList;
    }

    public LiveData<List<Boolean>> getCompleteList() {
        return completeList;
    }

    public LiveData<Boolean> getCheckStatePage() {
        return checkStatePage;
    }

    public void changeCheckStatePage() {
        Boolean current = checkStatePage.getValue();
        checkStatePage.setValue(current == null || !current);
    }

    public void deleteShoppingList(int idProduct) {
        FutureHelper.observe(container.getShoppingRepository().getIdShopping(idProduct), idShopping -> {
            if (idShopping != null) {
                container.getShoppingRepository().deleteShopping(new Shopping(idShopping, idProduct));
            }
        });
    }

    public void addListSelect(int idProduct) {
        List<Integer> current = new ArrayList<>(safeProductList());
        if (!current.contains(idProduct)) {
            current.add(idProduct);
            productList.setValue(current);
        }
        addListIngredient(idProduct);
    }

    public void deleteListSelect(int idProduct) {
        List<Integer> current = new ArrayList<>(safeProductList());
        if (current.remove((Integer) idProduct)) {
            productList.setValue(current);
        }
        deleteListIngredient(idProduct);
    }

    public boolean checkListSelect(int idProduct) {
        return safeProductList().contains(idProduct);
    }

    public void completeShopping() {
        for (Integer idProduct : new ArrayList<>(safeProductList())) {
            deleteShoppingList(idProduct);
        }
        productList.setValue(new ArrayList<>());
        ingredientList.setValue(new ArrayList<>());
        completeList.setValue(new ArrayList<>());
    }

    public void addListIngredient(int idProduct) {
        List<StaticIngredient> ingredients = products.getIngredient(idProduct);
        List<StaticIngredient> currentIngredients = new ArrayList<>(safeIngredientList());
        for (StaticIngredient ingredient : ingredients) {
            StaticIngredient existingIngredient = findById(currentIngredients, ingredient.getId());
            if (existingIngredient != null) {
                existingIngredient.setQuantity(calculateQuantities(existingIngredient.getQuantity(), ingredient.getQuantity(), true));
            } else {
                currentIngredients.add(ingredient.copy(ingredient.getQuantity()));
            }
        }
        ingredientList.setValue(currentIngredients);
        createElementForCompleteList();
    }

    public void deleteListIngredient(int idProduct) {
        List<StaticIngredient> ingredients = products.getIngredient(idProduct);
        List<StaticIngredient> currentIngredients = new ArrayList<>(safeIngredientList());
        List<Boolean> currentCompletes = new ArrayList<>(safeCompleteList());
        for (StaticIngredient ingredient : ingredients) {
            int index = indexOfIngredient(currentIngredients, ingredient.getId());
            if (index != -1) {
                StaticIngredient existingIngredient = currentIngredients.get(index);
                String newQuantity = calculateQuantities(existingIngredient.getQuantity(), ingredient.getQuantity(), false);
                existingIngredient.setQuantity(newQuantity);
                if (newQuantity.startsWith("0")) {
                    currentIngredients.remove(index);
                    if (index < currentCompletes.size()) {
                        currentCompletes.remove(index);
                    }
                }
            }
        }
        ingredientList.setValue(currentIngredients);
        completeList.setValue(currentCompletes);
    }

    public void createElementForCompleteList() {
        List<StaticIngredient> ingredients = safeIngredientList();
        List<Boolean> statuses = new ArrayList<>(safeCompleteList());
        while (statuses.size() < ingredients.size()) {
            statuses.add(false);
        }
        completeList.setValue(statuses);
    }

    public void updateCompleteList(int index) {
        List<Boolean> current = new ArrayList<>(safeCompleteList());
        if (index >= 0 && index < current.size()) {
            current.set(index, !current.get(index));
            completeList.setValue(current);
        }
    }

    private List<Integer> safeProductList() {
        List<Integer> value = productList.getValue();
        return value == null ? new ArrayList<>() : value;
    }

    private List<StaticIngredient> safeIngredientList() {
        List<StaticIngredient> value = ingredientList.getValue();
        return value == null ? new ArrayList<>() : value;
    }

    private List<Boolean> safeCompleteList() {
        List<Boolean> value = completeList.getValue();
        return value == null ? new ArrayList<>() : value;
    }

    private StaticIngredient findById(List<StaticIngredient> ingredients, int id) {
        for (StaticIngredient ingredient : ingredients) {
            if (ingredient.getId() == id) {
                return ingredient;
            }
        }
        return null;
    }

    private int indexOfIngredient(List<StaticIngredient> ingredients, int id) {
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private String calculateQuantities(String quantity1, String quantity2, boolean add) {
        ParsedQuantity q1 = parseQuantity(quantity1);
        ParsedQuantity q2 = parseQuantity(quantity2);
        if (!q1.unit.equals(q2.unit)) {
            throw new IllegalArgumentException("Don vi khong giong nhau: " + q1.unit + " va " + q2.unit);
        }
        int result = add ? q1.number + q2.number : q1.number - q2.number;
        return result + " " + q1.unit;
    }

    private ParsedQuantity parseQuantity(String input) {
        String[] parts = input.split(" ");
        int number = 0;
        if (parts.length > 0) {
            try {
                number = Integer.parseInt(parts[0]);
            } catch (NumberFormatException ignored) {
            }
        }
        StringBuilder unitBuilder = new StringBuilder();
        for (int i = 1; i < parts.length; i++) {
            if (unitBuilder.length() > 0) {
                unitBuilder.append(' ');
            }
            unitBuilder.append(parts[i]);
        }
        return new ParsedQuantity(number, unitBuilder.toString().trim());
    }

    private static class ParsedQuantity {
        final int number;
        final String unit;

        ParsedQuantity(int number, String unit) {
            this.number = number;
            this.unit = unit;
        }
    }
}

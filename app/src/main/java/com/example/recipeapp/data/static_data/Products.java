package com.example.recipeapp.data.static_data;

import android.content.Context;
import android.content.res.Resources;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Products {
    private static final String ASSET_FILE = "products.json";
    private static volatile Products instance;

    private final List<Product> productList;

    private final Ingredients ingredients = Ingredients.getInstance();
    private final List<Category> categories = Categories.getInstance().getCategoryList();

    private Products(Context context) {
        productList = loadProductsFromAsset(context.getApplicationContext());
    }

    public static void init(Context context) {
        if (instance == null) {
            synchronized (Products.class) {
                if (instance == null) {
                    instance = new Products(context);
                }
            }
        }
    }

    public static Products getInstance() {
        Products current = instance;
        if (current == null) {
            throw new IllegalStateException("Products is not initialized");
        }
        return current;
    }

    private List<Product> loadProductsFromAsset(Context context) {
        try {
            JSONObject root = new JSONObject(readAssetText(context, ASSET_FILE));
            JSONArray productsJson = root.getJSONArray("products");
            List<Product> result = new ArrayList<>();
            for (int i = 0; i < productsJson.length(); i++) {
                result.add(parseProduct(context, productsJson.getJSONObject(i)));
            }
            return result;
        } catch (IOException | JSONException e) {
            throw new IllegalStateException("Cannot load static products from assets", e);
        }
    }

    private Product parseProduct(Context context, JSONObject data) throws JSONException {
        int id = data.getInt("id");
        String name = data.getString("name");
        int image = resolveDrawable(context, data.getString("image"));
        int timeComplete = data.getInt("timeComplete");
        List<StaticIngredient> productIngredients = parseIngredients(data.getJSONArray("ingredients"));
        List<Procedure> procedures = parseProcedures(data.getJSONArray("procedures"));
        List<Category> productCategories = parseCategories(data.getJSONArray("categoryIds"));

        return new Product(id, name, image, timeComplete, productIngredients, procedures, productCategories);
    }

    private List<StaticIngredient> parseIngredients(JSONArray ingredientsJson) throws JSONException {
        List<StaticIngredient> list = new ArrayList<>();
        for (int i = 0; i < ingredientsJson.length(); i++) {
            JSONObject ingredient = ingredientsJson.getJSONObject(i);
            list.add(ingredient(ingredient.getInt("index"), ingredient.getString("quantity")));
        }
        return list;
    }

    private List<Procedure> parseProcedures(JSONArray proceduresJson) throws JSONException {
        List<Procedure> list = new ArrayList<>();
        for (int i = 0; i < proceduresJson.length(); i++) {
            JSONObject procedure = proceduresJson.getJSONObject(i);
            list.add(new Procedure(procedure.getString("step"), procedure.getString("des")));
        }
        return list;
    }

    private List<Category> parseCategories(JSONArray categoryIdsJson) throws JSONException {
        List<Category> list = new ArrayList<>();
        for (int i = 0; i < categoryIdsJson.length(); i++) {
            list.add(category(categoryIdsJson.getInt(i)));
        }
        return list;
    }

    private int resolveDrawable(Context context, String drawableName) {
        Resources resources = context.getResources();
        int id = resources.getIdentifier(drawableName, "drawable", context.getPackageName());
        if (id == 0) {
            throw new IllegalStateException("Drawable not found: " + drawableName);
        }
        return id;
    }

    private String readAssetText(Context context, String name) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (InputStream stream = context.getAssets().open(name);
             InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append('\n');
            }
        }
        return builder.toString();
    }

    private StaticIngredient ingredient(int index, String quantity) {
        return ingredients.get(index, quantity);
    }

    private Category category(int index) {
        return categories.get(index);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProduct(int idProduct) {
        for (Product product : productList) {
            if (product.getId() == idProduct) {
                return product;
            }
        }
        return null;
    }

    public String getNameProduct(int idProduct) {
        Product product = getProduct(idProduct);
        return product == null ? "" : product.getName();
    }

    public List<Product> getProductsByName(String text) {
        String query = text.toLowerCase(Locale.ROOT);
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase(Locale.ROOT).contains(query)) {
                result.add(product);
            }
        }
        return result;
    }

    public List<StaticIngredient> getIngredient(int idProduct) {
        Product product = getProduct(idProduct);
        return product == null ? new ArrayList<>() : product.getIngredient();
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            for (Category category : product.getCategory()) {
                if (category.getId() == categoryId) {
                    result.add(product);
                    break;
                }
            }
        }
        return result;
    }

    public List<Product> getRandomProducts() {
        return getRandomProducts(2);
    }

    public List<Product> getRandomProducts(int count) {
        List<Product> shuffled = new ArrayList<>(productList);
        Collections.shuffle(shuffled);
        return new ArrayList<>(shuffled.subList(0, Math.min(count, shuffled.size())));
    }

    public List<Product> getLastFiveProducts() {
        int fromIndex = Math.max(0, productList.size() - 5);
        return new ArrayList<>(productList.subList(fromIndex, productList.size()));
    }
}

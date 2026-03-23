package com.example.recipeapp.ui.schedule;

import android.app.Application;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recipeapp.data.dynamic_data.schedule.Schedule;
import com.example.recipeapp.data.static_data.Products;
import com.example.recipeapp.ui.BaseRecipeAndroidViewModel;

import java.time.LocalDate;
import java.util.List;

public class ScheduleViewModel extends BaseRecipeAndroidViewModel {

    private final MutableLiveData<Boolean> isDatePickerDialogOpen = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isDateSelectAndDatePicker = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isBottomSheetOpen = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isBottomSheetAdd = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isSelectMealOpen = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isPeopleOpen = new MutableLiveData<>(false);
    private final MutableLiveData<LocalDate> selectedDate = new MutableLiveData<>(LocalDate.now());
    private final MutableLiveData<String> nameProduct = new MutableLiveData<>("Lua chon cong thuc");
    private final MutableLiveData<String> mealValue = new MutableLiveData<>("bua sang");
    private final MutableLiveData<Integer> colorMeal = new MutableLiveData<>(Color.RED);
    private final MutableLiveData<Integer> numberPeople = new MutableLiveData<>(1);
    private final MutableLiveData<String> note = new MutableLiveData<>("");
    private final MutableLiveData<Integer> idSchedule = new MutableLiveData<>(0);
    private final Products products = Products.getInstance();

    public ScheduleViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getIsDatePickerDialogOpen() { return isDatePickerDialogOpen; }
    public LiveData<Boolean> getIsDateSelectAndDatePicker() { return isDateSelectAndDatePicker; }
    public LiveData<Boolean> getIsBottomSheetOpen() { return isBottomSheetOpen; }
    public LiveData<Boolean> getIsBottomSheetAdd() { return isBottomSheetAdd; }
    public LiveData<Boolean> getIsSelectMealOpen() { return isSelectMealOpen; }
    public LiveData<Boolean> getIsPeopleOpen() { return isPeopleOpen; }
    public LiveData<LocalDate> getSelectedDate() { return selectedDate; }
    public LiveData<String> getNameProduct() { return nameProduct; }
    public LiveData<String> getMealValue() { return mealValue; }
    public LiveData<Integer> getColorMeal() { return colorMeal; }
    public LiveData<Integer> getNumberPeople() { return numberPeople; }
    public LiveData<String> getNote() { return note; }
    public LiveData<Integer> getIdSchedule() { return idSchedule; }

    public void updateIsDatePickerDialogOpen(boolean value) { isDatePickerDialogOpen.setValue(value); }
    public void updateIsDateSelectAndDatePicker(boolean value) { isDateSelectAndDatePicker.setValue(value); }
    public void updateIsBottomSheetOpen(boolean value) { isBottomSheetOpen.setValue(value); }
    public void updateIsBottomSheetAdd(boolean value) { isBottomSheetAdd.setValue(value); }
    public void updateIsSelectMealOpen(boolean value) { isSelectMealOpen.setValue(value); }
    public void updateIsPeopleOpen(boolean value) { isPeopleOpen.setValue(value); }
    public void updateSelectDate(LocalDate value) { selectedDate.setValue(value); }
    public void updateMealValue(String value) { mealValue.setValue(value); }
    public void updateColorMeal(int value) { colorMeal.setValue(value); }
    public void updateNumberPeople(int value) { numberPeople.setValue(value); }
    public void updateNote(String value) { note.setValue(value); }
    public void updateIdSchedule(int value) { idSchedule.setValue(value); }

    public void updateNameProduct(int idProduct) {
        if (idProduct >= 0) {
            nameProduct.setValue(products.getNameProduct(idProduct));
        } else {
            nameProduct.setValue("Lua chon cong thuc");
        }
    }

    public int getColorForPosition(String position) {
        if ("Bữa sáng".equals(position)) return Color.RED;
        if ("Bữa trưa".equals(position)) return Color.YELLOW;
        if ("Bữa xế".equals(position)) return Color.GREEN;
        if ("Bữa chiều".equals(position)) return Color.GRAY;
        if ("Bữa tối".equals(position)) return Color.BLUE;
        return Color.BLACK;
    }

    public LiveData<List<Schedule>> getListSchedule(long date) {
        return container.getScheduleRepository().selectScheduleForDate(date);
    }

    public LiveData<List<String>> getPositionsForDate(long date) {
        return container.getScheduleRepository().selectPositionsForDate(date);
    }

    public void addSchedule(int idProduct) {
        LocalDate date = selectedDate.getValue() == null ? LocalDate.now() : selectedDate.getValue();
        if (idProduct >= 0) {
            container.getScheduleRepository().insertSchedule(new Schedule(
                    0,
                    valueOf(mealValue, ""),
                    valueOf(note, ""),
                    valueOf(numberPeople, 1),
                    ScheduleDateUtils.toMillis(date),
                    idProduct
            ));
        }
    }

    public void updateSchedule(int idProduct) {
        LocalDate date = selectedDate.getValue() == null ? LocalDate.now() : selectedDate.getValue();
        container.getScheduleRepository().updateSchedule(new Schedule(
                valueOf(idSchedule, 0),
                valueOf(mealValue, ""),
                valueOf(note, ""),
                valueOf(numberPeople, 1),
                ScheduleDateUtils.toMillis(date),
                idProduct
        ));
    }

    public void deleteSchedule(int idProduct) {
        LocalDate date = selectedDate.getValue() == null ? LocalDate.now() : selectedDate.getValue();
        container.getScheduleRepository().deleteSchedule(new Schedule(
                valueOf(idSchedule, 0),
                valueOf(mealValue, ""),
                valueOf(note, ""),
                valueOf(numberPeople, 1),
                ScheduleDateUtils.toMillis(date),
                idProduct
        ));
    }

    private <T> T valueOf(MutableLiveData<T> data, T fallback) {
        T value = data.getValue();
        return value == null ? fallback : value;
    }
}

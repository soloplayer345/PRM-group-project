package com.example.recipeapp.data.dynamic_data.recipe_person;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CongThucNguoiDung")
public class RecipePerson {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "I_id_cong_thuc_nd")
    public int id;

    @ColumnInfo(name = "T_ten_cong_thuc")
    public String nameRecipe;

    @ColumnInfo(name = "T_thgian")
    public String time;

    @ColumnInfo(name = "T_buoc_lam")
    public String step;

    public RecipePerson(int id, String nameRecipe, String time, String step) {
        this.id = id;
        this.nameRecipe = nameRecipe;
        this.time = time;
        this.step = step;
    }
}

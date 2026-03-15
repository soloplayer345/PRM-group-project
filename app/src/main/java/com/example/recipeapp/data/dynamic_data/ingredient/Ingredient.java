package com.example.recipeapp.data.dynamic_data.ingredient;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePerson;

@Entity(
    tableName = "NguyenLieu",
    indices = {@Index(value = {"I_id_cong_thuc_nd"})},
    foreignKeys = @ForeignKey(
        entity = RecipePerson.class,
        parentColumns = "I_id_cong_thuc_nd",
        childColumns = "I_id_cong_thuc_nd",
        onDelete = ForeignKey.CASCADE
    )
)
public class Ingredient {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "I_id_nguyen_lieu")
    public int id;

    @ColumnInfo(name = "T_ten_nguyen_lieu")
    public String nameIngre;

    @ColumnInfo(name = "T_trong_luong")
    public String weightIngre;

    @ColumnInfo(name = "I_id_cong_thuc_nd")
    public int idRecPer;

    public Ingredient(int id, String nameIngre, String weightIngre, int idRecPer) {
        this.id = id;
        this.nameIngre = nameIngre;
        this.weightIngre = weightIngre;
        this.idRecPer = idRecPer;
    }
}

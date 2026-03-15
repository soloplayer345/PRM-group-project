package com.example.recipeapp.data.dynamic_data.favourite;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "YeuThich")
public class Favourite {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "I_id_yeu_thich")
    public int id;

    @ColumnInfo(name = "I_id_san_pham")
    public int idProduct;

    public Favourite(int id, int idProduct) {
        this.id = id;
        this.idProduct = idProduct;
    }
}

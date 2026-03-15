package com.example.recipeapp.data.dynamic_data.shopping;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "MuaSam")
public class Shopping {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "I_id_mua_sam")
    public int id;

    @ColumnInfo(name = "I_id_san_pham")
    public int idProduct;

    public Shopping(int id, int idProduct) {
        this.id = id;
        this.idProduct = idProduct;
    }
}

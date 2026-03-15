package com.example.recipeapp.data.dynamic_data.schedule;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "LichTrinh")
public class Schedule {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "I_id_lich_trinh")
    public int id;

    @ColumnInfo(name = "T_vi_tri_bua_an")
    public String position;

    @ColumnInfo(name = "T_mo_ta")
    public String description;

    @ColumnInfo(name = "I_so_nguoi")
    public int numberPeople;

    @ColumnInfo(name = "L_ngay_duoc_chon")
    public long dueDate;

    @ColumnInfo(name = "I_id_san_pham")
    public int idProduct;

    public Schedule(int id, String position, String description, int numberPeople, long dueDate, int idProduct) {
        this.id = id;
        this.position = position;
        this.description = description;
        this.numberPeople = numberPeople;
        this.dueDate = dueDate;
        this.idProduct = idProduct;
    }
}

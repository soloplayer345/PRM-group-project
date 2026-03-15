package com.example.recipeapp.data.dynamic_data.schedule;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface ScheduleDao {

    @Insert
    ListenableFuture<Long> insertSchedule(Schedule schedule);

    @Update
    ListenableFuture<Integer> updateSchedule(Schedule schedule);

    @Delete
    ListenableFuture<Integer> deleteSchedule(Schedule schedule);

    @Query("SELECT * FROM lichtrinh WHERE L_ngay_duoc_chon = :date")
    LiveData<List<Schedule>> selectScheduleForDate(long date);

    @Query("SELECT I_id_san_pham FROM lichtrinh WHERE L_ngay_duoc_chon = :date")
    LiveData<List<Integer>> selectIdProductForDate(long date);

    @Query("SELECT T_vi_tri_bua_an FROM LichTrinh WHERE L_ngay_duoc_chon = :date")
    LiveData<List<String>> selectPositionsForDate(long date);
}

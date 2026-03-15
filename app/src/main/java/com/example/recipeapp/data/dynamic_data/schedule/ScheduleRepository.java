package com.example.recipeapp.data.dynamic_data.schedule;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public interface ScheduleRepository {
    ListenableFuture<Long> insertSchedule(Schedule schedule);
    ListenableFuture<Integer> updateSchedule(Schedule schedule);
    ListenableFuture<Integer> deleteSchedule(Schedule schedule);
    LiveData<List<Schedule>> selectScheduleForDate(long date);
    LiveData<List<Integer>> selectIdProductForDate(long date);
    LiveData<List<String>> selectPositionsForDate(long date);
}

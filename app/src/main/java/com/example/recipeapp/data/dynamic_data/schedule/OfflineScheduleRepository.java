package com.example.recipeapp.data.dynamic_data.schedule;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public class OfflineScheduleRepository implements ScheduleRepository {

    private final ScheduleDao scheduleDao;

    public OfflineScheduleRepository(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    @Override
    public ListenableFuture<Long> insertSchedule(Schedule schedule) {
        return scheduleDao.insertSchedule(schedule);
    }

    @Override
    public ListenableFuture<Integer> updateSchedule(Schedule schedule) {
        return scheduleDao.updateSchedule(schedule);
    }

    @Override
    public ListenableFuture<Integer> deleteSchedule(Schedule schedule) {
        return scheduleDao.deleteSchedule(schedule);
    }

    @Override
    public LiveData<List<Schedule>> selectScheduleForDate(long date) {
        return scheduleDao.selectScheduleForDate(date);
    }

    @Override
    public LiveData<List<Integer>> selectIdProductForDate(long date) {
        return scheduleDao.selectIdProductForDate(date);
    }

    @Override
    public LiveData<List<String>> selectPositionsForDate(long date) {
        return scheduleDao.selectPositionsForDate(date);
    }
}

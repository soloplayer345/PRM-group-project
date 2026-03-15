package com.example.recipeapp.data.static_data;

public class Procedure {
    private final String step;
    private final String des;

    public Procedure(String step, String des) {
        this.step = step;
        this.des = des;
    }

    public String getStep() { return step; }
    public String getDes() { return des; }
}

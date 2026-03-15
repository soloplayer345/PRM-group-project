package com.example.recipeapp.data.static_data;

public class FooterItem {
    private final int id;
    private final int iconResId;
    private boolean checked;

    public FooterItem(int id, int iconResId, boolean checked) {
        this.id = id;
        this.iconResId = iconResId;
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public int getIconResId() {
        return iconResId;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}

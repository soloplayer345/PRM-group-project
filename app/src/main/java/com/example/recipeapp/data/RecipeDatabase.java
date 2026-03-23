package com.example.recipeapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.migration.Migration;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;

import android.database.Cursor;

import com.example.recipeapp.data.dynamic_data.favourite.Favourite;
import com.example.recipeapp.data.dynamic_data.favourite.FavouriteDao;
import com.example.recipeapp.data.dynamic_data.ingredient.Ingredient;
import com.example.recipeapp.data.dynamic_data.ingredient.IngredientDao;
import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePerson;
import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePersonDao;
import com.example.recipeapp.data.dynamic_data.schedule.Schedule;
import com.example.recipeapp.data.dynamic_data.schedule.ScheduleDao;
import com.example.recipeapp.data.dynamic_data.shopping.Shopping;
import com.example.recipeapp.data.dynamic_data.shopping.ShoppingDao;

@Database(
        entities = {
                Favourite.class,
                Shopping.class,
                RecipePerson.class,
                Ingredient.class,
                Schedule.class
        },
        version = 4,
        exportSchema = false
)
public abstract class RecipeDatabase extends RoomDatabase {

    private static final Migration MIGRATION_1_4 = new Migration(1, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase db) {
            migrateToV4(db);
        }
    };

    private static final Migration MIGRATION_2_4 = new Migration(2, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase db) {
            migrateToV4(db);
        }
    };

    private static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase db) {
            migrateToV4(db);
        }
    };

    public abstract FavouriteDao favouriteDao();
    public abstract ShoppingDao shoppingDao();
    public abstract RecipePersonDao recipePersonDao();
    public abstract IngredientDao ingredientDao();
    public abstract ScheduleDao scheduleDao();

    private static volatile RecipeDatabase INSTANCE;

    public static RecipeDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (RecipeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    RecipeDatabase.class,
                                    "item_database"
                            )
                            .addMigrations(MIGRATION_1_4, MIGRATION_2_4, MIGRATION_3_4)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static void migrateToV4(SupportSQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=OFF");

        rebuildYeuThich(db);
        rebuildMuaSam(db);
        rebuildCongThucNguoiDung(db);
        rebuildNguyenLieu(db);
        rebuildLichTrinh(db);

        db.execSQL("PRAGMA foreign_keys=ON");
    }

    private static void rebuildYeuThich(SupportSQLiteDatabase db) {
        String table = "YeuThich";
        String backup = "YeuThich_legacy";
        if (tableExists(db, table)) {
            db.execSQL("ALTER TABLE " + table + " RENAME TO " + backup);
        }
        db.execSQL("CREATE TABLE IF NOT EXISTS YeuThich (I_id_yeu_thich INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, I_id_san_pham INTEGER NOT NULL)");
        if (tableExists(db, backup)) {
            String idExpr = columnExprOrDefault(db, backup, "I_id_yeu_thich", "NULL");
            String productExpr = columnExprOrDefault(db, backup, "I_id_san_pham", "0");
            db.execSQL("INSERT INTO YeuThich (I_id_yeu_thich, I_id_san_pham) SELECT " + idExpr + ", " + productExpr + " FROM " + backup);
            db.execSQL("DROP TABLE " + backup);
        }
    }

    private static void rebuildMuaSam(SupportSQLiteDatabase db) {
        String table = "MuaSam";
        String backup = "MuaSam_legacy";
        if (tableExists(db, table)) {
            db.execSQL("ALTER TABLE " + table + " RENAME TO " + backup);
        }
        db.execSQL("CREATE TABLE IF NOT EXISTS MuaSam (I_id_mua_sam INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, I_id_san_pham INTEGER NOT NULL)");
        if (tableExists(db, backup)) {
            String idExpr = columnExprOrDefault(db, backup, "I_id_mua_sam", "NULL");
            String productExpr = columnExprOrDefault(db, backup, "I_id_san_pham", "0");
            db.execSQL("INSERT INTO MuaSam (I_id_mua_sam, I_id_san_pham) SELECT " + idExpr + ", " + productExpr + " FROM " + backup);
            db.execSQL("DROP TABLE " + backup);
        }
    }

    private static void rebuildCongThucNguoiDung(SupportSQLiteDatabase db) {
        String table = "CongThucNguoiDung";
        String backup = "CongThucNguoiDung_legacy";
        if (tableExists(db, table)) {
            db.execSQL("ALTER TABLE " + table + " RENAME TO " + backup);
        }
        db.execSQL("CREATE TABLE IF NOT EXISTS CongThucNguoiDung (I_id_cong_thuc_nd INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, T_ten_cong_thuc TEXT, T_thgian TEXT, T_buoc_lam TEXT)");
        if (tableExists(db, backup)) {
            String idExpr = columnExprOrDefault(db, backup, "I_id_cong_thuc_nd", "NULL");
            String nameExpr = columnExprOrDefault(db, backup, "T_ten_cong_thuc", "NULL");
            String timeExpr = columnExprOrDefault(db, backup, "T_thgian", "NULL");
            String stepExpr = columnExprOrDefault(db, backup, "T_buoc_lam", "NULL");
            db.execSQL("INSERT INTO CongThucNguoiDung (I_id_cong_thuc_nd, T_ten_cong_thuc, T_thgian, T_buoc_lam) SELECT " + idExpr + ", " + nameExpr + ", " + timeExpr + ", " + stepExpr + " FROM " + backup);
            db.execSQL("DROP TABLE " + backup);
        }
    }

    private static void rebuildNguyenLieu(SupportSQLiteDatabase db) {
        String table = "NguyenLieu";
        String backup = "NguyenLieu_legacy";
        if (tableExists(db, table)) {
            db.execSQL("ALTER TABLE " + table + " RENAME TO " + backup);
        }
        db.execSQL("CREATE TABLE IF NOT EXISTS NguyenLieu (I_id_nguyen_lieu INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, T_ten_nguyen_lieu TEXT, T_trong_luong TEXT, I_id_cong_thuc_nd INTEGER NOT NULL, FOREIGN KEY(I_id_cong_thuc_nd) REFERENCES CongThucNguoiDung(I_id_cong_thuc_nd) ON DELETE CASCADE)");
        db.execSQL("CREATE INDEX IF NOT EXISTS index_NguyenLieu_I_id_cong_thuc_nd ON NguyenLieu (I_id_cong_thuc_nd)");
        if (tableExists(db, backup)) {
            String idExpr = columnExprOrDefault(db, backup, "I_id_nguyen_lieu", "NULL");
            String nameExpr = columnExprOrDefault(db, backup, "T_ten_nguyen_lieu", "NULL");
            String weightExpr = columnExprOrDefault(db, backup, "T_trong_luong", "NULL");
            String recipeExpr = columnExprOrDefault(db, backup, "I_id_cong_thuc_nd", "0");
            db.execSQL("INSERT INTO NguyenLieu (I_id_nguyen_lieu, T_ten_nguyen_lieu, T_trong_luong, I_id_cong_thuc_nd) SELECT " + idExpr + ", " + nameExpr + ", " + weightExpr + ", " + recipeExpr + " FROM " + backup);
            db.execSQL("DROP TABLE " + backup);
        }
    }

    private static void rebuildLichTrinh(SupportSQLiteDatabase db) {
        String table = "LichTrinh";
        String backup = "LichTrinh_legacy";
        if (tableExists(db, table)) {
            db.execSQL("ALTER TABLE " + table + " RENAME TO " + backup);
        }
        db.execSQL("CREATE TABLE IF NOT EXISTS LichTrinh (I_id_lich_trinh INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, T_vi_tri_bua_an TEXT, T_mo_ta TEXT, I_so_nguoi INTEGER NOT NULL, L_ngay_duoc_chon INTEGER NOT NULL, I_id_san_pham INTEGER NOT NULL)");
        if (tableExists(db, backup)) {
            String idExpr = columnExprOrDefault(db, backup, "I_id_lich_trinh", "NULL");
            String positionExpr = columnExprOrDefault(db, backup, "T_vi_tri_bua_an", "NULL");
            String descriptionExpr = columnExprOrDefault(db, backup, "T_mo_ta", "NULL");
            String peopleExpr = columnExprOrDefault(db, backup, "I_so_nguoi", "0");
            String dateExpr = columnExprOrDefault(db, backup, "L_ngay_duoc_chon", "0");
            String productExpr = columnExprOrDefault(db, backup, "I_id_san_pham", "0");
            db.execSQL("INSERT INTO LichTrinh (I_id_lich_trinh, T_vi_tri_bua_an, T_mo_ta, I_so_nguoi, L_ngay_duoc_chon, I_id_san_pham) SELECT " + idExpr + ", " + positionExpr + ", " + descriptionExpr + ", " + peopleExpr + ", " + dateExpr + ", " + productExpr + " FROM " + backup);
            db.execSQL("DROP TABLE " + backup);
        }
    }

    private static boolean tableExists(SupportSQLiteDatabase db, String tableName) {
        SupportSQLiteQuery query = new SimpleSQLiteQuery(
                "SELECT name FROM sqlite_master WHERE type='table' AND name=?",
                new Object[]{tableName}
        );
        Cursor cursor = db.query(query);
        try {
            return cursor.moveToFirst();
        } finally {
            cursor.close();
        }
    }

    private static boolean columnExists(SupportSQLiteDatabase db, String tableName, String columnName) {
        Cursor cursor = db.query("PRAGMA table_info(" + tableName + ")");
        try {
            int nameIndex = cursor.getColumnIndex("name");
            while (cursor.moveToNext()) {
                if (nameIndex >= 0 && columnName.equals(cursor.getString(nameIndex))) {
                    return true;
                }
            }
            return false;
        } finally {
            cursor.close();
        }
    }

    private static String columnExprOrDefault(SupportSQLiteDatabase db, String tableName, String columnName, String defaultExpr) {
        return columnExists(db, tableName, columnName) ? columnName : defaultExpr;
    }
}

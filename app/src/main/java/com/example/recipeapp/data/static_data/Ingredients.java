package com.example.recipeapp.data.static_data;

import com.example.recipeapp.R;

import java.util.ArrayList;
import java.util.List;

public class Ingredients {
    private final List<StaticIngredient> ingredientList;

    public Ingredients() {
        ingredientList = new ArrayList<>();
        ingredientList.add(new StaticIngredient(0,  "Thịt heo",      R.drawable.khong_thitheo_ing,    ""));
        ingredientList.add(new StaticIngredient(1,  "Tôm sú",         R.drawable.mot_tomsu_ing,         ""));
        ingredientList.add(new StaticIngredient(2,  "Thịt ba chỉ",    R.drawable.hai_thibachi_ing,      ""));
        ingredientList.add(new StaticIngredient(3,  "Chả lụa",        R.drawable.ba_chalua_ing,         ""));
        ingredientList.add(new StaticIngredient(4,  "Thịt heo xay",   R.drawable.bon_thitheoxay_ing,    ""));
        ingredientList.add(new StaticIngredient(5,  "Bắp bò",         R.drawable.nam_thitbapbo_ing,     ""));
        ingredientList.add(new StaticIngredient(6,  "Thịt gà",        R.drawable.sau_thitga_ing,        ""));
        ingredientList.add(new StaticIngredient(7,  "Mực",            R.drawable.bay_muc_ing,           ""));
        ingredientList.add(new StaticIngredient(8,  "Sườn non",       R.drawable.tam_suonnon_ing,       ""));
        ingredientList.add(new StaticIngredient(9,  "Cá",             R.drawable.chin_ca_ing,           ""));
        ingredientList.add(new StaticIngredient(10, "Thịt nạm",       R.drawable.muoi_thitnam_ing,      ""));
        ingredientList.add(new StaticIngredient(11, "Giò heo",        R.drawable.muoimot_gioheo_ing,    ""));
        ingredientList.add(new StaticIngredient(12, "Thịt bò tái",    R.drawable.muoihai_thitbotai_ing, ""));
        ingredientList.add(new StaticIngredient(13, "Chả cua",        R.drawable.muoiba_chacua_ing,     ""));
        ingredientList.add(new StaticIngredient(14, "Xà lách",        R.drawable.muoibon_xalach_ing,    ""));
        ingredientList.add(new StaticIngredient(15, "Rau thơm",       R.drawable.muoilam_rauthom_ing,   ""));
        ingredientList.add(new StaticIngredient(16, "Rau muống",      R.drawable.muoisau_raumuong_ing,  ""));
        ingredientList.add(new StaticIngredient(17, "Giá",            R.drawable.muoibay_giado_ing,     ""));
        ingredientList.add(new StaticIngredient(18, "Dưa leo",        R.drawable.muoitam_dualeo_ing,    ""));
        ingredientList.add(new StaticIngredient(19, "Cà rốt",         R.drawable.muoichin_carot_ing,    ""));
        ingredientList.add(new StaticIngredient(20, "Chuối chát",     R.drawable.haimuoi_chuoichat_ing, ""));
        ingredientList.add(new StaticIngredient(21, "Khế chua",       R.drawable.haimot_khechua_ing,    ""));
        ingredientList.add(new StaticIngredient(22, "Hành tím",       R.drawable.haihai_hanhtim_ing,    ""));
        ingredientList.add(new StaticIngredient(23, "Tỏi",            R.drawable.haiba_toi_ing,         ""));
        ingredientList.add(new StaticIngredient(24, "Hành lá",        R.drawable.haibon_hanhla_ing,     ""));
        ingredientList.add(new StaticIngredient(25, "Ngò gai",        R.drawable.hailam_ngogai_ing,     ""));
        ingredientList.add(new StaticIngredient(26, "Gừng",           R.drawable.haisau_gung_ing,       ""));
        ingredientList.add(new StaticIngredient(27, "Riềng",          R.drawable.haibay_rieng_ing,      ""));
        ingredientList.add(new StaticIngredient(28, "Sả",             R.drawable.haitam_sa_ing,         ""));
        ingredientList.add(new StaticIngredient(29, "Hành tây",       R.drawable.haichin_hanhtay_ing,   ""));
        ingredientList.add(new StaticIngredient(30, "Lá chanh",       R.drawable.bamuoi_lachanh_ing,    ""));
        ingredientList.add(new StaticIngredient(31, "Bí đỏ",          R.drawable.bamot_bido_ing,        ""));
        ingredientList.add(new StaticIngredient(32, "Măng chua",      R.drawable.bahai_mangchua_ing,    ""));
        ingredientList.add(new StaticIngredient(33, "Bắp chuối",      R.drawable.baba_bapchuoi_ing,     ""));
        ingredientList.add(new StaticIngredient(34, "Bún tươi",       R.drawable.babon_buntuoi_ing,     ""));
        ingredientList.add(new StaticIngredient(35, "Miến",           R.drawable.banam_mien_ing,        ""));
        ingredientList.add(new StaticIngredient(36, "Bánh tráng",     R.drawable.basau_banhtrang_ing,   ""));
        ingredientList.add(new StaticIngredient(37, "Mì quảng",       R.drawable.babay_miquang_ing,     ""));
        ingredientList.add(new StaticIngredient(38, "Bột mì",         R.drawable.batam_botmi_ing,       ""));
        ingredientList.add(new StaticIngredient(39, "Bột gạo",        R.drawable.bachin_botgao_ing,     ""));
        ingredientList.add(new StaticIngredient(40, "Nước mắm",       R.drawable.bonmuoi_nuocmam_ing,   ""));
        ingredientList.add(new StaticIngredient(41, "Đường",          R.drawable.bonmot_duong_ing,      ""));
        ingredientList.add(new StaticIngredient(42, "Nước cốt chanh", R.drawable.bonhai_nuoccotchanh_ing, ""));
        ingredientList.add(new StaticIngredient(43, "Ớt",             R.drawable.bonba_ot,              ""));
        ingredientList.add(new StaticIngredient(44, "Muối",           R.drawable.bonbon_muoi_ing,       ""));
        ingredientList.add(new StaticIngredient(45, "Nước lọc",       R.drawable.bonnam_nuocloc_ing,    ""));
        ingredientList.add(new StaticIngredient(46, "Bột ngọt",       R.drawable.bonsau_botngot_ing,    ""));
        ingredientList.add(new StaticIngredient(47, "Tiêu",           R.drawable.bonbay_tieu_ing,       ""));
        ingredientList.add(new StaticIngredient(48, "Hạt nêm",        R.drawable.bontam_hatnem_ing,     ""));
        ingredientList.add(new StaticIngredient(49, "Nước cốt dừa",   R.drawable.bonchin_nuocdua_ing,   ""));
        ingredientList.add(new StaticIngredient(50, "Nước tương",     R.drawable.nammuoi_nuoctuong_ing, ""));
        ingredientList.add(new StaticIngredient(51, "Dầu ăn",         R.drawable.nammot_dauan_ing,      ""));
        ingredientList.add(new StaticIngredient(52, "Mật ong",        R.drawable.namhai_matong_ing,     ""));
        ingredientList.add(new StaticIngredient(53, "Ngũ vị hương",   R.drawable.namba_nguvihuong_ing,  ""));
        ingredientList.add(new StaticIngredient(54, "Tương ớt",       R.drawable.nambon_tuongot_ing,    ""));
        ingredientList.add(new StaticIngredient(55, "Trứng gà",       R.drawable.namnam_trungga_ing,    ""));
        ingredientList.add(new StaticIngredient(56, "Trứng cút",      R.drawable.namsau_trungcut_ing,   ""));
        ingredientList.add(new StaticIngredient(57, "Me",             R.drawable.nambay_me_ing,         ""));
        ingredientList.add(new StaticIngredient(58, "Lạc",            R.drawable.namtam_lacrang_ing,    ""));
        ingredientList.add(new StaticIngredient(59, "Đậu xanh",       R.drawable.namchin_dauxanh_ing,   ""));
        ingredientList.add(new StaticIngredient(60, "Hạt sen",        R.drawable.saumuoi_hatsen_ing,    ""));
        ingredientList.add(new StaticIngredient(61, "Sữa tươi",       R.drawable.saumot_suatuoi_ing,    ""));
        ingredientList.add(new StaticIngredient(62, "Sữa chua",       R.drawable.sauhai_suachua_ing,    ""));
        ingredientList.add(new StaticIngredient(63, "Xương heo",      R.drawable.sauba_xuongheo_ing,    ""));
        ingredientList.add(new StaticIngredient(64, "Nấm",            R.drawable.saubon_nam_ing,        ""));
        ingredientList.add(new StaticIngredient(65, "Đường phèn",     R.drawable.saunam_duongphen_ing,  ""));
        ingredientList.add(new StaticIngredient(66, "Phở",            R.drawable.sausau_pho_ing,        ""));
        ingredientList.add(new StaticIngredient(67, "Súp lơ",         R.drawable.saubay_suploxanh_ing,  ""));
        ingredientList.add(new StaticIngredient(68, "Bắp cải",        R.drawable.sautam_bapcai_ing,     ""));
    }

    public List<StaticIngredient> getIngredientList() {
        return ingredientList;
    }

    // Helper: get a copy of ingredient at index with a new quantity
    public StaticIngredient get(int index, String quantity) {
        StaticIngredient orig = ingredientList.get(index);
        return new StaticIngredient(orig.getId(), orig.getName(), orig.getImage(), quantity);
    }
}

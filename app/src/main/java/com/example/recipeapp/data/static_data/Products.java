package com.example.recipeapp.data.static_data;

import com.example.recipeapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Products {
    public final List<Product> productList;

    private final Ingredients ingredients = new Ingredients();
    private final List<Category> categories = new Categories().getCategoryList();

    public Products() {
        productList = new ArrayList<>(Arrays.asList(
            new Product(
                0,
                "Gỏi cuốn",
                R.drawable.mot_goicuon_re,
                35,
                Arrays.asList(
                    ingredient(0, "300 g"),
                    ingredient(1, "200 g"),
                    ingredient(2, "200 g"),
                    ingredient(3, "200 g"),
                    ingredient(34, "300 g"),
                    ingredient(55, "2 quả"),
                    ingredient(14, "1 cây"),
                    ingredient(16, "200 g"),
                    ingredient(17, "200 g"),
                    ingredient(18, "2 trái"),
                    ingredient(19, "1 củ"),
                    ingredient(36, "200 g"),
                    ingredient(40, "3 muỗng canh"),
                    ingredient(42, "2 muỗng canh"),
                    ingredient(44, "1 muỗng cà phê")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "1.\tThịt heo: Rửa sạch, cho vào nồi luộc chín cùng 1 ít muối. Vớt thịt ra để nguội, xé nhỏ.\n2.\tTôm sú: Bóc vỏ, bỏ đầu, chỉ đen, rửa sạch. Cho tôm vào nồi luộc chín. Vớt tôm ra để nguội, cắt đôi.\n3.\tThịt ba chỉ: Rửa sạch, cho vào nồi luộc chín. Vớt thịt ra để nguội, cắt lát mỏng.\n4.\tChả lụa: Cắt lát mỏng.\n5.\tBún tươi: Chần qua nước sôi, vớt ra để ráo.\n6.\tTrứng gà: Luộc chín, bóc vỏ, cắt đôi.\n7.\tRau sống: Rửa sạch, để ráo. Xà lách, rau thơm, húng quế, húng lủi, diếp cá cắt nhỏ. Rau muống bào, giá đỗ rửa sạch.\n8.\tDưa leo: Rửa sạch, cắt sợi.\n9.\tCà rốt: Gọt vỏ, bào sợi.\n10.\tNước chấm: Pha nước mắm, đường, nước cốt chanh, tỏi băm, ớt băm, muối, nước lọc.\n"),
                    new Procedure("Bước 2: Cuốn gỏi", "1.\tTrải bánh tráng ra một mặt phẳng, nhúng bánh tráng vào nước ấm cho mềm.\n2.\tXếp lần lượt rau sống, bún, thịt heo, tôm sú, thịt ba chỉ, chả lụa, trứng gà, dưa leo, cà rốt lên bánh tráng.\n3.\tCuốn bánh tráng lại cho chặt tay.\n")
                ),
                Arrays.asList(category(0))
            ),
            new Product(
                1,
                "Nem rán",
                R.drawable.hai_nemran_re,
                60,
                Arrays.asList(
                    ingredient(0, "500 g"),
                    ingredient(35, "100 g"),
                    ingredient(64, "50 g"),
                    ingredient(54, "1 chén"),
                    ingredient(22, "5 củ"),
                    ingredient(40, "3 muỗng canh"),
                    ingredient(44, "1 muỗng cà phê"),
                    ingredient(48, "1 muỗng cà phê"),
                    ingredient(42, "1 muỗng canh"),
                    ingredient(23, "2 tép"),
                    ingredient(43, "1 trái"),
                    ingredient(18, "2 trái")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tThịt heo: Rửa sạch, xay nhuyễn.\n•\tMỡ heo: Rửa sạch, xay nhuyễn.\n•\tMiến: Ngâm mềm, cắt nhỏ.\n•\tNấm mèo: Ngâm mềm, cắt nhỏ.\n•\tTrứng gà: Đánh tan.\n•\tHành tím: Băm nhuyễn.\n•\tGia vị: Pha hỗn hợp gồm nước mắm, đường, bột ngọt, tiêu, muối, hạt nêm, nước cốt chanh, tỏi băm, ớt băm.\n•\tRau sống: Rửa sạch, để ráo. Xà lách, rau thơm, húng quế, húng lủi, diếp cá cắt nhỏ. Rau muống bào, giá đỗ rửa sạch.\n•\tDưa leo: Rửa sạch, cắt sợi.\n•\tCà rốt: Gọt vỏ, bào sợi.\n"),
                    new Procedure("Bước 2: Trộn nhân nem", "•\tCho thịt xay, mỡ xay, miến, nấm mèo, hành tím băm, hỗn hợp gia vị vào tô lớn, trộn đều.\n•\tƯớp nhân trong 30 phút cho thấm gia vị.\n"),
                    new Procedure("Bước 3: Gói nem", "•\tTrải bánh tráng nem ra mặt phẳng, thoa một lớp trứng gà mỏng lên bánh tráng.\n•\tCho một lượng nhân vừa đủ vào giữa bánh tráng.\n•\tCuốn nem lại cho chặt tay.\n"),
                    new Procedure("Bước 4: Rán nem", "•\tCho dầu ăn vào chảo, đun nóng.\n•\tCho nem vào rán vàng đều hai mặt.\n•\tVớt nem ra để ráo dầu.\n")
                ),
                Arrays.asList(category(0))
            ),
            new Product(
                2,
                "Chả giò",
                R.drawable.ba_chagio_re,
                45,
                Arrays.asList(
                    ingredient(36, "200 g"),
                    ingredient(54, "1 chén"),
                    ingredient(0, "300 g"),
                    ingredient(64, "50 g"),
                    ingredient(35, "100 g"),
                    ingredient(19, "1 củ"),
                    ingredient(22, "5 củ"),
                    ingredient(40, "3 muỗng canh"),
                    ingredient(44, "1 muỗng cà phê"),
                    ingredient(49, "1 muỗng canh"),
                    ingredient(42, "1 muỗng canh"),
                    ingredient(23, "2 tép"),
                    ingredient(43, "1 trái")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tVỏ: Bánh tráng nem ngâm mềm trong nước ấm. Trứng gà đánh tan.\n•\tNhân: Thịt heo xay, tôm sú bóc vỏ, chỉ đen, rửa sạch. Nấm mèo ngâm mềm, cắt nhỏ. Miến ngâm mềm, cắt nhỏ. Cà rốt, khoai môn gọt vỏ, bào sợi. Hành tím băm nhuyễn. Pha hỗn hợp gia vị gồm nước mắm, đường, bột ngọt, tiêu, muối, hạt nêm, nước cốt chanh, tỏi băm, ớt băm. Rau sống rửa sạch, để ráo. Bún tươi chần qua nước sôi, vớt ra để ráo.\n•\tNước mắm chua ngọt: Pha nước mắm, đường, chanh, tỏi ớt băm.\n"),
                    new Procedure("Bước 2: Trộn nhân chả giò", "•\tCho thịt xay, tôm sú, nấm mèo, miến, cà rốt, khoai môn, hành tím băm, hỗn hợp gia vị vào tô lớn, trộn đều.\n•\tƯớp nhân trong 30 phút cho thấm gia vị.\n"),
                    new Procedure("Bước 3: Cuốn chả giò", "•\tTrải bánh tráng nem ra mặt phẳng, thoa một lớp trứng gà mỏng lên bánh tráng.\n•\tCho một lượng nhân vừa đủ vào giữa bánh tráng.\n•\tCuốn chả giò lại cho chặt tay.\n"),
                    new Procedure("Bước 4: Chiên chả giò", "•\tCho dầu ăn vào chảo, đun nóng.\n•\tCho chả giò vào chiên vàng đều hai mặt.\n•\tVớt chả giò ra để ráo dầu.\n")
                ),
                Arrays.asList(category(1))
            ),
            new Product(
                3,
                "Gỏi bò",
                R.drawable.bon_goibo_re,
                30,
                Arrays.asList(
                    ingredient(5, "500 g"),
                    ingredient(29, "1 củ"),
                    ingredient(19, "1 củ"),
                    ingredient(20, "2 quả"),
                    ingredient(21, "1 quả"),
                    ingredient(16, "1 bó"),
                    ingredient(58, "100 g"),
                    ingredient(40, "3 muỗng canh"),
                    ingredient(41, "2 muỗng cà phê"),
                    ingredient(23, "3 tép"),
                    ingredient(43, "1 trái"),
                    ingredient(44, "1 muỗng cà phê"),
                    ingredient(45, "100 ml")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tThịt bắp bò: Luộc chín, vớt ra để nguội, xé nhỏ.\n•\tHành tây: Cắt lát mỏng.\n•\tCà rốt: Gọt vỏ, bào sợi.\n•\tChuối chát: Gọt vỏ, bào sợi.\n•\tKhế chua: Gọt vỏ, cắt lát mỏng.\n•\tRau thơm: Rửa sạch, cắt nhỏ.\n•\tLạc rang, đậu phộng rang: Giã nhỏ.\n•\tGia vị: Pha nước mắm, đường, nước cốt chanh, tỏi băm, ớt băm, muối, nước lọc.\n"),
                    new Procedure("Bước 2: Trộn gỏi", "•\tCho thịt bò, hành tây, cà rốt, chuối chát, khế chua, rau thơm vào tô lớn, trộn đều.\n•\tRưới nước mắm pha lên trên, trộn đều cho gỏi thấm gia vị. Bánh tráng trộn\n")
                ),
                Arrays.asList(category(0))
            ),
            new Product(
                4,
                "Đậu phộng rang muối ớt",
                R.drawable.nam_dauphongranmuoiot_re,
                20,
                Arrays.asList(
                    ingredient(58, "500 g"),
                    ingredient(44, "1 muỗng canh"),
                    ingredient(43, "3 trái"),
                    ingredient(41, "1 muỗng cà phê"),
                    ingredient(51, "2 muỗng canh"),
                    ingredient(30, "5 lá"),
                    ingredient(23, "2 tép")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tĐậu phộng: Rửa sạch, để ráo. Nên chọn những hạt đậu phộng to, đều, không bị lép, mốc.\n•\tMuối: Cho vào chảo, rang trên lửa nhỏ cho đến khi muối chuyển sang màu vàng nhạt và dậy mùi thơm.\n•\tỚt bột: Chuẩn bị sẵn hoặc tự làm bằng cách phơi khô ớt tươi, xay nhuyễn.\n•\tLá chanh: Rửa sạch, cắt sợi (tùy chọn).\n•\tTỏi: Băm nhuyễn (tùy chọn).\n"),
                    new Procedure("Bước 2: Rang đậu phộng", "•\tPhương pháp 1 (rang trên bếp):\no\tCho dầu ăn vào chảo, đun nóng.\no\tCho đậu phộng vào chảo, đảo đều cho đến khi đậu vàng giòn.\no\tVớt đậu phộng ra đĩa để ráo dầu.\n•\tPhương pháp 2 (rang bằng nồi chiên không dầu):\no\tXếp đậu phộng vào nồi chiên không dầu.\no\tSet nhiệt độ 180 độ C, hẹn giờ 15-20 phút.\no\tLấy đậu phộng ra khỏi nồi, đảo đều cho đến khi nguội bớt.\n")
                ),
                Arrays.asList(category(0))
            ),
            new Product(
                5,
                "Cá kho tộ",
                R.drawable.sau_cakhoto_re,
                90,
                Arrays.asList(
                    ingredient(9, "1 kg"),
                    ingredient(22, "10 củ"),
                    ingredient(23, "5 tép"),
                    ingredient(43, "2 trái"),
                    ingredient(26, "1 củ"),
                    ingredient(27, "1 củ"),
                    ingredient(24, "2 cây"),
                    ingredient(25, "2 cây"),
                    ingredient(40, "3 muỗng canh"),
                    ingredient(42, "2 muỗng canh"),
                    ingredient(48, "1 muỗng cà phê"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(49, "2 muỗng canh"),
                    ingredient(51, "2 muỗng canh")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tCá: Rửa sạch, cắt khúc vừa ăn. Ướp cá với 1 muỗng cà phê muối, 1 muỗng cà phê tiêu trong 15 phút.\n•\tThịt ba chỉ: Rửa sạch, cắt miếng vừa ăn.\n•\tHành tím: Băm nhuyễn.\n•\tTỏi: Băm nhuyễn.\n•\tỚt: Băm nhuyễn.\n•\tGừng: Gọt vỏ, băm nhuyễn.\n•\tRiềng: Gọt vỏ, băm nhuyễn.\n•\tHành lá, ngò gai: Rửa sạch, cắt nhỏ.\n"),
                    new Procedure("Bước 2: Kho cá", "•\tCho dầu ăn vào tộ đất, phi thơm hành tím băm.\n•\tCho thịt ba chỉ vào xào săn.\n•\tCho cá vào kho cùng, đảo nhẹ cho cá thấm gia vị.\n•\tNêm thêm nước mắm, đường, hạt nêm, tiêu, gừng băm, riềng băm, ớt băm.\n•\tCho nước dừa tươi (hoặc nước lọc) vào xâm xấp mặt cá.\n•\tKho cá với lửa nhỏ trong khoảng 45-60 phút cho đến khi cá chín mềm và nước kho sánh lại.\n"),
                    new Procedure("Bước 3: Hoàn thành", "•\tTắt bếp, cho hành lá, ngò gai cắt nhỏ vào đảo đều.\n•\tMúc cá kho tộ ra đĩa và thưởng thức nóng với cơm trắng.\n")
                ),
                Arrays.asList(category(1))
            ),
            new Product(
                6,
                "Thịt kho tàu",
                R.drawable.bay_thitkhotau_re,
                120,
                Arrays.asList(
                    ingredient(2, "500 g"),
                    ingredient(55, "10 quả"),
                    ingredient(49, "2 muỗng canh"),
                    ingredient(22, "10 củ"),
                    ingredient(23, "5 tép"),
                    ingredient(43, "4 trái"),
                    ingredient(26, "1 củ"),
                    ingredient(27, "1 củ"),
                    ingredient(24, "2 cây"),
                    ingredient(25, "2 cây"),
                    ingredient(40, "3 muỗng canh"),
                    ingredient(41, "2 muỗng canh"),
                    ingredient(47, "1 muỗng canh"),
                    ingredient(48, "1 muỗng canh"),
                    ingredient(51, "2 muỗng canh")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tThịt ba chỉ: Rửa sạch, cắt miếng vuông vừa ăn. Ướp thịt với 1 muỗng cà phê muối, 1 muỗng cà phê tiêu trong 15 phút.\n•\tTrứng gà: Luộc chín, bóc vỏ.\n•\tHành tím: Băm nhuyễn.\n•\tTỏi: Băm nhuyễn.\n•\tỚt: Băm nhuyễn.\n•\tGừng: Gọt vỏ, băm nhuyễn.\n•\tRiềng: Gọt vỏ, băm nhuyễn.\n•\tHành lá, ngò gai: Rửa sạch, cắt nhỏ.\n"),
                    new Procedure("Bước 2: Kho thịt", "•\tCho dầu ăn vào nồi, phi thơm hành tím băm.\n•\tCho thịt ba chỉ vào xào săn.\n•\tNêm thêm nước mắm, đường, hạt nêm, tiêu, gừng băm, riềng băm, ớt băm.\n•\tCho nước dừa tươi (hoặc nước lọc) vào xâm xấp mặt thịt.\n•\tKho thịt với lửa nhỏ trong khoảng 45-60 phút cho đến khi thịt chín mềm và nước kho sánh lại.\n•\tCho trứng gà đã luộc chín vào kho cùng thịt trong 10 phút.\n"),
                    new Procedure("Bước 3: Hoàn thành", "•\tTắt bếp, cho hành lá, ngò gai cắt nhỏ vào đảo đều.\n•\tNêm nếm gia vị cho vừa ăn (nếu cần thiết).\n•\tMúc thịt kho tàu ra đĩa và thưởng thức nóng với cơm trắng.\n")
                ),
                Arrays.asList(category(1))
            ),
            new Product(
                7,
                "Sườn rim nước dừa",
                R.drawable.tam_suonrimnuocdua_re,
                60,
                Arrays.asList(
                    ingredient(8, "500 g"),
                    ingredient(49, "2 muỗng canh"),
                    ingredient(22, "5 củ"),
                    ingredient(23, "3 tép"),
                    ingredient(43, "2 trái"),
                    ingredient(26, "1 củ"),
                    ingredient(27, "1 củ"),
                    ingredient(24, "2 cây"),
                    ingredient(25, "2 cây"),
                    ingredient(40, "3 muỗng canh"),
                    ingredient(41, "2 muỗng cà phê"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(48, "1 muỗng cà phê"),
                    ingredient(44, "1 muỗng cà phê"),
                    ingredient(51, "2 muỗng canh")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tSườn non: Rửa sạch, chặt miếng vừa ăn. Ướp sườn với 1 muỗng cà phê muối, 1 muỗng cà phê tiêu trong 15 phút.\n•\tHành tím: Băm nhuyễn.\n•\tTỏi: Băm nhuyễn.\n•\tỚt: Băm nhuyễn.\n•\tGừng: Gọt vỏ, băm nhuyễn.\n•\tRiềng: Gọt vỏ, băm nhuyễn.\n•\tHành lá, ngò gai: Rửa sạch, cắt nhỏ.\n"),
                    new Procedure("Bước 2: Rim sườn", "•\tCho dầu ăn vào chảo, phi thơm hành tím băm.\n•\tCho sườn vào xào săn.\n•\tNêm thêm nước mắm, đường, hạt nêm, tiêu, gừng băm, riềng băm, ớt băm.\n•\tCho nước dừa tươi vào xâm xấp mặt sườn.\n•\tRim sườn với lửa nhỏ trong khoảng 45-60 phút cho đến khi sườn chín mềm và nước rim sánh lại.\n"),
                    new Procedure("Bước 3: Hoàn thành", "•\tTắt bếp, cho hành lá, ngò gai cắt nhỏ vào đảo đều.\n•\tNêm nếm gia vị cho vừa ăn (nếu cần thiết).\n•\tMúc sườn rim nước dừa ra đĩa và thưởng thức nóng với cơm trắng.\n")
                ),
                Arrays.asList(category(1))
            ),
            new Product(
                8,
                "Gà kho sả ớt",
                R.drawable.chin_gakhosaot_re,
                45,
                Arrays.asList(
                    ingredient(6, "1 con"),
                    ingredient(28, "5 củ"),
                    ingredient(43, "5 trái"),
                    ingredient(26, "1 củ"),
                    ingredient(23, "5 tép"),
                    ingredient(22, "10 củ"),
                    ingredient(30, "5 lá"),
                    ingredient(40, "3 muỗng canh"),
                    ingredient(41, "1 muỗng cà phê"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(48, "1 muỗng cà phê"),
                    ingredient(44, "1 muỗng cà phê"),
                    ingredient(51, "2 muỗng canh")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tGà: Rửa sạch, chặt miếng vừa ăn. Ướp gà với 1 muỗng cà phê muối, 1 muỗng cà phê tiêu trong 15 phút.\n•\tSả: Cắt khúc, băm nhuyễn phần gốc. Phần thân sả đập dập.\n•\tỚt: Băm nhuyễn.\n•\tGừng: Gọt vỏ, băm nhuyễn.\n•\tTỏi: Băm nhuyễn.\n•\tHành tím: Băm nhuyễn.\n•\tRễ ngò: Băm nhuyễn (tùy chọn).\n•\tLá chanh: Rửa sạch, cắt sợi (tùy chọn).\n"),
                    new Procedure("Bước 2: Kho gà", "•\tCho dầu ăn vào nồi, phi thơm hành tím băm.\n•\tCho sả băm vào xào cho đến khi thơm.\n•\tCho gà vào xào săn.\n•\tNêm thêm nước mắm, đường, hạt nêm, tiêu, gừng băm, ớt băm, rễ ngò băm (nếu sử dụng).\n•\tCho nước dừa tươi (hoặc nước lọc) vào xâm xấp mặt gà.\n•\tKho gà với lửa nhỏ trong khoảng 45-60 phút cho đến khi gà chín mềm và nước kho sánh lại.\n•\tCho sả đập dập vào kho cùng trong 15 phút cuối cùng.\n•\tNêm nếm gia vị cho vừa ăn (nếu cần thiết).\n"),
                    new Procedure("Bước 3: Hoàn thành", "•\tTắt bếp, cho lá chanh cắt sợi (nếu sử dụng) vào đảo đều.\n•\tMúc gà kho sả ớt ra đĩa và thưởng thức nóng với cơm trắng.\n")
                ),
                Arrays.asList(category(1))
            ),
            new Product(
                9,
                "Tôm rim me",
                R.drawable.muoi_tomrimme_re,
                30,
                Arrays.asList(
                    ingredient(1, "500 g"),
                    ingredient(57, "100 g"),
                    ingredient(40, "3 muỗng canh"),
                    ingredient(41, "2 muỗng cà phê"),
                    ingredient(43, "2 trái"),
                    ingredient(22, "5 củ"),
                    ingredient(26, "2 củ"),
                    ingredient(51, "2 muỗng canh"),
                    ingredient(24, "2 cọng"),
                    ingredient(45, "200 ml")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tTôm rửa sạch, bóc vỏ, bỏ đầu và chỉ đen. Ướp tôm với 1 muỗng cà phê muối, 1 muỗng cà phê tiêu trong 15 phút.\n•\tMe chín: Ngâm me với nước ấm cho me mềm ra, lọc lấy phần nước cốt me.\n•\tỚt: Băm nhuyễn.\n•\tTỏi: Băm nhuyễn.\n•\tHành tím: Băm nhuyễn.\n•\tGừng: Gọt vỏ, băm nhuyễn.\n•\tHành lá, ngò rí: Rửa sạch, cắt nhỏ.\n"),
                    new Procedure("Bước 2: Rim tôm", "•\tCho dầu ăn vào chảo, phi thơm hành tím băm.\n•\tCho tôm vào xào săn.\n•\tNêm thêm nước mắm, đường, gừng băm, ớt băm.\n•\tĐảo đều cho tôm thấm gia vị.\n•\tCho nước cốt me và nước lọc (hoặc nước dừa tươi) vào xâm xấp mặt tôm.\n•\tRim tôm với lửa nhỏ trong khoảng 15-20 phút cho đến khi tôm chín mềm và nước rim sánh lại.\n"),
                    new Procedure("Bước 3: Hoàn thành", "•\tTắt bếp, cho hành lá, ngò rí cắt nhỏ vào đảo đều.\n•\tNêm nếm gia vị cho vừa ăn (nếu cần thiết).\n•\tMúc tôm rim me ra đĩa và thưởng thức nóng với cơm trắng.\n")
                ),
                Arrays.asList(category(1))
            ),
            new Product(
                10,
                "Lẩu thái",
                R.drawable.muoimot_lauthai_re,
                120,
                Arrays.asList(
                    ingredient(63, "1 kg"),
                    ingredient(49, "2 muỗng canh"),
                    ingredient(29, "1 củ"),
                    ingredient(28, "3 củ"),
                    ingredient(26, "1 củ"),
                    ingredient(27, "1 củ"),
                    ingredient(30, "5 lá"),
                    ingredient(57, "100 g"),
                    ingredient(12, "500 g"),
                    ingredient(1, "500 g"),
                    ingredient(7, "500 g"),
                    ingredient(9, "500 g"),
                    ingredient(15, "4 g"),
                    ingredient(14, "20 g"),
                    ingredient(34, "100 g"),
                    ingredient(40, "2 muỗng canh"),
                    ingredient(41, "1 muỗng cà phê"),
                    ingredient(42, "2 muỗng canh"),
                    ingredient(43, "5 trái"),
                    ingredient(44, "3 muỗng cà phê")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Nấu nước dùng lẩu", "•\tRửa sạch xương heo, cho vào nồi luộc sơ qua để lấy đi phần nước bẩn.\n•\tCho xương heo vào nồi, đổ nước dừa tươi vào hầm trong khoảng 1-2 tiếng cho đến khi xương mềm và nước dùng ngọt.\n•\tNướng cà chua, hành tây, sả, gừng, riềng cho đến khi thơm.\n•\tBăm nhuyễn cà chua, hành tây, sả, gừng, riềng.\n•\tCho hỗn hợp cà chua, hành tây, sả, gừng, riềng băm nhuyễn vào nồi nước dùng, nêm thêm muối, đường, hạt nêm, nước mắm cho vừa ăn.\n•\tCho lá chanh vào nồi nước dùng, nấu thêm 10 phút rồi tắt bếp.\n"),
                    new Procedure("Bước 2: Sơ chế nguyên liệu nhúng lẩu", "•\tThịt bò rửa sạch, thái mỏng.\n•\tTôm sú rửa sạch, bóc vỏ, bỏ đầu và chỉ đen.\n•\tMực rửa sạch, thái khoanh.\n•\tCá viên cắt đôi.\n•\tRau củ rửa sạch, cắt khúc vừa ăn.\n•\tBún tươi, mì gói ngâm nước cho mềm.\n"),
                    new Procedure("Bước 3: Chuẩn bị gia vị chấm", "•\tPha nước mắm với ớt, chanh, tỏi băm nhuyễn."),
                    new Procedure("Bước 4: Thưởng thức", "•\tCho nước dùng lẩu vào nồi, đun sôi.\n•\tCho các nguyên liệu nhúng lẩu vào nồi nước dùng, nấu chín.\n•\tĂn lẩu Thái cùng với bún tươi, mì gói và chấm với nước mắm ớt.\n")
                ),
                Arrays.asList(category(1))
            ),
            new Product(
                11,
                "Mì quảng",
                R.drawable.muoihai_miquang_re,
                60,
                Arrays.asList(
                    ingredient(37, "500 g"),
                    ingredient(6, "500 g"),
                    ingredient(1, "200 g"),
                    ingredient(14, "50 g"),
                    ingredient(15, "10 g"),
                    ingredient(40, "2 muỗng canh"),
                    ingredient(41, "1 muỗng cà phê"),
                    ingredient(43, "2 trái"),
                    ingredient(44, "2 muỗng canh"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(48, "1 muỗng cà phê"),
                    ingredient(26, "1 củ"),
                    ingredient(23, "5 tép"),
                    ingredient(51, "2 muỗng canh")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tSợi mì Quảng ngâm nước ấm cho mềm.\n•\tThịt gà rửa sạch, chặt miếng vừa ăn. Ướp thịt với 1 muỗng cà phê muối, 1 muỗng cà phê tiêu trong 15 phút.\n•\tTôm rửa sạch, bóc vỏ, bỏ đầu và chỉ đen.\n•\tTrứng cút luộc chín, bóc vỏ.\n•\tRau củ rửa sạch, cắt nhỏ.\n•\tTỏi, ớt, gừng băm nhuyễn.\n"),
                    new Procedure("Bước 2: Nấu nước dùng", "•\tPhi thơm hành tím băm với dầu ăn, cho thịt gà vào xào săn.\n•\tNêm thêm nước mắm, muối, tiêu, bột nghệ, gừng băm vào xào chung.\n•\tCho nước vào nồi, nấu sôi.\n•\tCho sả đập dập vào nồi nước dùng, nấu thêm 15 phút.\n"),
                    new Procedure("Bước 3: Chế biến mì Quảng", "•\tCho mì Quảng vào nồi nước dùng, nấu cho đến khi mì chín mềm.\n•\tCho tôm vào nồi, nấu chín.\n•\tCho rau củ vào nồi, nấu chín sơ.\n•\tNêm nếm gia vị cho vừa ăn.\n"),
                    new Procedure("Bước 4: Hoàn thành", "•\tMúc mì Quảng ra tô, cho thịt gà, tôm, trứng cút, rau củ lên trên.\n•\tRắc thêm hành lá, hẹ, hành phi, ớt băm vào.\n•\tDùng nóng với nước mắm ớt.\n")
                ),
                Arrays.asList(category(1))
            ),
            new Product(
                12,
                "Chè hạt sen",
                R.drawable.muoiba_chehatsen_re,
                90,
                Arrays.asList(
                    ingredient(60, "200 g"),
                    ingredient(41, "1 lít"),
                    ingredient(44, "2 muỗng cà phê"),
                    ingredient(65, "50 g")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tHạt sen rửa sạch, tách tim sen. Ngâm hạt sen trong nước ấm khoảng 30 phút cho nở mềm.\n•\tLá dứa rửa sạch, cắt khúc.\n"),
                    new Procedure("Bước 2: Nấu chè", "•\tCho nước vào nồi, đun sôi.\n•\tCho lá dứa vào nồi, nấu thêm 5 phút cho nước có màu xanh và thơm mùi lá dứa.\n•\tVớt lá dứa ra.\n•\tCho hạt sen vào nồi, nấu khoảng 30 phút cho hạt sen chín mềm.\n•\tNêm thêm muối và đường vào nồi, khuấy đều cho tan.\n•\tNấu thêm 10 phút cho nước chè ngấm gia vị.\n•\t(Tùy chọn) Cho đường phèn vào nồi, nấu cho tan.\n")
                ),
                Arrays.asList(category(2))
            ),
            new Product(
                13,
                "Chè đậu xanh",
                R.drawable.muoibon_chedauxanh_re,
                50,
                Arrays.asList(
                    ingredient(59, "200 g"),
                    ingredient(41, "1 lít"),
                    ingredient(44, "1 muỗng cà phê"),
                    ingredient(65, "50 g")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tĐậu xanh vo sạch, loại bỏ hạt lép. Ngâm đậu xanh trong nước ấm khoảng 30 phút cho nở mềm.\n•\tLá dứa rửa sạch, cắt khúc.\n"),
                    new Procedure("Bước 2: Nấu chè", "•\tCho nước vào nồi, đun sôi.\n•\tCho lá dứa vào nồi, nấu thêm 5 phút cho nước có màu xanh và thơm mùi lá dứa.\n•\tVớt lá dứa ra.\n•\tCho đậu xanh vào nồi, nấu khoảng 30 phút cho đậu xanh chín mềm.\n•\tNêm thêm muối và đường vào nồi, khuấy đều cho tan.\n•\tNấu thêm 10 phút cho nước chè ngấm gia vị.\n•\t(Tùy chọn) Cho đường phèn vào nồi, nấu cho tan.\n")
                ),
                Arrays.asList(category(2))
            ),
            new Product(
                14,
                "Sữa chua",
                R.drawable.muoinam_suachua_re,
                600,
                Arrays.asList(
                    ingredient(61, "1 lít"),
                    ingredient(62, "1 hộp"),
                    ingredient(41, "50 g")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Khử trùng dụng cụ", "•\tRửa sạch tất cả dụng cụ làm sữa chua (lọ thủy tinh, nắp đậy, muỗng khuấy) bằng nước nóng và xà phòng.\n•\tTrụng dụng cụ qua nước sôi để khử trùng.\n"),
                    new Procedure("Bước 2: Làm hỗn hợp sữa chua", "•\tCho sữa tươi vào nồi, đun sôi trên lửa nhỏ.\n•\tTắt bếp, để sữa nguội bớt đến khoảng 40°C (sờ vào sữa thấy ấm nhưng không nóng).\n•\tCho sữa chua cái vào tô, khuấy đều.\n•\tCho hỗn hợp sữa chua cái vào nồi sữa ấm, khuấy đều cho tan.\n•\t(Tùy chọn) Cho thêm đường vào hỗn hợp sữa chua, khuấy đều.\n"),
                    new Procedure("Bước 3: Ủ sữa chua", "•\tCho hỗn hợp sữa chua vào các lọ thủy tinh đã khử trùng.\n•\tĐậy kín nắp lọ.\n•\tQuấn khăn ấm hoặc ủ sữa chua trong nồi cơm điện đã tắt (giữ ấm).\n•\tỦ sữa chua trong 6-8 tiếng (hoặc qua đêm).\n"),
                    new Procedure("Bước 4: Kiểm tra và bảo quản", "•\tSau khi ủ, mở nắp lọ sữa chua, nếu thấy sữa chua đông đặc, mịn màng là đã thành công.\n•\tCho sữa chua vào ngăn mát tủ lạnh để bảo quản.\n")
                ),
                Arrays.asList(category(2))
            ),
            new Product(
                15,
                "Phở",
                R.drawable.muoisau_pho_re,
                240,
                Arrays.asList(
                    ingredient(66, "500 g"),
                    ingredient(63, "2 kg"),
                    ingredient(12, "300 g"),
                    ingredient(40, "2 muỗng canh"),
                    ingredient(44, "1 muỗng cà phê"),
                    ingredient(48, "1 muỗng cà phê"),
                    ingredient(65, "30 g"),
                    ingredient(26, "1 củ"),
                    ingredient(29, "1 củ"),
                    ingredient(22, "3 củ"),
                    ingredient(23, "5 tép"),
                    ingredient(43, "6 trái"),
                    ingredient(15, "20 g")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tXương bò rửa sạch, chặt thành miếng vừa ăn. Chần xương bò với nước sôi khoảng 5 phút để khử mùi hôi, sau đó rửa sạch lại với nước.\n•\tThịt bò rửa sạch, thái mỏng.\n•\tGừng, hành tây, hành tím, tỏi bóc vỏ, nướng thơm.\n•\tỚt rửa sạch, băm nhuyễn.\n•\tRau thơm rửa sạch, cắt nhỏ.\n"),
                    new Procedure("Bước 2: Nấu nước dùng", "•\tCho xương bò vào nồi, đổ nước xâm xấp mặt xương.\n•\tNêm thêm 1 muỗng canh muối, 1 muỗng cà phê hạt nêm và 2 viên đường phèn vào nồi.\n•\tĐun sôi nồi nước dùng, sau đó hớt bọt và hạ lửa nhỏ, hầm trong khoảng 2-3 tiếng cho đến khi nước dùng ngọt và trong.\n•\tCho quế, hồi, hoa hồi vào nồi nước dùng, hầm thêm 30 phút.\n•\tVớt xương bò ra khỏi nồi.\n"),
                    new Procedure("Bước 3: Chần thịt bò", "•\tCho nước sôi vào nồi khác, nêm thêm 1 muỗng cà phê muối.\n•\tChần nhanh thịt bò trong nước sôi cho đến khi thịt tái.\n•\tVớt thịt bò ra đĩa, để ráo nước.\n"),
                    new Procedure("Bước 4: Trụng bánh phở", "•\tCho bánh phở vào tô, trụng bánh phở trong nước dùng nóng cho đến khi bánh phở mềm.\n•\tVớt bánh phở ra tô.\n"),
                    new Procedure("Bước 5: Hoàn thành", "•\tXếp thịt bò lên trên bánh phở.\n•\tChan nước dùng nóng vào tô.\n•\tRắc thêm hành lá, ngò gai, ớt băm và hành phi lên trên.\n•\tThưởng thức phở bò cùng với chanh, ớt, tương ớt và rau thơm.\n")
                ),
                Arrays.asList(category(3))
            ),
            new Product(
                16,
                "Bún chả Hà Nội",
                R.drawable.muoibay_bunchahn_re,
                120,
                Arrays.asList(
                    ingredient(13, "200 g"),
                    ingredient(34, "100 g"),
                    ingredient(33, "20 g"),
                    ingredient(2, "500 g"),
                    ingredient(0, "200 g"),
                    ingredient(40, "2 muỗng canh"),
                    ingredient(41, "1 muỗng cà phê"),
                    ingredient(52, "5 ml"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(46, "1 muỗng cà phê"),
                    ingredient(53, "1 muỗng cà phê"),
                    ingredient(22, "4 củ"),
                    ingredient(23, "5 tép"),
                    ingredient(14, "50 g"),
                    ingredient(15, "10 g"),
                    ingredient(17, "30 g"),
                    ingredient(18, "2 trái")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tThịt: Rửa sạch thịt ba chỉ, thịt nạc vai và mỡ heo. Thịt ba chỉ thái miếng vừa ăn, thịt nạc vai xay nhuyễn, mỡ heo thái hạt lựu.\n•\tRau củ: Rau sống, bắp chuối bào, dưa chuột rửa sạch, để ráo nước. Xà lách, húng quế, tía tô, húng lủi nhặt lá, rửa sạch. Cà rốt, đu đủ xanh gọt vỏ, bào sợi.\n•\tNước chấm: Pha nước mắm với nước lọc, đường, nước cốt chanh, ớt băm, tỏi băm. Nêm nếm gia vị cho vừa ăn\n"),
                    new Procedure("Bước 2: Ướp thịt", "•\tCho thịt ba chỉ vào tô lớn, ướp với hỗn hợp gia vị gồm nước mắm, đường, mật ong, tiêu xay, bột ngọt, dầu ăn, hành tím băm, tỏi băm, dầu hào (tùy thích). Trộn đều và để thịt thấm gia vị trong 30 phút.\n•\tCho thịt nạc vai xay vào tô khác, ướp với 1 muỗng canh nước mắm, 1 muỗng cà phê tiêu xay, 1 muỗng cà phê bột ngọt. Trộn đều và để thịt nghỉ 15 phút.\n"),
                    new Procedure("Bước 3: Nướng thịt", "•\tLàm nóng than hoa hoặc lò nướng.\n•\tXiên thịt ba chỉ vào que, xếp lên vỉ nướng. Nướng thịt đến khi chín vàng đều hai mặt.\n•\tVo viên thịt nạc vai xay, xếp lên vỉ nướng và nướng chín vàng đều.\n•\tNướng mỡ heo cho đến khi vàng giòn.\n"),
                    new Procedure("Bước 4: Thưởng thức", "•\tXếp bún, thịt nướng, rau sống, bắp chuối bào, dưa chuột vào đĩa.\n•\tChan nước chấm lên trên hoặc chấm trực tiếp.\n•\tThêm ớt tươi, chanh tươi tùy theo khẩu vị.\n")
                ),
                Arrays.asList(category(3))
            ),
            new Product(
                17,
                "Bún bò Huế",
                R.drawable.muoitam_bunbohue_re,
                150,
                Arrays.asList(
                    ingredient(5, "400 g"),
                    ingredient(34, "200 g"),
                    ingredient(26, "1 củ"),
                    ingredient(28, "2 củ"),
                    ingredient(29, "1 củ"),
                    ingredient(24, "2 cây"),
                    ingredient(44, "2 muỗng cà phê"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(13, "200 g"),
                    ingredient(14, "50 g"),
                    ingredient(15, "5 g"),
                    ingredient(17, "20 g"),
                    ingredient(40, "2 muỗng cà phê"),
                    ingredient(41, "1 muỗng cà phê"),
                    ingredient(43, "2 trái")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Nấu nước dùng", "•\tRửa sạch xương bò, thịt bắp bò và giò heo. Cho vào nồi lớn, đổ nước xâm xấp, hầm trong 2 tiếng để lấy nước dùng.\n•\tNướng gừng, sả và hành tây cho thơm. Cho vào nồi nước dùng, hầm thêm 30 phút.\n•\tNêm nếm gia vị mắm ruốc, muối, tiêu xay cho vừa ăn.\n•\tThêm hành lá và hành tây cắt khúc vào nồi nước dùng, tắt bếp.\n"),
                    new Procedure("Bước 2: Sơ chế topping", "•\tThịt bò tái thái mỏng. Chả cua và tiết lợn luộc chín, cắt miếng vừa ăn.\n•\tRau sống rửa sạch, để ráo nước.\n"),
                    new Procedure("Bước 3: Thưởng thức", "•\tXếp bún, thịt bò tái, chả cua, tiết lợn, rau sống vào tô.\n•\tChan nước dùng nóng hổi lên trên.\n•\tThêm ớt tươi, chanh tươi, và mắm ruốc (tùy thích) để tăng hương vị.\n")
                ),
                Arrays.asList(category(3))
            ),
            new Product(
                18,
                "Bánh mì",
                R.drawable.muoichin_banhmi_re,
                60,
                Arrays.asList(
                    ingredient(38, "100 g"),
                    ingredient(44, "2 muỗng cà phê"),
                    ingredient(41, "1 muỗng cà phê"),
                    ingredient(51, "1 muỗng canh"),
                    ingredient(45, "200 ml"),
                    ingredient(0, "200 g"),
                    ingredient(18, "1 trái"),
                    ingredient(19, "2 trái"),
                    ingredient(15, "20 g"),
                    ingredient(43, "3 trái"),
                    ingredient(50, "1 chén")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Làm vỏ bánh mì", "•\tCho bột mì, men nở, nước ấm, muối, đường và dầu ăn vào tô lớn. Trộn đều bằng tay hoặc máy đánh bột cho đến khi hỗn hợp mịn và dẻo.\n•\tNhào bột trong 10-15 phút cho đến khi bột trở nên đàn hồi và mịn.\n•\tBọc tô bột bằng khăn ẩm và ủ bột ở nơi ấm áp trong 1 tiếng cho đến khi bột nở gấp đôi.\n•\tChia bột thành những phần bằng nhau, vo tròn và để bột nghỉ thêm 15 phút.\n•\tTạo hình bánh mì theo ý thích (hình baguette, hình ổ loa,..) và đặt lên khay nướng đã lót giấy nến.\n•\tPhủ khăn ẩm lên khay bánh mì và ủ thêm 30 phút cho đến khi bánh mì nở gấp đôi.\n•\tLàm nóng lò nướng ở 180°C.\n•\tPhết một lớp mỏng nước lên mặt bánh mì.\n•\tNướng bánh mì trong 20-25 phút cho đến khi vàng đều.\n"),
                    new Procedure("Bước 2: Làm nhân bánh mì", "•\tThịt heo quay hoặc pate cắt lát mỏng.\n•\tDưa leo và cà rốt gọt vỏ, thái sợi.\n•\tRau thơm rửa sạch, cắt nhỏ.\n•\tTrộn ớt băm, mayonnaise, nước mắm và tương ớt với nhau để làm nước sốt.\n"),
                    new Procedure("Bước 3: Thưởng thức", "•\tCắt bánh mì theo chiều dọc.\n•\tXếp thịt heo quay hoặc pate, dưa leo, cà rốt, rau thơm vào trong bánh mì.\n•\tChan nước sốt lên bánh mì và thưởng thức.\n")
                ),
                Arrays.asList(category(3))
            ),
            new Product(
                19,
                "Bánh cuốn",
                R.drawable.haimuoi_banhcuon_re,
                30,
                Arrays.asList(
                    ingredient(39, "200 g"),
                    ingredient(45, "100 ml"),
                    ingredient(0, "500 g"),
                    ingredient(64, "50 g"),
                    ingredient(22, "1 củ"),
                    ingredient(40, "2 muỗng canh"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(48, "1 muỗng cà phê"),
                    ingredient(24, "2 cây"),
                    ingredient(42, "1 muỗng canh"),
                    ingredient(44, "1 muỗng cà phê"),
                    ingredient(14, "20 g"),
                    ingredient(18, "1 trái")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Làm vỏ bánh", "•\tCho bột gạo, nước, muối và dầu ăn vào tô lớn. Khuấy đều cho đến khi hỗn hợp mịn và không bị vón cục.\n•\tĐậy kín tô bột và để nghỉ trong 30 phút.\n•\tLàm nóng xửng hấp.\n•\tLấy một muỗng canh bột bánh, tráng mỏng đều trên mặt vải căng trong xửng. Hấp bánh trong khoảng 1 phút cho đến khi bánh chín mềm và trong suốt.\n•\tDùng dụng cụ gỡ bánh ra khỏi vải và đặt lên đĩa.\n"),
                    new Procedure("Bước 2: Làm nhân bánh", "•\tNgâm mộc nhĩ và nấm hương trong nước ấm cho nở mềm. Sau đó, vớt ra, rửa sạch và băm nhỏ.\n•\tPhi thơm hành tím băm với dầu ăn. Cho thịt băm vào xào săn.\n•\tThêm mộc nhĩ, nấm hương, nước mắm, tiêu xay, hạt nêm vào xào chung. Nêm nếm gia vị cho vừa ăn.\n•\tThêm hành lá, ngò rí cắt nhỏ vào đảo đều rồi tắt bếp.\n"),
                    new Procedure("Bước 3: Làm nước chấm", "•\tPha nước mắm với nước lọc, đường, nước cốt chanh, ớt băm, tỏi băm. Nêm nếm gia vị cho vừa ăn."),
                    new Procedure("Bước 4: Thưởng thức", "•\tXếp bánh cuốn lên đĩa. Cho nhân thịt băm xào lên trên.\n•\tChan nước chấm và ăn kèm với rau sống, bắp chuối bào, dưa chuột.\n")
                ),
                Arrays.asList(category(3))
            ),
            new Product(
                20,
                "Thịt ba chỉ nướng",
                R.drawable.haimot_thibachinuong_re,
                45,
                Arrays.asList(
                    ingredient(2, "500 g"),
                    ingredient(40, "2 muỗng canh"),
                    ingredient(51, "1 muỗng canh"),
                    ingredient(52, "50 ml"),
                    ingredient(22, "5 củ"),
                    ingredient(23, "5 tép"),
                    ingredient(43, "3 trái"),
                    ingredient(53, "20 g"),
                    ingredient(46, "1 muỗng cà phê"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(44, "2 muỗng cà phê"),
                    ingredient(19, "2 trái"),
                    ingredient(14, "20 g"),
                    ingredient(15, "5 g")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tThịt ba chỉ rửa sạch, cắt miếng vừa ăn.\n•\tƯớp thịt ba chỉ với hỗn hợp gia vị đã chuẩn bị trong ít nhất 30 phút cho thấm đều.\n•\tRau củ rửa sạch, cắt khúc vừa ăn.\n•\tPha nước chấm chua ngọt theo khẩu vị.\n"),
                    new Procedure("Bước 2: Nướng thịt", "•\tCó thể nướng thịt ba chỉ bằng than hoa, lò nướng hoặc nồi chiên không dầu.\n•\tNếu nướng bằng than hoa, xếp thịt lên vỉ nướng và nướng trên than hồng cho đến khi chín vàng đều.\n•\tNếu nướng bằng lò nướng, làm nóng lò ở 200°C, xếp thịt lên khay nướng và nướng trong khoảng 20 phút cho đến khi chín vàng đều.\n•\tNếu nướng bằng nồi chiên không dầu, xếp thịt vào nồi chiên, set nhiệt độ 180°C và nướng trong khoảng 15-20 phút cho đến khi chín vàng đều.\n"),
                    new Procedure("Bước 3: Hoàn thành", "•\tGắp thịt ba chỉ nướng ra đĩa, ăn kèm với rau củ, bánh tráng và nước chấm.")
                ),
                Arrays.asList(category(4))
            ),
            new Product(
                21,
                "Tôm nướng",
                R.drawable.haihai_tomnuong_re,
                30,
                Arrays.asList(
                    ingredient(1, "1 kg"),
                    ingredient(52, "50 ml"),
                    ingredient(22, "5 củ"),
                    ingredient(23, "5 tép"),
                    ingredient(43, "3 trái"),
                    ingredient(53, "20 g"),
                    ingredient(19, "2 trái"),
                    ingredient(14, "20 g"),
                    ingredient(15, "5 g"),
                    ingredient(46, "1 muỗng cà phê"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(44, "2 muỗng cà phê"),
                    ingredient(40, "2 muỗng canh"),
                    ingredient(51, "1 muỗng canh")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tTôm rửa sạch, bóc vỏ, bỏ đầu và chỉ đen.\n•\tƯớp tôm với hỗn hợp gia vị đã chuẩn bị trong ít nhất 30 phút cho thấm đều.\n•\tRau củ rửa sạch, cắt khúc vừa ăn.\n•\tPha nước chấm chua ngọt theo khẩu vị.\n"),
                    new Procedure("Bước 2: Nướng tôm", "•\tCó thể nướng tôm bằng than hoa, lò nướng hoặc nồi chiên không dầu.\n•\tNếu nướng bằng than hoa, xếp tôm lên vỉ nướng và nướng trên than hồng cho đến khi chín vàng đều.\n•\tNếu nướng bằng lò nướng, làm nóng lò ở 200°C, xếp tôm lên khay nướng và nướng trong khoảng 10-15 phút cho đến khi chín vàng đều.\n•\tNếu nướng bằng nồi chiên không dầu, xếp tôm vào nồi chiên, set nhiệt độ 180°C và nướng trong khoảng 10-12 phút cho đến khi chín vàng đều.\n"),
                    new Procedure("Bước 3: Hoàn thành", "•\tGắp tôm nướng ra đĩa, ăn kèm với rau củ, bánh tráng và nước chấm.")
                ),
                Arrays.asList(category(4))
            ),
            new Product(
                22,
                "Mực nướng",
                R.drawable.haiba_mucnuong_re,
                60,
                Arrays.asList(
                    ingredient(7, "2 kg"),
                    ingredient(52, "50 ml"),
                    ingredient(22, "5 củ"),
                    ingredient(23, "5 tép"),
                    ingredient(43, "3 trái"),
                    ingredient(53, "20 g"),
                    ingredient(19, "2 trái"),
                    ingredient(14, "20 g"),
                    ingredient(15, "5 g"),
                    ingredient(46, "1 muỗng cà phê"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(44, "2 muỗng cà phê"),
                    ingredient(40, "2 muỗng canh"),
                    ingredient(51, "1 muỗng canh"),
                    ingredient(36, "50 g")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tMực rửa sạch, để ráo nước.\n•\tNếu là mực ống, cần rút hết phần nội tạng và túi mực.\n•\tCắt mực thành từng khoanh dày khoảng 2-3 cm.\n•\tƯớp mực với hỗn hợp gia vị đã chuẩn bị trong ít nhất 30 phút cho thấm đều.\n•\tRau củ rửa sạch, cắt khúc vừa ăn.\n•\tPha nước chấm chua ngọt theo khẩu vị.\n"),
                    new Procedure("Bước 2: Nướng mực", "•\tCó thể nướng mực bằng than hoa, lò nướng hoặc nồi chiên không dầu.\n•\tNếu nướng bằng than hoa, xếp mực lên vỉ nướng và nướng trên than hồng cho đến khi chín vàng đều.\n•\tNếu nướng bằng lò nướng, làm nóng lò ở 200°C, xếp mực lên khay nướng và nướng trong khoảng 10-15 phút cho đến khi chín vàng đều.\n•\tNếu nướng bằng nồi chiên không dầu, xếp mực vào nồi chiên, set nhiệt độ 180°C và nướng trong khoảng 10-12 phút cho đến khi chín vàng đều.\n"),
                    new Procedure("Bước 3: Hoàn thành", "•\tGắp mực nướng ra đĩa, ăn kèm với rau củ, bánh tráng và nước chấm.")
                ),
                Arrays.asList(category(4))
            ),
            new Product(
                23,
                "Sườn nướng",
                R.drawable.haibon_suonnuong_re,
                100,
                Arrays.asList(
                    ingredient(8, "1 kg"),
                    ingredient(30, "20 g"),
                    ingredient(52, "50 ml"),
                    ingredient(22, "5 củ"),
                    ingredient(23, "5 tép"),
                    ingredient(43, "3 trái"),
                    ingredient(53, "20 g"),
                    ingredient(19, "2 trái"),
                    ingredient(14, "20 g"),
                    ingredient(15, "5 g"),
                    ingredient(46, "1 muỗng cà phê"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(44, "2 muỗng cà phê"),
                    ingredient(40, "2 muỗng canh"),
                    ingredient(51, "1 muỗng canh"),
                    ingredient(36, "50 g")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tSườn rửa sạch, chặt thành miếng vừa ăn.\n•\tƯớp sườn với hỗn hợp gia vị đã chuẩn bị trong ít nhất 30 phút cho thấm đều.\n•\tRau củ rửa sạch, cắt khúc vừa ăn.\n•\tPha nước chấm chua ngọt theo khẩu vị.\n"),
                    new Procedure("Bước 2: Nướng sườn", "•\tCó thể nướng sườn bằng than hoa, lò nướng hoặc nồi chiên không dầu.\n•\tNếu nướng bằng than hoa, xếp sườn lên vỉ nướng và nướng trên than hồng cho đến khi chín vàng đều.\n•\tNếu nướng bằng lò nướng, làm nóng lò ở 200°C, xếp sườn lên khay nướng và nướng trong khoảng 20-25 phút cho đến khi chín vàng đều.\n•\tNếu nướng bằng nồi chiên không dầu, xếp sườn vào nồi chiên, set nhiệt độ 180°C và nướng trong khoảng 15-20 phút cho đến khi chín vàng đều.\n"),
                    new Procedure("Bước 3: Hoàn thành", "•\tGắp sườn nướng ra đĩa, ăn kèm với rau củ, bánh tráng và nước chấm.")
                ),
                Arrays.asList(category(4))
            ),
            new Product(
                24,
                "Rau muống xào tỏi",
                R.drawable.hainam_raumuonxaotoi_re,
                15,
                Arrays.asList(
                    ingredient(16, "100 g"),
                    ingredient(44, "2 muỗng cà phê"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(51, "1 muỗng canh")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tRửa sạch rau, cắt thành miếng vừa ăn.\n•\tTỏi bóc vỏ, băm nhuyễn.\n"),
                    new Procedure("Bước 2: Xào rau củ", "•\tLàm nóng chảo với dầu ăn. Cho tỏi băm vào phi thơm.\n•\tCho rau củ vào xào với lửa lớn cho đến khi rau củ chín tái.\n•\tNêm nếm muối, tiêu xay cho vừa ăn.\n•\tXào thêm khoảng 1 phút cho rau củ thấm gia vị rồi tắt bếp.\n"),
                    new Procedure("Bước 3: Thưởng thức", "•\tMúc rau củ xào tỏi ra đĩa và thưởng thức nóng với cơm trắng.")
                ),
                Arrays.asList(category(5))
            ),
            new Product(
                25,
                "Rau củ xào nấm",
                R.drawable.haisau_raucuxaonam_re,
                20,
                Arrays.asList(
                    ingredient(67, "100 g"),
                    ingredient(64, "50 g"),
                    ingredient(19, "50 g"),
                    ingredient(29, "1 củ"),
                    ingredient(23, "3 tép"),
                    ingredient(51, "1 muỗng canh"),
                    ingredient(50, "1 chén"),
                    ingredient(48, "1 muỗng cà phê"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(24, "1 cây")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tRửa sạch rau củ, cắt thành miếng vừa ăn.\n•\tNấm rửa sạch, cắt lát mỏng.\n•\tHành tây bóc vỏ, cắt múi cau.\n•\tTỏi bóc vỏ, băm nhuyễn.\n•\tHành lá, ngò rí rửa sạch, cắt nhỏ.\n"),
                    new Procedure("Bước 2: Xào rau củ và nấm", "•\tLàm nóng chảo với dầu ăn. Cho tỏi băm vào phi thơm.\n•\tCho hành tây vào xào cho đến khi mềm và chuyển sang màu vàng.\n•\tCho nấm vào xào cùng cho đến khi nấm chín mềm.\n•\tCho rau củ vào xào cùng với nấm và hành tây.\n•\tNêm nếm nước tương, hạt nêm, tiêu xay cho vừa ăn.\n•\tXào rau củ và nấm thêm 2-3 phút cho đến khi chín đều\n"),
                    new Procedure("Bước 3: Hoàn thành", "•\tTắt bếp, cho hành lá, ngò rí vào đảo đều.\n•\tMúc rau củ xào nấm ra đĩa và thưởng thức nóng với cơm trắng hoặc bún.\n")
                ),
                Arrays.asList(category(5))
            ),
            new Product(
                26,
                "Gỏi rau củ",
                R.drawable.haibay_goiraucu_re,
                30,
                Arrays.asList(
                    ingredient(68, "200 g"),
                    ingredient(0, "500 g"),
                    ingredient(1, "200 g"),
                    ingredient(58, "50 g"),
                    ingredient(40, "2 muỗng canh"),
                    ingredient(15, "5 g")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tRửa sạch rau củ, cắt sợi hoặc bào mỏng.\n•\tTôm sú rửa sạch, bóc vỏ, luộc chín và cắt đôi.\n•\tThịt heo quay thái mỏng.\n•\tLạc rang giã nhỏ.\n•\tRau thơm rửa sạch, cắt nhỏ.\n•\tPha nước mắm chua ngọt với tỷ lệ 1:1 đường và nước mắm, thêm ớt băm và chanh (tùy thích).\n"),
                    new Procedure("Bước 2: Trộn gỏi", "•\tCho rau củ, tôm sú, thịt heo quay vào tô lớn.\n•\tRưới nước mắm chua ngọt lên trên và trộn đều.\n•\tThêm lạc rang, rau thơm và trộn đều lần nữa.\n"),
                    new Procedure("Bước 3: Hoàn thành", "•\tCho gỏi ra đĩa và thưởng thức.\n•\tGỏi rau củ có thể ăn kèm với bánh tráng cuốn hoặc bún.\n")
                ),
                Arrays.asList(category(5))
            ),
            new Product(
                27,
                "Canh măng chua",
                R.drawable.haitam_canhmangchua_re,
                20,
                Arrays.asList(
                    ingredient(32, "100 g"),
                    ingredient(63, "300 g"),
                    ingredient(33, "20 g"),
                    ingredient(15, "5 g"),
                    ingredient(40, "2 muỗng canh"),
                    ingredient(44, "2 muỗng cà phê"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(46, "1 muỗng cà phê"),
                    ingredient(48, "1 muỗng cà phê")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tMăng chua rửa sạch, cắt miếng vừa ăn.\n•\tXương heo rửa sạch, chặt miếng vừa ăn.\n•\tThịt heo rửa sạch, cắt miếng vừa ăn.\n•\tCà chua rửa sạch, cắt múi cau.\n•\tBắp chuối bào rửa sạch, vắt ráo nước.\n•\tRau thơm rửa sạch, cắt nhỏ.\n"),
                    new Procedure("Bước 2: Nấu canh", "•\tCho xương heo vào nồi, đổ nước xâm xấp mặt xương và hầm trong khoảng 1 tiếng cho đến khi xương mềm và tiết ra nước ngọt.\n•\tCho măng chua vào nồi nước dùng, hầm thêm 30 phút cho măng mềm.\n•\tThêm thịt heo, cà chua vào nồi và nấu thêm 15 phút.\n•\tNêm nếm gia vị (muối, đường, nước mắm, hạt nêm) cho vừa ăn.\n•\tCho bắp chuối bào vào nồi và nấu thêm 5 phút.\n•\tTắt bếp, cho rau thơm vào nồi và đảo đều.\n"),
                    new Procedure("Bước 3: Hoàn thành", "•\tMúc canh măng chua ra tô và thưởng thức nóng với cơm trắng.")
                ),
                Arrays.asList(category(6))
            ),
            new Product(
                28,
                "Canh bí đỏ nấu tôm",
                R.drawable.haichin_canhbidonautom_re,
                30,
                Arrays.asList(
                    ingredient(31, "1 trái"),
                    ingredient(1, "200 g"),
                    ingredient(63, "200 g"),
                    ingredient(44, "2 muỗng cà phê"),
                    ingredient(41, "1 muỗng cà phê"),
                    ingredient(40, "2 muỗng canh"),
                    ingredient(46, "1 muỗng cà phê"),
                    ingredient(47, "1 muỗng cà phê"),
                    ingredient(48, "1 muỗng cà phê"),
                    ingredient(53, "1 muỗng cà phê")
                ),
                Arrays.asList(
                    new Procedure("Bước 1: Sơ chế nguyên liệu", "•\tBí đỏ gọt vỏ, bỏ hạt, cắt miếng vừa ăn.\n•\tTôm tươi rửa sạch, bóc vỏ, bỏ đầu và chỉ đen.\n•\tXương heo rửa sạch, chặt miếng vừa ăn.\n"),
                    new Procedure("Bước 2: Nấu nước dùng", "•\tCho xương heo vào nồi, đổ nước xâm xấp mặt xương và hầm trong khoảng 1 tiếng cho đến khi xương mềm và tiết ra nước ngọt. Nêm nếm gia vị (muối, hạt nêm) cho vừa ăn."),
                    new Procedure("Bước 3: Nấu canh", "•\tCho bí đỏ vào nồi nước dùng, nấu sôi.\n•\tThêm tôm tươi vào nồi và nấu thêm 5 phút.\n•\tNêm nếm gia vị (nước mắm, tiêu xay) cho vừa ăn.\n•\tTắt bếp, cho hành lá, ngò rí vào nồi và đảo đều.\n"),
                    new Procedure("Bước 4: Thưởng thức", "•\tMúc canh bí đỏ nấu tôm ra tô và thưởng thức nóng với cơm trắng.")
                ),
                Arrays.asList(category(6))
            )
        ));
    }

    private StaticIngredient ingredient(int index, String quantity) {
        return ingredients.get(index, quantity);
    }

    private Category category(int index) {
        return categories.get(index);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProduct(int idProduct) {
        return productList.get(idProduct);
    }

    public String getNameProduct(int idProduct) {
        return productList.get(idProduct).getName();
    }

    public List<Product> getProductsByName(String text) {
        String query = text.toLowerCase(Locale.ROOT);
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase(Locale.ROOT).contains(query)) {
                result.add(product);
            }
        }
        return result;
    }

    public List<StaticIngredient> getIngredient(int idProduct) {
        return productList.get(idProduct).getIngredient();
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            for (Category category : product.getCategory()) {
                if (category.getId() == categoryId) {
                    result.add(product);
                    break;
                }
            }
        }
        return result;
    }

    public List<Product> getRandomProducts() {
        return getRandomProducts(2);
    }

    public List<Product> getRandomProducts(int count) {
        List<Product> shuffled = new ArrayList<>(productList);
        Collections.shuffle(shuffled);
        return new ArrayList<>(shuffled.subList(0, Math.min(count, shuffled.size())));
    }

    public List<Product> getLastFiveProducts() {
        int fromIndex = Math.max(0, productList.size() - 5);
        return new ArrayList<>(productList.subList(fromIndex, productList.size()));
    }
}

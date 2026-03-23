# Dev Note

Tài liệu ghi lại các thay đổi kỹ thuật gần đây trong dự án.

## Mốc cập nhật: 2026-03-24

## 1) Add Recipe: cải tiến luồng nguyên liệu

### Mục tiêu
- Tránh trải nghiệm bấm nút Thêm nguyên liệu nhưng không thấy gì.
- Cho phép người dùng nhập thủ công nguyên liệu.
- Hỗ trợ chỉnh sửa/xóa từng nguyên liệu trước khi lưu công thức.

### Thay đổi
- Tạo adapter mới cho danh sách nguyên liệu vừa thêm.
  - app/src/main/java/com/example/recipeapp/ui/recipe_person/add_recipe/AddedIngredientAdapter.java
- Tạo layout item có nút Cập nhật và Xóa.
  - app/src/main/res/layout/item_added_ingredient.xml
- Tạo popup nhập nguyên liệu.
  - app/src/main/res/layout/dialog_add_ingredient.xml
- Cập nhật AddRecipeFragment:
  - Gắn RecyclerView + observe LiveData ingredients.
  - Mở popup nhập/sửa nguyên liệu.
  - Xóa nguyên liệu có xác nhận.
  - app/src/main/java/com/example/recipeapp/ui/recipe_person/add_recipe/AddRecipeFragment.java
- Cập nhật AddRecipeViewModel:
  - Bổ sung updateIngredient(index, name, weight)
  - Bổ sung removeIngredient(index)
  - app/src/main/java/com/example/recipeapp/ui/recipe_person/add_recipe/AddRecipeViewModel.java
- Cập nhật text nút màn thêm công thức.
  - app/src/main/res/layout/fragment_add_recipe.xml

### Kết quả
- Luồng nhập nguyên liệu trở nên trực quan.
- Dữ liệu nguyên liệu cập nhật tức thời trên UI.

## 2) Favourite: sửa lỗi không lưu và thêm bỏ yêu thích

### Mục tiêu
- Bấm Yêu thích phải lưu được.
- Tránh lưu trùng.
- Cho phép Bỏ yêu thích ngay tại màn chi tiết.
- Danh mục yêu thích hiển thị đúng item.

### Thay đổi
- Cập nhật RecipeViewModel:
  - Thêm guard productId không hợp lệ.
  - Kiểm tra trùng trước khi insert yêu thích.
  - Thêm message trạng thái thao tác (thành công/thất bại/đã tồn tại).
  - Thêm toggleFavourite để bật/tắt yêu thích.
  - Khi bỏ yêu thích, xóa record và cập nhật trạng thái.
  - app/src/main/java/com/example/recipeapp/ui/recipe/RecipeViewModel.java
- Cập nhật RecipeDetailFragment:
  - Quan sát trạng thái yêu thích để đổi text nút.
  - Nút chuyển thành Yêu thích hoặc Bỏ yêu thích theo trạng thái.
  - Hiển thị toast phản hồi thao tác.
  - Xử lý an toàn khi không tìm thấy product.
  - app/src/main/java/com/example/recipeapp/ui/recipe/RecipeDetailFragment.java
- Sửa Products.getProduct theo id thay vì index list.
  - app/src/main/java/com/example/recipeapp/data/static_data/Products.java
- Cập nhật FavouriteRecipeFragment:
  - Bỏ qua product null khi dựng danh sách yêu thích.
  - app/src/main/java/com/example/recipeapp/ui/favouriteRecipe/FavouriteRecipeFragment.java

### Kết quả
- Nút yêu thích hoạt động theo cơ chế toggle.
- Có thể thêm và bỏ yêu thích trực tiếp từ màn chi tiết.
- Danh mục yêu thích đồng bộ đúng dữ liệu.

## 3) Localization: chuẩn hóa tiếng Việt có dấu

### Thay đổi
- Chuẩn hóa lại các string tiếng Việt trong resource.
- Bổ sung string cho các thông báo và hành động mới.
- Loại bỏ một số text hard-code không dấu trong layout item.
  - app/src/main/res/values/strings.xml
  - app/src/main/res/layout/item_product_new.xml
  - app/src/main/res/layout/item_product_random.xml

### Kết quả
- UI đồng bộ tiếng Việt có dấu.
- Tránh lệch text giữa layout và resource.

## 4) Kiểm thử build
- Đã chạy assembleDebug sau mỗi nhóm sửa lớn.
- Trạng thái: BUILD SUCCESSFUL.

## Ghi chú kỹ thuật
- Project đang dùng Java 17 và AGP 8.2.1.
- Nếu môi trường local dùng JDK thấp hơn 17, build có thể lỗi.
- Khuyến nghị giữ toàn bộ text hiển thị trong string resource để dễ i18n và bảo trì.

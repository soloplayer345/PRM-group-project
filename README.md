# Recipe App (Android)

Ứng dụng Android quản lý công thức nấu ăn, danh sách mua sắm, lịch món ăn và công thức cá nhân.

## Công nghệ
- Android (Java)
- ViewBinding
- MVVM (Fragment + ViewModel)
- Room Database
- Navigation Component
- RecyclerView
- Material Components

## Yêu cầu môi trường
- Android Studio Hedgehog trở lên (khuyến nghị)
- JDK 17
- Android SDK 34
- Gradle Wrapper đi kèm trong repo

## Cách chạy dự án
1. Clone repo và mở thư mục dự án bằng Android Studio.
2. Đồng bộ Gradle.
3. Chạy một trong các lệnh sau tại thư mục gốc:

```powershell
.\gradlew.bat assembleDebug
```

Hoặc cài trực tiếp lên thiết bị/emulator:

```powershell
.\gradlew.bat installDebug
```

## Cấu trúc chính
- app/src/main/java/com/example/recipeapp/ui: màn hình và ViewModel
- app/src/main/java/com/example/recipeapp/data: database, repository, model động
- app/src/main/java/com/example/recipeapp/data/static_data: dữ liệu công thức tĩnh
- app/src/main/res: layout, string, theme, navigation
- app/src/main/assets/products.json: dữ liệu công thức ban đầu

## Tính năng hiện có
- Xem công thức theo danh mục, tìm kiếm, xem chi tiết
- Thêm vào danh sách mua sắm
- Quản lý yêu thích (thêm, bỏ yêu thích)
- Tạo công thức cá nhân và quản lý nguyên liệu
- Lịch món ăn theo ngày/bữa
- Giao diện tiếng Việt có dấu

## Cập nhật mới
### 1) Màn thêm công thức cá nhân
- Tách rõ nút Thêm nguyên liệu và Lưu công thức.
- Bấm Thêm nguyên liệu mở popup nhập liệu (tên nguyên liệu, khối lượng).
- Hỗ trợ chỉnh sửa và xóa nguyên liệu đã thêm bằng nút Cập nhật/Xóa trên từng dòng.

### 2) Màn công thức yêu thích
- Sửa luồng lưu yêu thích để phản hồi rõ ràng khi thêm thành công/đã tồn tại/thất bại.
- Thêm cơ chế bật/tắt yêu thích ngay trên nút ở màn chi tiết công thức.
- Khi đã yêu thích, nút hiển thị Bỏ yêu thích và bấm sẽ xóa khỏi danh mục yêu thích.
- Sửa ánh xạ product theo id để danh sách yêu thích hiển thị đúng.

### 3) Chuẩn hóa tiếng Việt
- Cập nhật strings sang tiếng Việt có dấu.
- Loại bỏ một số text cứng không dấu trong layout.

## Gợi ý phát triển tiếp
- Thêm test cho ViewModel của luồng yêu thích và luồng thêm/sửa/xóa nguyên liệu.
- Thêm DiffUtil cho adapter để tối ưu cập nhật danh sách.
- Thêm icon trạng thái cho nút yêu thích (outlined/filled).

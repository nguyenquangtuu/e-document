================================================================================
 HỆ THỐNG TIẾP NHẬN VÀ XỬ LÝ HỒ SƠ ĐIỆN TỬ (E-DOCUMENT) v2.0
 Báo cáo Tiểu luận Giữa kỳ môn: Mẫu Thiết Kế (Design Patterns)
 Trường Đại học Tôn Đức Thắng (TDTU) - Khoa Công nghệ Thông tin
================================================================================

1. THÔNG TIN NHÓM
--------------------------------------------------------------------------------
- Mã nhóm: GKPT03
- Thành viên:
  + 524H0031 - Ngô Tấn Thành
  + 524H0132 - Đỗ Quốc Trung
  + 524H0136 - Nguyễn Quang Tựu

2. GIỚI THIỆU DỰ ÁN
--------------------------------------------------------------------------------
- Tên dự án: Hệ thống Tiếp nhận và Xử lý Hồ sơ Điện tử v2.0 (eDocument)
- Mô tả: Nâng cấp từ phiên bản v1.0 nguyên khối (monolithic) sang v2.0 bằng việc
  áp dụng 5 Design Patterns chuẩn GoF, giúp mã nguồn module hóa, linh hoạt mở rộng,
  dễ kiểm thử và bảo trì.
- Link GitHub: https://github.com/nguyenquangtuu/e-document.git
- Link video thuyết trình & demo: [DÁN LINK GOOGLE DRIVE / YOUTUBE CÔNG KHAI VÀO ĐÂY]

3. YÊU CẦU MÔI TRƯỜNG
--------------------------------------------------------------------------------
- Java Development Kit: JDK 8 trở lên (Khuyến nghị JDK 11, 17, 21)
- Không yêu cầu cài đặt Maven/Gradle (Sử dụng trực tiếp javac/java)
- Hệ điều hành: Windows, macOS, Linux

4. CẤU TRÚC THƯ MỤC SOURCE CODE
--------------------------------------------------------------------------------
Thư mục gốc:
├── readme.txt                      : File hướng dẫn chạy và thông tin nhóm
├── MainDemo.java                   : File thực thi chạy 3 kịch bản demo trên Console
├── MainSwingUI.java                : File thực thi chạy giao diện đồ họa Java Swing
├── AddDocumentDialog.java          : Dialog nhập liệu và nộp hồ sơ trên Swing
│
├── model/                          : [Yêu cầu 1] Model dữ liệu & Builder Pattern
│   ├── Document.java               : Lớp chứa thông tin hồ sơ điện tử
│   ├── DocumentBuilder.java        : Builder hỗ trợ khởi tạo từng bước và lưu nháp
│   └── DocumentStatus.java         : Enum trạng thái vòng đời của hồ sơ
│
├── extractor/                      : [Yêu cầu 2] Strategy & Factory Method Pattern
│   ├── ContentExtractor.java       : Interface Strategy trích xuất nội dung
│   ├── ExtractorFactory.java       : Factory tạo bộ đọc phù hợp theo đuôi file
│   ├── TxtExtractor.java           : Bộ đọc file .txt thuần túy
│   ├── PdfExtractor.java           : Bộ đọc file .pdf qua OCR (mô phỏng)
│   └── ImageOcrExtractor.java      : Bộ đọc hình ảnh .jpg, .png qua OCR (mô phỏng)
│
├── validation/                     : [Yêu cầu 3] Chain of Responsibility Pattern
│   ├── ValidationHandler.java      : Abstract Handler cho từng trạm kiểm tra
│   ├── ValidationPipeline.java     : Quản lý chuỗi kiểm duyệt và điều phối ngắt luồng
│   ├── ValidationResult.java       : Đóng gói kết quả kiểm duyệt và thông báo lỗi
│   ├── RequiredFieldsHandler.java  : Trạm 1 - Kiểm tra thông tin bắt buộc và dung lượng <= 5MB
│   ├── AntivirusScanHandler.java   : Trạm 2 - Quét an toàn mã độc / virus trong file
│   └── DuplicateCheckHandler.java  : Trạm 3 - Kiểm tra tính toàn vẹn và chống trùng lặp mã hồ sơ
│
├── notification/                   : [Yêu cầu 4] Observer Pattern
│   ├── DocumentObserver.java       : Interface Observer nhận thông báo
│   ├── NotificationManager.java    : Subject quản lý danh sách kênh và preference người dùng
│   ├── EmailNotifier.java          : Observer gửi thông báo qua Email
│   ├── SmsNotifier.java            : Observer gửi thông báo qua tin nhắn SMS
│   └── AppPushNotifier.java        : Observer gửi thông báo qua App Mobile Push
│
├── repository/                     : [Yêu cầu 5] Repository & Factory Pattern
│   ├── DocumentRepository.java     : Interface chuẩn hóa thao tác lưu trữ
│   ├── RepositoryFactory.java      : Factory khởi tạo kho lưu trữ (JSON/MySQL/AWS S3)
│   ├── JsonFileRepository.java     : Lưu trữ hồ sơ dạng file .json cục bộ
│   ├── MySqlRepository.java        : Mô phỏng lưu trữ vào Cơ sở dữ liệu MySQL
│   └── S3Repository.java           : Mô phỏng lưu trữ lên Đám mây AWS S3
│
├── service/                        : Tầng Service điều phối nghiệp vụ
│   └── DocumentProcessor.java      : Điều phối quy trình duyệt, trích xuất, lưu trữ và thông báo
│
└── test/                           : Tầng kiểm thử tự động
    └── SystemIntegrationTest.java  : Unit Test và Integration Test kiểm thử toàn diện 5 Pattern
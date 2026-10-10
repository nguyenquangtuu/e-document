================================================================================
 HỆ THỐNG TIẾP NHẬN VÀ XỬ LÝ HỒ SƠ ĐIỆN TỬ (E-DOCUMENT) v2.0
 Báo cáo Tiểu luận Giữa kỳ môn: Mẫu Thiết Kế (Design Patterns - Mã MH: 504077)
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
  áp dụng 100% các Mẫu Thiết Kế GoF nằm trong Đề cương môn học (Course Syllabus 504077),
  bao gồm: Singleton (Chương 2), Strategy (Chương 3), Template Method (Chương 4),
  Factory Method (Chương 5), Command với Undo/Redo & Logging (Chương 7),
  Adapter (Chương 8) và Observer (Chương 9).
- Link GitHub: https://github.com/nguyenquangtuu/e-document.git
- Link video thuyết trình & demo: [DÁN LINK GOOGLE DRIVE / YOUTUBE CÔNG KHAI VÀO ĐÂY]

3. YÊU CẦU MÔI TRƯỜNG
--------------------------------------------------------------------------------
- Java Development Kit: JDK 8 trở lên (Khuyến nghị JDK 11, 17, 21, 27)
- Không yêu cầu cài đặt Maven/Gradle (Sử dụng trực tiếp javac/java thuần)
- Hệ điều hành: Windows, macOS, Linux

4. CẤU TRÚC THƯ MỤC SOURCE CODE
--------------------------------------------------------------------------------
Thư mục gốc:
├── readme.txt                      : File hướng dẫn chạy và thông tin nhóm
├── README.md                       : Tài liệu Markdown trên GitHub
├── MainDemo.java                   : File thực thi chạy 5 kịch bản demo trên Console
├── MainSwingUI.java                : File thực thi chạy giao diện đồ họa Java Swing
├── AddDocumentDialog.java          : Dialog tiếp nhận hồ sơ qua SubmitDocumentCommand
│
├── model/                          : Domain Model
│   ├── Document.java               : Lớp thực thể hồ sơ điện tử
│   └── DocumentStatus.java         : Enum trạng thái vòng đời
│
├── command/                        : [Yêu cầu 1] Command Pattern (Chương 7)
│   ├── DocumentCommand.java        : Interface Command (execute, undo)
│   ├── SubmitDocumentCommand.java  : Lệnh nộp và xử lý hồ sơ
│   ├── ApproveDocumentCommand.java : Lệnh phê duyệt hồ sơ
│   ├── RejectDocumentCommand.java  : Lệnh từ chối hồ sơ
│   └── DocumentCommandInvoker.java : Invoker quản lý Undo/Redo & Audit Logging
│
├── extractor/                      : [Yêu cầu 2] Strategy & Factory Method (Chương 3 & 5)
│   ├── ContentExtractor.java       : Interface Strategy trích xuất
│   ├── ExtractorFactory.java       : Factory Method tạo Extractor
│   ├── TxtExtractor.java           : Trích xuất file .txt thật
│   ├── PdfExtractor.java           : Giả lập OCR đọc file .pdf
│   └── ImageOcrExtractor.java      : Giả lập OCR đọc file ảnh .jpg, .png
│
├── validation/                     : [Yêu cầu 3] Template Method Pattern (Chương 4)
│   ├── AbstractDocumentValidator.java : Base Template với Hollywood Principle & Hook
│   ├── StandardDocumentValidator.java : Kiểm duyệt tiêu chuẩn
│   ├── StrictSecurityValidator.java   : Kiểm duyệt an ninh cao (Bật Hook RSA)
│   └── ValidationResult.java       : Đóng gói kết quả kiểm tra
│
├── notification/                   : [Yêu cầu 4] Observer & Singleton Pattern (Chương 9 & 2)
│   ├── NotificationManager.java    : Singleton Subject phát thông báo
│   ├── DocumentObserver.java       : Observer Interface
│   ├── EmailNotifier.java          : Kênh Email
│   ├── SmsNotifier.java            : Kênh SMS
│   └── AppPushNotifier.java        : Kênh App Push
│
├── storage/                        : [Yêu cầu 5] Adapter Pattern (Chương 8)
│   ├── DocumentStorageTarget.java  : Target Interface chuẩn hóa lưu trữ
│   ├── JsonFileStorageAdapter.java : Adapter ghi file JSON thật vào server_storage/
│   ├── MySqlStorageAdapter.java    : Adapter mô phỏng MySQL Database
│   ├── AwsS3StorageAdapter.java    : Adapter mô phỏng Cloud AWS S3
│   └── StorageAdapterFactory.java  : Factory cung cấp Adapter phù hợp
│
└── service/                        : Service điều phối nghiệp vụ
    └── DocumentProcessor.java      : Kết nối Validator, Extractor, Adapter và Notifier

5. HƯỚNG DẪN BIÊN DỊCH VÀ CHẠY
--------------------------------------------------------------------------------
Bước 1: Mở Terminal tại thư mục gốc dự án.

Bước 2: Biên dịch:
        javac -d bin *.java command/*.java extractor/*.java model/*.java notification/*.java storage/*.java service/*.java validation/*.java

Bước 3: Chạy Demo Console (5 kịch bản kiểm thử):
        java -cp bin MainDemo

Bước 4: Chạy giao diện Swing:
        java -cp bin MainSwingUI
================================================================================
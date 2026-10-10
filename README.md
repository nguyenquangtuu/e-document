# Hệ Thống Tiếp Nhận và Xử Lý Hồ Sơ Điện Tử (eDocument) v2.0

> **Báo cáo Tiểu luận Giữa kỳ môn:** Mẫu Thiết Kế (Design Patterns - Mã MH: 504077)  
> **Trường Đại học Tôn Đức Thắng (TDTU)** - Khoa Công nghệ Thông tin  
> **Chương trình chuẩn GoF 100% bám sát Course Syllabus**

---

## 👥 1. Thông Tin Nhóm
* **Mã nhóm:** `GKPT03`
* **Thành viên:**
  * **524H0031** - Ngô Tấn Thành
  * **524H0132** - Đỗ Quốc Trung
  * **524H0136** - Nguyễn Quang Tựu

---

## 📖 2. Giới Thiệu Dự Án
* **Tên dự án:** Hệ thống Tiếp nhận và Xử lý Hồ sơ Điện tử v2.0 (`eDocument`)
* **Mô tả:** Tái cấu trúc và nâng cấp từ phiên bản v1.0 nguyên khối (monolithic) sang v2.0 bằng việc áp dụng **các Design Patterns chuẩn GoF có trong Đề cương môn học (Course Syllabus 504077)**. Hệ thống phân rã module rõ ràng, loại bỏ hoàn toàn các liên kết chặt (tight coupling), tuân thủ chặt chẽ bộ nguyên tắc **SOLID**, chuẩn **Hollywood Principle**, hỗ trợ **Undo/Redo** và **Audit Logging**.
* **GitHub Repository:** [https://github.com/nguyenquangtuu/e-document.git](https://github.com/nguyenquangtuu/e-document.git)
* **Link Video Thuyết trình & Demo:** `[DÁN LINK GOOGLE DRIVE / YOUTUBE CÔNG KHAI VÀO ĐÂY]`

---

## 🏗️ 3. Danh Sách Các Design Pattern Đã Áp Dụng (100% Chuẩn Syllabus TDTU)

| Yêu Cầu | Bài Toán Nghiệp Vụ | Design Pattern (Syllabus) | Lớp Trọng Tâm |
| :---: | :--- | :---: | :--- |
| **YC 1** | Thực thi lệnh nộp/phê duyệt hồ sơ, hỗ trợ **Hoàn tác (Undo/Redo)** và **Audit Logging** | **Command Pattern**<br>*(Chương 7 - Syllabus)* | [`command/DocumentCommand.java`](command/DocumentCommand.java)<br>[`command/SubmitDocumentCommand.java`](command/SubmitDocumentCommand.java)<br>[`command/ApproveDocumentCommand.java`](command/ApproveDocumentCommand.java)<br>[`command/DocumentCommandInvoker.java`](command/DocumentCommandInvoker.java) |
| **YC 2** | Đọc đa định dạng tài liệu (Đọc `.txt` thật, mô phỏng OCR `.pdf` & ảnh `.jpg`) | **Strategy Pattern & Factory Method**<br>*(Chương 3 & 5 - Syllabus)* | [`extractor/ContentExtractor.java`](extractor/ContentExtractor.java)<br>[`extractor/ExtractorFactory.java`](extractor/ExtractorFactory.java) |
| **YC 3** | Quy trình kiểm duyệt hồ sơ nhiều bước, ngắt luồng và kích hoạt **Hook Method** | **Template Method Pattern**<br>*(Chương 4 - Syllabus)* | [`validation/AbstractDocumentValidator.java`](validation/AbstractDocumentValidator.java)<br>[`validation/StandardDocumentValidator.java`](validation/StandardDocumentValidator.java)<br>[`validation/StrictSecurityValidator.java`](validation/StrictSecurityValidator.java) |
| **YC 4** | Đăng ký nhận thông báo theo nhu cầu (`Email`, `SMS`, `App Push`) qua trung tâm duy nhất | **Observer & Singleton Pattern**<br>*(Chương 9 & 2 - Syllabus)* | [`notification/NotificationManager.java`](notification/NotificationManager.java)<br>[`notification/DocumentObserver.java`](notification/DocumentObserver.java) |
| **YC 5** | Tương thích đa nền tảng lưu trữ (Lưu `.json` thật, mô phỏng `MySQL` & `AWS S3`) | **Adapter Pattern**<br>*(Chương 8 - Syllabus)* | [`storage/DocumentStorageTarget.java`](storage/DocumentStorageTarget.java)<br>[`storage/JsonFileStorageAdapter.java`](storage/JsonFileStorageAdapter.java)<br>[`storage/MySqlStorageAdapter.java`](storage/MySqlStorageAdapter.java)<br>[`storage/AwsS3StorageAdapter.java`](storage/AwsS3StorageAdapter.java) |

---

## 📁 4. Cấu Trúc Thư Mục Source Code

```text
e-document/
├── README.md                       # Tài liệu hướng dẫn GitHub
├── readme.txt                      # Tài liệu hướng dẫn nộp bài
├── MainDemo.java                   # Thực thi 5 kịch bản Demo Console
├── MainSwingUI.java                # Giao diện đồ họa Java Swing (có nút Approve & Undo)
├── AddDocumentDialog.java          # Dialog tiếp nhận hồ sơ trên Swing
│
├── model/                          # Domain Model
│   ├── Document.java               # Lớp thực thể hồ sơ điện tử
│   └── DocumentStatus.java         # Enum trạng thái vòng đời
│
├── command/                        # [YC1] Command Pattern (Chương 7)
│   ├── DocumentCommand.java        # Interface Command (execute, undo)
│   ├── SubmitDocumentCommand.java  # Lệnh nộp và xử lý hồ sơ
│   ├── ApproveDocumentCommand.java # Lệnh phê duyệt hồ sơ
│   ├── RejectDocumentCommand.java  # Lệnh từ chối hồ sơ
│   └── DocumentCommandInvoker.java # Invoker quản lý Undo/Redo & Audit Log
│
├── extractor/                      # [YC2] Strategy & Factory Method (Chương 3 & 5)
│   ├── ContentExtractor.java       # Interface Strategy trích xuất
│   ├── ExtractorFactory.java       # Factory Method tạo Extractor
│   ├── TxtExtractor.java           # Trích xuất file .txt thật
│   ├── PdfExtractor.java           # Giả lập OCR đọc file .pdf
│   └── ImageOcrExtractor.java      # Giả lập OCR đọc file ảnh .jpg, .png
│
├── validation/                     # [YC3] Template Method Pattern (Chương 4)
│   ├── AbstractDocumentValidator.java # Base Template với Hollywood Principle & Hook
│   ├── StandardDocumentValidator.java # Kiểm duyệt tiêu chuẩn
│   ├── StrictSecurityValidator.java   # Kiểm duyệt an ninh cao (Bật Hook RSA)
│   └── ValidationResult.java       # Đóng gói kết quả kiểm tra
│
├── notification/                   # [YC4] Observer & Singleton Pattern (Chương 9 & 2)
│   ├── NotificationManager.java    # Singleton Subject phát thông báo
│   ├── DocumentObserver.java       # Observer Interface
│   ├── EmailNotifier.java          # Kênh Email
│   ├── SmsNotifier.java            # Kênh SMS
│   └── AppPushNotifier.java        # Kênh App Push
│
├── storage/                        # [YC5] Adapter Pattern (Chương 8)
│   ├── DocumentStorageTarget.java  # Target Interface chuẩn hóa lưu trữ
│   ├── JsonFileStorageAdapter.java # Adapter ghi file JSON thật vào server_storage/
│   ├── MySqlStorageAdapter.java    # Adapter mô phỏng MySQL Database
│   ├── AwsS3StorageAdapter.java    # Adapter mô phỏng Cloud AWS S3
│   └── StorageAdapterFactory.java  # Factory cung cấp Adapter phù hợp
│
└── service/                        # Service điều phối nghiệp vụ
    └── DocumentProcessor.java      # Kết nối Validator, Extractor, Adapter và Notifier
```

---

## 🚀 5. Hướng Dẫn Biên Dịch và Chạy

### Yêu cầu môi trường
* **JDK:** Java 8 trở lên (Khuyến nghị JDK 11, 17, 21, 27).
* Hoàn toàn không cần cài Maven/Gradle (Dùng thuần thư viện Java SE tiêu chuẩn).

### Lệnh chạy nhanh:

1. **Biên dịch toàn bộ mã nguồn:**
   ```bash
   javac -d bin *.java command/*.java extractor/*.java model/*.java notification/*.java storage/*.java service/*.java validation/*.java
   ```

2. **Chạy kịch bản Demo Console (5 kịch bản tương ứng các chương đề cương):**
   ```bash
   java -cp bin MainDemo
   ```

3. **Chạy giao diện đồ họa Java Swing:**
   ```bash
   java -cp bin MainSwingUI
   ```

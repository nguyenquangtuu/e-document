# Hệ Thống Tiếp Nhận và Xử Lý Hồ Sơ Điện Tử (eDocument) v2.0

> **Báo cáo Tiểu luận Giữa kỳ môn:** Mẫu Thiết Kế (Design Patterns)  
> **Trường Đại học Tôn Đức Thắng (TDTU)** - Khoa Công nghệ Thông tin

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
* **Mô tả:** Tái cấu trúc và nâng cấp từ phiên bản v1.0 nguyên khối (monolithic) sang v2.0 bằng việc áp dụng **5 Design Patterns chuẩn GoF**. Hệ thống mới module hóa cao, linh hoạt mở rộng, tuân thủ nguyên tắc **SOLID**, dễ bảo trì và kiểm thử.
* **GitHub Repository:** [https://github.com/nguyenquangtuu/e-document.git](https://github.com/nguyenquangtuu/e-document.git)
* **Link Video Thuyết trình & Demo:** `[DÁN LINK GOOGLE DRIVE / YOUTUBE CÔNG KHAI VÀO ĐÂY]`

---

## 🏗️ 3. Danh Sách 5 Design Pattern Đã Áp Dụng

| Yêu Cầu | Bài Toán Nghiệp Vụ | Design Pattern | Lớp Trọng Tâm |
| :---: | :--- | :---: | :--- |
| **YC 1** | Cho phép lưu nháp và nộp hồ sơ theo từng bước | **Builder** | [`model/DocumentBuilder.java`](model/DocumentBuilder.java)<br>[`model/Document.java`](model/Document.java) |
| **YC 2** | Đọc đa định dạng tài liệu (Đọc `.txt` thật, mô phỏng OCR `.pdf` & ảnh `.jpg`) | **Strategy + Factory Method** | [`extractor/ContentExtractor.java`](extractor/ContentExtractor.java)<br>[`extractor/ExtractorFactory.java`](extractor/ExtractorFactory.java) |
| **YC 3** | Quy trình kiểm duyệt linh hoạt qua 3 trạm độc lập | **Chain of Responsibility** | [`validation/ValidationPipeline.java`](validation/ValidationPipeline.java)<br>[`validation/ValidationHandler.java`](validation/ValidationHandler.java) |
| **YC 4** | Đăng ký nhận thông báo theo nhu cầu (`Email`, `SMS`, `App Push`) | **Observer** | [`notification/NotificationManager.java`](notification/NotificationManager.java)<br>[`notification/DocumentObserver.java`](notification/DocumentObserver.java) |
| **YC 5** | Mở rộng lưu trữ dữ liệu (Lưu `.json` thật, mô phỏng CSDL `MySQL` & `AWS S3`) | **Repository + Factory** | [`repository/DocumentRepository.java`](repository/DocumentRepository.java)<br>[`repository/RepositoryFactory.java`](repository/RepositoryFactory.java) |

---

## 📁 4. Cấu Trúc Thư Mục Source Code

```text
e-document/
├── README.md                       # Tài liệu hướng dẫn GitHub
├── readme.txt                      # Tài liệu hướng dẫn nộp bài
├── MainDemo.java                   # Thực thi 3 kịch bản Demo Console
├── MainSwingUI.java                # Giao diện đồ họa Java Swing
├── AddDocumentDialog.java          # Dialog tiếp nhận hồ sơ trên Swing
│
├── model/                          # [YC1] Model dữ liệu & Builder Pattern
│   ├── Document.java
│   ├── DocumentBuilder.java
│   └── DocumentStatus.java
│
├── extractor/                      # [YC2] Strategy & Factory Method
│   ├── ContentExtractor.java
│   ├── ExtractorFactory.java
│   ├── TxtExtractor.java
│   ├── PdfExtractor.java
│   └── ImageOcrExtractor.java
│
├── validation/                     # [YC3] Chain of Responsibility
│   ├── ValidationHandler.java
│   ├── ValidationPipeline.java
│   ├── ValidationResult.java
│   ├── RequiredFieldsHandler.java  # Trạm 1: Dung lượng <= 5MB + đủ thông tin
│   ├── AntivirusScanHandler.java   # Trạm 2: Quét virus / malware
│   └── DuplicateCheckHandler.java  # Trạm 3: Chống trùng lặp mã hồ sơ
│
├── notification/                   # [YC4] Observer Pattern
│   ├── DocumentObserver.java
│   ├── NotificationManager.java
│   ├── EmailNotifier.java
│   ├── SmsNotifier.java
│   └── AppPushNotifier.java
│
├── repository/                     # [YC5] Repository & Factory Pattern
│   ├── DocumentRepository.java
│   ├── RepositoryFactory.java
│   ├── JsonFileRepository.java
│   ├── MySqlRepository.java
│   └── S3Repository.java
│
└── service/                        # Service điều phối nghiệp vụ
    └── DocumentProcessor.java
```

---

## 🚀 5. Hướng Dẫn Biên Dịch và Chạy

### Yêu cầu môi trường
* **JDK:** Java 8 trở lên (Khuyến nghị JDK 11, 17, 21, 27).
* Không cần cài Maven/Gradle.

### Lệnh chạy nhanh:

1. **Biên dịch toàn bộ mã nguồn:**
   ```bash
   javac -d bin *.java
   ```

2. **Chạy kịch bản Demo Console:**
   ```bash
   java -cp bin MainDemo
   ```

3. **Chạy giao diện đồ họa Java Swing:**
   ```bash
   java -cp bin MainSwingUI
   ```

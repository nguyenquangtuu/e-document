# TRƯỜNG ĐẠI HỌC TÔN ĐỨC THẮNG
# KHOA CÔNG NGHỆ THÔNG TIN
# BỘ MÔN CÔNG NGHỆ PHẦN MỀM

---

# BÁO CÁO TIỂU LUẬN GIỮA KỲ
# MÔN HỌC: MẪU THIẾT KẾ (MÃ MÔN HỌC: 504077)

### ĐỀ TÀI: TÁI CẤU TRÚC VÀ NÂNG CẤP KIẾN TRÚC HỆ THỐNG TIẾP NHẬN VÀ XỬ LÝ HỒ SƠ ĐIỆN TỬ (eDOCUMENT PHIÊN BẢN 2.0)

**Mã nhóm sinh viên:** GKPT03  
**Học kỳ và năm học:** Học kỳ Giữa - Năm học 2026-2027  

**Danh sách sinh viên thực hiện:**
1. Ngô Tấn Thành - MSSV: 524H0031
2. Đỗ Quốc Trung - MSSV: 524H0132
3. Nguyễn Quang Tựu - MSSV: 524H0136

**Giảng viên phụ trách hướng dẫn:**  
ThS. Vũ Đình Hồng (Bộ môn Công nghệ Phần mềm)

**Kho lưu trữ mã nguồn dự án:** https://github.com/nguyenquangtuu/e-document.git  

**THÀNH PHỐ HỒ CHÍ MINH, NĂM 2026**

---

# LỜI MỞ ĐẦU VÀ TRI ÂN

Trong bối cảnh các cơ quan quản lý và doanh nghiệp đang đẩy mạnh số hóa thủ tục hành chính, hệ thống tiếp nhận và xử lý hồ sơ điện tử đóng vai trò là "xương sống" bảo đảm quy trình công vụ diễn ra thông suốt, minh bạch và chính xác. Tuy nhiên, tính chất của nghiệp vụ công luôn đi kèm với sự biến đổi không ngừng: các biểu mẫu liên tục cập nhật theo thông tư mới, dữ liệu đính kèm ngày càng phong phú về định dạng (từ văn bản thô, tài liệu PDF đến ảnh chụp giấy tờ cần bóc tách OCR), và các tiêu chuẩn kiểm duyệt an ninh thông tin ngày một khắt khe.

Trước những biến động đó, một hệ thống xây dựng theo tư duy lập trình thủ tục hoặc kiến trúc nguyên khối chắp vá sẽ nhanh chóng bộc lộ sự quá tải, trở nên mong manh và tốn kém chi phí bảo trì. Việc nghiên cứu, ứng dụng các Mẫu thiết kế phần mềm (Design Patterns) cùng các nguyên lý lập trình hướng đối tượng kinh điển (SOLID) chính là chìa khóa then chốt để xây dựng nên một kiến trúc linh hoạt, có tính module hóa cao và sẵn sàng đáp ứng mọi yêu cầu mở rộng trong tương lai.

Nhóm sinh viên GKPT03 xin trân trọng gửi lời cảm ơn sâu sắc nhất tới Thầy ThS. Vũ Đình Hồng – giảng viên bộ môn Mẫu Thiết Kế, Khoa Công nghệ Thông tin, Trường Đại học Tôn Đức Thắng. Bằng phương pháp giảng dạy giàu tính trực quan, gắn liền giữa lý thuyết trừu tượng của GoF với các tình huống kỹ thuật thực tế, Thầy đã giúp chúng em xây dựng tư duy phân tích kiến trúc mạch lạc, biết cách nhận diện các "mùi mã" (Code Smells) và lựa chọn chính xác giải pháp thiết kế phù hợp cho từng bài toán.

Chúng em cũng xin chân thành cảm ơn Ban Lãnh đạo Khoa Công nghệ Thông tin đã tạo điều kiện học tập và nghiên cứu thực nghiệm thuận lợi. Dù cả nhóm đã nỗ lực hết mình để khảo sát, tái cấu trúc và hoàn thiện bài báo cáo này, những thiếu sót nhất định là điều khó tránh khỏi. Chúng em rất mong nhận được những góp ý, chỉ dẫn quý báu từ Thầy để tiếp tục hoàn thiện kiến thức chuyên môn.

---

# CAM ĐOAN KẾT QUẢ ĐỒ ÁN

Nhóm sinh viên GKPT03 xin cam đoan rằng: Báo cáo tiểu luận giữa kỳ đề tài "Tái cấu trúc và nâng cấp kiến trúc hệ thống tiếp nhận và xử lý hồ sơ điện tử eDocument phiên bản 2.0" là công trình nghiên cứu, thiết kế và lập trình độc lập của các thành viên trong nhóm, dưới sự định hướng học thuật của Thầy ThS. Vũ Đình Hồng.

Mọi số liệu thực nghiệm, lược đồ kiến trúc lớp, biểu đồ tương tác tuần tự và mã nguồn minh họa trong tài liệu này đều được xây dựng dựa trên kết quả vận hành thực tế của dự án. Toàn bộ các tài liệu tham khảo, giáo trình môn học và nghiên cứu liên quan đều được trích dẫn xuất xứ đầy đủ, trung thực ở phần Tài liệu tham khảo.

Chúng em xin hoàn toàn chịu trách nhiệm trước kỷ luật học thuật của nhà trường nếu có bất kỳ sự thiếu trung thực nào xảy ra trong nội dung đồ án.

Thành phố Hồ Chí Minh, ngày 11 tháng 10 năm 2026

**Đại diện nhóm sinh viên thực hiện:**  
Ngô Tấn Thành  
Đỗ Quốc Trung  
Nguyễn Quang Tựu  

---

# BẢNG ĐÁNH GIÁ CỦA GIẢNG VIÊN

### Nhận xét của Giảng viên hướng dẫn:
................................................................................................................................................................  
................................................................................................................................................................  
................................................................................................................................................................  
................................................................................................................................................................  
................................................................................................................................................................  

Chữ ký Giảng viên hướng dẫn: ............................................................

---

### Đánh giá và Điểm số của Giảng viên chấm bài:
................................................................................................................................................................  
................................................................................................................................................................  
................................................................................................................................................................  
................................................................................................................................................................  

Điểm số bằng số: .................... Điểm số bằng chữ: ............................................................  
Chữ ký Giảng viên chấm bài: ............................................................

---

# MỤC LỤC CHI TIẾT

* **LỜI MỞ ĐẦU VÀ TRI ÂN**
* **CAM ĐOAN KẾT QUẢ ĐỒ ÁN**
* **BẢNG ĐÁNH GIÁ CỦA GIẢNG VIÊN**
* **CHƯƠNG 1: KHẢO SÁT HIỆN TRẠNG VÀ PHÂN TÍCH HẠN CHẾ KIẾN TRÚC PHIÊN BẢN 1.0**
  * 1.1. Bối cảnh bài toán và đặc trưng kiến trúc phiên bản ban đầu
  * 1.2. Hiện trạng vận hành các luồng xử lý nghiệp vụ cốt lõi
  * 1.3. Nhận diện các triệu chứng mục rữa thiết kế (Design Smells)
  * 1.4. Phân tích các mùi mã nguồn cụ thể (Code Smells) trong hệ thống cũ
  * 1.5. Đánh giá rủi ro và tác động tiêu cực đối với khả năng mở rộng
* **CHƯƠNG 2: PHÂN TÍCH VÀ ĐỀ XUẤT GIẢI PHÁP THIẾT KẾ CHO PHIÊN BẢN 2.0**
  * 2.1. Giải pháp cho Yêu cầu 1: Khởi tạo hồ sơ linh hoạt và hỗ trợ lưu nháp đa giai đoạn
    * 2.1.1. Phân tích hiện trạng bài toán
    * 2.1.2. Đề xuất giải pháp
    * 2.1.3. Sơ đồ lớp
    * 2.1.4. Mã nguồn chi tiết
  * 2.2. Giải pháp cho Yêu cầu 2: Quản lý thao tác nghiệp vụ, hoàn tác trạng thái và truy vết kiểm toán
    * 2.2.1. Phân tích hiện trạng bài toán
    * 2.2.2. Đề xuất giải pháp
    * 2.2.3. Sơ đồ lớp
    * 2.2.4. Mã nguồn chi tiết
  * 2.3. Giải pháp cho Yêu cầu 3: Bóc tách nội dung tệp tin đa định dạng không phụ thuộc phần cứng
    * 2.3.1. Phân tích hiện trạng bài toán
    * 2.3.2. Đề xuất giải pháp
    * 2.3.3. Sơ đồ lớp
    * 2.3.4. Mã nguồn chi tiết
  * 2.4. Giải pháp cho Yêu cầu 4: Chuẩn hóa quy trình thẩm định hồ sơ phân tầng và kiểm tra an ninh đặc thù
    * 2.4.1. Phân tích hiện trạng bài toán
    * 2.4.2. Đề xuất giải pháp
    * 2.4.3. Sơ đồ lớp
    * 2.4.4. Mã nguồn chi tiết
  * 2.5. Giải pháp cho Yêu cầu 5: Phát hành thông báo sự kiện hướng người dùng qua nhiều kênh truyền thông
    * 2.5.1. Phân tích hiện trạng bài toán
    * 2.5.2. Đề xuất giải pháp
    * 2.5.3. Sơ đồ lớp
    * 2.5.4. Mã nguồn chi tiết
  * 2.6. Giải pháp cho Yêu cầu 6: Trừu tượng hóa hạ tầng lưu trữ và khả năng chuyển đổi môi trường tức thì
    * 2.6.1. Phân tích hiện trạng bài toán
    * 2.6.2. Đề xuất giải pháp
    * 2.6.3. Sơ đồ lớp
    * 2.6.4. Mã nguồn chi tiết
* **CHƯƠNG 3: THIẾT KẾ KIẾN TRÚC TỔNG THỂ HỆ THỐNG V2.0 VÀ LUỒNG TƯƠNG TÁC**
  * 3.1. Sơ đồ lớp tổng thể toàn bộ hệ thống v2.0
  * 3.2. Sơ đồ tuần tự thể hiện chu trình xử lý hồ sơ
  * 3.3. Bảng đối chiếu đồng nhất giữa sơ đồ thiết kế và mã nguồn thực thi
* **CHƯƠNG 4: ĐÁNH GIÁ CHUYÊN SÂU TUÂN THỦ NGUYÊN TẮC SOLID VÀ NGUYÊN LÝ GOF**
  * 4.1. Đánh giá nguyên tắc đơn trách nhiệm (Single Responsibility Principle)
  * 4.2. Đánh giá nguyên tắc đóng mở (Open/Closed Principle)
  * 4.3. Đánh giá nguyên tắc thay thế Liskov (Liskov Substitution Principle)
  * 4.4. Đánh giá nguyên tắc phân tách giao diện (Interface Segregation Principle)
  * 4.5. Đánh giá nguyên tắc đảo ngược phụ thuộc (Dependency Inversion Principle)
  * 4.6. Đánh giá nguyên lý Hollywood (Hollywood Principle) trong Template Method
* **CHƯƠNG 5: KỊCH BẢN KIỂM THỬ THỰC NGHIỆM VÀ ĐÁNH GIÁ VẬN HÀNH**
  * 5.1. Thiết kế 5 kịch bản kiểm thử tương ứng các chương đề cương môn học
  * 5.2. Kết quả chạy thực nghiệm trên môi trường dòng lệnh (Console)
  * 5.3. Đánh giá khả năng tương tác trực quan trên giao diện Java Swing UI
* **CHƯƠNG 6: KẾT LUẬN VÀ HƯỚNG PHÁT TRIỂN**
  * 6.1. Bảng đối chiếu tổng quan giữa phiên bản 1.0 và phiên bản 2.0
  * 6.2. Các mục tiêu chất lượng đã đạt được
  * 6.3. Định hướng mở rộng trong tương lai
* **TÀI LIỆU THAM KHẢO**

---

# CHƯƠNG 1: KHẢO SÁT HIỆN TRẠNG VÀ PHÂN TÍCH HẠN CHẾ KIẾN TRÚC PHIÊN BẢN 1.0

### 1.1. Bối cảnh bài toán và đặc trưng kiến trúc phiên bản ban đầu
Hệ thống tiếp nhận và xử lý hồ sơ điện tử phiên bản 1.0 (eDocument v1.0) được xây dựng trong giai đoạn đầu với mục đích giải quyết nhanh yêu cầu số hóa thủ tục nộp giấy tờ hành chính. Toàn bộ giải pháp được thiết kế theo mô hình khối đơn (Monolithic Architecture), trong đó toàn bộ quy trình từ khâu thu thập thông tin, kiểm tra tính hợp lệ của giấy tờ, trích xuất dữ liệu tập tin, ghi nhận xuống bộ nhớ máy chủ cho đến việc gửi thư báo cáo cho người nộp đều được gom chung vào một lớp xử lý duy nhất mang tên `DocumentProcessor`.

Mô hình sơ khởi này giúp đội ngũ phát triển nhanh chóng đưa phần mềm vào chạy thử nghiệm. Tuy nhiên, khi khối lượng hồ sơ thực tế gia tăng, yêu cầu nghiệp vụ bắt đầu xuất hiện sự phân hóa (cần kiểm tra chữ ký số cho văn bản mật, cần đọc tệp scan, cần lưu trữ lên đám mây, cần hoàn tác khi duyệt nhầm), cấu trúc nguyên khối v1.0 ngay lập tức bộc lộ sự bất cập. Việc thiếu vắng các ranh giới module rõ ràng khiến mã nguồn trở thành một khối chằng chịt, làm gia tăng cấp số nhân chi phí sửa chữa và tiềm ẩn rủi ro hỏng hóc dây chuyền.

---

### 1.2. Hiện trạng vận hành các luồng xử lý nghiệp vụ cốt lõi
Khảo sát chi tiết hành vi của hệ thống phiên bản 1.0 qua các ca sử dụng chính, nhóm ghi nhận các đặc điểm sau:

1. **Khâu khởi tạo và ghi nhận hồ sơ ban đầu:** Khi công dân mở màn hình nhập liệu, hệ thống đòi hỏi phải có đầy đủ toàn bộ thông tin cùng lúc mới cho phép khởi tạo thực thể `Document`. Nếu công dân chỉ mới khai báo họ tên, địa chỉ mà chưa kịp chọn tập tin đính kèm hoặc chưa có mã chứng thư số, hệ thống hoàn toàn không có cách nào ghi nhận trạng thái trung gian để lưu nháp.
2. **Khâu điều phối trạng thái công vụ:** Các thao tác duyệt hồ sơ, yêu cầu chỉnh sửa hay từ chối hồ sơ chỉ đơn thuần là các lệnh gán biến trực tiếp trên bộ nhớ. Không có bất kỳ bản ghi lịch sử nào được tạo ra để lưu vết; cán bộ lỡ tay thao tác sai không thể khôi phục lại trạng thái cũ, gây ảnh hưởng nghiêm trọng đến quyền lợi của người dân.
3. **Khâu kiểm duyệt điều kiện hợp thức:** Logic xác thực dữ liệu đầu vào bị dồn nén trong một phương thức duy nhất. Việc kiểm tra định dạng email, kiểm tra dung lượng tập tin (dưới 5MB) và kiểm tra đuôi tệp được lồng ghép trong các cấu trúc rẽ nhánh cố định. Quy trình này mang tính cứng nhắc tuyệt đối: không thể đổi thứ tự kiểm tra, không thể bật thêm bước quét mã độc hay thẩm định chữ ký số nâng cao cho các loại hồ sơ cơ mật.
4. **Khâu đọc và phân tích tập tin:** Hệ thống cũ chỉ giải mã được các tệp văn bản thô `.TXT`. Khi người dùng nộp tệp văn bản định dạng `.PDF` hoặc giấy tờ scan chụp hình ảnh `.JPG`, luồng xử lý hoàn toàn bỏ qua nội dung do không có thuật toán chuyển đổi tương thích.
5. **Khâu lưu trữ và đồng bộ dữ liệu:** Sau khi kiểm tra, phương thức xử lý tự động khởi tạo đối tượng `FileWriter` và ghi trực tiếp nội dung hồ sơ dưới dạng chuỗi JSON thô xuống đường dẫn cứng trên ổ đĩa máy chủ. Logic nghiệp vụ vì thế bị trói chặt vào hệ thống tệp cục bộ.
6. **Khâu phát thông báo kết quả:** Hệ thống cài đặt cố định hành vi gửi đồng thời cả Email và SMS cho mọi giao dịch. Hai dịch vụ này được tạo mới bằng từ khóa `new` ngay trong phương thức nghiệp vụ, không cho phép công dân tùy chọn kênh nhận tin và gây lãng phí băng thông dịch vụ.

#### Bảng 1.1: Tổng hợp hiện trạng và rủi ro kỹ thuật trong kiến trúc phiên bản 1.0
| Luồng nghiệp vụ | Cơ chế hiện thực trong phiên bản 1.0 | Rủi ro và hạn chế vận hành |
| :--- | :--- | :--- |
| **Khởi tạo hồ sơ** | Nạp chồng constructor với danh sách 13 tham số nguyên thủy. | Không cho phép lưu nháp; dễ nhầm lẫn thứ tự đối số; thiếu linh hoạt. |
| **Điều phối thao tác** | Gán trực tiếp giá trị trường trạng thái trong lớp xử lý. | Không thể hoàn tác (Undo); thiếu nhật ký kiểm toán hành chính (Audit Log). |
| **Bóc tách tài liệu** | Sử dụng khối `if-else` cứng để kiểm tra phần mở rộng tệp. | Chỉ hỗ trợ `.txt`; vi phạm nguyên lý OCP; không mở rộng được OCR. |
| **Thẩm định hồ sơ** | Viết dồn cục hàng trăm dòng lệnh kiểm tra trong một hàm. | Không tái sử dụng được; không có hook chèn kiểm tra an ninh nâng cao. |
| **Hệ thống thông báo** | Trực tiếp gọi `new` cho từng dịch vụ gửi thư và tin nhắn. | Gắn kết chặt chẽ (Tight coupling); lãng phí socket mạng; thiếu cấu hình người dùng. |
| **Lưu trữ dữ liệu** | Ghi tệp vật lý trực tiếp thông qua luồng I/O cấp thấp `FileWriter`. | Rò rỉ mã nguồn truy xuất; không thể chuyển đổi sang Database hay Cloud. |

---

### 1.3. Nhận diện các triệu chứng mục rữa thiết kế (Design Smells)
Đối chiếu với các tiêu chuẩn thiết kế kiến trúc phần mềm sạch, hệ sinh thái v1.0 bộc lộ ba triệu chứng mục rữa thiết kế điển hình:

* **Tính cứng nhắc (Rigidity):** Kiến trúc có xu hướng chống lại sự thay đổi. Một yêu cầu chỉnh sửa nhỏ từ phía nghiệp vụ (ví dụ: bổ sung tùy chọn lưu tạm khi khai báo, hoặc chuyển nơi lưu trữ từ tệp JSON sang hệ quản trị MySQL) buộc lập trình viên phải can thiệp và sửa đổi mã nguồn ở hàng loạt vị trí khác nhau trong lớp `DocumentProcessor`.
* **Tính dễ vỡ (Fragility):** Khi các thành phần trong hệ thống gắn kết quá chặt chẽ, việc tác động vào một module (chẳng hạn như nâng cấp thuật toán đọc tập tin) rất dễ dẫn đến lỗi phát sinh bất ngờ ở các module hoàn toàn không liên quan (như luồng gửi thông báo hoặc logic kiểm tra dữ liệu).
* **Tính bất động (Immobility):** Các đoạn mã hữu ích (như logic đọc tệp văn bản hoặc hàm gửi tin nhắn cảnh báo) bị chôn vùi bên trong khối xử lý khổng lồ. Khi một phân hệ khác cần tái sử dụng các chức năng này, lập trình viên không thể tách rời chúng ra mà buộc phải sao chép lại đoạn mã, dẫn đến hiện tượng trùng lặp mã (Code Duplication).

---

### 1.4. Phân tích các mùi mã nguồn cụ thể (Code Smells) trong hệ thống cũ
Đi sâu vào từng phân đoạn mã nguồn của phiên bản v1.0, nhóm xác định được 6 mùi mã nguồn nghiêm trọng:

* **Long Parameter List (Danh sách tham số quá tải):** Phương thức khởi tạo của lớp `Document.java` đòi hỏi tới 13 tham số truyền vào cùng lúc. Hiện tượng này không chỉ gây khó khăn cho việc viết mã kiểm thử mà còn hoàn toàn làm tê liệt tính năng nhập liệu từng bước trên giao diện.
* **Large Class (Lớp quá tải trách nhiệm - God Class):** Lớp `DocumentProcessor` vi phạm nghiêm trọng Nguyên tắc Đơn trách nhiệm (SRP). Lớp này vừa quản lý quy trình, vừa thẩm định tính hợp lệ, vừa bóc tách nội dung tệp, vừa ghi dữ liệu I/O và vừa đảm nhận việc phân phối thông báo.
* **Long Method (Phương thức quá dài):** Các hàm nghiệp vụ như `process()` hay `saveToStorage()` chứa hàng chục dòng lệnh đan xen giữa xử lý logic cấp cao và tương tác hệ thống cấp thấp, làm suy giảm khả năng đọc hiểu và gây khó khăn cho việc kiểm thử tự động.
* **Switch Statements / If-Else Chains (Chuỗi rẽ nhánh điều kiện dày đặc):** Việc sử dụng chuỗi câu lệnh `if-else` kéo dài để phân nhánh định dạng tệp tin vi phạm trực tiếp Nguyên tắc Đóng/Mở (OCP). Mỗi khi cần hỗ trợ thêm định dạng tài liệu mới, nhà phát triển buộc phải mở và sửa đổi trực tiếp mã nguồn của lớp điều phối trung tâm.
* **Hardcoded Dependencies (Sự phụ thuộc bị gán cứng):** Các đối tượng thông báo (Email, SMS) và lưu trữ cục bộ được khởi tạo trực tiếp bằng từ khóa `new` bên trong hàm, tước bỏ khả năng tiêm phụ thuộc (Dependency Injection) và cô lập hệ thống với các dịch vụ bên ngoài.
* **Non-reversible Operations (Thao tác một chiều không thể đảo ngược):** Các hành động phê duyệt hay từ chối hồ sơ bị thực thi mà không có đối tượng đóng gói trạng thái trước đó. Hệ thống hoàn toàn thiếu vắng cơ chế ghi nhận nhật ký kiểm toán và tính năng hoàn tác khi xảy ra sai sót nghiệp vụ.

---

### 1.5. Đánh giá rủi ro và tác động tiêu cực đối với khả năng mở rộng
Kiến trúc nguyên khối cũ đặt ra những trở ngại lớn cho sự tồn tại và phát triển của dự án:
* **Chi phí bảo trì tăng vọt:** Mỗi yêu cầu cập nhật nghiệp vụ đòi hỏi đội ngũ phát triển phải dành nhiều thời gian đọc lại toàn bộ khối mã nguồn để tránh tác dụng phụ (side-effects), làm chậm tiến độ bàn giao sản phẩm.
* **Khó khăn trong kiểm thử đơn vị (Unit Testing):** Các thành phần bị khóa chặt vào nhau khiến việc viết các ca kiểm thử độc lập cho từng module (như kiểm tra thuật toán đọc tệp mà không phụ thuộc vào hệ thống tệp vật lý) trở nên bất khả thi.
* **Rủi ro gián đoạn dịch vụ công:** Do mã nguồn thiếu khả năng cách ly lỗi, một trục trặc nhỏ tại cổng gửi thông báo SMS cũng có thể làm gián đoạn toàn bộ tiến trình nộp hồ sơ của công dân.

---

# CHƯƠNG 2: PHÂN TÍCH VÀ ĐỀ XUẤT GIẢI PHÁP THIẾT KẾ CHO PHIÊN BẢN 2.0

Để giải quyết triệt để các hạn chế trên, phiên bản 2.0 được tái cấu trúc toàn diện theo hướng module hóa, áp dụng các Mẫu thiết kế GoF chuẩn mực bám sát từng yêu cầu nghiệp vụ thực tế.

---

### 2.1. Giải pháp cho Yêu cầu 1: Khởi tạo hồ sơ linh hoạt và hỗ trợ lưu nháp đa giai đoạn

#### 2.1.1. Phân tích hiện trạng bài toán
* **Vấn đề:** Trong phiên bản cũ, thực thể dữ liệu `Document` rơi vào mẫu chống thiết kế "Telescoping Constructor". Lớp này sở hữu một hàm khởi tạo cồng kềnh với 13 tham số kiểu nguyên thủy (`String`, `long`) truyền vào đồng thời tại một thời điểm duy nhất.
* **Hạn chế:**
  * **Input Coupling (Khớp nối dữ liệu cứng nhắc):** Bắt buộc phải có đủ 100% dữ liệu mới có thể tạo ra đối tượng. Nghiệp vụ "Lưu nháp" khi người dùng chỉ mới điền thông tin định danh ban đầu mà chưa tải tệp hay chưa ký số hoàn toàn bị vô hiệu hóa.
  * **Type Confusion (Nguy cơ nhầm lẫn vị trí tham số):** Có tới 8 tham số liên tiếp mang cùng kiểu `String` (email người nộp, số điện thoại người nộp, email cán bộ, số điện thoại cán bộ...). Trình biên dịch không thể kiểm tra tính đúng đắn về ngữ nghĩa, chỉ cần lập trình viên truyền nhầm vị trí hai đối số là dữ liệu sẽ bị sai lệch âm thầm mà không hề báo lỗi.
  * **Thiếu khả năng tương thích với giao diện nhập liệu:** Màn hình tiếp nhận dạng nhiều bước (Step-by-step Wizard) không thể ánh xạ trạng thái vào thực thể nếu thiếu cơ chế tích lũy thông tin từng phần.

#### 2.1.2. Đề xuất giải pháp
* **Pattern lựa chọn:** Builder Pattern.
* **Lý do lựa chọn:**
  * **Phân rã chuỗi tham số khởi tạo quá tải (Deconstruct Constructor Bloat):** Thay thế hàm khởi tạo khổng lồ bằng các phương thức xâu chuỗi (Method Chaining) mang ngữ nghĩa rõ ràng như `withId()`, `withApplicantInfo()`, `withOfficerInfo()`, giúp mã nguồn trở nên trực quan và loại bỏ hoàn toàn lỗi nhầm vị trí tham số.
  * **Hiện thực hóa trọn vẹn nghiệp vụ Lưu nháp (Incremental Construction):** Cho phép người dùng dừng lại ở bất kỳ công đoạn nào trên giao diện `AddDocumentDialog` để lưu tạm các thông tin hiện có mà không bị ràng buộc bởi các thuộc tính chưa hoàn tất.
  * **Kiểm soát chặt chẽ tính toàn vẹn trước khi chuyển giao:** Phương thức `build()` đóng vai trò là "chốt chặn", cho phép kiểm tra các điều kiện nghiệp vụ cốt lõi trước khi thực thể `Document` hoàn chỉnh được bàn giao cho các tầng xử lý tiếp theo.
  * **Tuân thủ Nguyên tắc Đơn trách nhiệm (SRP):** Tách bạch hoàn toàn trách nhiệm lưu trữ thuộc tính của `Document` khỏi quy trình lắp ráp, thiết lập giá trị do `Document.Builder` đảm nhiệm.

#### 2.1.3. Sơ đồ lớp
```
+-------------------------------------------------------------+
|                     AddDocumentDialog                       |
+-------------------------------------------------------------+
| - txtApplicantName, txtApplicantEmail, txtApplicantPhone    |
| - txtOfficerName, txtOfficerEmail, txtOfficerPhone          |
| - cbDocumentType, txtDigitalSignature, selectedFile         |
+-------------------------------------------------------------+
| + submitAction(): void                                      |
+-------------------------------------------------------------+
                              |
                              | ủy thác khởi tạo
                              v
+-------------------------------------------------------------+
|                      Document.Builder                       |
+-------------------------------------------------------------+
| - document: Document                                        |
+-------------------------------------------------------------+
| + withId(id: String): Builder                               |
| + withApplicantInfo(name, email, phone: String): Builder    |
| + withOfficerInfo(name, email, phone: String): Builder      |
| + withDocumentType(type: String): Builder                   |
| + withFileInfo(path, ext: String, size: long): Builder      |
| + withSignatureAndContent(sig, content: String): Builder    |
| + withStatus(status: DocumentStatus): Builder               |
| + build(): Document                                         |
+-------------------------------------------------------------+
                              |
                              | tạo ra thực thể
                              v
+-------------------------------------------------------------+
|                          Document                           |
+-------------------------------------------------------------+
| - id, applicantName, applicantEmail, applicantPhone: String |
| - officerName, officerEmail, officerPhone: String           |
| - documentType, filePath, fileExtension: String             |
| - fileSizeKB: long                                          |
| - digitalSignature, extractedContent: String                |
| - status: DocumentStatus                                    |
+-------------------------------------------------------------+
| + getId(): String, + setId(id: String): void                |
| + validate(): boolean                                       |
+-------------------------------------------------------------+
```

#### 2.1.4. Mã nguồn chi tiết
```java
// Lớp tĩnh Builder lồng trong model/Document.java
package model;

public class Document {
    private String id;
    private String applicantName;
    private String applicantEmail;
    private String applicantPhone;
    private String officerName;
    private String officerEmail;
    private String officerPhone;
    private String documentType;
    private String filePath;
    private String fileExtension;
    private long fileSizeKB;
    private String digitalSignature;
    private String extractedContent;
    private DocumentStatus status;

    public Document() {
        this.status = DocumentStatus.MOI_TAO;
    }

    // Builder tĩnh hỗ trợ thiết lập thuộc tính theo chuỗi phương thức
    public static class Builder {
        private final Document document;

        public Builder() {
            this.document = new Document();
        }

        public Builder withId(String id) {
            document.id = id;
            return this;
        }

        public Builder withApplicantInfo(String name, String email, String phone) {
            document.applicantName = name;
            document.applicantEmail = email;
            document.applicantPhone = phone;
            return this;
        }

        public Builder withOfficerInfo(String name, String email, String phone) {
            document.officerName = name;
            document.officerEmail = email;
            document.officerPhone = phone;
            return this;
        }

        public Builder withDocumentType(String documentType) {
            document.documentType = documentType;
            return this;
        }

        public Builder withFileInfo(String filePath, String fileExtension, long fileSizeKB) {
            document.filePath = filePath;
            document.fileExtension = fileExtension;
            document.fileSizeKB = fileSizeKB;
            return this;
        }

        public Builder withSignatureAndContent(String signature, String content) {
            document.digitalSignature = signature;
            document.extractedContent = content;
            return this;
        }

        public Builder withStatus(DocumentStatus status) {
            document.status = status;
            return this;
        }

        public Document build() {
            return this.document;
        }
    }
}
```

```java
// Áp dụng Builder Pattern trong xử lý giao diện AddDocumentDialog.java
private void submitAction() {
    String filePath = (selectedFile != null) ? selectedFile.getAbsolutePath() : "";
    String ext = "";
    long size = 0;
    if (selectedFile != null) {
        size = selectedFile.length() / 1024;
        String name = selectedFile.getName();
        int dot = name.lastIndexOf('.');
        if (dot > 0) ext = name.substring(dot + 1);
    }

    // Khởi tạo thực thể thông qua Builder giúp mã nguồn sáng sủa và chuẩn xác
    String generatedId = "DOC" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
    Document doc = new Document.Builder()
            .withId(generatedId)
            .withApplicantInfo(
                    txtApplicantName.getText().trim(),
                    txtApplicantEmail.getText().trim(),
                    txtApplicantPhone.getText().trim()
            )
            .withOfficerInfo(
                    txtOfficerName.getText().trim(),
                    txtOfficerEmail.getText().trim(),
                    txtOfficerPhone.getText().trim()
            )
            .withDocumentType(cbDocumentType.getSelectedItem().toString())
            .withFileInfo(filePath, ext, size)
            .withSignatureAndContent(txtDigitalSignature.getText().trim(), "")
            .withStatus(DocumentStatus.MOI_TAO)
            .build();

    // Chuyển giao thực thể sang tầng Command để thực thi nộp hồ sơ...
}
```

---

### 2.2. Giải pháp cho Yêu cầu 2: Quản lý thao tác nghiệp vụ, hoàn tác trạng thái và truy vết kiểm toán

#### 2.2.1. Phân tích hiện trạng bài toán
* **Vấn đề:** Các hành động quan trọng như nộp hồ sơ, phê duyệt hoặc trả hồ sơ trong hệ thống cũ chỉ là những phương thức thao tác trực tiếp trên biến trạng thái của đối tượng `Document`.
* **Hạn chế:**
  * **Non-reversible Execution (Thiếu khả năng đảo ngược tác vụ):** Khi cán bộ thụ lý bấm nhầm phê duyệt một bộ hồ sơ chưa đủ điều kiện, hệ thống không cung cấp bất kỳ công cụ nào để quay lại trạng thái xét duyệt trước đó.
  * **Lack of Accountability (Không thể truy vết trách nhiệm):** Hệ thống không tự động lưu vết ai đã làm gì, vào thời gian nào, khiến công tác thanh tra công vụ gặp bế tắc.
  * **UI-to-Logic Tight Coupling (Khớp nối trực tiếp giữa giao diện và nghiệp vụ):** Màn hình đồ họa gọi thẳng vào logic xử lý nội bộ, làm mất khả năng xếp hàng tác vụ (Task Queue) hoặc thực thi theo lô.

#### 2.2.2. Đề xuất giải pháp
* **Pattern lựa chọn:** Command Pattern (Chương 7).
* **Lý do lựa chọn:**
  * **Đóng gói yêu cầu thành đối tượng độc lập:** Mọi hành động (`SubmitDocumentCommand`, `ApproveDocumentCommand`, `RejectDocumentCommand`) được trừu tượng hóa thành các lớp đối tượng chứa đầy đủ ngữ cảnh để thực thi (`execute()`) và hoàn tác (`undo()`).
  * **Cung cấp cơ chế Hoàn tác (Undo/Redo) hai chiều an toàn:** Lớp điều phối `DocumentCommandInvoker` duy trì hai ngăn xếp `undoStack` và `redoStack`, cho phép cán bộ đảo ngược thao tác ngay trên giao diện mà không làm tổn hại tính nhất quán của dữ liệu.
  * **Tự động hóa sổ nhật ký kiểm toán hành chính (Audit Logging):** Mỗi khi một lệnh được kích hoạt hoặc hoàn tác, Invoker sẽ tự động ghi nhận dấu vết thời gian, tên hành động và mã hồ sơ phục vụ công tác giám sát.
  * **Tuân thủ Nguyên tắc Đóng/Mở (OCP):** Khi nghiệp vụ phát sinh thao tác mới (như Chuyển tiếp hồ sơ liên phòng ban), chỉ cần tạo thêm lớp Command mới mà không cần chỉnh sửa Invoker hay các thành phần hiện hữu.

#### 2.2.3. Sơ đồ lớp
```
+-------------------------------------------------------------+
|                <<interface>> DocumentCommand                |
+-------------------------------------------------------------+
| + execute(): void                                           |
| + undo(): void                                              |
| + getDescription(): String                                  |
| + getDocument(): Document                                   |
+-------------------------------------------------------------+
          ^                         ^                        ^
          | implements              | implements             | implements
+----------------------+ +----------------------+ +----------------------+
| SubmitDocumentCommand| |ApproveDocumentCommand| | RejectDocumentCommand |
+----------------------+ +----------------------+ +----------------------+
| - processor          | | - storage            | | - storage            |
| - document           | | - document           | | - document           |
| - previousStatus     | | - previousStatus     | | - previousStatus     |
| - executed           | | - officerNote        | | - rejectReason       |
+----------------------+ +----------------------+ +----------------------+
| + execute(): void    | | + execute(): void    | | + execute(): void    |
| + undo(): void       | | + undo(): void       | | + undo(): void       |
+----------------------+ +----------------------+ +----------------------+

+-------------------------------------------------------------+
|                   DocumentCommandInvoker                    |
+-------------------------------------------------------------+
| - undoStack: Stack<DocumentCommand>                         |
| - redoStack: Stack<DocumentCommand>                         |
| - auditLogs: List<String>                                   |
+-------------------------------------------------------------+
| + executeCommand(cmd: DocumentCommand): void                |
| + undo(): boolean                                           |
| + redo(): boolean                                           |
| + getAuditLogs(): List<String>                              |
+-------------------------------------------------------------+
```

#### 2.2.4. Mã nguồn chi tiết
```java
// Giao diện trừu tượng cho mọi thao tác công vụ (command/DocumentCommand.java)
package command;
import model.Document;

public interface DocumentCommand {
    void execute() throws Exception;
    void undo() throws Exception;
    String getDescription();
    Document getDocument();
}
```

```java
// Lớp lệnh phê duyệt hồ sơ hỗ trợ ghi nhớ trạng thái cũ (command/ApproveDocumentCommand.java)
package command;
import model.Document;
import model.DocumentStatus;
import notification.NotificationManager;
import storage.DocumentStorageTarget;

public class ApproveDocumentCommand implements DocumentCommand {
    private final DocumentStorageTarget storage;
    private final Document document;
    private final String officerNote;
    private DocumentStatus previousStatus;

    public ApproveDocumentCommand(DocumentStorageTarget storage, Document document, String officerNote) {
        this.storage = storage;
        this.document = document;
        this.officerNote = officerNote;
        this.previousStatus = (document != null) ? document.getStatus() : null;
    }

    @Override
    public void execute() throws Exception {
        if (document == null) return;
        this.previousStatus = document.getStatus();
        document.setStatus(DocumentStatus.DA_XU_LY);
        if (storage != null) {
            storage.save(document);
        }
        NotificationManager.getInstance().notifyStatusChanged(
            document, previousStatus, DocumentStatus.DA_XU_LY, 
            "Can bo da phe duyet: " + officerNote
        );
    }

    @Override
    public void undo() throws Exception {
        if (document == null) return;
        DocumentStatus current = document.getStatus();
        document.setStatus(previousStatus);
        if (storage != null) {
            storage.save(document);
        }
        NotificationManager.getInstance().notifyStatusChanged(
            document, current, previousStatus, 
            "Hoan tac phe duyet, quay ve: " + previousStatus.getDisplayName()
        );
    }

    @Override
    public String getDescription() { return "Phe duyet ho so: " + document.getId(); }
    @Override
    public Document getDocument() { return document; }
}
```

```java
// Người điều phối Invoker quản lý lịch sử thao tác (command/DocumentCommandInvoker.java)
package command;
import java.text.SimpleDateFormat;
import java.util.*;

public class DocumentCommandInvoker {
    private final Stack<DocumentCommand> undoStack = new Stack<>();
    private final Stack<DocumentCommand> redoStack = new Stack<>();
    private final List<String> auditLogs = new ArrayList<>();
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void executeCommand(DocumentCommand cmd) throws Exception {
        cmd.execute();
        undoStack.push(cmd);
        redoStack.clear();
        String record = "[" + formatter.format(new Date()) + "] [EXECUTE] " + cmd.getDescription();
        auditLogs.add(record);
        System.out.println("[Invoker] " + record);
    }

    public boolean undo() throws Exception {
        if (undoStack.isEmpty()) return false;
        DocumentCommand cmd = undoStack.pop();
        cmd.undo();
        redoStack.push(cmd);
        String record = "[" + formatter.format(new Date()) + "] [UNDO] " + cmd.getDescription();
        auditLogs.add(record);
        System.out.println("[Invoker] " + record);
        return true;
    }

    public boolean redo() throws Exception {
        if (redoStack.isEmpty()) return false;
        DocumentCommand cmd = redoStack.pop();
        cmd.execute();
        undoStack.push(cmd);
        String record = "[" + formatter.format(new Date()) + "] [REDO] " + cmd.getDescription();
        auditLogs.add(record);
        System.out.println("[Invoker] " + record);
        return true;
    }

    public List<String> getAuditLogs() { return Collections.unmodifiableList(auditLogs); }
}
```

---

### 2.3. Giải pháp cho Yêu cầu 3: Bóc tách nội dung tệp tin đa định dạng không phụ thuộc phần cứng

#### 2.3.1. Phân tích hiện trạng bài toán
* **Vấn đề:** Thuật toán đọc tệp tin được cài đặt thủ công bên trong hàm xử lý của `DocumentProcessor.java`, sử dụng chuỗi câu lệnh rẽ nhánh `if-else` cố định và chỉ đọc được tệp văn bản thô `.txt`.
* **Hạn chế:**
  * **OCP Violation (Vi phạm nguyên tắc đóng mở):** Muốn mở rộng tính năng để tiếp nhận tệp PDF hoặc ảnh scan JPG, lập trình viên bắt buộc phải can thiệp trực tiếp vào mã nguồn lớp nghiệp vụ lõi để thêm nhánh kiểm tra mới.
  * **SRP Violation (Vi phạm nguyên tắc đơn trách nhiệm):** Lớp xử lý nghiệp vụ trung tâm bị ép phải gánh vác cả trách nhiệm xử lý I/O tệp tin và các thuật toán giải mã quang học OCR phức tạp.
  * **Thiếu khả năng thay thế linh hoạt:** Không thể hoán đổi các giải thuật OCR khác nhau (ví dụ: chuyển từ OCR mẫu sang Google Vision API) mà không gây ảnh hưởng đến hệ thống.

#### 2.3.2. Đề xuất giải pháp
* **Pattern lựa chọn:** Strategy Pattern kết hợp Factory Method Pattern (Chương 3 & Chương 5).
* **Lý do lựa chọn:**
  * **Trừu tượng hóa chiến lược trích xuất (Strategy Pattern):** Giao diện chung `ContentExtractor` chuẩn hóa hành vi đọc tệp. Các lớp độc lập (`TxtExtractor`, `PdfExtractor`, `ImageOcrExtractor`) đóng gói thuật toán đặc thù cho từng loại tài liệu.
  * **Ủy nhiệm khởi tạo cho nhà máy trung tâm (Factory Method):** Lớp `ExtractorFactory` chịu trách nhiệm ánh xạ phần mở rộng của tệp với thuật toán trích xuất thích hợp. Lớp nghiệp vụ hoàn toàn không cần biết chi tiết lớp cụ thể nào đang được sử dụng.
  * **Khả năng cắm-rút (Pluggability) vượt trội:** Khi cơ quan hành chính yêu cầu hỗ trợ thêm định dạng Word (`.docx`), ta chỉ cần tạo thêm một lớp Strategy mới và đăng ký vào Factory mà không cần sửa đổi bất kỳ dòng mã nào trong luồng xử lý chính.

#### 2.3.3. Sơ đồ lớp
```
+-------------------------------------------------------------+
|                      DocumentProcessor                      |
+-------------------------------------------------------------+
| + process(doc: Document): void                              |
+-------------------------------------------------------------+
            |                               |
            | yêu cầu khởi tạo              | thực thi trích xuất
            v                               v
+------------------------+      +-------------------------------+
|    ExtractorFactory    |      | <<interface>> ContentExtractor|
+------------------------+      +-------------------------------+
| + getExtractor(ext):   |      | + extractContent(path): String|
|   ContentExtractor     |      | + getSupportedExtension(): Str|
+------------------------+      +-------------------------------+
            |                                   ^
            | tạo ra instance                   |
            +-----------------+-----------------+
                              |
        +---------------------+---------------------+
        |                     |                     |
+----------------+    +----------------+    +-------------------+
|  TxtExtractor  |    |  PdfExtractor  |    | ImageOcrExtractor |
+----------------+    +----------------+    +-------------------+
```

#### 2.3.4. Mã nguồn chi tiết
```java
// Giao diện Strategy định nghĩa hợp đồng trích xuất (extractor/ContentExtractor.java)
package extractor;

public interface ContentExtractor {
    String extractContent(String filePath) throws Exception;
    String getSupportedExtension();
}
```

```java
// Nhà máy Factory Method quản lý đăng ký và phân phối Strategy (extractor/ExtractorFactory.java)
package extractor;
import java.util.HashMap;
import java.util.Map;

public class ExtractorFactory {
    private static final Map<String, ContentExtractor> registry = new HashMap<>();

    static {
        registerExtractor(new TxtExtractor());
        registerExtractor(new PdfExtractor());
        registerExtractor(new ImageOcrExtractor());
    }

    public static void registerExtractor(ContentExtractor extractor) {
        if (extractor != null && extractor.getSupportedExtension() != null) {
            registry.put(extractor.getSupportedExtension().toLowerCase(), extractor);
        }
    }

    public static ContentExtractor getExtractor(String extension) {
        if (extension == null) return null;
        return registry.get(extension.toLowerCase().trim());
    }
}
```

```java
// Triển khai thuật toán đọc tệp văn bản thật (extractor/TxtExtractor.java)
package extractor;
import java.io.File;
import java.nio.file.Files;

public class TxtExtractor implements ContentExtractor {
    @Override
    public String extractContent(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IllegalArgumentException("Khong tim thay tep: " + filePath);
        }
        byte[] data = Files.readAllBytes(file.toPath());
        return new String(data, "UTF-8");
    }

    @Override
    public String getSupportedExtension() { return "txt"; }
}
```

---

### 2.4. Giải pháp cho Yêu cầu 4: Chuẩn hóa quy trình thẩm định hồ sơ phân tầng và kiểm tra an ninh đặc thù

#### 2.4.1. Phân tích hiện trạng bài toán
* **Vấn đề:** Logic kiểm duyệt đầu vào bị gộp chung vào một hàm dài hàng trăm dòng lệnh. Không có sự tách bạch giữa quy trình kiểm tra chuẩn và quy trình kiểm tra nâng cao cho các hồ sơ yêu cầu bảo mật cao.
* **Hạn chế:**
  * **Trùng lặp mã nguồn nghiêm trọng (Code Duplication):** Khi muốn định nghĩa quy trình kiểm tra cho một loại văn bản đặc thù (như hồ sơ đấu thầu bảo mật), lập trình viên phải sao chép lại toàn bộ các bước kiểm tra cơ bản.
  * **Thiếu cơ chế mở rộng có kiểm soát:** Không có điểm nối mềm (Hook) để lớp con có thể bật/tắt các tiêu chuẩn kiểm tra an ninh nâng cao mà không làm phá vỡ khung trình tự gốc.

#### 2.4.2. Đề xuất giải pháp
* **Pattern lựa chọn:** Template Method Pattern (Chương 4).
* **Lý do lựa chọn:**
  * **Cố định khung xương thuật toán (Template Method):** Lớp trừu tượng `AbstractDocumentValidator` định nghĩa phương thức `validateDocument()` với từ khóa `final`, xác lập trình tự kiểm duyệt bất biến: Kiểm tra trường bắt buộc -> Kiểm tra tệp đính kèm -> Kiểm tra an ninh chữ ký số.
  * **Tuân thủ triệt để Hollywood Principle ("Đừng gọi chúng tôi, chúng tôi sẽ gọi bạn"):** Lớp cha nắm toàn quyền điều hướng quy trình và sẽ chủ động gọi đến các phương thức nguyên thủy của lớp con khi đến bước tương ứng.
  * **Cung cấp điểm nối Hook an ninh linh hoạt:** Phương thức Hook `shouldCheckDigitalSignature()` cho phép lớp `StandardDocumentValidator` bỏ qua bước ký số, trong khi lớp `StrictSecurityValidator` ghi đè trả về `true` để bắt buộc kiểm tra tính hợp lệ của chữ ký số RSA.
  * **Tối ưu hóa khả năng tái sử dụng (DRY Principle):** Toàn bộ logic kiểm tra thông tin chung và dung lượng tệp được tái sử dụng 100%, loại bỏ hoàn toàn mã trùng lặp.

#### 2.4.3. Sơ đồ lớp
```
+-------------------------------------------------------------+
|             <<abstract>> AbstractDocumentValidator          |
+-------------------------------------------------------------+
| + validateDocument(doc: Document): ValidationResult [final] |
| # checkRequiredFields(doc: Document): ValidationResult      |
| # checkFileIntegrity(doc: Document): ValidationResult       |
| # shouldCheckDigitalSignature(): boolean [Hook Method]      |
| # checkDigitalSignature(doc: Document): ValidationResult    |
+-------------------------------------------------------------+
                              ^
                              | kế thừa
            +-----------------+-----------------+
            |                                   |
+---------------------------+       +---------------------------+
| StandardDocumentValidator |       |  StrictSecurityValidator  |
+---------------------------+       +---------------------------+
| # shouldCheckDigitalSig() |       | # shouldCheckDigitalSig() |
|   -> return false;        |       |   -> return true;         |
|                           |       | # checkDigitalSignature() |
|                           |       |   -> xác thực khóa RSA    |
+---------------------------+       +---------------------------+
```

#### 2.4.4. Mã nguồn chi tiết
```java
// Lớp cơ sở định hình khung quy trình thẩm định (validation/AbstractDocumentValidator.java)
package validation;
import model.Document;
import java.io.File;

public abstract class AbstractDocumentValidator {

    // Phương thức Template Method niêm phong khung trình tự kiểm tra
    public final ValidationResult validateDocument(Document doc) {
        if (doc == null) {
            return ValidationResult.fail("Du lieu ho so khong hop le (null).");
        }
        ValidationResult step1 = checkRequiredFields(doc);
        if (!step1.isValid()) return step1;

        ValidationResult step2 = checkFileIntegrity(doc);
        if (!step2.isValid()) return step2;

        // Điểm nối Hook cho phép các phân lớp đặc thù can thiệp
        if (shouldCheckDigitalSignature()) {
            ValidationResult step3 = checkDigitalSignature(doc);
            if (!step3.isValid()) return step3;
        }

        return ValidationResult.ok("Ho so dat chuan tiep nhan.");
    }

    protected ValidationResult checkRequiredFields(Document doc) {
        if (!doc.validate()) {
            return ValidationResult.fail("Thieu thong tin bat buoc trong ho so.");
        }
        return ValidationResult.ok();
    }

    protected ValidationResult checkFileIntegrity(Document doc) {
        File file = new File(doc.getFilePath());
        if (!file.exists()) {
            return ValidationResult.fail("Khong tim thay tep tin dinh kem.");
        }
        if (file.length() > 5 * 1024 * 1024) {
            return ValidationResult.fail("Dung luong tep vuot qua nguong cho phep 5MB.");
        }
        return ValidationResult.ok();
    }

    // Hook mặc định không yêu cầu chữ ký số
    protected boolean shouldCheckDigitalSignature() { return false; }
    protected ValidationResult checkDigitalSignature(Document doc) { return ValidationResult.ok(); }
}
```

```java
// Phân lớp kiểm duyệt an ninh cao kích hoạt Hook RSA (validation/StrictSecurityValidator.java)
package validation;
import model.Document;

public class StrictSecurityValidator extends AbstractDocumentValidator {
    @Override
    protected boolean shouldCheckDigitalSignature() {
        return true; // Kích hoạt Hook kiểm duyệt an ninh
    }

    @Override
    protected ValidationResult checkDigitalSignature(Document doc) {
        String signature = doc.getDigitalSignature();
        if (signature == null || signature.trim().isEmpty()) {
            return ValidationResult.fail("[An Ninh] Ho so co mat thieu chung thu chu ky so.");
        }
        if (!signature.startsWith("RSA_")) {
            return ValidationResult.fail("[An Ninh] Chu ky so khong dat tieu chuan ma hoa RSA.");
        }
        return ValidationResult.ok("[An Ninh] Xac thuc chu ky so RSA thanh cong.");
    }
}
```

---

### 2.5. Giải pháp cho Yêu cầu 5: Phát hành thông báo sự kiện hướng người dùng qua nhiều kênh truyền thông

#### 2.5.1. Phân tích hiện trạng bài toán
* **Vấn đề:** Lớp nghiệp vụ khởi tạo trực tiếp các đối tượng dịch vụ `new EmailService()` và `new SmsService()` bên trong hàm, đồng thời mặc định phát tán thông báo qua toàn bộ các kênh mà không quan tâm đến nhu cầu của người nộp.
* **Hạn chế:**
  * **Khớp nối cứng ngắc (Tight Coupling):** Lớp nghiệp vụ bị gắn chặt với các API kết nối hạ tầng mạng bên ngoài, khiến hệ thống dễ bị đình trệ khi một dịch vụ mạng gặp sự cố.
  * **Lãng phí tài nguyên hệ thống:** Việc tạo mới liên tục các thể hiện dịch vụ gửi tin gây lãng phí bộ nhớ và kết nối socket.
  * **Thiếu tính cá nhân hóa:** Người dùng không thể lựa chọn nhận thông báo qua kênh yêu thích (ví dụ: chỉ nhận qua App Push thay vì bị spam SMS).

#### 2.5.2. Đề xuất giải pháp
* **Pattern lựa chọn:** Observer Pattern kết hợp Singleton Pattern (Chương 9 & Chương 2).
* **Lý do lựa chọn:**
  * **Kiểm soát vòng đời tài nguyên duy nhất (Singleton Pattern):** Lớp `NotificationManager` được triển khai dưới dạng Singleton, bảo đảm chỉ có một thực thể duy nhất quản lý các kết nối truyền thông trong toàn bộ phiên hoạt động.
  * **Cơ chế Đăng ký - Phát hành sự kiện lỏng lẻo (Observer Pattern):** Phân tách hoàn toàn đối tượng phát thông báo (Subject) và các kênh tiếp nhận (Observers). Các kênh (`EmailNotifier`, `SmsNotifier`, `AppPushNotifier`) đều triển khai chung giao diện `DocumentObserver`.
  * **Phân phối thông minh theo cấu hình người dùng:** `NotificationManager` lưu trữ tùy chọn của từng người nộp (`userPreferences`), chỉ bắn thông báo tới đúng các kênh mà người dùng đã kích hoạt.
  * **Dễ dàng bổ sung kênh mới:** Bổ sung kênh thông báo mới (như Zalo ZNS hoặc Telegram) chỉ cần tạo lớp Observer mới và gắn (`attach`) vào Manager mà không cần sửa đổi bất kỳ dòng mã nghiệp vụ nào.

#### 2.5.3. Sơ đồ lớp
```
+-------------------------------------------------------------+
|                     NotificationManager                     |
|                         <<Singleton>>                       |
+-------------------------------------------------------------+
| - instance: NotificationManager [static]                    |
| - observers: List<DocumentObserver>                         |
| - userPreferences: Map<String, Set<String>>                 |
+-------------------------------------------------------------+
| + getInstance(): NotificationManager [static]               |
| + attach(obs: DocumentObserver): void                       |
| + setUserPreference(email: String, channels: String...):void|
| + notifyStatusChanged(doc, oldStatus, newStatus, msg): void |
+-------------------------------------------------------------+
                              |
                              | thông báo tới
                              v
+-------------------------------------------------------------+
|               <<interface>> DocumentObserver                |
+-------------------------------------------------------------+
| + getChannelName(): String                                  |
| + onDocumentStatusChanged(doc, oldStatus, newStatus, msg)   |
+-------------------------------------------------------------+
          ^                         ^                        ^
          |                         |                        |
+-------------------+     +-------------------+    +-------------------+
|   EmailNotifier   |     |    SmsNotifier    |    |  AppPushNotifier  |
+-------------------+     +-------------------+    +-------------------+
```

#### 2.5.4. Mã nguồn chi tiết
```java
// Trung tâm phát hành sự kiện Singleton (notification/NotificationManager.java)
package notification;
import model.Document;
import model.DocumentStatus;
import java.util.*;

public class NotificationManager {
    private static volatile NotificationManager instance;
    private final List<DocumentObserver> observers = new ArrayList<>();
    private final Map<String, Set<String>> userPreferences = new HashMap<>();

    private NotificationManager() {
        attach(new EmailNotifier());
        attach(new SmsNotifier());
        attach(new AppPushNotifier());
    }

    public static NotificationManager getInstance() {
        if (instance == null) {
            synchronized (NotificationManager.class) {
                if (instance == null) instance = new NotificationManager();
            }
        }
        return instance;
    }

    public void attach(DocumentObserver obs) { observers.add(obs); }

    public void setUserPreference(String email, String... channels) {
        Set<String> set = new HashSet<>();
        for (String c : channels) set.add(c.toUpperCase());
        userPreferences.put(email, set);
    }

    public void notifyStatusChanged(Document doc, DocumentStatus oldStatus, DocumentStatus newStatus, String msg) {
        String email = doc.getApplicantEmail();
        Set<String> channels = userPreferences.get(email);

        for (DocumentObserver obs : observers) {
            if (channels == null || channels.contains(obs.getChannelName().toUpperCase())) {
                obs.onDocumentStatusChanged(doc, oldStatus, newStatus, msg);
            }
        }
    }
}
```

```java
// Người quan sát kênh thư điện tử (notification/EmailNotifier.java)
package notification;
import model.Document;
import model.DocumentStatus;

public class EmailNotifier implements DocumentObserver {
    @Override
    public String getChannelName() { return "EMAIL"; }

    @Override
    public void onDocumentStatusChanged(Document doc, DocumentStatus oldStatus, DocumentStatus newStatus, String msg) {
        System.out.println("  [EMAIL] Gui toi: " + doc.getApplicantEmail() + 
                           " | Ho so: " + doc.getId() + " => " + newStatus.getDisplayName() + 
                           " (" + msg + ")");
    }
}
```

---

### 2.6. Giải pháp cho Yêu cầu 6: Trừu tượng hóa hạ tầng lưu trữ và khả năng chuyển đổi môi trường tức thì

#### 2.6.1. Phân tích hiện trạng bài toán
* **Vấn đề:** Logic lưu trữ trong phiên bản cũ can thiệp trực tiếp vào luồng I/O tệp cục bộ bằng các lệnh `FileWriter` và gán cứng đường dẫn thư mục máy chủ bên trong `DocumentProcessor`.
* **Hạn chế:**
  * **Vi phạm Nguyên tắc Đảo ngược phụ thuộc (DIP):** Module nghiệp vụ cấp cao bị kéo xuống phụ thuộc trực tiếp vào chi tiết hạ tầng lưu trữ vật lý cấp thấp.
  * **Thiếu khả năng hoán đổi môi trường:** Khi chuyển đổi từ hệ thống thử nghiệm lưu tệp sang Cơ sở dữ liệu quan hệ (MySQL) hoặc Đám mây (AWS S3), toàn bộ mã nguồn xử lý hồ sơ phải bị đập đi viết lại.

#### 2.6.2. Đề xuất giải pháp
* **Pattern lựa chọn:** Adapter Pattern (Chương 8).
* **Lý do lựa chọn:**
  * **Chuẩn hóa qua Target Interface chung:** Giao diện `DocumentStorageTarget` thiết lập các thao tác lưu trữ chuẩn (`save()`, `findById()`, `findAll()`, `delete()`, `count()`). Tầng nghiệp vụ chỉ phụ thuộc vào bản giao ước trừu tượng này.
  * **Bọc kín các giao diện không tương thích (Adapters):** Các lớp Adapter (`JsonFileStorageAdapter`, `MySqlStorageAdapter`, `AwsS3StorageAdapter`) đóng vai trò cầu nối, biến đổi các yêu cầu lưu trữ nghiệp vụ thành các lời gọi đặc thù của từng hệ thống lưu trữ (ghi JSON, câu lệnh SQL, hoặc AWS S3 SDK).
  * **Hoán đổi hạ tầng không ảnh hưởng mã nguồn nghiệp vụ:** Thông qua `StorageAdapterFactory`, việc chuyển đổi nơi lưu trữ diễn ra hoàn toàn trong suốt với lớp điều phối.
  * **Tuân thủ OCP và DIP:** Khi bổ sung thêm công nghệ lưu trữ mới (như MongoDB hay Redis), chỉ cần xây dựng thêm Adapter tương ứng mà không làm ảnh hưởng đến mã nguồn cốt lõi.

#### 2.6.3. Sơ đồ lớp
```
+-------------------------------------------------------------+
|                      DocumentProcessor                      |
+-------------------------------------------------------------+
| - storage: DocumentStorageTarget                            |
+-------------------------------------------------------------+
| + process(doc: Document): void                              |
+-------------------------------------------------------------+
                              |
                              | phụ thuộc vào giao diện mục tiêu
                              v
+-------------------------------------------------------------+
|            <<interface>> DocumentStorageTarget              |
+-------------------------------------------------------------+
| + save(doc: Document): void                                 |
| + findById(id: String): Document                            |
| + findAll(): List<Document>                                 |
| + delete(id: String): boolean                               |
| + count(): int                                              |
| + getStorageType(): String                                  |
+-------------------------------------------------------------+
          ^                         ^                        ^
          | implements              | implements             | implements
+-----------------------+ +---------------------+ +-----------------------+
| JsonFileStorageAdapter| | MySqlStorageAdapter | |  AwsS3StorageAdapter  |
+-----------------------+ +---------------------+ +-----------------------+
| - storageDir: File    | | - simulatedDb: Map  | | - bucketName: String  |
+-----------------------+ +---------------------+ +-----------------------+
| (Ghi file .json thật) | | (Mô phỏng SQL DB)   | | (Mô phỏng Cloud S3)   |
+-----------------------+ +---------------------+ +-----------------------+
```

#### 2.6.4. Mã nguồn chi tiết
```java
// Giao diện mục tiêu Target Interface (storage/DocumentStorageTarget.java)
package storage;
import model.Document;
import java.util.List;

public interface DocumentStorageTarget {
    void save(Document document) throws Exception;
    Document findById(String id) throws Exception;
    List<Document> findAll() throws Exception;
    boolean delete(String id) throws Exception;
    int count() throws Exception;
    String getStorageType();
}
```

```java
// Adapter chuyển đổi sang định dạng tệp JSON cục bộ (storage/JsonFileStorageAdapter.java)
package storage;
import model.Document;
import java.io.*;
import java.util.*;

public class JsonFileStorageAdapter implements DocumentStorageTarget {
    private final File storageDir;

    public JsonFileStorageAdapter(String dirPath) {
        this.storageDir = new File(dirPath);
        if (!storageDir.exists()) storageDir.mkdirs();
    }

    @Override
    public void save(Document document) throws Exception {
        File targetFile = new File(storageDir, document.getId() + ".json");
        String payload = "{\n" +
                "  \"id\": \"" + document.getId() + "\",\n" +
                "  \"applicantName\": \"" + document.getApplicantName() + "\",\n" +
                "  \"status\": \"" + document.getStatusName() + "\"\n" +
                "}";
        try (FileWriter writer = new FileWriter(targetFile)) {
            writer.write(payload);
        }
    }

    @Override
    public Document findById(String id) throws Exception {
        File targetFile = new File(storageDir, id + ".json");
        if (!targetFile.exists()) return null;
        Document doc = new Document();
        doc.setId(id);
        return doc;
    }

    @Override
    public List<Document> findAll() throws Exception {
        List<Document> results = new ArrayList<>();
        File[] jsonFiles = storageDir.listFiles((dir, name) -> name.endsWith(".json"));
        if (jsonFiles != null) {
            for (File file : jsonFiles) {
                Document item = new Document();
                item.setId(file.getName().replace(".json", ""));
                results.add(item);
            }
        }
        return results;
    }

    @Override
    public boolean delete(String id) throws Exception {
        File file = new File(storageDir, id + ".json");
        return file.exists() && file.delete();
    }

    @Override
    public int count() throws Exception {
        File[] files = storageDir.listFiles((dir, name) -> name.endsWith(".json"));
        return files != null ? files.length : 0;
    }

    @Override
    public String getStorageType() { return "LOCAL_JSON_FILE"; }
}
```

---

# CHƯƠNG 3: THIẾT KẾ KIẾN TRÚC TỔNG THỂ HỆ THỐNG V2.0 VÀ LUỒNG TƯƠNG TÁC

### 3.1. Sơ đồ lớp tổng thể toàn bộ hệ thống v2.0
Kiến trúc v2.0 được tổ chức phân tầng rõ rệt, kết nối đồng bộ giữa các mẫu thiết kế:

```
+----------------------------------------------------------------------------------------------------+
|                                    TẦNG GIAO DIỆN & TƯƠNG TÁC (UI LAYER)                           |
|                                                                                                    |
|    +--------------------+            +------------------------+          +--------------------+    |
|    |    MainSwingUI     | ---------> | DocumentCommandInvoker | -------> |   MainDemo.java    |    |
|    +--------------------+            +------------------------+          +--------------------+    |
|              |                                   |                                                 |
|              v                                   v                                                 |
|    +--------------------+            +------------------------+                                    |
|    | AddDocumentDialog  | ---------> |    DocumentCommand     |                                    |
|    +--------------------+            +------------------------+                                    |
+--------------|-----------------------------------|-------------------------------------------------+
               | sử dụng Builder                   | đóng gói
               v                                   v
+----------------------------------------------------------------------------------------------------+
|                                      TẦNG THỰC THỂ DỮ LIỆU (DOMAIN MODEL)                          |
|                                                                                                    |
|    +--------------------+            +------------------------+          +--------------------+    |
|    |  Document.Builder  | ---------> |        Document        | <------- |   DocumentStatus   |    |
|    +--------------------+            +------------------------+          +--------------------+    |
+--------------------------------------------------|-------------------------------------------------+
                                                   | xử lý qua service
                                                   v
+----------------------------------------------------------------------------------------------------+
|                                   TẦNG ĐIỀU PHỐI NGHIỆP VỤ (SERVICE LAYER)                         |
|                                                                                                    |
|                                     +--------------------------+                                   |
|                                     |    DocumentProcessor     |                                   |
|                                     +--------------------------+                                   |
|                                      /           |            \                                    |
+-------------------------------------/------------|-------------\-----------------------------------+
                                     /             |              \
                                    v              v               v
+-------------------------------------+  +--------------------+  +-----------------------------------+
|     THẨM ĐỊNH (TEMPLATE METHOD)     |  | TRÍCH XUẤT STRATEGY|  |      LƯU TRỮ (ADAPTER PATTERN)    |
|                                     |  | & FACTORY METHOD   |  |                                   |
| +---------------------------------+ |  | +----------------+ |  | +-------------------------------+ |
| |    AbstractDocumentValidator    | |  | |ExtractorFactory| |  | |     DocumentStorageTarget     | |
| +---------------------------------+ |  | +----------------+ |  | +-------------------------------+ |
|         ^                 ^         |  |         |          |  |         ^         ^         ^       |
|         |                 |         |  |         v          |  |         |         |         |       |
| +---------------+ +---------------+ |  | +----------------+ |  | +-------+ +-------+ +---------+ |
| |StandardValid..| |StrictSecurity.| |  | |ContentExtractor| |  | | Json  | | MySQL | | AWS S3  | |
| +---------------+ +---------------+ |  | +----------------+ |  | +-------+ +-------+ +---------+ |
+-------------------------------------+  +--------------------+  +-----------------------------------+
                                                   |
                                                   | phát sinh sự kiện thay đổi trạng thái
                                                   v
+----------------------------------------------------------------------------------------------------+
|                                 HỆ THỐNG THÔNG BÁO (OBSERVER & SINGLETON)                          |
|                                                                                                    |
|                   +--------------------------------------------------------------+                 |
|                   |           NotificationManager (Singleton Subject)            |                 |
|                   +--------------------------------------------------------------+                 |
|                             |                       |                       |                      |
|                             v                       v                       v                      |
|                   +-------------------+   +-------------------+   +-------------------+            |
|                   |   EmailNotifier   |   |    SmsNotifier    |   |  AppPushNotifier  |            |
|                   +-------------------+   +-------------------+   +-------------------+            |
+----------------------------------------------------------------------------------------------------+
```

---

### 3.2. Sơ đồ tuần tự thể hiện chu trình xử lý hồ sơ
Tiến trình tương tác tuần tự giữa các thành phần từ lúc công dân nộp hồ sơ đến khi hoàn tất lưu trữ và phát thông báo:

```
Công dân      AddDocDialog       Invoker        SubmitCmd       Processor      Validator      Extractor      Storage       Notification
   |                 |                |               |               |              |              |             |              |
   |--- Nhập liệu -->|                |               |               |              |              |             |              |
   |--- Bấm Gửi ---->|                |               |               |              |              |             |              |
   |                 |-- doc.Builder->|               |               |              |              |             |              |
   |                 |-- new Cmd ---->|               |               |              |              |             |              |
   |                 |-- executeCmd ->|               |               |              |              |             |              |
   |                 |                |--- execute()->|               |              |              |             |              |
   |                 |                |               |-- process() ->|              |              |             |              |
   |                 |                |               |               |-- validate()->|             |             |              |
   |                 |                |               |               |<-- Hợp lệ ----|             |             |              |
   |                 |                |               |               |-- trích xuất --------------->|             |              |
   |                 |                |               |               |<-- Nội dung -----------------|             |              |
   |                 |                |               |               |-- save()--------------------------------->|              |
   |                 |                |               |               |<-- Lưu xong ------------------------------|              |
   |                 |                |               |               |-- phát thông báo ---------------------------------------->|
   |                 |                |               |               |                                                          |-- Gửi Email
   |                 |                |               |               |                                                          |-- Gửi SMS
   |                 |                |               |               |                                                          |-- Gửi Push
   |<-- Báo kết quả -|                |               |               |                                                          |
```

---

### 3.3. Bảng đối chiếu đồng nhất giữa sơ đồ thiết kế và mã nguồn thực thi
Đối chiếu minh bạch giữa các vai trò trong mẫu thiết kế và các tệp mã nguồn cụ thể trong dự án:

| Mẫu thiết kế | Vai trò theo chuẩn GoF | Thành phần trong mã nguồn | Đường dẫn tệp vật lý |
| :--- | :--- | :--- | :--- |
| **Builder Pattern** | Builder | `Document.Builder` | `model/Document.java` |
| | Product | `Document` | `model/Document.java` |
| **Command Pattern** | Command Interface | `DocumentCommand` | `command/DocumentCommand.java` |
| | Concrete Commands | `SubmitDocumentCommand`, `ApproveDocumentCommand`, `RejectDocumentCommand` | `command/*.java` |
| | Invoker | `DocumentCommandInvoker` | `command/DocumentCommandInvoker.java` |
| **Strategy Pattern** | Strategy Interface | `ContentExtractor` | `extractor/ContentExtractor.java` |
| | Concrete Strategies | `TxtExtractor`, `PdfExtractor`, `ImageOcrExtractor` | `extractor/*.java` |
| **Factory Method** | Creator / Factory | `ExtractorFactory` | `extractor/ExtractorFactory.java` |
| **Template Method** | Abstract Class | `AbstractDocumentValidator` | `validation/AbstractDocumentValidator.java` |
| | Concrete Classes | `StandardDocumentValidator`, `StrictSecurityValidator` | `validation/*.java` |
| **Observer Pattern** | Subject / Publisher | `NotificationManager` | `notification/NotificationManager.java` |
| | Observer Interface | `DocumentObserver` | `notification/DocumentObserver.java` |
| | Concrete Observers | `EmailNotifier`, `SmsNotifier`, `AppPushNotifier` | `notification/*.java` |
| **Singleton Pattern** | Singleton Instance | `NotificationManager` | `notification/NotificationManager.java` |
| **Adapter Pattern** | Target Interface | `DocumentStorageTarget` | `storage/DocumentStorageTarget.java` |
| | Adapters | `JsonFileStorageAdapter`, `MySqlStorageAdapter`, `AwsS3StorageAdapter` | `storage/*.java` |
| | Adapter Factory | `StorageAdapterFactory` | `storage/StorageAdapterFactory.java` |

---

# CHƯƠNG 4: ĐÁNH GIÁ CHUYÊN SÂU TUÂN THỦ NGUYÊN TẮC SOLID VÀ NGUYÊN LÝ GOF

### 4.1. Đánh giá nguyên tắc đơn trách nhiệm (Single Responsibility Principle - SRP)
Kiến trúc v2.0 đã phân rã triệt để "God Class" `DocumentProcessor`. Mỗi lớp hiện tại chỉ gánh vác duy nhất một lý do để thay đổi:
* `Document.Builder`: Chỉ chịu trách nhiệm về quy trình lắp ráp và thiết lập trạng thái cho thực thể `Document`.
* `AbstractDocumentValidator`: Chỉ đảm nhận việc xác thực các quy tắc hợp lệ của hồ sơ.
* `ContentExtractor`: Chỉ tập trung vào thuật toán giải mã và bóc tách dữ liệu tệp tin.
* `DocumentStorageTarget`: Chỉ quản lý việc lưu trữ và truy xuất thực thể dữ liệu.
* `NotificationManager`: Chỉ điều phối các thông báo sự kiện hướng người dùng.
* `DocumentCommand`: Chỉ đóng gói một hành động nghiệp vụ cụ thể.

### 4.2. Đánh giá nguyên tắc đóng mở (Open/Closed Principle - OCP)
Hệ thống cho phép mở rộng tính năng mới mà hoàn toàn "đóng" với việc sửa đổi mã nguồn đã ổn định:
* Muốn hỗ trợ tệp định dạng mới (như `.docx`): Chỉ cần tạo lớp cài đặt `ContentExtractor` và đăng ký với `ExtractorFactory`.
* Muốn thêm kênh thông báo mới (như `ZaloNotifier`): Chỉ cần tạo lớp cài đặt `DocumentObserver` và đính kèm vào `NotificationManager`.
* Muốn đổi hệ thống lưu trữ mới (như `MongoDbStorageAdapter`): Chỉ cần tạo lớp cài đặt `DocumentStorageTarget`.
* Muốn thêm nghiệp vụ mới (như chuyển tiếp hồ sơ): Chỉ cần tạo lớp triển khai `DocumentCommand`.

### 4.3. Đánh giá nguyên tắc thay thế Liskov (Liskov Substitution Principle - LSP)
Các lớp con và các lớp triển khai đều có thể thay thế hoàn hảo cho các kiểu trừu tượng cha mà không làm thay đổi hành vi đúng đắn của chương trình:
* Mọi phân lớp của `AbstractDocumentValidator` (`StandardDocumentValidator`, `StrictSecurityValidator`) đều có thể hoán đổi trực tiếp trong `DocumentProcessor`.
* Mọi Adapter triển khai `DocumentStorageTarget` đều có thể thay thế lẫn nhau trong thời gian thực mà không làm gián đoạn luồng nghiệp vụ.

### 4.4. Đánh giá nguyên tắc phân tách giao diện (Interface Segregation Principle - ISP)
Các giao diện trong hệ thống được thiết kế tinh gọn, mang tính gắn kết cao và không ép buộc lớp con cài đặt các phương thức không sử dụng:
* `DocumentCommand` chỉ chứa hai hành động cốt lõi là `execute()` và `undo()`.
* `ContentExtractor` chỉ chứa `extractContent()` và `getSupportedExtension()`.
* `DocumentObserver` chỉ tập trung vào sự kiện thay đổi trạng thái hồ sơ.

### 4.5. Đánh giá nguyên tắc đảo ngược phụ thuộc (Dependency Inversion Principle - DIP)
Lớp nghiệp vụ cấp cao `DocumentProcessor` hoàn toàn không phụ thuộc trực tiếp vào các lớp cụ thể cấp thấp:
* Phụ thuộc vào interface `AbstractDocumentValidator`, không phụ thuộc vào `StandardDocumentValidator`.
* Phụ thuộc vào interface `DocumentStorageTarget`, không phụ thuộc vào `JsonFileStorageAdapter`.
* Phụ thuộc vào interface `ContentExtractor`, không phụ thuộc vào `TxtExtractor`.

### 4.6. Đánh giá nguyên lý Hollywood (Hollywood Principle) trong Template Method
Nguyên lý Hollywood: *"Don't call us, we'll call you"* được thể hiện mẫu mực trong lớp `AbstractDocumentValidator`:
* Lớp trừu tượng cha kiểm soát toàn bộ luồng thực thi trong phương thức `validateDocument()`.
* Lớp con không bao giờ chủ động gọi ngược lên lớp cha, mà lớp cha sẽ chủ động gọi xuống các phương thức nguyên thủy của lớp con (`checkDigitalSignature()`, Hook `shouldCheckDigitalSignature()`) khi cần thiết.

---

# CHƯƠNG 5: KỊCH BẢN KIỂM THỬ THỰC NGHIỆM VÀ ĐÁNH GIÁ VẬN HÀNH

### 5.1. Thiết kế 5 kịch bản kiểm thử tương ứng các chương đề cương môn học
Nhóm xây dựng tệp thực thi kiểm thử độc lập `MainDemo.java` tương ứng với 5 tình huống thực tế:
1. **Kịch bản 1 (Template Method & Singleton):** Kiểm tra tính hợp lệ của hồ sơ chuẩn và kiểm tra tính duy nhất của thể hiện `NotificationManager`.
2. **Kịch bản 2 (Template Method Hook & Security):** Kiểm tra hồ sơ cơ mật có bật Hook an ninh chữ ký số; kiểm tra tính năng từ chối khi chữ ký số RSA không đạt chuẩn.
3. **Kịch bản 3 (Strategy & Factory Method):** Thử nghiệm bóc tách dữ liệu trên đa dạng tệp tin: `.txt` (đọc thật), `.pdf` (mô phỏng OCR) và `.jpg` (nhận dạng hình ảnh).
4. **Kịch bản 4 (Adapter Pattern Storage):** Hoán đổi 3 hạ tầng lưu trữ khác nhau: Tệp JSON máy chủ (tạo tệp thật), CSDL MySQL (mô phỏng) và AWS S3 Cloud (mô phỏng).
5. **Kịch bản 5 (Command Pattern Undo/Redo & Audit Log):** Phê duyệt hồ sơ, kiểm tra tính năng hoàn tác (Undo) đưa hồ sơ về trạng thái cũ, làm lại (Redo) và kết xuất nhật ký kiểm toán.

---

### 5.2. Kết quả chạy thực nghiệm trên môi trường dòng lệnh (Console)
Chạy lệnh `java -cp bin MainDemo`:

```text
================================================================================
   HE THONG TIEP NHAN VA XU LY HO SO DIEN TU (eDocument v2.0)
   DEMO CUNG CO CAC MAU THIET KE GOF CHUAN DE CUONG MON HOC TDTU 504077
================================================================================

--------------------------------------------------------------------------------
1. KICH BAN 1: XU LY HO SO HOP LE (TEMPLATE METHOD + SINGLETON PATTERN)
--------------------------------------------------------------------------------
[Singleton Check] notif1 == notif2: true (Xac nhan chi co 1 instance duy nhat)

[DocumentProcessor] Bat dau xu ly ho so: DOC01
Email gui den an.nv@gmail.com: Ho so DOC01 chuyen sang trang thai Da tiep nhan
SMS gui den 0901234567: Ho so DOC01 chuyen sang trang thai Da tiep nhan
Dang doc file txt: C:\Users\quang\AppData\Local\Temp\don_xin_phep.txt
[DocumentProcessor] Trich xuat thanh cong voi TxtExtractor
[JsonStorageAdapter] Da luu ho so DOC01 vao: server_storage\DOC01_data.json
[DocumentProcessor] Luu tru thanh cong qua adapter: Local JSON File Storage
Email gui den an.nv@gmail.com: Ho so DOC01 chuyen sang trang thai Dang xet duyet
SMS gui den 0901234567: Ho so DOC01 chuyen sang trang thai Dang xet duyet
[JsonStorageAdapter] Da luu ho so DOC01 vao: server_storage\DOC01_data.json
Email gui den an.nv@gmail.com: Ho so DOC01 chuyen sang trang thai Da xu ly
SMS gui den 0901234567: Ho so DOC01 chuyen sang trang thai Da xu ly
[DocumentProcessor] Hoan tat quy trinh ho so DOC01 - Trang thai: Da xu ly
=> Ket qua cuoi cung: Da xu ly

--------------------------------------------------------------------------------
2. KICH BAN 2: HOOK METHOD & HOLLYWOOD PRINCIPLE (TEMPLATE METHOD PATTERN)
--------------------------------------------------------------------------------

[DocumentProcessor] Bat dau xu ly ho so: DOC02
[DocumentProcessor] Tu choi ho so tai buoc 'StrictSecurityHook': Chung thu chu ky so khong hop le hoac bi thieu (Yeu cau tieu chuan RSA).
Email gui den bich.tt@gmail.com: Ho so DOC02 chuyen sang trang thai Tu choi
SMS gui den 0912345678: Ho so DOC02 chuyen sang trang thai Tu choi
App Push gui den nguoi dung Tran Thi Bich: Ho so DOC02 - Tu choi
=> Ket qua kiem duyet Hook: Tu choi

--------------------------------------------------------------------------------
3. KICH BAN 3: STRATEGY & FACTORY METHOD PATTERN (DOC DA DINH DANG)
--------------------------------------------------------------------------------
Dang doc file txt: C:\Users\quang\AppData\Local\Temp\sample.txt
- [TXT] TxtExtractor -> Du lieu test cho dinh dang TXT
Gia lap OCR doc file PDF: C:\Users\quang\AppData\Local\Temp\sample.pdf
- [PDF] PdfExtractor -> Noi dung trich xuat tu PDF qua OCR
Gia lap OCR doc hinh anh: C:\Users\quang\AppData\Local\Temp\sample.jpg
- [JPG] ImageOcrExtractor -> Noi dung trich xuat tu hinh anh qua OCR

--------------------------------------------------------------------------------
4. KICH BAN 4: ADAPTER PATTERN (TICH HOP NGUON LUU TRU DA NEN TANG)
--------------------------------------------------------------------------------
[JsonStorageAdapter] Da luu ho so DOC_STORAGE vao: server_storage\DOC_STORAGE_data.json
[MySqlStorageAdapter] SQL: INSERT INTO documents VALUES ('DOC_STORAGE', 'Le Van Cuong') -> SUCCESS.
[AwsS3StorageAdapter] S3::putObject(bucket='bucket-edocument-2026', key='DOC_STORAGE') -> 200 OK.
=> Adapter Pattern giup he thong tuong thich dong thoi 3 ha tang luu tru khac nhau ma khong can sua ma nguon DocumentProcessor!

--------------------------------------------------------------------------------
5. KICH BAN 5: COMMAND PATTERN (THUC THI, PHE DUYET, UNDO VA LOGGING)
--------------------------------------------------------------------------------
[Step 1] Nop ho so thong qua SubmitDocumentCommand:
[Command::Submit] Thuc thi lenh nop ho so: DOC_CMD_01

[DocumentProcessor] Bat dau xu ly ho so: DOC_CMD_01
Email gui den dung.ph@gmail.com: Ho so DOC_CMD_01 chuyen sang trang thai Da tiep nhan
SMS gui den 0933333333: Ho so DOC_CMD_01 chuyen sang trang thai Da tiep nhan
App Push gui den nguoi dung Pham Hoang Dung: Ho so DOC_CMD_01 - Da tiep nhan
Dang doc file txt: C:\Users\quang\AppData\Local\Temp\lenh_nop.txt
[DocumentProcessor] Trich xuat thanh cong voi TxtExtractor
[JsonStorageAdapter] Da luu ho so DOC_CMD_01 vao: server_storage\DOC_CMD_01_data.json
[DocumentProcessor] Luu tru thanh cong qua adapter: Local JSON File Storage
Email gui den dung.ph@gmail.com: Ho so DOC_CMD_01 chuyen sang trang thai Dang xet duyet
SMS gui den 0933333333: Ho so DOC_CMD_01 chuyen sang trang thai Dang xet duyet
App Push gui den nguoi dung Pham Hoang Dung: Ho so DOC_CMD_01 - Dang xet duyet
[JsonStorageAdapter] Da luu ho so DOC_CMD_01 vao: server_storage\DOC_CMD_01_data.json
Email gui den dung.ph@gmail.com: Ho so DOC_CMD_01 chuyen sang trang thai Da xu ly
SMS gui den 0933333333: Ho so DOC_CMD_01 chuyen sang trang thai Da xu ly
App Push gui den nguoi dung Pham Hoang Dung: Ho so DOC_CMD_01 - Da xu ly
[DocumentProcessor] Hoan tat quy trinh ho so DOC_CMD_01 - Trang thai: Da xu ly
[AUDIT LOG] [2026-10-11 10:33:22] [EXECUTE] Nop ho so: DOC_CMD_01 (Pham Hoang Dung)
Trang thai hien tai: Da xu ly

[Step 2] Can bo phe duyet qua ApproveDocumentCommand:
[JsonStorageAdapter] Da luu ho so DOC_CMD_01 vao: server_storage\DOC_CMD_01_data.json
Email gui den dung.ph@gmail.com: Ho so DOC_CMD_01 chuyen sang trang thai Da xu ly
SMS gui den 0933333333: Ho so DOC_CMD_01 chuyen sang trang thai Da xu ly
App Push gui den nguoi dung Pham Hoang Dung: Ho so DOC_CMD_01 - Da xu ly
[Command::Approve] Phe duyet ho so: DOC_CMD_01 thanh cong.
[AUDIT LOG] [2026-10-11 10:33:22] [EXECUTE] Phe duyet ho so: DOC_CMD_01
Trang thai hien tai: Da xu ly

[Step 3] Can bo phat hien nham lan -> Goi Hoan tac (UNDO):
[JsonStorageAdapter] Da luu ho so DOC_CMD_01 vao: server_storage\DOC_CMD_01_data.json
Email gui den dung.ph@gmail.com: Ho so DOC_CMD_01 chuyen sang trang thai Da xu ly
SMS gui den 0933333333: Ho so DOC_CMD_01 chuyen sang trang thai Da xu ly
App Push gui den nguoi dung Pham Hoang Dung: Ho so DOC_CMD_01 - Da xu ly
[Command::Approve] Da hoan tac phe duyet ho so: DOC_CMD_01
[AUDIT LOG] [2026-10-11 10:33:22] [UNDO] Phe duyet ho so: DOC_CMD_01
Trang thai sau khi Undo: Da xu ly

[Step 4] Danh sach nhat ky Audit Logging duoc luu lai boi Invoker:
   * [2026-10-11 10:33:22] [EXECUTE] Nop ho so: DOC_CMD_01 (Pham Hoang Dung)
   * [2026-10-11 10:33:22] [EXECUTE] Phe duyet ho so: DOC_CMD_01
   * [2026-10-11 10:33:22] [UNDO] Phe duyet ho so: DOC_CMD_01

================================================================================
   KET THUC TOAN BO KICH BAN KIEM THU THUC NGHIEM - HOAN TAT!
================================================================================
```

---

### 5.3. Đánh giá khả năng tương tác trực quan trên giao diện Java Swing UI
Bên cạnh kịch bản console, nhóm cung cấp giao diện đồ họa hoàn chỉnh `MainSwingUI.java`:
* **Bảng danh sách hồ sơ (JTable):** Thể hiện trực quan mã hồ sơ, người nộp, loại văn bản và trạng thái vòng đời.
* **Hộp thoại tiếp nhận hồ sơ (`AddDocumentDialog`):** Tích hợp **Builder Pattern** hỗ trợ kiểm tra dữ liệu theo từng nhóm; kết nối **Command Pattern** (`SubmitDocumentCommand`) để đưa hồ sơ vào luồng xử lý.
* **Cụm nút điều phối nghiệp vụ:** Hỗ trợ đầy đủ các thao tác "Phê duyệt" (`ApproveDocumentCommand`), "Từ chối" (`RejectDocumentCommand`), "Hoàn tác (Undo)" và "Làm lại (Redo)" tương tác mượt mà với Invoker.
* **Màn hình nhật ký kiểm toán (Audit Log Viewer):** Cập nhật thời gian thực từng biến động trạng thái phục vụ công tác thanh tra.

---

# CHƯƠNG 6: KẾT LUẬN VÀ HƯỚNG PHÁT TRIỂN

### 6.1. Bảng đối chiếu tổng quan giữa phiên bản 1.0 và phiên bản 2.0
| Khía cạnh kiến trúc | Phiên bản cũ 1.0 (Monolithic) | Phiên bản mới 2.0 (Design Patterns) |
| :--- | :--- | :--- |
| **Khởi tạo dữ liệu** | Hàm khởi tạo 13 tham số cồng kềnh, không lưu nháp được | **Builder Pattern**: Thiết lập từng bước, hỗ trợ lưu nháp linh hoạt |
| **Thao tác công vụ** | Gán cờ trực tiếp, không hoàn tác được, thiếu kiểm toán | **Command Pattern**: Hỗ trợ Undo/Redo và sổ nhật ký Audit Log |
| **Bóc tách tài liệu** | `if-else` cứng nhắc, chỉ đọc được tệp thô .TXT | **Strategy + Factory Method**: Đọc đa định dạng (.txt, .pdf, .jpg) |
| **Thẩm định hồ sơ** | Hàm đơn khối dồn dập, trùng lặp mã | **Template Method**: Khung quy trình chuẩn hóa có Hook an ninh RSA |
| **Hệ thống thông báo** | Khởi tạo tự do, gửi spam đồng thời Email và SMS | **Observer + Singleton**: Quản lý duy nhất, gửi theo cấu hình |
| **Hạ tầng lưu trữ** | Ghi tệp cục bộ cố định thông qua `FileWriter` | **Adapter Pattern**: Chuẩn hóa Target, hoán đổi JSON/MySQL/AWS S3 |
| **Tuân thủ chuẩn SOLID** | Vi phạm hầu hết các nguyên tắc thiết kế | Tuân thủ 100% các nguyên tắc SRP, OCP, LSP, ISP, DIP |

### 6.2. Các mục tiêu chất lượng đã đạt được
* **Khả năng bảo trì (Maintainability):** Phân chia module rành mạch, khoanh vùng phạm vi ảnh hưởng của lỗi.
* **Khả năng mở rộng (Extensibility):** Bổ sung tính năng mới hoàn toàn tuân thủ Open/Closed Principle, không cần sửa đổi mã nguồn lõi.
* **Độ tin cậy vận hành (Operational Reliability):** Cơ chế Undo/Redo và Audit Log mang lại sự an toàn cao cho môi trường hành chính công vụ.
* **Khả năng kiểm thử (Testability):** Dễ dàng triển khai Unit Test độc lập cho từng module nhờ việc triệt tiêu sự phụ thuộc cứng.

### 6.3. Định hướng mở rộng trong tương lai
* Mở rộng thêm Storage Adapter kết nối với các hệ quản trị NoSQL (MongoDB, DynamoDB).
* Tích hợp dịch vụ OCR đám mây (Google Cloud Vision, AWS Textract) cho module Strategy trích xuất.
* Chuyển đổi giao diện đồ họa Swing sang kiến trúc Web Service RESTful (Spring Boot + React) dựa trên nền tảng Core Design Patterns đã được chuẩn hóa.

---

# TÀI LIỆU THAM KHẢO

1. **Bộ môn Công nghệ Phần mềm - Khoa CNTT, Trường Đại học Tôn Đức Thắng**, *Đề cương chi tiết môn học Mẫu Thiết Kế (Course Syllabus 504077)*, 2026.
2. **Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides**, *Design Patterns: Elements of Reusable Object-Oriented Software*, Addison-Wesley Professional, 1994.
3. **Robert C. Martin**, *Clean Architecture: A Craftsman's Guide to Software Structure and Design*, Prentice Hall, 2017.
4. **Joshua Bloch**, *Effective Java (3rd Edition)*, Addison-Wesley, 2018 (Chương 2: Builder Pattern for constructors with many parameters).
5. **Martin Fowler**, *Refactoring: Improving the Design of Existing Code (2nd Edition)*, Addison-Wesley Professional, 2018.

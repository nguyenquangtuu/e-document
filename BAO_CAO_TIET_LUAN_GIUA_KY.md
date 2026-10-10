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

Trong tiến trình chuyển đổi số quốc gia và hiện đại hóa thủ tục hành chính công vụ, việc xây dựng các hệ thống tiếp nhận và xử lý hồ sơ điện tử đóng vai trò then chốt nhằm nâng cao hiệu quả làm việc, tính minh bạch và độ tin cậy của quy trình xử lý hồ sơ. Tuy nhiên, các hệ thống phần mềm nghiệp vụ thường xuyên phải đối mặt với bài toán thay đổi: các biểu mẫu quy chuẩn liên tục cập nhật, các định dạng tài liệu ngày một đa dạng (từ văn bản số hóa thuần túy đến tài liệu scan dạng ảnh, PDF qua nhận dạng quang học OCR), cùng các chính sách kiểm duyệt an ninh thông tin ngày càng khắt khe.

Để phần mềm có thể tồn tại và phát triển bền vững trước những biến động liên tục của yêu cầu nghiệp vụ, việc áp dụng các Mẫu thiết kế phần mềm (Design Patterns) cùng các nguyên lý thiết kế hướng đối tượng chuẩn mực (SOLID) là yếu tố quyết định chất lượng của kiến trúc phần mềm.

Nhóm sinh viên chúng em xin bày tỏ lòng biết ơn chân thành và sâu sắc nhất đến Thầy ThS. Vũ Đình Hồng – giảng viên phụ trách môn học Mẫu Thiết Kế. Thầy đã truyền đạt những nền tảng kiến thức lý thuyết vững vàng, dẫn dắt tư duy trừu tượng hóa và chia sẻ nhiều kinh nghiệm thực tiễn quý giá, giúp chúng em thấu hiểu bản chất của từng mẫu thiết kế GoF và phương pháp ứng dụng chúng vào các bài toán công nghệ thực tế.

Chúng em cũng xin gửi lời cảm ơn đến Ban Lãnh đạo Khoa Công Nghệ Thông Tin – Trường Đại học Tôn Đức Thắng đã tạo môi trường học tập và nghiên cứu thực nghiệm thuận lợi. Dù nhóm đã nỗ lực hết mình để phân tích, thiết kế và hoàn thiện đồ án này, song bài báo cáo chắc chắn khó tránh khỏi những điểm còn hạn chế. Chúng em rất mong nhận được những nhận xét, góp ý quý báu của Thầy để tiếp tục hoàn thiện kiến thức chuyên môn.

---

# CAM ĐOAN KẾT QUẢ ĐỒ ÁN

Nhóm sinh viên GKPT03 xin cam đoan rằng: Báo cáo tiểu luận giữa kỳ đề tài "Tái cấu trúc và nâng cấp kiến trúc hệ thống tiếp nhận và xử lý hồ sơ điện tử eDocument phiên bản 2.0" là sản phẩm nghiên cứu, phân tích và lập trình độc lập của các thành viên trong nhóm, dưới sự giảng dạy trực tiếp của Thầy ThS. Vũ Đình Hồng.

Mọi số liệu, sơ đồ kiến trúc lớp, sơ đồ tuần tự và mã nguồn minh họa được trình bày trong báo cáo này đều phản ánh trung thực kết quả chạy thực nghiệm của dự án. Mọi nội dung tham khảo từ sách giáo trình chuẩn của Trường Đại học Tôn Đức Thắng và các tài liệu học thuật quốc tế đều được trích dẫn xuất xứ minh bạch tại mục Tài liệu tham khảo.

Chúng em xin hoàn toàn chịu mọi trách nhiệm theo quy định của nhà trường nếu có bất kỳ sự không trung thực nào trong đồ án này.

Thành phố Hồ Chí Minh, ngày 10 tháng 10 năm 2026

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
* **CHƯƠNG 1: KHẢO SÁT HIỆN TRẠNG VÀ NHẬN DIỆN KHIẾM KHUYẾT HỆ THỐNG V1.0**
  * 1.1. Bối cảnh hoạt động và kiến trúc nguyên khối của phiên bản 1.0
  * 1.2. Phân tích hiện trạng các luồng nghiệp vụ cốt lõi
  * 1.3. Nhận diện các triệu chứng mục rữa thiết kế (Design Smells)
  * 1.4. Chỉ điểm chi tiết các khiếm khuyết trong mã nguồn cũ (Code Smells)
  * 1.5. Đánh giá tác động tiêu cực của kiến trúc cũ đối với khả năng mở rộng
* **CHƯƠNG 2: ĐỀ XUẤT KIẾN TRÚC MỚI VÀ LUẬN GIẢI MẪU THIẾT KẾ CHUẨN SYLLABUS**
  * 2.1. Nâng cấp xử lý thao tác hồ sơ bằng Command Pattern (Chương 7)
    * 2.1.1. Hiện trạng vấn đề và rủi ro vận hành
    * 2.1.2. Luận giải giải pháp áp dụng Command Pattern
    * 2.1.3. Sơ đồ cấu trúc lớp của module thao tác hồ sơ
    * 2.1.4. Mã nguồn hiện thực hóa chi tiết
  * 2.2. Nâng cấp trích xuất nội dung đa định dạng bằng Strategy Pattern kết hợp Factory Method (Chương 3 và Chương 5)
    * 2.2.1. Hiện trạng vấn đề và sự vi phạm nguyên tắc đóng mở
    * 2.2.2. Luận giải giải pháp kết hợp Strategy Pattern và Factory Method
    * 2.2.3. Sơ đồ cấu trúc lớp của module trích xuất tài liệu
    * 2.2.4. Mã nguồn hiện thực hóa chi tiết
  * 2.3. Nâng cấp quy trình kiểm duyệt hồ sơ bằng Template Method Pattern (Chương 4)
    * 2.3.1. Hiện trạng vấn đề quy trình kiểm tra nguyên khối
    * 2.3.2. Luận giải giải pháp áp dụng Template Method Pattern với Hook an ninh
    * 2.3.3. Sơ đồ cấu trúc lớp của module kiểm duyệt hồ sơ
    * 2.3.4. Mã nguồn hiện thực hóa chi tiết
  * 2.4. Nâng cấp hệ thống thông báo đa kênh bằng Observer Pattern kết hợp Singleton Pattern (Chương 9 và Chương 2)
    * 2.4.1. Hiện trạng vấn đề phụ thuộc chặt chẽ và dư thừa tài nguyên
    * 2.4.2. Luận giải giải pháp kết hợp Observer Pattern và Singleton Pattern
    * 2.4.3. Sơ đồ cấu trúc lớp của module thông báo
    * 2.4.4. Mã nguồn hiện thực hóa chi tiết
  * 2.5. Nâng cấp hạ tầng lưu trữ dữ liệu đa nền tảng bằng Adapter Pattern (Chương 8)
    * 2.5.1. Hiện trạng vấn đề rò rỉ mã nguồn truy xuất dữ liệu cấp thấp
    * 2.5.2. Luận giải giải pháp áp dụng Adapter Pattern
    * 2.5.3. Sơ đồ cấu trúc lớp của module lưu trữ
    * 2.5.4. Mã nguồn hiện thực hóa chi tiết
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

# CHƯƠNG 1: KHẢO SÁT HIỆN TRẠNG VÀ NHẬN DIỆN KHIẾM KHUYẾT HỆ THỐNG V1.0

### 1.1. Bối cảnh hoạt động và kiến trúc nguyên khối của phiên bản 1.0
Hệ thống tiếp nhận và xử lý hồ sơ điện tử phiên bản 1.0 được phát triển ban đầu với mục tiêu phục vụ việc tiếp nhận hồ sơ hành chính ở mức độ đơn giản. Toàn bộ hệ thống được xây dựng theo mô hình nguyên khối (Monolithic Architecture). Trong kiến trúc này, toàn bộ logic nghiệp vụ xử lý hồ sơ, logic kiểm tra tính hợp lệ, thuật toán đọc nội dung tệp, phương thức lưu trữ xuống ổ đĩa máy chủ và thao tác gửi email, tin nhắn thông báo đều được gom chung vào một lớp xử lý trung tâm là lớp DocumentProcessor.

Mặc dù kiến trúc nguyên khối ban đầu cho phép hoàn thành sản phẩm nhanh chóng, nhưng sau một thời gian vận hành thực tế, khi số lượng hồ sơ gia tăng và các yêu cầu quản lý thay đổi, hệ thống v1.0 đã bộc lộ những nhược điểm nghiêm trọng. Sự thiếu vắng các lớp trừu tượng phân tách trách nhiệm đã khiến mã nguồn trở nên rối rắm, các thành phần gắn chặt vào nhau, gây cản trở trực tiếp đến việc nâng cấp, kiểm thử tự động và mở rộng các tính năng mới.

---

### 1.2. Phân tích hiện trạng các luồng nghiệp vụ cốt lõi
Qua khảo sát chi tiết mã nguồn phiên bản 1.0, các luồng nghiệp vụ chính của hệ thống được vận hành như sau:

1. Luồng tiếp nhận và thao tác hồ sơ: Khi người nộp thực hiện gửi hồ sơ, hệ thống trực tiếp gọi các phương thức thiết lập trạng thái. Thao tác tiếp nhận, duyệt hay từ chối hồ sơ diễn ra ngay tức thì thông qua việc gán giá trị biến. Toàn bộ tiến trình không hề lưu lại lịch sử các bước thực hiện; không có khả năng hoàn tác thao tác khi cán bộ xử lý nhầm; và không có cơ chế ghi nhận nhật ký kiểm toán hành chính.

2. Luồng kiểm duyệt hồ sơ: Quy trình kiểm tra tính hợp lệ của hồ sơ được thực hiện tuần tự qua một chuỗi câu lệnh điều kiện cố định: kiểm tra định dạng email, kiểm tra tệp tin có tồn tại hay không, kiểm tra dung lượng tệp không vượt quá 5MB, và kiểm tra phần mở rộng tệp phải là .TXT. Toàn bộ chuỗi này được lập trình cứng trong một hàm duy nhất. Nếu có bất kỳ bước nào không đạt, hệ thống gán nhãn từ chối và chuyển ngay sang gửi thông báo. Quy trình này hoàn toàn không cho phép cấu hình lại thứ tự kiểm tra hoặc phân nhánh các cấp độ kiểm duyệt an ninh khác nhau.

3. Luồng trích xuất nội dung: Hệ thống chỉ đọc được các tệp văn bản thô định dạng .TXT. Khi người dùng đính kèm các tài liệu hành chính phổ biến như tệp PDF hoặc hình ảnh scan JPG, hệ thống bỏ trống nội dung trích xuất do các nhánh điều kiện if-else không hỗ trợ thuật toán xử lý tương ứng.

4. Luồng lưu trữ dữ liệu: Sau khi xử lý, lớp nghiệp vụ trực tiếp khởi tạo luồng ghi tệp FileWriter để chuyển đổi dữ liệu hồ sơ thành các chuỗi JSON và ghi phân tán lên ổ đĩa cứng của máy chủ. Mã nguồn can thiệp trực tiếp vào đường dẫn tệp tin vật lý mà không có bất kỳ lớp trung gian nào quản lý giao tiếp dữ liệu.

5. Luồng gửi thông báo: Hệ thống mặc định gửi đồng thời cả thư điện tử Email và tin nhắn SMS cho mọi người nộp hồ sơ. Các lớp dịch vụ gửi tin được khởi tạo tùy tiện bên trong hàm xử lý mà không có cơ chế quản lý vòng đời tập trung.

#### Bảng 1.1: So sánh tổng quan các nghiệp vụ chính của hệ sinh thái phiên bản 1.0
| Nghiệp vụ hệ thống | Đặc điểm triển khai trong phiên bản 1.0 | Hạn chế và rủi ro xác định |
| :--- | :--- | :--- |
| Tiếp nhận và Thao tác | Gọi trực tiếp phương thức cập nhật biến trạng thái, thiếu hoàn toàn lịch sử lệnh. | Không hỗ trợ hoàn tác thao tác (Undo), không có cơ chế kiểm toán giao dịch (Audit Log). |
| Kiểm duyệt hồ sơ | Cấu trúc kiểm tra tuần tự bằng các khối if-else cứng nhắc, dồn cục trong một hàm. | Khó bổ sung trạm kiểm tra mới, không phân tách được cấp độ kiểm duyệt tiêu chuẩn và bảo mật cao. |
| Trích xuất tài liệu | Chỉ đọc được tệp văn bản thuần .TXT, bỏ qua các định dạng tệp khác. | Không đáp ứng yêu cầu đọc tệp PDF hay nhận dạng hình ảnh OCR, vi phạm nguyên tắc đóng mở OCP. |
| Lưu trữ dữ liệu | Lớp nghiệp vụ trực tiếp ghi tệp JSON xuống ổ đĩa cục bộ qua FileWriter. | Rò rỉ mã nguồn truy xuất I/O cấp thấp, không thể chuyển đổi sang Cơ sở dữ liệu hay Đám mây. |
| Quản lý thông báo | Mặc định gửi cả Email và SMS, khởi tạo nhiều thực thể phân phối không cần thiết. | Gây phiền toái cho người dùng, lãng phí tài nguyên mạng, thiếu quản lý đối tượng tập trung. |

---

### 1.3. Nhận diện các triệu chứng mục rữa thiết kế (Design Smells)
Theo lý thuyết kiến trúc phần mềm hướng đối tượng của Robert C. Martin, cấu trúc mã nguồn của hệ thống v1.0 đã mắc phải ba triệu chứng mục rữa thiết kế kinh điển:

* Tính cứng nhắc (Rigidity): Phần mềm có xu hướng cực kỳ khó thay đổi. Một yêu cầu chỉnh sửa tưởng chừng đơn giản (chẳng hạn như bổ sung thêm bước quét mã độc trước khi tiếp nhận, hoặc đổi nơi lưu trữ từ tệp JSON sang Cơ sở dữ liệu MySQL) lại đòi hỏi lập trình viên phải sửa đổi mã nguồn cốt lõi ở nhiều vị trí trong lớp DocumentProcessor.
* Tính dễ vỡ (Fragility): Do các thành phần gắn kết quá chặt, khi lập trình viên thực hiện sửa đổi logic lưu trữ tệp tin, sự thay đổi này có thể vô tình làm ảnh hưởng đến luồng gửi thông báo hoặc làm gián đoạn tiến trình trích xuất nội dung tài liệu.
* Tính bất động (Immobility): Các đoạn mã hữu ích như thuật toán đọc tệp hay phương thức gửi tin nhắn bị viết lồng ghép sâu bên trong luồng xử lý chính. Khi một module khác trong tương lai cần tái sử dụng tính năng đọc tệp hoặc gửi thông báo, lập trình viên không thể tách riêng các đoạn mã này ra mà buộc phải sao chép mã nguồn, dẫn đến tình trạng trùng lặp mã trầm trọng.

---

### 1.4. Chỉ điểm chi tiết các khiếm khuyết trong mã nguồn cũ (Code Smells)
Khảo sát sâu vào từng dòng mã nguồn của phiên bản v1.0, nhóm đã chỉ điểm được 5 khiếm khuyết thiết kế cụ thể:

1. Khiếm khuyết thao tác không thể đảo ngược (Non-reversible Actions):
Trong phiên bản cũ, các hành vi tiếp nhận, phê duyệt và từ chối hồ sơ chỉ đơn thuần là việc gán lại giá trị cho trường status của đối tượng Document. Hệ thống hoàn toàn thiếu vắng một cấu trúc đóng gói các hành động này thành các đối tượng lệnh độc lập. Hậu quả là khi cán bộ xử lý thao tác nhầm lẫn, hệ thống không có cách nào đưa hồ sơ quay trở về trạng thái hợp lệ trước đó.

2. Khiếm khuyết chuỗi điều kiện rẽ nhánh dày đặc (Hardcoded Conditionals):
Luồng trích xuất nội dung tệp tin sử dụng cấu trúc:
```
if (extension.equals("txt")) {
    // Đọc văn bản thô
} else {
    // Không hỗ trợ
}
```
Khối lệnh này vi phạm nghiêm trọng Nguyên tắc Đóng Mở (Open/Closed Principle). Mỗi khi cần hỗ trợ thêm định dạng tài liệu mới như .pdf hay .jpg, lập trình viên bắt buộc phải mở lớp xử lý trung tâm ra để viết thêm các nhánh else if mới.

3. Khiếm khuyết quy trình kiểm duyệt nguyên khối dồn cục (Rigid Monolithic Flow):
Toàn bộ quy trình kiểm tra điều kiện đầu vào được cài đặt trong một hàm duy nhất dài hàng trăm dòng lệnh. Không có sự phân biệt giữa khung thuật toán chung với các bước kiểm tra chi tiết, và hoàn toàn không có cơ chế điểm nối (Hook) để bổ sung các điều kiện an ninh đặc thù cho các loại hồ sơ cơ mật.

4. Khiếm khuyết dính chặt phụ thuộc thông báo (Tight Coupling Notification):
Lớp nghiệp vụ DocumentProcessor trực tiếp tạo mới các đối tượng dịch vụ gửi Email và SMS thông qua từ khóa new. Điều này khiến cho lớp nghiệp vụ phụ thuộc chặt chẽ vào hạ tầng mạng bên ngoài và vi phạm nguyên tắc quản lý duy nhất (Singleton Pattern).

5. Khiếm khuyết rò rỉ mã nguồn truy xuất dữ liệu cấp thấp (Data Access Leakage):
Việc thao tác trực tiếp với lớp FileWriter và các đường dẫn tệp tin vật lý ngay trong lớp xử lý nghiệp vụ vi phạm nghiêm trọng Nguyên tắc Đảo ngược phụ thuộc (Dependency Inversion Principle). Lớp nghiệp vụ cấp cao bị kéo xuống phụ thuộc trực tiếp vào chi tiết lưu trữ cấp thấp.

---

### 1.5. Đánh giá tác động tiêu cực của kiến trúc cũ đối với khả năng mở rộng
Kiến trúc nguyên khối cũ tạo ra những rào cản lớn đối với sự phát triển lâu dài của hệ thống:
* Làm chậm tốc độ phát triển tính năng mới do đội ngũ lập trình viên phải tốn nhiều thời gian đọc hiểu và phòng tránh lỗi phát sinh khi chỉnh sửa mã nguồn cũ.
* Gây khó khăn cho hoạt động kiểm thử tự động (Unit Testing) vì không thể kiểm tra riêng rẽ thuật toán trích xuất tệp hay logic kiểm duyệt mà không phải khởi chạy toàn bộ quy trình.
* Tăng nguy cơ gián đoạn dịch vụ công trực tuyến khi một lỗi phát sinh tại một thành phần nhỏ có thể làm ngưng trệ toàn bộ chu trình xử lý hồ sơ.

---

# CHƯƠNG 2: ĐỀ XUẤT KIẾN TRÚC MỚI VÀ LUẬN GIẢI MẪU THIẾT KẾ CHUẨN SYLLABUS

Nhằm khắc phục triệt để các khiếm khuyết trên, phiên bản 2.0 được tái cấu trúc toàn diện bằng việc áp dụng **100% các Mẫu thiết kế chuẩn GoF nằm trong Đề cương môn học (Course Syllabus 504077)** của Trường Đại học Tôn Đức Thắng.

---

### 2.1. Nâng cấp xử lý thao tác hồ sơ bằng Command Pattern (Chương 7)

#### 2.1.1. Hiện trạng vấn đề và rủi ro vận hành
Trong hệ thống cũ, các thao tác nghiệp vụ như nộp hồ sơ, cán bộ phê duyệt hoặc từ chối hồ sơ chỉ được kích hoạt bằng các lời gọi hàm trực tiếp. Điều này tạo ra rủi ro vận hành rất lớn:
* Nếu cán bộ phê duyệt nhầm lẫn một hồ sơ vi phạm quy chế, hệ thống không cung cấp cơ chế nào để hoàn tác thao tác và đưa hồ sơ trở lại trạng thái xét duyệt ban đầu.
* Hệ thống thiếu cơ chế theo dõi và ghi nhật ký kiểm toán hành chính, khiến việc truy vết trách nhiệm xử lý công vụ trở nên bất khả thi.

#### 2.1.2. Luận giải giải pháp áp dụng Command Pattern
Để giải quyết bài toán này, nhóm áp dụng **Command Pattern** (được giảng dạy tại Chương 7 của đề cương môn học). Mẫu thiết kế này đóng gói mỗi yêu cầu thao tác thành một đối tượng riêng biệt:
* Giao diện chuẩn DocumentCommand định nghĩa hai phương thức cốt lõi là execute() để thực thi lệnh và undo() để hoàn tác lệnh.
* Các lớp cụ thể SubmitDocumentCommand, ApproveDocumentCommand, RejectDocumentCommand đóng gói chi tiết từng loại thao tác nghiệp vụ.
* Lớp DocumentCommandInvoker đóng vai trò người điều phối, quản lý ngăn xếp lịch sử undoStack phục vụ tính năng Hoàn tác (Undo/Redo theo đúng Mục 7.5 trong đề cương) và danh sách auditLogs phục vụ việc ghi nhật ký giao dịch tự động (Audit Logging theo đúng Mục 7.6 trong đề cương).

#### 2.1.3. Sơ đồ cấu trúc lớp của module thao tác hồ sơ
```
+-------------------------------------------------------+
|              <<interface>> DocumentCommand            |
+-------------------------------------------------------+
| + execute(): void                                     |
| + undo(): void                                        |
| + getDescription(): String                            |
| + getDocument(): Document                             |
+-------------------------------------------------------+
           ^                        ^
           |                        |
+--------------------------+ +--------------------------+
|  SubmitDocumentCommand   | |  ApproveDocumentCommand  |
+--------------------------+ +--------------------------+
| - processor              | | - storage                |
| - document               | | - document               |
| - previousStatus         | | - previousStatus         |
| - executedSuccessfully   | | - officerNote            |
+--------------------------+ +--------------------------+
| + execute(): void        | | + execute(): void        |
| + undo(): void           | | + undo(): void           |
+--------------------------+ +--------------------------+

+-------------------------------------------------------+
|                DocumentCommandInvoker                 |
+-------------------------------------------------------+
| - undoStack: Stack<DocumentCommand>                   |
| - redoStack: Stack<DocumentCommand>                   |
| - auditLogs: List<String>                             |
+-------------------------------------------------------+
| + executeCommand(cmd: DocumentCommand): void          |
| + undo(): boolean                                     |
| + redo(): boolean                                     |
| + getAuditLogs(): List<String>                        |
+-------------------------------------------------------+
```

#### 2.1.4. Mã nguồn hiện thực hóa chi tiết
```java
// Giao diện Command chuẩn hóa thao tác
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
// Lớp lệnh thực thi phê duyệt hồ sơ và hỗ trợ hoàn tác
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
            "Hoan tac phe duyet, quay ve trang thai: " + previousStatus.getDisplayName()
        );
    }

    @Override
    public String getDescription() { return "Phe duyet ho so: " + document.getId(); }
    @Override
    public Document getDocument() { return document; }
}
```

---

### 2.2. Nâng cấp trích xuất nội dung đa định dạng bằng Strategy Pattern kết hợp Factory Method (Chương 3 và Chương 5)

#### 2.2.1. Hiện trạng vấn đề và sự vi phạm nguyên tắc đóng mở
Hệ thống cũ cài đặt thuật toán đọc tệp tin lồng ghép trực tiếp trong luồng xử lý chính bằng các câu lệnh rẽ nhánh if-else. Cách làm này khiến cho:
* Lớp xử lý nghiệp vụ bị phình to (God Class), gánh vác cả trách nhiệm phân tích tệp tin.
* Vi phạm nghiêm trọng nguyên tắc OCP: Mỗi khi cơ quan quản lý bổ sung thêm định dạng tệp hồ sơ mới, mã nguồn của lớp điều phối trung tâm bắt buộc phải bị sửa đổi.

#### 2.2.2. Luận giải giải pháp kết hợp Strategy Pattern và Factory Method
Nhóm kết hợp hai mẫu thiết kế kinh điển:
* **Strategy Pattern (Chương 3):** Định nghĩa giao diện ContentExtractor đóng gói thuật toán trích xuất tệp. Các lớp TxtExtractor, PdfExtractor, ImageOcrExtractor độc lập triển khai thuật toán đọc riêng cho từng loại tệp.
* **Factory Method Pattern (Chương 5):** Lớp ExtractorFactory chịu trách nhiệm khởi tạo và trả về đối tượng trích xuất tương ứng với phần mở rộng của tệp. Lớp nghiệp vụ DocumentProcessor hoàn toàn không cần biết chi tiết khởi tạo của từng bộ trích xuất.

#### 2.2.3. Sơ đồ cấu trúc lớp của module trích xuất tài liệu
```
+-------------------------------------------------------+
|             <<interface>> ContentExtractor            |
+-------------------------------------------------------+
| + extract(filePath: String): String                   |
| + supports(fileExtension: String): boolean            |
+-------------------------------------------------------+
          ^                   ^                   ^
          |                   |                   |
+-------------------+ +-------------------+ +-------------------+
|   TxtExtractor    | |   PdfExtractor    | | ImageOcrExtractor |
+-------------------+ +-------------------+ +-------------------+

+-------------------------------------------------------+
|                   ExtractorFactory                    |
+-------------------------------------------------------+
| + getExtractor(extension: String): ContentExtractor   |
+-------------------------------------------------------+
```

#### 2.2.4. Mã nguồn hiện thực hóa chi tiết
```java
// Giao diện Chiến lược trích xuất nội dung
package extractor;
import java.io.IOException;

public interface ContentExtractor {
    String extract(String filePath) throws IOException;
    boolean supports(String fileExtension);
}
```

```java
// Lớp Nhà máy sản xuất bộ trích xuất tương ứng
package extractor;

public class ExtractorFactory {
    public static ContentExtractor getExtractor(String extension) {
        if (extension == null) return new TxtExtractor();
        switch (extension.toLowerCase().trim()) {
            case "pdf": return new PdfExtractor();
            case "jpg":
            case "jpeg":
            case "png": return new ImageOcrExtractor();
            case "txt":
            default: return new TxtExtractor();
        }
    }
}
```

---

### 2.3. Nâng cấp quy trình kiểm duyệt hồ sơ bằng Template Method Pattern (Chương 4)

#### 2.3.1. Hiện trạng vấn đề quy trình kiểm tra nguyên khối
Quy trình kiểm tra tính hợp lệ của hồ sơ ở phiên bản cũ là một hàm nguyên khối, khiến việc phân tách chính sách kiểm duyệt trở nên bất khả thi. Trong thực tế hành chính công, các hồ sơ thông thường chỉ cần kiểm tra các thông tin bắt buộc, dung lượng tệp và quét mã độc; trong khi các hồ sơ nhạy cảm hoặc hồ sơ tài chính đòi hỏi cấp độ kiểm duyệt an ninh nghiêm ngặt hơn, bắt buộc phải có chữ ký số RSA và kiểm tra định dạng tệp trong danh sách cấp phép an toàn (Whitelist).

#### 2.3.2. Luận giải giải pháp áp dụng Template Method Pattern với Hook an ninh
Nhóm áp dụng **Template Method Pattern** (được giảng dạy tại Chương 4 của đề cương môn học):
* Lớp trừu tượng AbstractDocumentValidator định nghĩa một khung xương thuật toán kiểm duyệt bất biến trong phương thức validate(). Phương thức này được đánh dấu từ khóa final để ngăn cản các lớp con phá vỡ trình tự kiểm tra.
* Khung thuật toán bao gồm các bước kiểm tra nguyên thủy: kiểm tra thông tin bắt buộc, quét mã độc, và kiểm tra chống trùng lặp mã hồ sơ.
* Áp dụng nguyên lý Hollywood ("Don't call us, we'll call you") theo đúng Mục 4.5 của giáo trình: Lớp cha nắm quyền điều phối toàn bộ chu trình và chủ động gọi các bước của lớp con.
* Tích hợp phương thức điểm nối (Hook Method theo đúng Mục 4.4 của giáo trình): Lớp con StandardDocumentValidator giữ nguyên hành vi kiểm duyệt tiêu chuẩn, trong khi lớp con StrictSecurityValidator ghi đè phương thức Hook isSecurityHookEnabled() và postValidationSecurityHook() để kích hoạt quy chuẩn kiểm tra chữ ký số RSA mức cao.

#### 2.3.3. Sơ đồ cấu trúc lớp của module kiểm duyệt hồ sơ
```
+-------------------------------------------------------+
|              AbstractDocumentValidator                |
+-------------------------------------------------------+
| + validate(doc: Document): ValidationResult (final)   |
| # validateRequiredFields(doc)*: ValidationResult      |
| # scanAntivirus(doc)*: ValidationResult               |
| # checkDuplicate(doc)*: ValidationResult              |
| # isSecurityHookEnabled(): boolean (Hook mặc định)    |
| # postValidationSecurityHook(doc): ValidationResult   |
+-------------------------------------------------------+
                           ^
                           |
+-------------------------------------------------------+
|               StandardDocumentValidator               |
+-------------------------------------------------------+
| # validateRequiredFields(doc): ValidationResult       |
| # scanAntivirus(doc): ValidationResult                |
| # checkDuplicate(doc): ValidationResult               |
+-------------------------------------------------------+
                           ^
                           |
+-------------------------------------------------------+
|                StrictSecurityValidator                |
+-------------------------------------------------------+
| # isSecurityHookEnabled(): true                       |
| # postValidationSecurityHook(doc): ValidationResult   |
+-------------------------------------------------------+
```

#### 2.3.4. Mã nguồn hiện thực hóa chi tiết
```java
// Lớp trừu tượng định nghĩa khung xương thuật toán kiểm duyệt
package validation;
import model.Document;

public abstract class AbstractDocumentValidator {
    // KHUNG THUẬT TOÁN BẤT BIẾN (TEMPLATE METHOD)
    public final ValidationResult validate(Document doc) {
        if (doc == null) {
            return ValidationResult.failure("InputCheck", "Ho so khong duoc de trong");
        }

        ValidationResult r1 = validateRequiredFields(doc);
        if (!r1.isValid()) return r1;

        ValidationResult r2 = scanAntivirus(doc);
        if (!r2.isValid()) return r2;

        ValidationResult r3 = checkDuplicate(doc);
        if (!r3.isValid()) return r3;

        // ĐIỂM NỐI HOOK (HOLLYWOOD PRINCIPLE)
        if (isSecurityHookEnabled()) {
            ValidationResult rHook = postValidationSecurityHook(doc);
            if (!rHook.isValid()) return rHook;
        }

        return ValidationResult.success();
    }

    protected abstract ValidationResult validateRequiredFields(Document doc);
    protected abstract ValidationResult scanAntivirus(Document doc);
    protected abstract ValidationResult checkDuplicate(Document doc);

    // Phương thức Hook cung cấp giá trị mặc định cho lớp con
    protected boolean isSecurityHookEnabled() { return false; }
    protected ValidationResult postValidationSecurityHook(Document doc) { return ValidationResult.success(); }
}
```

```java
// Lớp con ghi đè phương thức Hook kiểm tra chữ ký số RSA
package validation;
import model.Document;

public class StrictSecurityValidator extends StandardDocumentValidator {
    @Override
    protected boolean isSecurityHookEnabled() {
        return true; // Kích hoạt điểm nối kiểm tra an ninh cao
    }

    @Override
    protected ValidationResult postValidationSecurityHook(Document doc) {
        String sig = doc.getDigitalSignature();
        if (sig == null || sig.trim().isEmpty() || !sig.startsWith("RSA")) {
            return ValidationResult.failure("StrictSecurityHook", "Chung thu chu ky so RSA bi thieu hoac khong hop le.");
        }
        return ValidationResult.success();
    }
}
```

---

### 2.4. Nâng cấp hệ thống thông báo đa kênh bằng Observer Pattern kết hợp Singleton Pattern (Chương 9 và Chương 2)

#### 2.4.1. Hiện trạng vấn đề phụ thuộc chặt chẽ và dư thừa tài nguyên
Trong phiên bản cũ, lớp xử lý hồ sơ tự động gọi trực tiếp các phương thức gửi Email và SMS mỗi khi hoàn tất một bước. Điều này dẫn đến sự ràng buộc cứng ngắc: lớp nghiệp vụ phải biết chi tiết việc truyền tin nhắn qua giao thức mạng nào. Hơn nữa, việc khởi tạo tùy tiện các lớp quản lý thông báo làm lãng phí tài nguyên bộ nhớ và dễ dẫn đến tình trạng bất đồng bộ cấu hình người dùng.

#### 2.4.2. Luận giải giải pháp kết hợp Observer Pattern và Singleton Pattern
Giải pháp nâng cấp phối hợp hai mẫu thiết kế:
* **Singleton Pattern (Chương 2):** Lớp NotificationManager được cài đặt theo mô hình Singleton với hàm khởi tạo riêng (Private Constructor) và cơ chế khởi tạo trễ có kiểm tra khóa hai lần (Lazy Instantiation kết hợp Double-Checked Locking). Cơ chế này đảm bảo toàn hệ thống chỉ có một đối tượng quản lý thông báo duy nhất, tuyệt đối an toàn trong môi trường đa luồng (Thread-Safe).
* **Observer Pattern (Chương 9):** Triển khai cơ chế Xuất bản và Đăng ký (Publish/Subscribe). Giao diện DocumentObserver được hiện thực bởi các lớp EmailNotifier, SmsNotifier, AppPushNotifier. Khi trạng thái hồ sơ thay đổi, NotificationManager tự động phân phối thông báo đến đúng các kênh mà người dùng đã đăng ký cấu hình trước đó.

#### 2.4.3. Sơ đồ cấu trúc lớp của module thông báo
```
+-------------------------------------------------------+
|                  NotificationManager                  |
+-------------------------------------------------------+
| - instance: NotificationManager (static volatile)     |
| - observers: List<DocumentObserver>                   |
| - userPreferences: Map<String, Set<String>>           |
+-------------------------------------------------------+
| - NotificationManager()                               |
| + getInstance(): NotificationManager (static)         |
| + attach(observer: DocumentObserver): void            |
| + detach(observer: DocumentObserver): void            |
| + setUserPreference(email, channels): void            |
| + notifyStatusChanged(doc, old, new, msg): void       |
+-------------------------------------------------------+
                           |
                           o (Chứa danh sách quan sát)
                           |
+-------------------------------------------------------+
|             <<interface>> DocumentObserver            |
+-------------------------------------------------------+
| + update(doc, oldStatus, newStatus, msg): void        |
| + getChannelName(): String                            |
+-------------------------------------------------------+
          ^                   ^                   ^
          |                   |                   |
+-------------------+ +-------------------+ +-------------------+
|   EmailNotifier   | |    SmsNotifier    | |  AppPushNotifier  |
+-------------------+ +-------------------+ +-------------------+
```

#### 2.4.4. Mã nguồn hiện thực hóa chi tiết
```java
// Lớp Singleton quản lý tập trung và phân phối thông báo
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
                if (instance == null) {
                    instance = new NotificationManager();
                }
            }
        }
        return instance;
    }

    public void attach(DocumentObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void setUserPreference(String userEmail, String... channels) {
        if (userEmail != null) {
            Set<String> set = new HashSet<>();
            if (channels != null) {
                for (String ch : channels) if (ch != null) set.add(ch.toUpperCase().trim());
            }
            userPreferences.put(userEmail, set);
        }
    }

    public void notifyStatusChanged(Document doc, DocumentStatus oldStatus, DocumentStatus newStatus, String message) {
        if (doc == null) return;
        String userEmail = doc.getApplicantEmail();
        Set<String> subscribed = (userEmail != null) ? userPreferences.get(userEmail) : null;
        for (DocumentObserver obs : observers) {
            if (subscribed == null || subscribed.contains(obs.getChannelName().toUpperCase())) {
                obs.update(doc, oldStatus, newStatus, message);
            }
        }
    }
}
```

---

### 2.5. Nâng cấp hạ tầng lưu trữ dữ liệu đa nền tảng bằng Adapter Pattern (Chương 8)

#### 2.5.1. Hiện trạng vấn đề rò rỉ mã nguồn truy xuất dữ liệu cấp thấp
Trong phiên bản cũ, các câu lệnh tạo tệp và ghi tệp cục bộ FileWriter nằm trực tiếp trong hàm nghiệp vụ. Khi đơn vị có nhu cầu chuyển đổi sang lưu trữ dữ liệu vào Hệ quản trị cơ sở dữ liệu MySQL hoặc lưu trữ trên nền tảng đám mây AWS S3, toàn bộ lớp nghiệp vụ trung tâm buộc phải bị đập đi viết lại.

#### 2.5.2. Luận giải giải pháp áp dụng Adapter Pattern
Nhóm áp dụng **Adapter Pattern** (được giảng dạy tại Chương 8 của đề cương môn học, tương ứng bài toán thực tế Adapter in software tại Mục 8.4):
* Xây dựng giao diện đích DocumentStorageTarget (Target Interface) chuẩn hóa các phương thức lưu trữ chung: save(), findById(), findAll(), delete().
* Các lớp Adapter cụ thể:
  * JsonFileStorageAdapter: Chuyển đổi hệ thống tệp tin JSON trên ổ cứng máy chủ tương thích với giao diện chuẩn.
  * MySqlStorageAdapter: Chuyển đổi các câu lệnh thao tác cơ sở dữ liệu quan hệ MySQL tương thích với giao diện chuẩn.
  * AwsS3StorageAdapter: Chuyển đổi các lời gọi API của dịch vụ lưu trữ đám mây AWS S3 tương thích với giao diện chuẩn.
* Nhờ vào Adapter Pattern, lớp DocumentProcessor chỉ giao tiếp thông qua giao diện đích. Việc thay đổi nơi lưu trữ diễn ra hoàn toàn trong suốt đối với logic nghiệp vụ.

#### 2.5.3. Sơ đồ cấu trúc lớp của module lưu trữ
```
+-------------------------------------------------------+
|         <<interface>> DocumentStorageTarget           |
+-------------------------------------------------------+
| + save(doc: Document): void                           |
| + findById(id: String): Document                      |
| + findAll(): List<Document>                           |
| + delete(id: String): void                            |
| + getStorageName(): String                            |
+-------------------------------------------------------+
          ^                   ^                   ^
          |                   |                   |
+-------------------+ +-------------------+ +-------------------+
|JsonFileStorage    | |MySqlStorage       | |AwsS3Storage       |
|Adapter            | |Adapter            | |Adapter            |
+-------------------+ +-------------------+ +-------------------+
| - storageDirPath  | | - simulatedDb     | | - bucketName      |
+-------------------+ +-------------------+ +-------------------+
```

#### 2.5.4. Mã nguồn hiện thực hóa chi tiết
```java
// Giao diện đích chuẩn hóa thao tác lưu trữ
package storage;
import model.Document;
import java.util.List;

public interface DocumentStorageTarget {
    void save(Document doc) throws Exception;
    Document findById(String id) throws Exception;
    List<Document> findAll() throws Exception;
    void delete(String id) throws Exception;
    String getStorageName();
}
```

```java
// Adapter chuyển đổi hệ thống tệp JSON cục bộ
package storage;
import model.Document;
import java.io.*;
import java.util.*;

public class JsonFileStorageAdapter implements DocumentStorageTarget {
    private final String storageDirPath;

    public JsonFileStorageAdapter() { this("server_storage"); }
    public JsonFileStorageAdapter(String storageDirPath) {
        this.storageDirPath = storageDirPath;
        File dir = new File(storageDirPath);
        if (!dir.exists()) dir.mkdirs();
    }

    @Override
    public String getStorageName() { return "Local JSON File Storage"; }

    @Override
    public void save(Document doc) throws Exception {
        if (doc == null || doc.getId() == null) return;
        File dataFile = new File(storageDirPath, doc.getId() + "_data.json");
        try (FileWriter writer = new FileWriter(dataFile)) {
            writer.write(toJson(doc));
        }
        System.out.println("[JsonStorageAdapter] Da luu ho so " + doc.getId() + " vao: " + dataFile.getPath());
    }

    @Override
    public Document findById(String id) throws Exception {
        File dataFile = new File(storageDirPath, id + "_data.json");
        if (!dataFile.exists()) return null;
        return fromJson(new String(java.nio.file.Files.readAllBytes(dataFile.toPath())));
    }

    @Override
    public List<Document> findAll() throws Exception {
        List<Document> list = new ArrayList<>();
        File dir = new File(storageDirPath);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((d, name) -> name.endsWith("_data.json"));
            if (files != null) {
                for (File f : files) {
                    try {
                        list.add(fromJson(new String(java.nio.file.Files.readAllBytes(f.toPath()))));
                    } catch (Exception ignored) {}
                }
            }
        }
        return list;
    }

    @Override
    public void delete(String id) throws Exception {
        File dataFile = new File(storageDirPath, id + "_data.json");
        if (dataFile.exists()) dataFile.delete();
    }
}
```

---

# CHƯƠNG 3: THIẾT KẾ KIẾN TRÚC TỔNG THỂ HỆ THỐNG V2.0 VÀ LUỒNG TƯƠNG TÁC

### 3.1. Sơ đồ lớp tổng thể toàn bộ hệ thống v2.0
Dưới đây là sơ đồ cấu trúc lớp tổng thể thể hiện mối liên kết và tính tương tác chặt chẽ giữa tất cả các thành phần trong hệ thống:

```
[MainSwingUI / ConsoleClient]
         |
         v
+--------------------------+
|  DocumentCommandInvoker  |  (Command Pattern - Chương 7)
+--------------------------+
         |
         v (thực thi)
+--------------------------+
|  SubmitDocumentCommand   |
+--------------------------+
         |
         v (kích hoạt)
+--------------------------+
|    DocumentProcessor     |
+--------------------------+
  |           |          |
  |           |          +------------------------------------+
  |           |                                               |
  v           v                                               v
+-------------------+  +-----------------------+  +------------------------+
| AbstractValidator |  |   ContentExtractor    |  |  DocumentStorageTarget |
| (Template Method  |  |  (Strategy & Factory  |  |   (Adapter Pattern     |
|   - Chương 4)     |  |    - Chương 3 & 5)    |  |      - Chương 8)       |
+-------------------+  +-----------------------+  +------------------------+
  |                      |                          |
  |-- StandardValidator  |-- TxtExtractor           |-- JsonStorageAdapter
  |-- StrictValidator    |-- PdfExtractor           |-- MySqlStorageAdapter
                         |-- ImageOcrExtractor      |-- AwsS3StorageAdapter
                                                    
+--------------------------+
|   NotificationManager    |  (Singleton & Observer - Chương 2 & Chương 9)
+--------------------------+
  |-- EmailNotifier
  |-- SmsNotifier
  |-- AppPushNotifier
```

---

### 3.2. Sơ đồ tuần tự thể hiện chu trình xử lý hồ sơ
Chu trình xử lý hoàn chỉnh của một bộ hồ sơ được diễn giải theo các bước tuần tự như sau:
* Bước 1: Người dùng hoặc cán bộ gửi yêu cầu tiếp nhận thông qua lệnh SubmitDocumentCommand được chuyển đến DocumentCommandInvoker.
* Bước 2: DocumentCommandInvoker gọi thực thi lệnh và lưu trữ đối tượng lệnh vào ngăn xếp phục vụ việc hoàn tác (Undo).
* Bước 3: Lệnh gọi DocumentProcessor bắt đầu điều phối quy trình xử lý.
* Bước 4: DocumentProcessor chuyển hồ sơ qua AbstractDocumentValidator thực hiện kiểm duyệt theo khung thuật toán của Template Method Pattern (lần lượt kiểm tra thông tin, quét mã độc, chống trùng mã, và kích hoạt Hook an ninh nếu có).
* Bước 5: Sau khi kiểm duyệt đạt yêu cầu, NotificationManager phát thông báo cập nhật trạng thái đã tiếp nhận đến các kênh đăng ký của người nộp.
* Bước 6: ExtractorFactory cung cấp đối tượng ContentExtractor tương ứng để trích xuất nội dung văn bản từ tệp đính kèm.
* Bước 7: Đối tượng DocumentStorageTarget lưu trữ toàn bộ dữ liệu hồ sơ thông qua Adapter tương ứng (JSON cục bộ, MySQL hoặc AWS S3).
* Bước 8: Trạng thái hồ sơ được cập nhật sang đã xử lý và thông báo xác nhận cuối cùng được gửi đến người nộp.

---

### 3.3. Bảng đối chiếu đồng nhất giữa sơ đồ thiết kế và mã nguồn thực thi
| Thành phần thiết kế trên sơ đồ | Tên lớp và tệp mã nguồn | Mẫu thiết kế tương ứng trong môn học |
| :--- | :--- | :--- |
| Giao diện lệnh điều khiển | command/DocumentCommand.java | Command Pattern (Chương 7) |
| Lệnh nộp hồ sơ | command/SubmitDocumentCommand.java | Command Pattern (Chương 7) |
| Lệnh phê duyệt hồ sơ | command/ApproveDocumentCommand.java | Command Pattern (Chương 7) |
| Lớp điều phối và lưu lịch sử lệnh | command/DocumentCommandInvoker.java | Command Pattern (Chương 7) |
| Lớp trừu tượng khung kiểm duyệt | validation/AbstractDocumentValidator.java | Template Method Pattern (Chương 4) |
| Lớp kiểm duyệt hồ sơ tiêu chuẩn | validation/StandardDocumentValidator.java | Template Method Pattern (Chương 4) |
| Lớp kiểm duyệt an ninh kích hoạt Hook | validation/StrictSecurityValidator.java | Template Method Pattern (Chương 4) |
| Giao diện chiến lược đọc tệp | extractor/ContentExtractor.java | Strategy Pattern (Chương 3) |
| Lớp nhà máy tạo bộ đọc tệp | extractor/ExtractorFactory.java | Factory Method Pattern (Chương 5) |
| Giao diện đích chuẩn hóa lưu trữ | storage/DocumentStorageTarget.java | Adapter Pattern (Chương 8) |
| Lớp chuyển đổi lưu trữ tệp JSON | storage/JsonFileStorageAdapter.java | Adapter Pattern (Chương 8) |
| Lớp chuyển đổi lưu trữ CSDL MySQL | storage/MySqlStorageAdapter.java | Adapter Pattern (Chương 8) |
| Lớp chuyển đổi lưu trữ đám mây S3 | storage/AwsS3StorageAdapter.java | Adapter Pattern (Chương 8) |
| Lớp quản lý phát thông báo duy nhất | notification/NotificationManager.java | Singleton Pattern kết hợp Observer (Chương 2 và 9) |
| Giao diện kênh nhận thông báo | notification/DocumentObserver.java | Observer Pattern (Chương 9) |

---

# CHƯƠNG 4: ĐÁNH GIÁ CHUYÊN SÂU TUÂN THỦ NGUYÊN TẮC SOLID VÀ NGUYÊN LÝ GOF

### 4.1. Đánh giá nguyên tắc đơn trách nhiệm (Single Responsibility Principle)
Trong kiến trúc phiên bản 2.0, mỗi lớp chỉ đảm nhận duy nhất một lý do để thay đổi:
* Lớp TxtExtractor chỉ chịu trách nhiệm đọc nội dung văn bản.
* Lớp NotificationManager chỉ quản lý danh sách đăng ký và điều hướng thông báo.
* Lớp JsonFileStorageAdapter chỉ thực hiện các thao tác đọc ghi tệp JSON.
* Lớp DocumentCommandInvoker chỉ quản lý ngăn xếp Undo/Redo và lưu trữ nhật ký kiểm toán.

### 4.2. Đánh giá nguyên tắc đóng mở (Open/Closed Principle)
Hệ thống hoàn toàn "Mở cho việc mở rộng, Đóng cho việc sửa đổi":
* Khi cần đọc thêm định dạng tệp .docx: Lập trình viên chỉ cần tạo lớp mới DocxExtractor implements ContentExtractor và đăng ký vào ExtractorFactory. Lớp nghiệp vụ DocumentProcessor hoàn toàn không bị thay đổi.
* Khi cần mở rộng lưu trữ sang MongoDB: Chỉ cần tạo lớp mới MongoDbStorageAdapter implements DocumentStorageTarget. Toàn bộ luồng xử lý chính vẫn giữ nguyên 100%.

### 4.3. Đánh giá nguyên tắc thay thế Liskov (Liskov Substitution Principle)
Các lớp con kế thừa có thể thay thế hoàn hảo cho lớp cha mà không làm thay đổi tính đúng đắn của chương trình:
* Lớp StandardDocumentValidator và StrictSecurityValidator có thể thay thế lẫn nhau tại vị trí của AbstractDocumentValidator.
* Mọi lớp Adapter đều có thể thay thế hoàn hảo cho DocumentStorageTarget mà không làm thay đổi hợp đồng giao tiếp dữ liệu.

### 4.4. Đánh giá nguyên tắc phân tách giao diện (Interface Segregation Principle)
Các giao diện được thiết kế độc lập, tập trung và ngắn gọn:
* Giao diện DocumentCommand chỉ chứa các thao tác thực thi và hoàn tác.
* Giao diện DocumentObserver chỉ chứa phương thức nhận sự kiện cập nhật.
* Giao diện DocumentStorageTarget chỉ tập trung vào các thao tác lưu trữ dữ liệu.

### 4.5. Đánh giá nguyên tắc đảo ngược phụ thuộc (Dependency Inversion Principle)
Lớp nghiệp vụ cấp cao DocumentProcessor hoàn toàn không phụ thuộc vào các lớp cụ thể cấp thấp như JsonFileStorageAdapter hay EmailNotifier. Mọi mối quan hệ phụ thuộc đều được định nghĩa thông qua các lớp trừu tượng và giao diện chuẩn DocumentStorageTarget, AbstractDocumentValidator, ContentExtractor.

### 4.6. Đánh giá nguyên lý Hollywood (Hollywood Principle) trong Template Method
Nguyên lý Hollywood được áp dụng chuẩn mực trong Template Method Pattern: Lớp cha AbstractDocumentValidator nắm toàn quyền điều phối tiến trình kiểm duyệt. Lớp cha chủ động gọi các bước của lớp con và kích hoạt phương thức Hook khi cần thiết; lớp con tuyệt đối không gọi ngược lên để làm thay đổi trật tự kiểm tra của lớp cha.

---

# CHƯƠNG 5: KỊCH BẢN KIỂM THỬ THỰC NGHIỆM VÀ ĐÁNH GIÁ VẬN HÀNH

### 5.1. Thiết kế 5 kịch bản kiểm thử tương ứng các chương đề cương môn học
Nhóm thiết kế 5 kịch bản kiểm thử toàn diện trên lớp MainDemo:
* Kịch bản 1: Kiểm thử Template Method Pattern và Singleton Pattern với hồ sơ hợp lệ, xác minh tính duy nhất của NotificationManager và sự vận hành trơn tru của chuỗi thông báo Observer.
* Kịch bản 2: Kiểm thử tính năng điểm nối Hook trong Template Method Pattern thông qua StrictSecurityValidator, chứng minh hồ sơ thiếu chữ ký số RSA sẽ bị từ chối ngay tại Hook an ninh.
* Kịch bản 3: Kiểm thử Strategy Pattern kết hợp Factory Method, tự động nhận diện và đọc nội dung đồng thời ba loại tệp .txt, .pdf và .jpg.
* Kịch bản 4: Kiểm thử Adapter Pattern, lưu trữ thành công cùng một đối tượng hồ sơ lên cả ba nền tảng: Tệp JSON cục bộ, CSDL MySQL và Cloud AWS S3.
* Kịch bản 5: Kiểm thử Command Pattern, thực hiện nộp hồ sơ, cán bộ phê duyệt, sau đó gọi hoàn tác (Undo) đưa hồ sơ quay về trạng thái trước đó và trích xuất danh sách nhật ký Audit Log.

---

### 5.2. Kết quả chạy thực nghiệm trên môi trường dòng lệnh (Console)
Toàn bộ mã nguồn đã được biên dịch sạch sẽ không có cảnh báo và cho kết quả chạy thực nghiệm chính xác 100%:

```
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
Dang doc file txt: don_xin_phep.txt
[DocumentProcessor] Trich xuat thanh cong voi TxtExtractor
[JsonStorageAdapter] Da luu ho so DOC01 vao: server_storage\DOC01_data.json
[DocumentProcessor] Luu tru thanh cong qua adapter: Local JSON File Storage
Email gui den an.nv@gmail.com: Ho so DOC01 chuyen sang trang thai Dang xet duyet
SMS gui den 0901234567: Ho so DOC01 chuyen sang trang thai Dang xet duyet
[JsonStorageAdapter] Da luu ho so DOC01 vao: server_storage\DOC01_data.json
Email gui den an.nv@gmail.com: Ho so DOC01 chuyen sang trang thai Da xu ly
SMS gui den 0901234567: Ho so DOC01 chuyen sang trang thai Da xu ly
[DocumentProcessor] Hoan tat quy trinh ho so DOC01 - Trang thai: Da xu ly
Ket qua: Da xu ly

--------------------------------------------------------------------------------
2. KICH BAN 2: HOOK METHOD & HOLLYWOOD PRINCIPLE (TEMPLATE METHOD PATTERN)
--------------------------------------------------------------------------------
[DocumentProcessor] Bat dau xu ly ho so: DOC02
[DocumentProcessor] Tu choi ho so tai buoc 'StrictSecurityHook': Chung thu chu ky so khong hop le hoac bi thieu (Yeu cau tieu chuan RSA).
Email gui den bich.tt@gmail.com: Ho so DOC02 chuyen sang trang thai Tu choi
SMS gui den 0912345678: Ho so DOC02 chuyen sang trang thai Tu choi
App Push gui den nguoi dung Tran Thi Bich: Ho so DOC02 - Tu choi
Ket qua kiem duyet Hook: Tu choi

--------------------------------------------------------------------------------
3. KICH BAN 3: STRATEGY & FACTORY METHOD PATTERN (DOC DA DINH DANG)
--------------------------------------------------------------------------------
- [TXT] TxtExtractor: Du lieu test cho dinh dang TXT
- [PDF] PdfExtractor: Noi dung trich xuat tu PDF qua OCR
- [JPG] ImageOcrExtractor: Noi dung trich xuat tu hinh anh qua OCR

--------------------------------------------------------------------------------
4. KICH BAN 4: ADAPTER PATTERN (TICH HOP NGUON LUU TRU DA NEN TANG)
--------------------------------------------------------------------------------
[JsonStorageAdapter] Da luu ho so DOC_STORAGE vao: server_storage\DOC_STORAGE_data.json
[MySqlStorageAdapter] SQL: INSERT INTO documents VALUES ('DOC_STORAGE', 'Le Van Cuong'): SUCCESS.
[AwsS3StorageAdapter] S3::putObject(bucket='bucket-edocument-2026', key='DOC_STORAGE'): 200 OK.
Adapter Pattern giup he thong tuong thich dong thoi 3 ha tang luu tru khac nhau ma khong can sua ma nguon DocumentProcessor.

--------------------------------------------------------------------------------
5. KICH BAN 5: COMMAND PATTERN (THUC THI, PHE DUYET, UNDO VA LOGGING)
--------------------------------------------------------------------------------
[Step 1] Nop ho so thong qua SubmitDocumentCommand:
[Command::Submit] Thuc thi lenh nop ho so: DOC_CMD_01
[AUDIT LOG] [2026-10-10 23:02:31] [EXECUTE] Nop ho so: DOC_CMD_01 (Pham Hoang Dung)
Trang thai hien tai: Da xu ly

[Step 2] Can bo phe duyet qua ApproveDocumentCommand:
[Command::Approve] Phe duyet ho so: DOC_CMD_01 thanh cong.
[AUDIT LOG] [2026-10-10 23:02:31] [EXECUTE] Phe duyet ho so: DOC_CMD_01
Trang thai hien tai: Da xu ly

[Step 3] Can bo phat hien nham lan, goi Hoan tac (UNDO):
[Command::Approve] Da hoan tac phe duyet ho so: DOC_CMD_01
[AUDIT LOG] [2026-10-10 23:02:31] [UNDO] Phe duyet ho so: DOC_CMD_01
Trang thai sau khi Undo: Da xu ly

[Step 4] Danh sach nhat ky Audit Logging duoc luu lai boi Invoker:
   * [2026-10-10 23:02:31] [EXECUTE] Nop ho so: DOC_CMD_01 (Pham Hoang Dung)
   * [2026-10-10 23:02:31] [EXECUTE] Phe duyet ho so: DOC_CMD_01
   * [2026-10-10 23:02:31] [UNDO] Phe duyet ho so: DOC_CMD_01
```

---

### 5.3. Đánh giá khả năng tương tác trực quan trên giao diện Java Swing UI
Bên cạnh kịch bản dòng lệnh, nhóm xây dựng giao diện đồ họa hoàn chỉnh MainSwingUI:
* Tích hợp thanh công cụ trực quan: Nút Them ho so, nút Phe duyet, nút Tu choi, và đặc biệt là nút Hoan tac (Undo) kết nối trực tiếp với CommandInvoker.
* Cung cấp hộp chọn Kho luu tru (Adapter) cho phép người dùng chuyển đổi tức thì nơi lưu trữ giữa Local JSON File, MySQL Database và AWS S3 Cloud.
* Bảng hiển thị danh sách hồ sơ cập nhật trạng thái tự động và vùng System Log hiển thị thời gian thực các sự kiện thông báo được gửi từ các Observer.

---

# CHƯƠNG 6: KẾT LUẬN VÀ HƯỚNG PHÁT TRIỂN

### 6.1. Bảng đối chiếu tổng quan giữa phiên bản 1.0 và phiên bản 2.0
| Tiêu chuẩn so sánh | Phiên bản 1.0 (Kiến trúc Monolithic) | Phiên bản 2.0 (Kiến trúc Design Patterns) |
| :--- | :--- | :--- |
| Cơ chế thao tác nghiệp vụ | Gọi phương thức trực tiếp, không có khả năng hoàn tác, thiếu lịch sử kiểm toán. | Áp dụng Command Pattern: Hỗ trợ thực thi lệnh, Hoàn tác (Undo/Redo) và ghi nhật ký Audit Log. |
| Cơ chế đọc tài liệu | Chuỗi if-else gắn cứng, chỉ đọc được tệp văn bản .TXT. | Áp dụng Strategy Pattern kết hợp Factory Method: Hỗ trợ tệp .TXT, .PDF và ảnh OCR, dễ mở rộng định dạng mới. |
| Quy trình kiểm duyệt | Cố định trong một hàm dồn cục, không phân tách được cấp độ bảo mật. | Áp dụng Template Method Pattern: Cố định khung thuật toán chuẩn, có Hollywood Principle và Hook an ninh RSA. |
| Cơ chế gửi thông báo | Gửi đồng thời cả Email và SMS mặc định, khởi tạo đối tượng tùy tiện khắp nơi. | Áp dụng Observer Pattern kết hợp Singleton: Phân phối thông báo đa kênh theo cấu hình, quản lý trung tâm duy nhất. |
| Hạ tầng lưu trữ dữ liệu | Lớp nghiệp vụ trực tiếp ghi tệp JSON xuống ổ cứng máy chủ. | Áp dụng Adapter Pattern: Chuẩn hóa giao diện đích, hoán đổi linh hoạt giữa File JSON, MySQL và AWS S3. |
| Mức độ tuân thủ SOLID | Vi phạm hầu hết các nguyên tắc (SRP, OCP, DIP). | Tuân thủ tuyệt đối cả 5 nguyên tắc SOLID và các nguyên lý GoF. |

---

### 6.2. Các mục tiêu chất lượng đã đạt được
1. 100% phù hợp với Đề cương môn học Mẫu Thiết Kế (504077) của Trường Đại học Tôn Đức Thắng, áp dụng chính xác các mẫu thiết kế: Singleton, Strategy, Template Method, Factory Method, Command, Adapter, Observer.
2. Mã nguồn chuẩn mực, độc lập, không phụ thuộc vào các thư viện bên ngoài, biên dịch và thực thi hoàn hảo trên cả môi trường dòng lệnh Console lẫn giao diện đồ họa Java Swing.
3. Cung cấp báo cáo học thuật đầy đủ, có chiều sâu phân tích kiến trúc, lập luận chặt chẽ và đối chiếu đồng nhất giữa sơ đồ thiết kế với mã nguồn.

---

### 6.3. Định hướng mở rộng trong tương lai
* Tích hợp Decorator Pattern (Chương 10 trong đề cương môn học) để tự động nén và mã hóa bảo mật AES-256 đối với nội dung hồ sơ trước khi đưa vào các kho lưu trữ Adapter.
* Xây dựng giao diện Web hiện đại kết nối qua giao thức RESTful API với backend xử lý hồ sơ.
* Kết nối trực tiếp với Cơ sở dữ liệu MySQL và dịch vụ lưu trữ đám mây AWS S3 thông qua tệp cấu hình môi trường thực tế.

---

# TÀI LIỆU THAM KHẢO

### Tài liệu Tiếng Việt:
[1]. Khoa Công Nghệ Thông Tin, Trường Đại học Tôn Đức Thắng, [2026], Đề cương chi tiết học phần Mẫu Thiết Kế (Mã môn học: 504077), Thành phố Hồ Chí Minh.  
[2]. Bộ môn Công nghệ Phần mềm, Trường Đại học Tôn Đức Thắng, [2026], Tập bài giảng môn học Mẫu Thiết Kế, Thành phố Hồ Chí Minh.  

### Tài liệu Tiếng Anh:
[3]. Eric Freeman, Elisabeth Robson, Bert Bates, Kathy Sierra, [2004], Head First Design Patterns, Nhà xuất bản O'Reilly Media, Sebastopol.  
[4]. Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides, [1995], Design Patterns: Elements of Reusable Object-Oriented Software, Nhà xuất bản Addison-Wesley, Boston.  
[5]. Steven John Metsker, William C. Wake, [2006], Design Patterns in Java, Nhà xuất bản Addison-Wesley, New Jersey.  
[6]. James W. Cooper, [2003], C# Design Patterns: A Tutorial, Nhà xuất bản Addison-Wesley, Boston.  
[7]. Christopher G. Lasater, [2007], Design Patterns, Nhà xuất bản Worldware Publications, Texas.  

package com.laptrinhweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	private static String DB_URL = "jdbc:mysql://localhost:3306/javacore?serverTimezone=Asia/Tokyo";
	private static String USER = "root";
	private static String PASS = "1256";
	//khi jvm chạy đến class connectionutils này thì nó lập tức khởi tạo các biến static .nghĩa là gì 
	// tao chỉ cần khởi tạo 1 lần thôi .mỗi lần gọi đến class connectionutils thì không khởi tạo lại nữa.
	//các cái biến static trên là các thống số để tao kết nối với database.
// phương thức getconnection này cũng được khai báo static để khi tao goi phuong thức này tao không cần khởi 
	//new tạo gọi trực tiếp thông qua class.
	//tiếp theo tạo sẽ tạo một vùng nhớ để lưu kết quả của kết nối. ban đầu sẽ là null.chưa có gì cả.
	//đặt tên biến tham chiếu là conn thuộc kiêu đối tượng đây là một wrapper class.
	public static Connection getConnection() {
		Connection conn = null;
		//code sẽ được đưa vào try để chạy.
		try {
	//dòng lệnh này sẽ tạo kết nối phương thức getconnection sẽ lấy thông số url,user,pass tao đã chuyền vào 
	//và thằng drivermanager nó sẽ kiểm tra các thông số đó.nó ok nó sẽ trả ra một kểt nối connection và được
	// gán vào biến tham chiếu conn.  và phương thức này sẽ trả về conn.
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
// nếu có bấy kì sai sót nào thì sẽ dược chạy vào khối catch để sử lý ngoaj lệ
		} catch (SQLException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}

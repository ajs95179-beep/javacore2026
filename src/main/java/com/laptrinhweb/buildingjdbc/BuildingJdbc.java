package com.laptrinhweb.buildingjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.utils.ConnectionUtils;
import com.laptrinhweb.utils.StringUtils;

public class BuildingJdbc  {
	
	
    public static void main(String[] args) {
    	String name =null;
    	String street =null;
    	Connection conn =null;
    	Statement stmt = null;
    	ResultSet rs=null;
    	
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   conn=ConnectionUtils.getConnection();
//sau khi kết nối đã được tạo.nghĩa là đã có cây cầu.cây cầu thì không thể mang dữ liệu đi được vậy cần
//tạo đôi tượng để mang dữ liệu từ java xuống mysql.vậy lên cây cầu này sẽ tạo một odj là statement.để 
//mang dữ liệu xuông mysql.	dữ liệu được statement mang theo đi trên kết nối connection.tất cả điều này đươjc lưu 
//lưu vào biến tham chiều stmt.		   
		     stmt = conn.createStatement();
//tao sử dụng stringbuilder để sử lý câu sql động 
//những câu query này vẫn đang ở java .
// where 1=1 nghia la điều kiện luôn đúng.ta kết nối nhiều điều kiện một lúc thông qua and hoặc or. 
//where dk1 and dk 2 and dk 3.	
//tại sao phải dùng where ở đây đảm bảo cú pháp là and luôn sau where 
		     
		   StringBuilder query =new StringBuilder("select *from building "+ SystemConstant.ONE_EQUAL_ONE +"" );
		        //vậy lên nếu không có dấu chấm than nó sẽ trả về true là không có giá trị.
		   //lúc này cách viết ở dưới là sai . phải viết thêm else .vậy lên khi tao thêm ! thì nó trở thành 
		   //khác true nghĩa là khác không có giá trị là có giá trị thì cách viết ở dưới là đúng.
		   if (StringUtils.isNullOrEmpty(name)) {
		            query.append(" AND name LIKE '%"+name+"%'");
				}
		   if (!StringUtils.isNullOrEmpty(street)) {
				    query.append(" AND street LIKE '%"+street+"%'");
//điều kiện if là có gía trị sẽ trả về false.không có giá trị trả về  true.
				}
				
		  /*Nhận chuỗi SQL
          Gửi SQL qua JDBC driver
          Driver gửi SQL xuống Database qua socket
          stmt  Nhận dữ liệu trả về bang cach
          Tạo ResultSet de hung du lieu va thang
          Trả ResultSet  tra ve mot bang du lieu */
		   //executequery no chinh la lenh select trong mysql
		    rs = stmt.executeQuery(query.toString()); 
		        while (rs.next()) {
		        System.out.println("name :" + rs.getString("name"));
		        System.out.println("street:" + rs.getString("street"));
		   }
		}catch(ClassNotFoundException | SQLException e) {
			   System.out.println("error:"+e.getMessage());
		   }
		   finally {
			   try {
				   if(rs!=null)
				   { rs.close();}
				   if(stmt!=null)
				   {stmt.close();}
				   if(conn!=null)
				   {conn.close();}
			   }catch(SQLException e) {
				   System.out.println("error:"+e.getMessage());
			   }
			  }
		    
}
};
 
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
		   stmt = conn.createStatement();
		   StringBuilder query =new StringBuilder("select *from building "+ SystemConstant.ONE_EQUAL_ONE +"" );
		        if (!StringUtils.isNullOrEmpty(name)) {
				    query.append(" AND name LIKE '%"+name+"%'");
				}

				if (!StringUtils.isNullOrEmpty(street)) {
				    query.append(" AND street LIKE '%"+street+"%'");
				}
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
 
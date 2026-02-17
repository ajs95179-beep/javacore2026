package com.laptrinhweb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.buildingInput.BuildingSearchInput;
import com.laptrinhweb.buildinganhyeuem.BuildingDaoAnhyeuem;
import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.utils.ConnectionUtils;
import com.laptrinhweb.utils.StringUtils;

public class BuildingDaoImpl implements BuildingDao {

	@Override
	public List<BuildingDaoAnhyeuem> findBuilding(String name, String street, String district, String type) {
		//sau khi kết nối với database nó sẽ trả về một mảng kết quả.được gán vào biến results
		List<BuildingDaoAnhyeuem> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();
			StringBuilder query = new StringBuilder("select *from building " + SystemConstant.ONE_EQUAL_ONE + "");
			if (!StringUtils.isNullOrEmpty(name)) {
				query.append(" AND name LIKE '%" + name + "%'");
			}

			if (!StringUtils.isNullOrEmpty(street)) {
				query.append(" AND street LIKE '%" + street + "%'");
			}
			if (!StringUtils.isNullOrEmpty(type)) {
				query.append(" and type like '%" + type + "%'");
			}
			rs = stmt.executeQuery(query.toString());
//thằng stmt sẽ mang cái executequery này xuông database mà thằng executequery nó chính là lệnh select
//trong mysql.nó sẽ chọn những cái thõa mãn rồi trả lại dữ liệu được hứng bởi đối tượng rs.nó như một cái bảng 
//tạm thời.bây giờ muốn lấy nó ra thì cần phải map sang đối tượng để java hiểu thông qua method .next
//cái thằng lớp buildingdaoanhyeuem là nơi chứa dữ liệu của thằng dao.muốn try xuất đối lớp này 
//thì tao thông qua đối tượng tham chiếu.là buildingDaoanhyeuem.lúc này thằng rs nó sẽ chạy qua từng dòng
//để  lấy dữ liệu của từng cột .ở đây có cột name,street,district,type.vậy một dòng chạy qua nó sẽ có 4 
//giá trị này.mỗi lần rs lấy gía trị xong một dòng nó sẽ được thêm vào result .đây là nơi dao lưu  dữ liêu
//được lấy từ database .dữ liệu này sẽ được trả về tầng service.vậy đến đây là xong nhiệm vụ của dao rồi.
//bây giowf tao lên service để phân tích tiếp.			
			while (rs.next()) {
				BuildingDaoAnhyeuem buildingDaoAnhyeuem = new BuildingDaoAnhyeuem();
				buildingDaoAnhyeuem.setName(rs.getString("name"));
				buildingDaoAnhyeuem.setStreet(rs.getString("street"));
				buildingDaoAnhyeuem.setDistrict(rs.getString("district"));
				buildingDaoAnhyeuem.setType(rs.getString("type"));
				results.add(buildingDaoAnhyeuem);
			}
			return results;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("error:" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public Long insert(BuildingDaoAnhyeuem buildingDaoAnhyeuem, String rentAreas) {

		Long buildingid = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			String sql = "INSERT INTO building(name,street) VALUES('" + buildingDaoAnhyeuem.getName() + "','"
					+ buildingDaoAnhyeuem.getStreet() + "')";
			int flag = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			resultSet = stmt.getGeneratedKeys();
			if (flag > 0) {
				while (resultSet.next()) {
					buildingid = resultSet.getLong(1);
				}
				return buildingid;
			}
			if (rentAreas.length() > 0) {
				for (String item : rentAreas.split(",")) {
					String sql2 = "INSERT INTO rentarea(value,buildingid) VALUES ('" + Integer.parseInt(item) + "','"
							+ buildingid + "')";
					stmt.execute(sql2);
				}
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
				stmt.close();
				resultSet.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<BuildingDaoAnhyeuem> findBuilding(BuildingSearchInput buildingSearch) {
		return null;
	}

};

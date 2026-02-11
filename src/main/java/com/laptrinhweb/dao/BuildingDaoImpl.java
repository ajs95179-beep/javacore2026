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
		List<BuildingDaoAnhyeuem> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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

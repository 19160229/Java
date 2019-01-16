package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Stu;
import util.DBHelper;

public class StuDAO {
	
	public static List<Stu> getAllStus(){
		List<Stu> allStus=new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select sno,sname from stu";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Stu stu=new Stu();
				stu.setSno(rs.getString("sno"));
				stu.setSname(rs.getString("sname"));
				allStus.add(stu);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			if (conn != null) {
				try {
					conn = null;
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		}
		return allStus;
	}
}

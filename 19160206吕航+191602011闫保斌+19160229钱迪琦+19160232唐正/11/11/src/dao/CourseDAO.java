package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Course;
import util.DBHelper;

public class CourseDAO {

	public static List<Course> getAllCourses() {
		List<Course> allCourses=new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select cno,cname,credit from course";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Course course=new Course();
				course.setCno(rs.getString("cno"));
				course.setCname(rs.getString("cname"));
				course.setCredit(rs.getInt("credit"));
				allCourses.add(course);
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
		return allCourses;
	}

}

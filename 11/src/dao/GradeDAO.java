package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Grade;
import util.DBHelper;
import util.Utility;

public class GradeDAO {

	private List<Grade> grades;

	public GradeDAO(String sno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		grades = new ArrayList<>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select stu.sno,sname,sc.cno,cname,grade,credit "
					+ "from stu left outer join sc on stu.sno=sc.sno " + "left outer join course on sc.cno=course.cno "
					+ "where stu.sno=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Grade grade = new Grade();
				grade.setSno(rs.getString("sno"));
				grade.setSname(rs.getString("sname"));
				grade.setCno(rs.getString("cno"));
				grade.setCname(rs.getString("cname"));
				grade.setGrade(rs.getInt("grade"));
				grade.setCredit(rs.getInt("credit"));
				if (grade.getGrade() < 60) {
					grade.setCredit(0);
				}
				grades.add(grade);
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
	}

	public GradeDAO() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		grades = new ArrayList<>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select stu.sno,sname,sc.cno,cname,grade,credit "
					+ "from stu left outer join sc on stu.sno=sc.sno " + "left outer join course on sc.cno=course.cno";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("cname") != null) {
					Grade grade = new Grade();
					grade.setSno(rs.getString("sno"));
					grade.setSname(rs.getString("sname"));
					grade.setCno(rs.getString("cno"));
					grade.setCname(rs.getString("cname"));
					grade.setGrade(rs.getInt("grade"));
					grade.setCredit(rs.getInt("credit"));
					if (grade.getGrade() < 60) {
						grade.setCredit(0);
					}
					grades.add(grade);
				}
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
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public static void deleteGrade(Grade grade) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "delete from sc where sno=? and cno=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade.getSno());
			pstmt.setString(2, grade.getCno());
			int row = pstmt.executeUpdate();
			if (row > 0) {
				System.out.println(row);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
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
	}

	public static void updateGrade(Grade grade) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "update sc set grade=? where sno=? and cno=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, grade.getGrade());
			pstmt.setString(2, grade.getSno());
			pstmt.setString(3, grade.getCno());
			pstmt.executeUpdate();
			if (grade.getGrade() >= 60) {
				sql = "select credit from course where cno=?;";
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, grade.getCno());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					grade.setCredit(rs.getInt("credit"));
				}
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
	}

	public static boolean isExist(String sno, String cno) {
		Boolean res=false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from sc where sno=? and cno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			pstmt.setString(2, cno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				res=true;
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
		return res;
	}

	public static void main(String[] args) {
		GradeDAO gradeDAO = new GradeDAO();
		List<Grade> grades = gradeDAO.getGrades();
		for (int i = 0; i < grades.size(); i++) {
			Grade grade = grades.get(i);
			System.out.println(grade.getSno() + " " + grade.getSname() + " " + grade.getCname() + " " + grade.getGrade()
					+ " " + grade.getCredit() + " " + grade.getCno());
		}
		List<String> courseName = Utility.getCourseName(grades);
		for (int i = 0; i < courseName.size(); i++) {
			System.out.println(courseName.get(i));
		}
	}

	public static void addGrade(Grade grade) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "insert into sc (sno,cno,grade) values(?,?,?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade.getSno());
			pstmt.setString(2, grade.getCno());
			pstmt.setInt(3, grade.getGrade());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
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
	}

}

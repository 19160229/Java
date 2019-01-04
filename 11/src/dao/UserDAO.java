package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.User;
import util.DBHelper;

public class UserDAO {
	public static int login(String usrname,String password){
		User user=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int authority=-1;
		try {
			conn=DBHelper.getConnection();
			String sql="select * from usr where usrname=?;";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, usrname);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUsrname(rs.getString("usrname"));
				user.setPassword(rs.getString("password"));
				user.setAuthority(rs.getInt("authority"));
			}
			if (password.equals(user.getPassword())) {
				authority=user.getAuthority();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			if (rs!=null) {
				try{
					rs.close();
					rs=null;
				}catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			if (pstmt!=null) {
				try{
					pstmt.close();
					pstmt=null;
				}catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			if (conn!=null) {
				try{
					conn=null;
				}catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		}
		return authority;
	}
	
	public static void main(String[] args) {
		System.out.println(login("stu", "stu"));
	}
}

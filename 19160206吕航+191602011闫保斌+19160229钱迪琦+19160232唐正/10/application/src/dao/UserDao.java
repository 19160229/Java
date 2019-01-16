package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import entity.User;
import util.DBHelper;

public class UserDao {
	
	private List<User> users;
	public List<User> getUsers() {
		return users;
	}

	public List<String> getLevelNum(){
		List<String> levelNum=new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBHelper.getConnection();
			String sql="select * from user where level != 0 and level!=1;";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				boolean flag=false;
				for(int i=0;i<levelNum.size();i++) {
					if(levelNum.get(i).equals(rs.getString("level"))) {
						flag=true;
					}
				}
				if(flag==false) {
					levelNum.add(rs.getString("level"));
				}
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
		
		return levelNum;
	}
	
	public User login(String username,String password){
		User user=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=DBHelper.getConnection();
			String sql="select * from user where username=?;";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				user=new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setLevel(rs.getString("level"));
				user.setApplicationID(rs.getString("applicationID"));
//				System.out.println(user.getUsername()+" "+user.getPassword()+" "+user.getLevel()+" "+user.getApplicationID());
				return user;

			}else {
//				System.out.println("�û������������");
				return null;
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
		return user;
	}
	
	
	public int allUserDao(){
		User user=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		users=new ArrayList<>();
		try {
			conn=DBHelper.getConnection();
			String sql="select * from user;";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				user=new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setLevel(rs.getString("level"));
				user.setApplicationID(rs.getString("applicationID"));
				users.add(user);
				System.out.println(user.getUsername()+" "+user.getPassword()+" "+user.getLevel()+" "+user.getApplicationID());
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
		return 0;
	}


	public void InsertUser(User user) {
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
            //�����ݿ⽨������
			conn=DBHelper.getConnection();

            //����sql��� ?ռλ��
            String sql="insert into user values(?,?,?,?)";
            //����Statement����
            pstmt=conn.prepareStatement(sql);

            //�����ֶ�
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getLevel());
            pstmt.setString(4,user.getApplicationID());


            //ִ��sql���
            int a=pstmt.executeUpdate();
            if(a==1){

                System.out.println("��ӳɹ�");
            }else{

                System.out.println("���ʧ��");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{   

            if(conn!=null){

                try {
//                    conn.close();
                	conn=null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if(pstmt!=null){

                try {
                	pstmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
	}

	public void DeleteUser(User user) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
            //�����ݿ⽨������
			conn=DBHelper.getConnection();

            //����sql��� ?ռλ��
			String sql = "DELETE FROM user WHERE username=?";	
            //����Statement����
            pstmt=conn.prepareStatement(sql);

            //�����ֶ�
            pstmt.setString(1,user.getUsername());


            //ִ��sql���
            int a=pstmt.executeUpdate();
            if(a==1){

                System.out.println("ɾ��	�ɹ�");
            }else{

                System.out.println("ɾ��ʧ��");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{   

            if(conn!=null){

                try {
//                    conn.close();
                	conn=null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if(pstmt!=null){

                try {
                	pstmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	public void UpdateUser(User user) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
            //�����ݿ⽨������
			conn=DBHelper.getConnection();

            //����sql��� ?ռλ��
            String sql="UPDATE user SET password=?, level=? WHERE username=?;";
            //����Statement����
            pstmt=conn.prepareStatement(sql);

            //�����ֶ�
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getLevel());
            pstmt.setString(3, user.getUsername());


            //ִ��sql���
            int a=pstmt.executeUpdate();
            if(a==1){

                System.out.println("�ɹ�");
            }else{

                System.out.println("ʧ��");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{   

            if(conn!=null){

                try {
//                    conn.close();
                	conn=null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if(pstmt!=null){

                try {
                	pstmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
	}
}

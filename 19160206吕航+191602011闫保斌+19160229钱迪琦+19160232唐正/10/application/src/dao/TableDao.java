package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Table;
import util.DBHelper;

public class TableDao {

	private List<Table> tables;
	
	
	public Table getTable(String applicationID){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Table table=null;
		try {
			conn=DBHelper.getConnection();
			String sql="select * from mtable where applicationID=?;";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, applicationID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				table=new Table();
				table.setApplicationID(rs.getString("applicationID"));
				table.setApplicant(rs.getString("applicant"));
				table.setCategory(rs.getString("category"));
				table.setStartTime(rs.getString("startTime"));
				table.setEndTime(rs.getString("endTime"));
				table.setPhone(rs.getString("phone"));
				table.setModel(rs.getString("model"));
				table.setResult(rs.getString("result"));
				table.setCurrentLevel(rs.getString("currentLevel"));
				System.out.println(table.getApplicationID()+" "
						+table.getApplicant()+" "+table.getCategory()+" "
						+table.getStartTime()+" "+table.getEndTime()+" "
						+table.getPhone()+" "+table.getModel()+" "
						+table.getResult()+" "+table.getCurrentLevel());
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
		return table;
	}
	
	public List<Table> getTables() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		tables=new ArrayList<>();
		try {
			conn=DBHelper.getConnection();
			String sql="select * from mtable;";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("applicationID")!=null) {
					Table table=new Table();
					table.setApplicationID(rs.getString("applicationID"));
					table.setApplicant(rs.getString("applicant"));
					table.setCategory(rs.getString("category"));
					table.setStartTime(rs.getString("startTime"));
					table.setEndTime(rs.getString("endTime"));
					table.setPhone(rs.getString("phone"));
					table.setModel(rs.getString("model"));
					table.setResult(rs.getString("result"));
					table.setCurrentLevel(rs.getString("currentLevel"));
					tables.add(table);
					
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
		
		for(int i=0;i<tables.size();i++) {
			System.out.println(tables.get(i).getApplicationID()+" "
					+tables.get(i).getApplicant()+" "+tables.get(i).getCategory()+" "
					+tables.get(i).getStartTime()+" "+tables.get(i).getEndTime()+" "
					+tables.get(i).getPhone()+" "+tables.get(i).getModel()+" "
					+tables.get(i).getResult()+" "+tables.get(i).getCurrentLevel());
		}
		return tables;
	}
	
	
	public List<Table> getTables(String level,String username) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		tables=new ArrayList<>();
		try {
			conn=DBHelper.getConnection();
			String sql="select * from mtable where currentLevel=? or currentLevel=?;";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, level);
			pstmt.setString(2, username);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("applicationID")!=null) {
					Table table=new Table();
					table.setApplicationID(rs.getString("applicationID"));
					table.setApplicant(rs.getString("applicant"));
					table.setCategory(rs.getString("category"));
					table.setStartTime(rs.getString("startTime"));
					table.setEndTime(rs.getString("endTime"));
					table.setPhone(rs.getString("phone"));
					table.setModel(rs.getString("model"));
					table.setResult(rs.getString("result"));
					table.setCurrentLevel(rs.getString("currentLevel"));
					tables.add(table);
					
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
		
		for(int i=0;i<tables.size();i++) {
			System.out.println(tables.get(i).getApplicationID()+" "
					+tables.get(i).getApplicant()+" "+tables.get(i).getCategory()+" "
					+tables.get(i).getStartTime()+" "+tables.get(i).getEndTime()+" "
					+tables.get(i).getPhone()+" "+tables.get(i).getModel()+" "
					+tables.get(i).getResult()+" "+tables.get(i).getCurrentLevel());
		}
		return tables;
	}

	public void InsertTable(Table table) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
            //和数据库建立连接
			conn=DBHelper.getConnection();

            //建立sql语句 ?占位符
            String sql="insert into mtable values(?,?,?,?,?,?,?,?,?)";
            //建立Statement对象
            pstmt=conn.prepareStatement(sql);

            //设置字段
            pstmt.setString(1, table.getApplicationID());
            pstmt.setString(2, table.getApplicant());
            pstmt.setString(3, table.getCategory());
            pstmt.setString(4, table.getStartTime());
            pstmt.setString(5, table.getEndTime());
            pstmt.setString(6, table.getPhone());
            pstmt.setString(7, table.getResult());
            pstmt.setString(8, table.getCurrentLevel());
            pstmt.setString(9, table.getModel());


            //执行sql语句
            int a=pstmt.executeUpdate();
            if(a==1){

                System.out.println("添加成功");
            }else{

                System.out.println("添加失败");
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

	public void UpdateTable(Table table) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
            //和数据库建立连接
			conn=DBHelper.getConnection();

            //建立sql语句 ?占位符
            String sql="UPDATE mtable SET currentLevel=? WHERE applicationID=?;";
            //建立Statement对象
            pstmt=conn.prepareStatement(sql);

            //设置字段
            pstmt.setString(1, table.getCurrentLevel());
            pstmt.setString(2, table.getApplicationID());


            //执行sql语句
            int a=pstmt.executeUpdate();
            if(a==1){

                System.out.println("添加成功");
            }else{

                System.out.println("添加失败");
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

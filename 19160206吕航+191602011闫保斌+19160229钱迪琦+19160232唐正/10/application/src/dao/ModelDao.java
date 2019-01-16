package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Model;
import util.DBHelper;

public class ModelDao {

	private List<Model> models;
	private List<String> modelNames;

	public List<String> getModelNames() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBHelper.getConnection();
			String sql="select * from model;";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			modelNames=new ArrayList<>();
			modelNames.add("默认");
			while (rs.next()) {
				boolean flag=false;
				for(int i=0;i<modelNames.size();i++) {
					if(modelNames.get(i).equals(rs.getString("modelName"))) {
						flag=true;
					}
				}
				if(flag==false) {
					modelNames.add(rs.getString("modelName"));
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
		return modelNames;
	}

	
	public Model getModel(String modelName){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Model model=new Model();
		List<String> username=new ArrayList<>();
		try {
			conn=DBHelper.getConnection();
			String sql="select * from model where modelName=?;";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, modelName);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				if(rs.getString("username").equals("head")) {
					
					String flag=rs.getString("next");
					while(flag!=null) {
						sql="select * from model where username=?;";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, flag);
						rs=pstmt.executeQuery();
						if(rs.next()) {
							username.add(rs.getString("username"));
							flag=rs.getString("next");
						}
					}
					model.setModelName(modelName);
					model.setUsername(username);
//					for(int i=0;i<model.getUsername().size();i++) {
//						System.out.println(model.getUsername().get(i));
//					}
					return model;
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
		
		return model;
	}
	
	public List<Model> getModels() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		models=new ArrayList<>();
		try {
			conn=DBHelper.getConnection();
			String sql="select * from model;";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			modelNames=new ArrayList<>();
			while (rs.next()) {
				boolean flag=false;
				for(int i=0;i<modelNames.size();i++) {
					if(modelNames.get(i).equals(rs.getString("modelName"))) {
						flag=true;
					}
				}
				if(flag==false) {
					modelNames.add(rs.getString("modelName"));
				}
			}
			for(int i=0;i<modelNames.size();i++) {
				models.add(getModel(modelNames.get(i)));
			}
			
//			for(int i=0;i<models.size();i++) {
//				for(int j=0;j<models.get(i).getUsername().size();j++) {
//					System.out.println(models.get(i).getModelName()+" "+models.get(i).getUsername().get(j));
//				}
//			}
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
		
		return models;
	}
	
	public void InsertModel(String modelName,String userName,String next) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
            //和数据库建立连接
			conn=DBHelper.getConnection();

            //建立sql语句 ?占位符
            String sql="insert into model values(?,?,?)";
            //建立Statement对象
            pstmt=conn.prepareStatement(sql);

            //设置字段
            pstmt.setString(1,modelName);
            pstmt.setString(2,userName);
            pstmt.setString(3,next);


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

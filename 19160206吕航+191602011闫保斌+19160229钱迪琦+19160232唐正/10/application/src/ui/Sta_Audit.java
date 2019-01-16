package ui;

import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;


import dao.ModelDao;
import dao.TableDao;
import dao.UserDao;
import entity.Model;
import entity.Table;
import entity.User;
import ui.Sta_Audit_TableModel;

public class Sta_Audit {

//	private JScrollPane panel;
	private JPanel panel;
	private JFrame frame;
	private User user;
	private List<Table> tables;
	Sta_Audit(User user){
		this.user=user;
		Level2_Audit_UI();
		setLevel2_Audit_UI_Visiable(true);
	}
	private void Level2_Audit_UI(){
		Font font;
		font = new Font("宋体", Font.PLAIN, 25);
		
		int width=900;
		int height=600;
		

		tables=new ArrayList<>();
		TableDao tabledao=new TableDao();
		tables=tabledao.getTables(user.getLevel(),user.getUsername());
		
		List<Object[]> tableData=new ArrayList<>();
		for(int i=0;i<tables.size();i++) {
			Table ta=new Table();
			ta=tables.get(i);
			Object[] data= {new Boolean(false),ta.getApplicationID(),ta.getApplicant(),ta.getCategory(),ta.getStartTime(),ta.getEndTime(),ta.getResult(),"点击查看详情"};
			tableData.add(data);
		}
		
		Sta_Audit_TableModel myModel = new Sta_Audit_TableModel(tableData.toArray(new Object[tableData.size()][]));
		 
		// JTable
		JTable table = new JTable(myModel);
		table.setRowHeight(30);
//		table.setFont( font);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(table.getSelectedColumn()+" "+table.getSelectedRow());
				if(table.getSelectedColumn()==0) {
	            	  boolean flag = Boolean.valueOf(myModel.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString());
	            	  if(flag==true)
	            		  flag=false;
	            	  else
	            		  flag=true;
	            	  myModel.setValueAt(flag, table.getSelectedRow(),table.getSelectedColumn());
				}
				
				if(table.getSelectedColumn()==7) {
					@SuppressWarnings("unused")
					Sta_Detail l2=new Sta_Detail(user,tables.get(table.getSelectedRow()));
							
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		

				
		JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		UserDao userdao=new UserDao();
		List<String> tempi=userdao.getLevelNum();
        List<Integer> lst_level=new ArrayList<>();
        
        JButton btn_approve = new JButton("通过");
        btn_approve.setFont(font);
        btn_approve.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<table.getRowCount();i++) {
					if(Boolean.parseBoolean(myModel.getValueAt(i, 0).toString())==true) {
						if(tables.get(i).getModel().equals("默认")) {
							
							
					        for(int j=0;j<tempi.size();j++) {
					        	lst_level.add(Integer.parseInt(tempi.get(j)));
					        	lst_level.add(1);
					        }
					        int maxLevel=1;
					       
					        for(int j=0;j<lst_level.size();j++) {
					        	if(maxLevel<lst_level.get(j)) {
					        		maxLevel=lst_level.get(j);
					        	}
					        }
					        
							int temp=Integer.parseInt(tables.get(i).getCurrentLevel())+1;
							if(temp>maxLevel) {
								tables.get(i).setCurrentLevel("0");
								tabledao.UpdateTable(tables.get(i));
							}else {
								tables.get(i).setCurrentLevel(temp+"");
								tabledao.UpdateTable(tables.get(i));
							}
							
							
						}else {
							ModelDao modeldao=new ModelDao();
							Model model=new Model();
							model=modeldao.getModel(tables.get(i).getModel());
//							System.out.println(model.getUsername().get(2+model.getUsername().indexOf(tables.get(i).getModel())));
							System.out.println(2+model.getUsername().indexOf(tables.get(i).getModel())+" "+model.getUsername().size());
							if(tables.get(i).getCurrentLevel().equals(model.getUsername().get(model.getUsername().size()-1))) {
								String next=null;
								tables.get(i).setCurrentLevel(next);
								tabledao.UpdateTable(tables.get(i));
							}else {
								String next=model.getUsername().get(2+model.getUsername().indexOf(tables.get(i).getModel()));
								tables.get(i).setCurrentLevel(next);
								tabledao.UpdateTable(tables.get(i));
							}
							
						}
					}
				}
				
				((JFrame)panel.getRootPane().getParent()).dispose();
				@SuppressWarnings("unused")
				Sta_Control l2=new Sta_Control(user);
				
			}
        	
        });
        
        JButton btn_back = new JButton("返回");
        btn_back.setFont(font);
        btn_back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((JFrame)panel.getRootPane().getParent()).dispose();
				@SuppressWarnings("unused")
				Sta_Control l2=new Sta_Control(user);
				
			}
        	
        });
        JPanel bottomPanel=new JPanel();
        bottomPanel.add(btn_approve);
        bottomPanel.add(btn_back);

        
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(bottomPanel, BorderLayout.SOUTH);
//		panel.add(upPanel, BorderLayout.NORTH);
//		panel.add(btn_fresh);
		
		frame = new JFrame("level2Audit");
		frame.setSize(width, height);
		frame.add(panel);
	    //frame.pack();
	    frame.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	}
	
	public void setLevel2_Audit_UI_Visiable(boolean visiable) {
		// 设置界面可见
        frame.setVisible(visiable);
	}
}

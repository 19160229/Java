package ui;

import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;


import dao.UserDao;

import entity.User;
import ui.Adm_Manage_TableModel;

public class Adm_Manage{

//	private JScrollPane panel;
	private JPanel panel;
	private JFrame frame;
	private User user;
	private List<User> users;
	Adm_Manage(User user){
		this.user=user;
		Level3_Manage_UI();
		setLevel3_Manage_UI_Visiable(true);
	}
	
	@SuppressWarnings("unused")
	private void update() {
		
	}
	
	@SuppressWarnings("unchecked")
	private void Level3_Manage_UI(){
		Font font;
		font = new Font("宋体", Font.PLAIN, 25);
		
		int width=900;
		int height=600;
		

		users=new ArrayList<>();
		UserDao userdao=new UserDao();
		userdao.allUserDao();
		users=userdao.getUsers();
		
		List<Object[]> tableData=new ArrayList<>();
		for(int i=0;i<users.size();i++) {
			User us=new User();
			us=users.get(i);
			if(us.getLevel().equals("0")) {
				continue;
			}
			Object[] data= {new Boolean(false),us.getUsername(),us.getPassword(),us.getLevel()};
			tableData.add(data);
			System.out.println(us.getUsername());
		}
		
		Adm_Manage_TableModel myModel = new Adm_Manage_TableModel(tableData.toArray(new Object[tableData.size()][]));
		 
		// JTable
		JTable table = new JTable(myModel);
		table.setRowHeight(30);

		// 获得表格的表格列类
				TableColumn tc0 = table.getColumnModel().getColumn(0);
		 
				// 实例化JCheckBox
				JCheckBox ckb = new JCheckBox();
				tc0.setCellEditor(new DefaultCellEditor(ckb));
				
				TableColumn tc3 = table.getColumnModel().getColumn(3);
				// 实例化JComboBox
				@SuppressWarnings("rawtypes")
				JComboBox cob = new JComboBox();
		
        List<String> temp=userdao.getLevelNum();
        List<Integer> lst_level=new ArrayList<>();
        for(int i=0;i<temp.size();i++) {
        	lst_level.add(Integer.parseInt(temp.get(i)));
        	lst_level.add(0);
        	lst_level.add(1);
        }
        int maxLevel=1;
       
        for(int i=0;i<lst_level.size();i++) {
        	if(maxLevel<lst_level.get(i)) {
        		maxLevel=lst_level.get(i);
        	}
        }
        for(int i=0;i<maxLevel+2;i++) {
        	cob.addItem(i+"");
        }
        
		tc3.setCellEditor(new DefaultCellEditor(cob));
				
				
		JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				

		
		
        JButton btn_delete = new JButton("删除");
        btn_delete.setFont(font);
        btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<table.getRowCount();i++) {
					if(Boolean.parseBoolean(myModel.getValueAt(i, 0).toString())==true) {
						userdao.DeleteUser(users.get(i+1));
					}
				}
				
				((JFrame)panel.getRootPane().getParent()).dispose();
				@SuppressWarnings("unused")
				Adm_Control l3=new Adm_Control(user);
				
			}
        	
        });
        
        JButton btn_save = new JButton("保存");
        btn_save.setFont(font);
        btn_save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<table.getRowCount();i++) {
					
					
					User newUser=new User();
					newUser.setUsername(myModel.getValueAt(i, 1).toString());
					newUser.setPassword(myModel.getValueAt(i, 2).toString());
					newUser.setLevel(myModel.getValueAt(i, 3).toString()); 
					newUser.setApplicationID(users.get(i).getApplicationID());
					userdao.UpdateUser(newUser);
					((JFrame)panel.getRootPane().getParent()).dispose();
					@SuppressWarnings("unused")
					Adm_Control l3=new Adm_Control(user);
				}
				
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
				Adm_Control l3=new Adm_Control(user);
				
			}
        	
        });
        JPanel bottomPanel=new JPanel();
        bottomPanel.add(btn_delete);
        bottomPanel.add(btn_save);
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
	
	public void setLevel3_Manage_UI_Visiable(boolean visiable) {
		// 设置界面可见
        frame.setVisible(visiable);
	}
}

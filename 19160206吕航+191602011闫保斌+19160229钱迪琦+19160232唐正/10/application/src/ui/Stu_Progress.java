package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Stu_Progress {

	private JPanel panel;
	private JFrame frame;
	private User user;
	Stu_Progress(User user){
		this.user=user;
		Level1_Progress_UI();
		setLevel1_Progress_UI_Visiable(true);
	}
	private void Level1_Progress_UI(){
		Font font;
		font = new Font("宋体", Font.PLAIN, 25);
		
		int width=900;
		int height=600;
		
		Table table=new Table();
		TableDao tabledao=new TableDao();
		List<String> levelNum=new ArrayList<>();
		List<Object[]> tableData=new ArrayList<>();
		
		if(user.getApplicationID()==null) {
			
		}else {
			table=tabledao.getTable(user.getApplicationID());
			if(table.getModel().equals("默认")) {
				UserDao userdao=new UserDao();
				levelNum=userdao.getLevelNum();
				for(int i=0;i<levelNum.size();i++){
					if(levelNum.get(i).equals("0")) {
						Object[] data = { levelNum.get(i), "已审核" };
						tableData.add(data);
						continue;
					}
					if((Integer.parseInt(levelNum.get(i))<Integer.parseInt(table.getCurrentLevel()))) {
						Object[] data = { levelNum.get(i), "已审核" };
						tableData.add(data);
					}else if((Integer.parseInt(levelNum.get(i))==Integer.parseInt(table.getCurrentLevel()))) {
						Object[] data = { levelNum.get(i), "正在审核" };
						tableData.add(data);
					}else {
						Object[] data = { levelNum.get(i), "等待" };
						tableData.add(data);
					}
					
				}
			}else {
				Model model=new Model();
				ModelDao modelDao=new ModelDao();
				model=modelDao.getModel(table.getModel());
				List<String> usrnames=model.getUsername();
				for(int i=0;i<usrnames.size();i++){
					if(table.getCurrentLevel()==null) {
						Object[] data = { usrnames.get(i), "已审核" };
						tableData.add(data);
						continue;
					}
					if(i<usrnames.indexOf(table.getCurrentLevel())) {
						Object[] data = { usrnames.get(i), "已审核" };
						tableData.add(data);
					}else if(i==model.getUsername().indexOf(table.getCurrentLevel())) {
						Object[] data = { usrnames.get(i), "正在审核" };
						tableData.add(data);
					}else {
						Object[] data = { usrnames.get(i), "等待" };
						tableData.add(data);
					}
					
				}
			}
			for(int i=0;i<levelNum.size();i++) {
				System.out.println(levelNum.get(i));
			}
		}
		
		
		Object[] columnProgress = {"流程" , "状态" };
		JTable jt=new JTable(tableData.toArray(new Object[tableData.size()][]) , columnProgress);
		jt.setFont(font);
		jt.setRowHeight(30);
		JScrollPane scrollPane = new JScrollPane(jt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
//        JButton btn_fresh = new JButton("刷新");
//        btn_fresh.setFont(font);
//        btn_fresh.setBounds(width*9/30, height*15/20, width*3/30, height*2/30);
//        btn_fresh.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//				
//			}
//        	
//        });
        
        JButton btn_back = new JButton("返回");
        btn_back.setFont(font);
        btn_back.setBounds(width*16/30, height*15/20, width*3/30, height*2/30);
        btn_back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((JFrame)panel.getRootPane().getParent()).dispose();
				@SuppressWarnings("unused")
				Stu_Control l1=new Stu_Control(user);
				
			}
        	
        });
		
        JPanel bottomPanel=new JPanel();
//        bottomPanel.add(btn_fresh);
        bottomPanel.add(btn_back);
		panel = new JPanel();    
        panel.setLayout(new BorderLayout());
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		frame = new JFrame("level1Progress");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
	}
	
	public void setLevel1_Progress_UI_Visiable(boolean visiable) {
		// 设置界面可见
        frame.setVisible(visiable);
	}
}

package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.User;

public class Stu_Control {

	private User user;
	private JFrame frame;
	private JPanel panel;
	public Stu_Control(User user) {
		this.user=user;
		Level1_Control_UI();
		setLevel1_Control_UI_Visiable(true);
	}
	
	private void Level1_Control_UI() {
		Font font;
		font = new Font("宋体", Font.PLAIN, 25);
		int width=450;
		int height=300;
		JButton btn_apply = new JButton("申请");
        btn_apply.setFont(font);
        btn_apply.setBounds(width*1/3, height*1/8 ,width*1/4, height*1/5);
        btn_apply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((JFrame)panel.getRootPane().getParent()).dispose();
				@SuppressWarnings("unused")
				Stu_Apply l1=new Stu_Apply(user);
				
			}
        	
        });
        
        JButton btn_progress=new JButton("查询");
        btn_progress.setFont(font);
        btn_progress.setBounds(width*1/3, height*4/10, width*1/4, height*1/5);
        btn_progress.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((JFrame)panel.getRootPane().getParent()).dispose();
				@SuppressWarnings("unused")
				Stu_Progress l1=new Stu_Progress(user);
				
			}
        	
        });
        
        panel = new JPanel();    
        panel.setLayout(null);
        panel.add(btn_apply);
        panel.add(btn_progress);
        
		frame = new JFrame("level1Control");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
	}
	public void setLevel1_Control_UI_Visiable(boolean visiable) {
		// 设置界面可见
        frame.setVisible(visiable);
	}
}

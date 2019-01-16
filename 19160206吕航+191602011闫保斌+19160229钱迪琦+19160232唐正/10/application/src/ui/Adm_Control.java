package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.User;

public class Adm_Control {

	private User user;
	private JFrame frame;
	private JPanel panel;
	public Adm_Control(User user) {
		this.user=user;
		Level3_Control_UI();
		setLevel3_Control_UI_Visiable(true);
	}
	private void Level3_Control_UI() {
		Font font;
		font = new Font("宋体", Font.PLAIN, 25);
		int width=450;
		int height=300;
		JButton btn_register = new JButton("注册");
        btn_register.setFont(font);
        btn_register.setBounds(width*1/3, height*1/10 ,width*1/4, height*1/5);
        btn_register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((JFrame)panel.getRootPane().getParent()).dispose();
				@SuppressWarnings("unused")
				Adm_Register l3=new Adm_Register(user);
				
			}
        	
        });
        
        JButton btn_manage=new JButton("管理");
        btn_manage.setFont(font);
        btn_manage.setBounds(width*1/3, height*4/12, width*1/4, height*1/5);
        btn_manage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((JFrame)panel.getRootPane().getParent()).dispose();
				@SuppressWarnings("unused")
				Adm_Manage l3=new Adm_Manage(user);
				
			}
        	
        });
        
        JButton btn_dynamic=new JButton("模板");
        btn_dynamic.setFont(font);
        btn_dynamic.setBounds(width*1/3, height*7/12, width*1/4, height*1/5);
        btn_dynamic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				((JFrame)panel.getRootPane().getParent()).dispose();
				@SuppressWarnings("unused")
				Adm_Manage_Dynamic l3=new Adm_Manage_Dynamic();
				
			}
        	
        });
        
        panel = new JPanel();    
        panel.setLayout(null);
        panel.add(btn_register);
        panel.add(btn_manage);
        panel.add(btn_dynamic);

        
		frame = new JFrame("level2Control");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
	}
	public void setLevel3_Control_UI_Visiable(boolean visiable) {
		// 设置界面可见
        frame.setVisible(visiable);
	}
}

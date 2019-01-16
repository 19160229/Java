package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import dao.UserDao;
import entity.User;;

public class LoginMenu{
	
	private JFrame frame;
	private JPanel panel;
	private String username,password;

	private User user;
	public LoginMenu() {

		int width=600;
		int height=400;
		Font font;
		font = new Font("宋体", Font.PLAIN, 25);
		
		JLabel lb_user = new JLabel("User:");
		lb_user.setFont(font);
		lb_user.setBounds(width/8, height/5, width/5, height/12);
        
        JTextField txt_user = new JTextField(20);
        txt_user.setFont(font);
        txt_user.setBounds(width/3,height/5,width/2,height/10);
        
        JLabel lb_password = new JLabel("Password:");
        lb_password.setFont(font);
        lb_password.setBounds(width/8,height*2/5,width/5, height/12);

        JPasswordField txt_password = new JPasswordField(20);
        txt_password.setFont(font);
        txt_password.setBounds(width*1/3,height*2/5,width/2,height/10);
        
        JButton btn_login = new JButton("login");
        btn_login.setFont(font);
        btn_login.setBounds(width/3, height*17/30, width/4, height/6);
        btn_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				username=txt_user.getText();
				password=String.valueOf(txt_password.getPassword());
				System.out.println(username+" "+password);
				if(validate()) {
					((JFrame)panel.getRootPane().getParent()).dispose();
					classify();
				}else {
					//提示用户名或密码错误
				}	
			}
        	
        });
        panel = new JPanel();    
        panel.setLayout(null);
        panel.add(lb_user);
        panel.add(txt_user);
        panel.add(lb_password);
        panel.add(txt_password);
        panel.add(btn_login);
        
        frame = new JFrame("Login");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        setLoginMenuVisiable(true);
	}
	
	public void setLoginMenuVisiable(boolean visiable) {
		// 设置界面可见
        frame.setVisible(visiable);
	}
	
	private boolean validate() {
		boolean isValidated=false;
		//验证用户信息
		UserDao userdao=new UserDao();
		user=new User();
		user=userdao.login(username, password);
		if(user==null) {
			isValidated=false;
		}else {
			if(username.equals(user.getUsername())&&password.equals(user.getPassword())) {
				isValidated=true;
			}else {
				isValidated=false;
			}
		}
//		System.out.println(user.getUsername()+" "+user.getPassword()+" "+user.getLevel()+" "+user.getApplicationID());
//		System.out.println(isValidated);
		return isValidated;
	}
	
	private void classify() {
		if(user.getLevel().equals("0")) {
			//l1()
			@SuppressWarnings("unused")
			Adm_Control l3c=new Adm_Control(user);
		}else if(user.getLevel().equals("1")) {
			//l2()
			@SuppressWarnings("unused")
			Stu_Control l1c=new Stu_Control(user);
		}else  {
			//l3()
			@SuppressWarnings("unused")
			Sta_Control l2c=new Sta_Control(user);
		}
	}
	
}

package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.*;

import dao.UserDao;
import entity.User;;

public class Adm_Register{
	
	private JFrame frame;
	private JPanel panel;
	private User user;
	private String username,password;

	@SuppressWarnings("unused")
	private Map<String ,String> map;
	public Adm_Register(User user) {
		this.user=user;
		int width=600;
		int height=400;
		Font font;
		font = new Font("宋体", Font.PLAIN, 25);
		
		JLabel lb_user = new JLabel("User:");
		lb_user.setFont(font);
		lb_user.setBounds(width/8, height/9, width/5, height/12);
        
        JTextField txt_user = new JTextField(20);
        txt_user.setFont(font);
        txt_user.setBounds(width/3,height/9,width/2,height/10);
        
        JLabel lb_password = new JLabel("Password:");
        lb_password.setFont(font);
        lb_password.setBounds(width/8,height/4,width/5, height/12);

        JPasswordField txt_password = new JPasswordField(20);
        txt_password.setFont(font);
        txt_password.setBounds(width*1/3,height/4,width/2,height/10);
        
        
        JLabel lb_category= new JLabel("权限:");
        lb_category.setFont(font);
        lb_category.setBounds(width/8, height*3/7, width/5, height/12);
     // 需要选择的条目
        
        UserDao userdao=new UserDao();
        List<String> temp=userdao.getLevelNum();
        List<Integer> lst_level=new ArrayList<>();
        for(int i=0;i<temp.size();i++) {
        	lst_level.add(Integer.parseInt(temp.get(i)));
        	lst_level.add(1);
        }
        int maxLevel=1;
       
        for(int i=0;i<lst_level.size();i++) {
        	if(maxLevel<lst_level.get(i)) {
        		maxLevel=lst_level.get(i);
        	}
        }
        List<String> listData=new ArrayList<>(); 
        for(int i=1;i<maxLevel+2;i++) {
        	listData.add(i+"");
        }
        
        
        // 创建一个下拉列表框
        JComboBox<String> cb_category = new JComboBox<String>(listData.toArray(new String[listData.size()])); 
        cb_category.setFont(font);
        cb_category.setBackground(Color.white);
        cb_category.setBounds(width/3,height*3/7,width/2,height/10);
        // 添加条目选中状态改变的监听器
        cb_category.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { 
                String data = "";
                if (cb_category.getSelectedIndex() != -1) {                     
                   data =cb_category.getItemAt
                        (cb_category.getSelectedIndex());             
                }              
                System.out.println(data);
             }
        });

        // 设置默认选中的条目
        cb_category.setSelectedIndex(0);
        
        
        JButton btn_register= new JButton("注册");
        btn_register.setFont(font);
        btn_register.setBounds(width/5, height*18/30, width/5, height/7);
        btn_register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				username=txt_user.getText();
				password=String.valueOf(txt_password.getPassword());
				if(validate()) {
					//注册成功
					User newUser=new User();
					newUser.setUsername(username);
					newUser.setPassword(password);
					newUser.setLevel(cb_category.getItemAt(cb_category.getSelectedIndex())); 
					newUser.setApplicationID(null);
					userdao.InsertUser(newUser);
					((JFrame)panel.getRootPane().getParent()).dispose();
					@SuppressWarnings("unused")
					Adm_Control l3=new Adm_Control(user);
				}else {
					//提示用户名已存在
				}	
			}
        	
        });
        
        JButton btn_back = new JButton("返回");
        btn_back.setFont(font);
        btn_back.setBounds(width/2, height*18/30, width/5, height/7);
        btn_back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((JFrame)panel.getRootPane().getParent()).dispose();
				@SuppressWarnings("unused")
				Adm_Control l3=new Adm_Control(user);
				
			}
        	
        });
        
        panel = new JPanel();    
        panel.setLayout(null);
        panel.add(lb_user);
        panel.add(txt_user);
        panel.add(lb_password);
        panel.add(txt_password);
        panel.add(lb_category);
        panel.add(cb_category);
        panel.add(btn_register);
        panel.add(btn_back);
        
        frame = new JFrame("Register");
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
			isValidated=true;
		}else {
			isValidated=false;
		}
//		System.out.println(user.getUsername()+" "+user.getPassword()+" "+user.getLevel()+" "+user.getApplicationID());
		System.out.println(isValidated);
		return isValidated;
	}
	
}

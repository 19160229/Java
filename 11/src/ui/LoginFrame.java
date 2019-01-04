package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dao.GradeDAO;
import dao.UserDAO;

public class LoginFrame {
	private JFrame loginFrame;
	
	public LoginFrame(){
		loginFrame = new JFrame("登陆");
		loginFrame.setSize(800, 600);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //得到屏幕的尺寸
		loginFrame.setLocation((screenSize.width-loginFrame.getWidth())/2, 
				(screenSize.height-loginFrame.getHeight())/2);
		JPanel panel = new JPanel();
		loginFrame.add(panel);
		CreateLoginPanel(panel);
		//ShowLoginFrame();
	}
	
	public void ShowLoginFrame(){
		loginFrame.setVisible(true);
	}
	
	private static void CreateLoginPanel(JPanel panel) {
		// TODO Auto-generated method stub
		panel.setLayout(null);
		JLabel usrLabel = new JLabel("用户名",JLabel.CENTER);
		usrLabel.setBounds(120, 100, 80, 50);
		usrLabel.setFont(new Font("宋体", Font.BOLD, 24));
		panel.add(usrLabel);
		JTextField usrField=new JTextField();
		usrField.setBounds(300, 100, 300, 50);
		usrField.setFont(new Font("宋体", Font.PLAIN, 24));
		panel.add(usrField);

		JLabel passLabel = new JLabel("密码",JLabel.CENTER);
		passLabel.setBounds(120, 250, 80, 50);
		passLabel.setFont(new Font("宋体", Font.BOLD, 24));
		panel.add(passLabel);
		JPasswordField passField=new JPasswordField();
		passField.setBounds(300, 250, 300, 50);
		passField.setFont(new Font("宋体", Font.PLAIN, 24));
		panel.add(passField);
		
		JButton loginButton=new JButton("确定");
		loginButton.setBounds(280,370,100,50);
		loginButton.setFont(new Font("宋体", Font.BOLD, 24));
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String password=new String(passField.getPassword());
				JLabel tipJLabel=new JLabel();
				tipJLabel.setFont(new Font("宋体", Font.PLAIN, 24));
				int authority=UserDAO.login(usrField.getText(), password);
				if (authority==1) {
					GradeDAO gradeDAO=new GradeDAO();
					new ManageGradeFrame(gradeDAO.getGrades());
					((JFrame)panel.getRootPane().getParent()).dispose();
				}else if (authority==2) {
					GradeDAO gradeDAO=new GradeDAO(usrField.getText());
					new ShowGradeFrame(gradeDAO.getGrades());
					((JFrame)panel.getRootPane().getParent()).dispose();
				}else{
					tipJLabel.setText("用户名或密码错误");
					JOptionPane.showMessageDialog(null, tipJLabel,"登陆失败",JOptionPane.ERROR_MESSAGE);
					passField.setText("");
				}
			}
		});
		panel.add(loginButton);
		
		JButton cancelButton=new JButton("取消");
		cancelButton.setBounds(450,370,100,50);
		cancelButton.setFont(new Font("宋体", Font.BOLD, 24));
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				usrField.setText(null);
				passField.setText(null);
			}
		});
		panel.add(cancelButton);
	}
}

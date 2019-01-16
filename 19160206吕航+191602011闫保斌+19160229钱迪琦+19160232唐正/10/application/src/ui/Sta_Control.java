package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.User;

public class Sta_Control {

	private User user;
	private JFrame frame;
	private JPanel panel;
	public Sta_Control(User user) {
		this.user=user;
		Level2_Control_UI();
		setLevel2_Control_UI_Visiable(true);
	}
	private void Level2_Control_UI() {
		Font font;
		font = new Font("宋体", Font.PLAIN, 25);
		int width=450;
		int height=300;
		JButton btn_audit = new JButton("审核");
        btn_audit.setFont(font);
        btn_audit.setBounds(width*1/3, height*1/4 ,width*1/4, height*1/5);
        btn_audit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((JFrame)panel.getRootPane().getParent()).dispose();
				@SuppressWarnings("unused")
				Sta_Audit l2=new Sta_Audit(user);
				
			}
        	
        });
        
      
        
        panel = new JPanel();    
        panel.setLayout(null);
        panel.add(btn_audit);

        
		frame = new JFrame("level2Control");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
	}
	public void setLevel2_Control_UI_Visiable(boolean visiable) {
		// 设置界面可见
        frame.setVisible(visiable);
	}
}

package ui;



import java.awt.Font;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import entity.Table;
import entity.User;

public class Sta_Detail {

	private JFrame frame;
	private JPanel panel;
	@SuppressWarnings("unused")
	private User user;
	@SuppressWarnings("unused")
	private Table table;
	public Sta_Detail(User user,Table table) {
		this.table=table;
		this.user=user;
		level1_Apply_UI(table);
		setLevel2_Detail_UI_Visiable(true);
	}
	
	private void level1_Apply_UI(Table table) {
		Font font;
		font = new Font("宋体", Font.PLAIN, 25);
		int width=900;
		int height=600;
		JLabel lb_user= new JLabel("请假人:");
		lb_user.setFont(font);
		lb_user.setBounds(width/30, height/20,width*4/30, height*2/20);
		JTextField txt_user= new JTextField();
        txt_user.setFont(font);
        txt_user.setEditable(false);
        txt_user.setText(table.getApplicant());
        txt_user.setBounds(width*5/30,height*2/30,width*8/30,height*2/30);
		
        JLabel lb_category= new JLabel("请假类别:");
        lb_category.setFont(font);
        lb_category.setBounds(width*15/30, height/20, width*4/30, height*2/20);
//        JTextField txt_category= new JTextField(1);
//        txt_category.setFont(font);
//        txt_category.setBounds(width*19/30,height*2/30,width*8/30,height*2/30);
        JTextField txt_category=new JTextField();
        txt_category.setFont(font);
        txt_category.setEditable(false);
        txt_category.setText(table.getCategory());
        txt_category.setBounds(width*19/30,height*2/30,width*8/30,height*2/30);
        

        JLabel lb_startTime= new JLabel("开始时间:");
        lb_startTime.setFont(font);
        lb_startTime.setBounds(width/30, height*3/20, width*4/30, height*2/20);
        JTextField txt_startTime= new JTextField(1);
        txt_startTime.setFont(font);
        txt_startTime.setEditable(false);
        txt_startTime.setText(table.getStartTime());
        txt_startTime.setBounds(width*5/30,height*5/30,width*8/30,height*2/30);
        
        JLabel lb_endTime= new JLabel("结束时间:");
        lb_endTime.setFont(font);
        lb_endTime.setBounds(width*15/30, height*3/20, width*4/30, height*2/20);
        JTextField txt_endTime= new JTextField(1);
        txt_endTime.setFont(font);
        txt_endTime.setEditable(false);
        txt_endTime.setText(table.getEndTime());
        txt_endTime.setBounds(width*19/30,height*5/30,width*8/30,height*2/30);
        
        JLabel lb_phone= new JLabel("联系电话:");
        lb_phone.setFont(font);
        lb_phone.setBounds(width/30, height*5/20, width*4/30, height*2/20);
        JTextField txt_phone= new JTextField(20);
        txt_phone.setFont(font);
        txt_phone.setEditable(false);
        txt_phone.setText(table.getPhone());
        txt_phone.setBounds(width*5/30,height*8/30,width*8/30,height*2/30);
        
        JLabel lb_model= new JLabel("审核模板:");
        lb_model.setFont(font);
        lb_model.setBounds(width*15/30, height*5/20, width*4/30, height*2/20);
        JTextField txt_model= new JTextField(1);
        txt_model.setFont(font);
        txt_model.setEditable(false);
        txt_model.setText(table.getModel());
        txt_model.setBounds(width*19/30,height*8/30,width*8/30,height*2/30);
        
       
        
   
        JLabel lb_result=new JLabel("请假理由:");
        lb_result.setFont(font);
        lb_result.setBounds(width*2/30, height*9/20, width*4/30, height*2/20);
        JTextArea txt_result= new JTextArea("",5,20);
        txt_result.setFont(font);
        txt_result.setEditable(false);
        txt_result.setText(table.getResult());
        
        txt_result.setBounds(width*7/30, height*8/20, width*18/30, height*8/30);
        //JScrollPane txt_result_scroll = new JScrollPane(txt_result);    
        
        
//        JButton btn_submit = new JButton("提交");
//        btn_submit.setFont(font);
//        btn_submit.setBounds(width*9/30, height*15/20, width*3/30, height*2/30);
//        
//        JButton btn_back = new JButton("返回");
//        btn_back.setFont(font);
//        btn_back.setBounds(width*16/30, height*15/20, width*3/30, height*2/30);
//        btn_back.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				((JFrame)panel.getRootPane().getParent()).dispose();
//				Level1_Control l1=new Level1_Control(username,password);
//				
//			}
//        	
//        });
        
        panel = new JPanel();    
        panel.setLayout(null);
        panel.add(lb_user);
        panel.add(txt_user);
        panel.add(lb_category);
        // 添加到内容面板
        panel.add(txt_category);
        panel.add(lb_startTime);
        panel.add(txt_startTime);
        panel.add(lb_endTime);
        panel.add(txt_endTime);
        panel.add(lb_model);
        panel.add(txt_model);
        panel.add(lb_phone);
        panel.add(txt_phone);
        panel.add(lb_result);
        panel.add(txt_result);
        //panel.add(txt_result_scroll);
//        panel.add(btn_submit);
//        panel.add(btn_back);
       
		
		frame = new JFrame("level1Apply");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
	}
	
	public void setLevel2_Detail_UI_Visiable(boolean visiable) {
		// 设置界面可见
        frame.setVisible(visiable);
	}
}


package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.ModelDao;
import dao.TableDao;
import entity.Model;
import entity.Table;
import entity.User;

public class Stu_Apply {

	private JFrame frame;
	private JPanel panel;
	private User user;
	public Stu_Apply(User user) {
		this.user=user;
		level1_Apply_UI();
		setLevel1_Apply_UI_Visiable(true);
	}
	
	private void level1_Apply_UI() {
		Font font;
		font = new Font("宋体", Font.PLAIN, 25);
		int width=900;
		int height=600;
		JLabel lb_user= new JLabel("请假人:");
		lb_user.setFont(font);
		lb_user.setBounds(width/30, height/20,width*4/30, height*2/20);
		JTextField txt_user= new JTextField(1);
        txt_user.setFont(font);
        txt_user.setBounds(width*5/30,height*2/30,width*8/30,height*2/30);
		
        JLabel lb_category= new JLabel("请假类别:");
        lb_category.setFont(font);
        lb_category.setBounds(width*15/30, height/20, width*4/30, height*2/20);
//        JTextField txt_category= new JTextField(1);
//        txt_category.setFont(font);
//        txt_category.setBounds(width*19/30,height*2/30,width*8/30,height*2/30);
        // 需要选择的条目
        String[] lst_category = new String[]{"事假", "病假", "其他"};
        // 创建一个下拉列表框
        JComboBox<String> cb_category = new JComboBox<String>(lst_category);
        cb_category.setFont(font);
        cb_category.setBackground(Color.white);
        cb_category.setBounds(width*19/30,height*2/30,width*8/30,height*2/30);
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

        JLabel lb_startTime= new JLabel("开始时间:");
        lb_startTime.setFont(font);
        lb_startTime.setBounds(width/30, height*3/20, width*4/30, height*2/20);
        JTextField txt_startTime= new JTextField(1);
        txt_startTime.setFont(font);
        txt_startTime.setBounds(width*5/30,height*5/30,width*8/30,height*2/30);
        
        JLabel lb_endTime= new JLabel("结束时间:");
        lb_endTime.setFont(font);
        lb_endTime.setBounds(width*15/30, height*3/20, width*4/30, height*2/20);
        JTextField txt_endTime= new JTextField(1);
        txt_endTime.setFont(font);
        txt_endTime.setBounds(width*19/30,height*5/30,width*8/30,height*2/30);
        
        JLabel lb_phone= new JLabel("联系电话:");
        lb_phone.setFont(font);
        lb_phone.setBounds(width/30, height*5/20, width*4/30, height*2/20);
        JTextField txt_phone= new JTextField(20);
        txt_phone.setFont(font);
        txt_phone.setBounds(width*5/30,height*8/30,width*8/30,height*2/30);
        
        JLabel lb_model= new JLabel("审核流程:");
        lb_model.setFont(font);
        lb_model.setBounds(width*15/30, height*5/20, width*4/30, height*2/20);
        ModelDao modeldao=new ModelDao();
        List<String> list=new ArrayList<>();
        list=modeldao.getModelNames();
//        for(int i=0;i<list.size();i++) {
//        	System.out.println(list.get(i));
//        }
        String[] lst_model = list.toArray(new String[list.size()]);
        // 创建一个下拉列表框
        JComboBox<String> cb_model = new JComboBox<String>(lst_model);
        cb_model.setFont(font);
        cb_model.setBackground(Color.white);
        cb_model.setBounds(width*19/30,height*8/30,width*8/30,height*2/30);
        // 添加条目选中状态改变的监听器
        cb_model.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { 
                String data = "";
                if (cb_model.getSelectedIndex() != -1) {                     
                   data =cb_model.getItemAt
                        (cb_model.getSelectedIndex());             
                }              
                System.out.println(data);
             }
        });
      
        JLabel lb_result=new JLabel("请假理由:");
        lb_result.setFont(font);
        lb_result.setBounds(width*2/30, height*9/20, width*4/30, height*2/20);
        JTextArea txt_result= new JTextArea("",5,20);
        txt_result.setFont(font);
        txt_result.setBounds(width*7/30, height*8/20, width*18/30, height*8/30);
        //JScrollPane txt_result_scroll = new JScrollPane(txt_result);    
        
        
        JButton btn_submit = new JButton("提交");
        btn_submit.setFont(font);
        btn_submit.setBounds(width*9/30, height*15/20, width*3/30, height*2/30);
        btn_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Calendar cal=Calendar.getInstance(); 
				Table table=new Table();
				table.setApplicationID(user.getUsername().substring(3,user.getUsername().length() )+cal.get(Calendar.YEAR)+(cal.get(Calendar.MONTH)+1)+cal.get(Calendar.DATE));
				table.setApplicant(txt_user.getText());
				table.setCategory(cb_category.getItemAt(cb_category.getSelectedIndex()));
				table.setStartTime(txt_startTime.getText());
				table.setEndTime(txt_endTime.getText());
				table.setPhone(txt_phone.getText());
				table.setModel(cb_model.getItemAt(cb_model.getSelectedIndex()));
				table.setResult(txt_result.getText());
				if(table.getModel().equals("默认")) {
					table.setCurrentLevel("2");
				}else {
					Model model=new Model();
					model=modeldao.getModel(table.getModel());
					table.setCurrentLevel(model.getUsername().get(0));
				}
				
				TableDao tabledao=new TableDao();
				tabledao.InsertTable(table);
				
				System.out.println(table.getApplicationID()+" "
						+table.getApplicant()+" "+table.getCategory()+" "
						+table.getStartTime()+" "+table.getEndTime()+" "
						+table.getPhone()+" "+table.getModel()+" "
						+table.getResult()+" "+table.getCurrentLevel());
				
				
				((JFrame)panel.getRootPane().getParent()).dispose();
				@SuppressWarnings("unused")
				Stu_Control l1=new Stu_Control(user);
			}
        });
        
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
        
        panel = new JPanel();    
        panel.setLayout(null);
        panel.add(lb_user);
        panel.add(txt_user);
        panel.add(lb_category);
        // 添加到内容面板
        panel.add(cb_category);
        panel.add(lb_startTime);
        panel.add(txt_startTime);
        panel.add(lb_endTime);
        panel.add(txt_endTime);
        panel.add(lb_phone);
        panel.add(txt_phone);
        panel.add(lb_model);
        panel.add(cb_model);
        panel.add(lb_result);
        panel.add(txt_result);
        panel.add(btn_submit);
        panel.add(btn_back);
       
		
		frame = new JFrame("level1Apply");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
	}
	
	public void setLevel1_Apply_UI_Visiable(boolean visiable) {
		// 设置界面可见
        frame.setVisible(visiable);
	}
}

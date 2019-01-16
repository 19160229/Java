package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import entity.Model;
import javax.swing.*;

import dao.ModelDao;
 
//本类继承自JFrame 实现了 ActionListener接口
@SuppressWarnings("serial")
public class Adm_Manage_Dynamic extends JFrame implements ActionListener  {
    JPanel jpc ;//存放组件的面板
    JScrollPane jsp;//滚动面板
    JButton jbAdd ,jbRemove,jbReset,jbSave;// 增加,删除按钮
    int index = 1;//开始的字符
    JTextField jtxt;
    List<Model> models=new ArrayList<>();
    //构造函数
    public Adm_Manage_Dynamic() {
        jpc = new JPanel();
        jpc.setLayout(new BoxLayout(jpc,  BoxLayout.Y_AXIS));//盒子布局.从上到下
        jsp = new JScrollPane(jpc,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(jsp);
             
        jbAdd = new JButton("增加");
        jbAdd.setFont(new Font("宋体", Font.PLAIN, 25));
        jbAdd.addActionListener(this);
        jbRemove = new JButton("删除");
        jbRemove.setFont(new Font("宋体", Font.PLAIN, 25));
        jbRemove.addActionListener(this);
        jbReset = new JButton("重置");
        jbReset.setFont(new Font("宋体", Font.PLAIN, 25));
        jbReset.addActionListener(this);
        jbSave = new JButton("保存");
        jbSave.setFont(new Font("宋体", Font.PLAIN, 25));
        jbSave.addActionListener(this);
        JPanel jps = new JPanel();
        jps.add(jbAdd);
        jps.add(jbRemove);
        jps.add(jbReset);
        jps.add(jbSave);
        
        JLabel jlb = new JLabel("模板名称:");
        jlb.setFont(new Font("宋体", Font.PLAIN, 25));
        jtxt = new JTextField(15);
        jtxt.setFont(new Font("宋体", Font.PLAIN, 25));
        JPanel upPanel=new JPanel();
        upPanel.add(jlb);
        upPanel.add(jtxt);
        add(upPanel,BorderLayout.NORTH);
        
        add(jps,BorderLayout.SOUTH);
        setTitle("增删组件");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 600);//大小
        setLocationRelativeTo(null);//居中
        
        
        jpc.add(new MyJPanel(index));//添加1个自己定义的面板组件
        index++;//自加1
        myUpdateUI();//刷新界面
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if(jb==jbAdd) {//当点击添加按钮时
            jpc.add(new MyJPanel(index));//添加1个自己定义的面板组件
            index++;//自加1
            myUpdateUI();//刷新界面
        }else if(jb ==jbRemove) {//当点击删除按钮时
            if(jpc.getComponentCount()>0) { // 得到jpc里的MyJPanel的组件数量
                jpc.remove(jpc.getComponentCount()-1);//删除末尾的一个组件 ,
                index-=1;
                myUpdateUI();
            }
        }else if(jb==jbReset) {
        	while(jpc.getComponentCount()>0) { // 得到jpc里的MyJPanel的组件数量
                jpc.remove(jpc.getComponentCount()-1);//删除末尾的一个组件 ,
                index-=1;
                myUpdateUI();
            }
        }else if(jb==jbSave) {
        	int count = jpc.getComponentCount();
        	Model model=new Model();
    	    List<String> usernames=new ArrayList<>();
    	    usernames.add("head");
        	for (int i = 0; i < count; i++) {
        	    Object obj = jpc.getComponent(i);
        	    if (obj instanceof MyJPanel) {
        	    	usernames.add(((MyJPanel) obj).getJTFValue());
//        	    	System.out.println(jtxt.getText());
//        	        System.out.println(((MyJPanel) obj).getJTFValue());
        	  }
        	    
        	}
        	usernames.add("");
        	model.setModelName(jtxt.getText());
    	    model.setUsername(usernames);
        	for(int i=0;i<model.getUsername().size();i++) {
        		System.out.println(model.getModelName()+" "+model.getUsername().get(i));
        	}
        	ModelDao modeldao=new ModelDao();
        	for(int i=0;i<model.getUsername().size()-1;i++) {
        		modeldao.InsertModel(model.getModelName(), model.getUsername().get(i), model.getUsername().get(i+1));
        	}
        }
         
    }
    //刷新界面函数
    private void myUpdateUI() {
        SwingUtilities.updateComponentTreeUI(this);//添加或删除组件后,更新窗口
        JScrollBar jsb = jsp.getVerticalScrollBar();//得到垂直滚动条
        jsb.setValue(jsb.getMaximum());//把滚动条位置设置到最下面
    }
     
}
 
//自定义一个JPanle类
@SuppressWarnings("serial")
class MyJPanel extends JPanel{
    public JTextField jtf;
    public MyJPanel(int index) {
        JLabel jl = new JLabel("审核"+index+":");
        jl.setFont(new Font("宋体", Font.PLAIN, 25));
        jtf = new JTextField(15);
        jtf.setFont(new Font("宋体", Font.PLAIN, 25));
        add(jl);
        add(jtf);
    }
    //获取文本框的值
    public String getJTFValue() {
        return jtf.getText();
    }
    //设置文本框的值
    public void setJTFValue(String value) {
        jtf.setText(value);
    }
}
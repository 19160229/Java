package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import entity.Model;
import javax.swing.*;

import dao.ModelDao;
 
//����̳���JFrame ʵ���� ActionListener�ӿ�
@SuppressWarnings("serial")
public class Adm_Manage_Dynamic extends JFrame implements ActionListener  {
    JPanel jpc ;//�����������
    JScrollPane jsp;//�������
    JButton jbAdd ,jbRemove,jbReset,jbSave;// ����,ɾ����ť
    int index = 1;//��ʼ���ַ�
    JTextField jtxt;
    List<Model> models=new ArrayList<>();
    //���캯��
    public Adm_Manage_Dynamic() {
        jpc = new JPanel();
        jpc.setLayout(new BoxLayout(jpc,  BoxLayout.Y_AXIS));//���Ӳ���.���ϵ���
        jsp = new JScrollPane(jpc,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(jsp);
             
        jbAdd = new JButton("����");
        jbAdd.setFont(new Font("����", Font.PLAIN, 25));
        jbAdd.addActionListener(this);
        jbRemove = new JButton("ɾ��");
        jbRemove.setFont(new Font("����", Font.PLAIN, 25));
        jbRemove.addActionListener(this);
        jbReset = new JButton("����");
        jbReset.setFont(new Font("����", Font.PLAIN, 25));
        jbReset.addActionListener(this);
        jbSave = new JButton("����");
        jbSave.setFont(new Font("����", Font.PLAIN, 25));
        jbSave.addActionListener(this);
        JPanel jps = new JPanel();
        jps.add(jbAdd);
        jps.add(jbRemove);
        jps.add(jbReset);
        jps.add(jbSave);
        
        JLabel jlb = new JLabel("ģ������:");
        jlb.setFont(new Font("����", Font.PLAIN, 25));
        jtxt = new JTextField(15);
        jtxt.setFont(new Font("����", Font.PLAIN, 25));
        JPanel upPanel=new JPanel();
        upPanel.add(jlb);
        upPanel.add(jtxt);
        add(upPanel,BorderLayout.NORTH);
        
        add(jps,BorderLayout.SOUTH);
        setTitle("��ɾ���");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 600);//��С
        setLocationRelativeTo(null);//����
        
        
        jpc.add(new MyJPanel(index));//���1���Լ������������
        index++;//�Լ�1
        myUpdateUI();//ˢ�½���
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if(jb==jbAdd) {//�������Ӱ�ťʱ
            jpc.add(new MyJPanel(index));//���1���Լ������������
            index++;//�Լ�1
            myUpdateUI();//ˢ�½���
        }else if(jb ==jbRemove) {//�����ɾ����ťʱ
            if(jpc.getComponentCount()>0) { // �õ�jpc���MyJPanel���������
                jpc.remove(jpc.getComponentCount()-1);//ɾ��ĩβ��һ����� ,
                index-=1;
                myUpdateUI();
            }
        }else if(jb==jbReset) {
        	while(jpc.getComponentCount()>0) { // �õ�jpc���MyJPanel���������
                jpc.remove(jpc.getComponentCount()-1);//ɾ��ĩβ��һ����� ,
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
    //ˢ�½��溯��
    private void myUpdateUI() {
        SwingUtilities.updateComponentTreeUI(this);//��ӻ�ɾ�������,���´���
        JScrollBar jsb = jsp.getVerticalScrollBar();//�õ���ֱ������
        jsb.setValue(jsb.getMaximum());//�ѹ�����λ�����õ�������
    }
     
}
 
//�Զ���һ��JPanle��
@SuppressWarnings("serial")
class MyJPanel extends JPanel{
    public JTextField jtf;
    public MyJPanel(int index) {
        JLabel jl = new JLabel("���"+index+":");
        jl.setFont(new Font("����", Font.PLAIN, 25));
        jtf = new JTextField(15);
        jtf.setFont(new Font("����", Font.PLAIN, 25));
        add(jl);
        add(jtf);
    }
    //��ȡ�ı����ֵ
    public String getJTFValue() {
        return jtf.getText();
    }
    //�����ı����ֵ
    public void setJTFValue(String value) {
        jtf.setText(value);
    }
}
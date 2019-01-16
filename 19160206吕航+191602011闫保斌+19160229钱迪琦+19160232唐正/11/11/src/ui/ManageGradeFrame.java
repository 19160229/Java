package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import dao.GradeDAO;
import entity.Grade;
import util.Utility;

public class ManageGradeFrame {
	private JFrame manageGradeFrame;
	private List<Grade> grades;
	private List<Grade> tmpGrades;
	private JTable table;
	private final String[] name = { "学号", "姓名", "课程名", "成绩", "学分" };
	private JComboBox<String> stuCmb;
	private JComboBox<String> courseCmb;

	public ManageGradeFrame(List<Grade> grades) {
		// TODO Auto-generated constructor stub
		// this.sno=sno;
		// gradeDAO=new GradeDAO(this.sno);
		// List<Grade> grades=gradeDAO.getGrades();
		this.grades = grades;
		this.tmpGrades=grades;
		manageGradeFrame = new JFrame("学生成绩表");
		manageGradeFrame.setLocationRelativeTo(null);
		manageGradeFrame.setSize(900, 700);
		manageGradeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 得到屏幕的尺寸
		manageGradeFrame.setLocation((screenSize.width - manageGradeFrame.getWidth()) / 2,
				(screenSize.height - manageGradeFrame.getHeight()) / 2);
		JPanel panel = new JPanel();
		manageGradeFrame.add(panel);
		createManageGradePanel(panel);
		manageGradeFrame.setVisible(true);
	}

	private Object[][] getDataTable(List<Grade> gradeList) {
		Object[][] tableData = new Object[gradeList.size()][5];
		for (int i = 0; i < gradeList.size(); i++) {
			Grade grade = gradeList.get(i);
			tableData[i][0] = grade.getSno();
			tableData[i][1] = grade.getSname();
			tableData[i][2] = grade.getCname();
			tableData[i][3] = grade.getGrade();
			tableData[i][4] = grade.getCredit();
		}
		return tableData;
	}
	
	private void changeJTable(List<Grade> grades){
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		tableModel.setColumnIdentifiers(name);
		for (int i = 0; i < grades.size(); i++) {
			Grade cGrade = grades.get(i);
			tableModel.addRow(new Object[] { cGrade.getSno(), cGrade.getSname(), cGrade.getCname(),
					cGrade.getGrade(), cGrade.getCredit() });
			table.setModel(tableModel);
		}
	}

	private void initJTable(Object[][] tableData) {
		table = new JTable();
		table.setModel(new DefaultTableModel(tableData, name));
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(header.getWidth(), 35));
		header.setFont(new Font("宋体", Font.BOLD, 20));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		for (int i = 0; i < name.length; i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setPreferredWidth(50);
			}
		}
		table.setRowHeight(50);
		table.setFont(new Font("宋体", Font.PLAIN, 18));
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
	}

	private JPanel createInfoPanel() {
		JPanel infoPanel = new JPanel();

		JLabel selectedSno = new JLabel("学号:");
		selectedSno.setFont(new Font("宋体", Font.PLAIN, 18));

		stuCmb = new JComboBox<String>();
		stuCmb.addItem("--请选择--");
		List<String> stuNos = Utility.getStuNos(grades);
		for (int i = 0; i < stuNos.size(); i++) {
			stuCmb.addItem(stuNos.get(i));
		}
		stuCmb.setFont(new Font("宋体", Font.PLAIN, 18));
		stuCmb.setBorder(new EmptyBorder(0, 50, 0, 0));

		JLabel selectedCourseLabel = new JLabel("所选课程:");
		selectedCourseLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		selectedCourseLabel.setBorder(new EmptyBorder(0, 50, 0, 0));

		courseCmb = new JComboBox<String>();
		courseCmb.addItem("--请选择--");
		List<String> courseName = Utility.getCourseName(grades);
		for (int i = 0; i < courseName.size(); i++) {
			courseCmb.addItem(courseName.get(i));
		}
		courseCmb.setFont(new Font("宋体", Font.PLAIN, 18));
		courseCmb.setBorder(new EmptyBorder(0, 50, 0, 50));

		JButton button = new JButton("查询");
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sno = (String) stuCmb.getSelectedItem();
				String cname = (String) courseCmb.getSelectedItem();
				if ((stuCmb.getSelectedIndex()==0)&&(courseCmb.getSelectedIndex()==0)) {
					tmpGrades = grades;
				}else if (stuCmb.getSelectedIndex()==0) {
					tmpGrades = Utility.getGradesByCName(grades, cname);
				} 
				else if (courseCmb.getSelectedIndex()==0) {
					tmpGrades=Utility.getGradesBySno(grades,sno);
				}else {
					tmpGrades=Utility.getGradesBySnoCname(grades,sno,cname);
				}
				changeJTable(tmpGrades);
			}
		});

		infoPanel.add(selectedSno);
		infoPanel.add(stuCmb);
		infoPanel.add(selectedCourseLabel);
		infoPanel.add(courseCmb);
		infoPanel.add(button);
		infoPanel.setBorder(new EmptyBorder(5, 5, 10, 5));

		return infoPanel;
	}
	
	private JPanel createBottomPanel() {
		JPanel bottomPanel=new JPanel();
		
		JButton addButton=new JButton("添加");
		addButton.setFont(new Font("宋体", Font.PLAIN, 18));
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddGradeDialog dialog=new AddGradeDialog();
				dialog.setModal(true);
				dialog.setVisible(true);
				Grade grade=dialog.getReturnGrade();
				if (grade!=null) {
					grades.add(grade);
					GradeDAO.addGrade(grade);
					tmpGrades=grades;
					stuCmb.setSelectedIndex(0);
					courseCmb.setSelectedItem(0);
					Collections.sort(grades);
					changeJTable(grades);
				}
			}
		});
		JPanel spacePanel0=new JPanel();
		spacePanel0.setBorder(new EmptyBorder(0, 450, 0, 0));
		bottomPanel.add(spacePanel0);
		bottomPanel.add(addButton);
		JPanel spacePanel1=new JPanel();
		spacePanel1.setBorder(new EmptyBorder(0, 30, 0, 0));
		bottomPanel.add(spacePanel1);
		
		JButton delButton=new JButton("删除");
		delButton.setFont(new Font("宋体", Font.PLAIN, 18));
		delButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()==-1) {
					JLabel tipJLabel=new JLabel();
					tipJLabel.setFont(new Font("宋体", Font.PLAIN, 24));
					tipJLabel.setText("请选择一条记录");
					JOptionPane.showMessageDialog(null, tipJLabel,"error",JOptionPane.WARNING_MESSAGE);
				}else{
					JLabel tipJLabel=new JLabel();
					tipJLabel.setFont(new Font("宋体", Font.PLAIN, 24));
					tipJLabel.setText("确定要删除本条记录？");
					int res = JOptionPane.showConfirmDialog(null, tipJLabel, "删除", JOptionPane.YES_NO_OPTION);
					if (res==0) {
						Grade grade=tmpGrades.get(table.getSelectedRow());
						GradeDAO.deleteGrade(grade);
						grades.remove(grade);
						tmpGrades.remove(grade);
						changeJTable(tmpGrades);
					}
				}
			}
		});
		bottomPanel.add(delButton);
		JPanel spacePanel2=new JPanel();
		spacePanel2.setBorder(new EmptyBorder(0, 30, 0, 0));
		bottomPanel.add(spacePanel2);
		
		JButton modifyButton=new JButton("修改");
		modifyButton.setFont(new Font("宋体", Font.PLAIN, 18));
		modifyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()==-1) {
					JLabel tipJLabel=new JLabel();
					tipJLabel.setFont(new Font("宋体", Font.PLAIN, 24));
					tipJLabel.setText("请选择一条记录");
					JOptionPane.showMessageDialog(null, tipJLabel,"error",JOptionPane.WARNING_MESSAGE);
				}else{
					JLabel tipJLabel=new JLabel();
					tipJLabel.setFont(new Font("宋体", Font.PLAIN, 24));
					tipJLabel.setText("请输入新的成绩");
					String res = (String)JOptionPane.showInputDialog(null, tipJLabel, "修改成绩", JOptionPane.PLAIN_MESSAGE, null, null, null);
					if (res!=null) {
						int g=Integer.parseInt(res);
						Grade grade=tmpGrades.get(table.getSelectedRow());
						grade.setGrade(g);
						GradeDAO.updateGrade(grade);
						changeJTable(tmpGrades);
					}
				}
			}
		});
		bottomPanel.add(modifyButton);
		
		bottomPanel.setBorder(new EmptyBorder(10, 5, 5, 5));
		return bottomPanel;
	}

	private void createManageGradePanel(JPanel panel) {
		// TODO Auto-generated method stub
		panel.setLayout(new BorderLayout());
		// List<Grade> grades=gradeDAO.getGrades();
		initJTable(getDataTable(grades));
		JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(scrollPane, BorderLayout.CENTER);
		JPanel infoPanel = createInfoPanel();
		panel.add(infoPanel, BorderLayout.NORTH);
		JPanel bottomPanel=createBottomPanel();
		panel.add(bottomPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		GradeDAO gradeDAO = new GradeDAO();
		new ManageGradeFrame(gradeDAO.getGrades());
	}
}

package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import dao.GradeDAO;
import entity.Grade;
import util.Utility;

public class ShowGradeFrame {

	private JFrame showGradeFrame;
	private List<Grade> grades;

	public ShowGradeFrame(List<Grade> grades) {
		// TODO Auto-generated constructor stub
		// this.sno=sno;
		// gradeDAO=new GradeDAO(this.sno);
		// List<Grade> grades=gradeDAO.getGrades();
		this.grades = grades;
		showGradeFrame = new JFrame("学生成绩表");
		showGradeFrame.setLocationRelativeTo(null);
		showGradeFrame.setSize(900, 700);
		showGradeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 得到屏幕的尺寸
		showGradeFrame.setLocation((screenSize.width - showGradeFrame.getWidth()) / 2,
				(screenSize.height - showGradeFrame.getHeight()) / 2);
		JPanel panel = new JPanel();
		showGradeFrame.add(panel);
		createShowGradePanel(panel);
		showGradeFrame.setVisible(true);
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

	private JTable createJTable(Object[][] tableData, String[] name) {
		JTable table = new JTable();
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
		return table;
	}

	private void createShowGradePanel(JPanel panel) {
		// TODO Auto-generated method stub
		panel.setLayout(new BorderLayout());
		// List<Grade> grades=gradeDAO.getGrades();
		String[] name = { "学号", "姓名", "课程名", "成绩", "学分" };
		JTable table = createJTable(getDataTable(grades), name);
		JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(scrollPane, BorderLayout.CENTER);
		JPanel infoPanel = new JPanel();
		panel.add(infoPanel, BorderLayout.NORTH);
		JLabel selectedCourseLabel = new JLabel("所选课程:");
		selectedCourseLabel.setFont(new Font("宋体", Font.PLAIN, 18));

		JComboBox<String> cmb = new JComboBox<String>();
		cmb.addItem("--请选择--");
		List<String> courseName = Utility.getCourseName(grades);
		for (int i = 0; i < courseName.size(); i++) {
			cmb.addItem(courseName.get(i));
		}
		cmb.setFont(new Font("宋体", Font.PLAIN, 18));
		cmb.setBorder(new EmptyBorder(0, 80, 0, 0));

		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cname = (String) cmb.getSelectedItem();
				List<Grade> cGrades;
				if ("--请选择--".equals(cname)) {
					cGrades=grades;
				} else {
					cGrades = Utility.getGradesByCName(grades, cname);
				}
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.setRowCount(0);
				tableModel.setColumnIdentifiers(name);
				for (int i = 0; i < cGrades.size(); i++) {
					Grade cGrade = cGrades.get(i);
					tableModel.addRow(new Object[] { cGrade.getSno(), cGrade.getSname(), cGrade.getCname(),
							cGrade.getGrade(), cGrade.getCredit() });
					table.setModel(tableModel);
				}
			}
		});

		infoPanel.add(selectedCourseLabel);
		infoPanel.add(cmb);
		infoPanel.add(button);
		infoPanel.setBorder(new EmptyBorder(5, 5, 10, 10));
	}

	public static void main(String[] args) {
		GradeDAO gradeDAO = new GradeDAO("1512101");
		new ShowGradeFrame(gradeDAO.getGrades());
	}
}

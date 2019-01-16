package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.CourseDAO;
import dao.GradeDAO;
import dao.StuDAO;
import entity.Course;
import entity.Grade;
import entity.Stu;

@SuppressWarnings("serial")
public class AddGradeDialog extends JDialog {

	private Grade grade;
	private List<Stu> allStus;
	private List<Course> allCourses;

	public static void main(String[] args) {
		AddGradeDialog dialog = new AddGradeDialog();
		dialog.setModal(true);
		dialog.setVisible(true);
		Grade grade = dialog.getReturnGrade();
		if (grade == null) {
			System.out.println("null");
		} else {
			System.out.println(grade.getSno() + " " + grade.getCno() + " " + grade.getCname() + " " + grade.getGrade()
					+ " " + grade.getCredit());
		}
	}

	public AddGradeDialog() {
		allStus=StuDAO.getAllStus();
		allCourses = CourseDAO.getAllCourses();

		setTitle("添加成绩");
		setSize(700, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 得到屏幕的尺寸
		setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout());
		panel.setFont(new Font("宋体", Font.PLAIN, 18));

		JPanel cmbPanel = new JPanel();
		panel.add(cmbPanel, BorderLayout.NORTH);
		cmbPanel.setBorder(new EmptyBorder(80, 20, 50, 20));
		JLabel selectedSnoLabel = new JLabel("选择学生");
		selectedSnoLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		selectedSnoLabel.setBorder(new EmptyBorder(0, 50, 0, 30));
		cmbPanel.add(selectedSnoLabel);
		JComboBox<String> snoCmb = new JComboBox<>();
		snoCmb.setFont(new Font("宋体", Font.PLAIN, 18));
		snoCmb.addItem("--请选择--");
		for (int i = 0; i < allStus.size(); i++) {
			snoCmb.addItem(allStus.get(i).getSno());
		}
		cmbPanel.add(snoCmb);
		JLabel selectedCourseLabel = new JLabel("选择课程");
		selectedCourseLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		selectedCourseLabel.setBorder(new EmptyBorder(0, 50, 0, 30));
		cmbPanel.add(selectedCourseLabel);
		JComboBox<String> cnameCmb = new JComboBox<>();
		cnameCmb.setFont(new Font("宋体", Font.PLAIN, 18));
		cnameCmb.addItem("--请选择--");
		cnameCmb.setBorder(new EmptyBorder(0, 0, 0, 50));
		for (int i = 0; i < allCourses.size(); i++) {
			cnameCmb.addItem(allCourses.get(i).getCname());
		}
		cmbPanel.add(cnameCmb);

		JPanel inputPanel = new JPanel();
		panel.add(inputPanel, BorderLayout.CENTER);
		JLabel inputGradeLabel = new JLabel("请输入成绩");
		inputGradeLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		inputGradeLabel.setBorder(new EmptyBorder(0, 0, 0, 130));
		inputPanel.add(inputGradeLabel);
		JTextField inputField = new JTextField(25);
		inputField.setHorizontalAlignment(JTextField.CENTER);
		inputField.setFont(new Font("宋体", Font.PLAIN, 24));
		inputPanel.add(inputField);

		JPanel btnPanel = new JPanel();
		panel.add(btnPanel, BorderLayout.SOUTH);
		JPanel spacePanel = new JPanel();
		spacePanel.setBorder(new EmptyBorder(0, 0, 80, 300));
		btnPanel.add(spacePanel);
		JButton btnConfirm = new JButton("确定");
		btnConfirm.setFont(new Font("宋体", Font.PLAIN, 18));
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel tipJLabel = new JLabel();
				tipJLabel.setFont(new Font("宋体", Font.PLAIN, 24));
				if ((snoCmb.getSelectedIndex() != 0) && (cnameCmb.getSelectedIndex() != 0)
						&& (!"".equals(inputField.getText()))) {
					tipJLabel.setText("确定添加成绩？");
					int res = JOptionPane.showConfirmDialog(null, tipJLabel, "添加", JOptionPane.YES_NO_OPTION);
					if (res == 0) {
						int g = Integer.parseInt(inputField.getText());
						if (g < 0 || g > 100) {
							tipJLabel.setText("请输入有效成绩！");
							JOptionPane.showMessageDialog(null, tipJLabel, "操作失败", JOptionPane.ERROR_MESSAGE);
						} else {
							grade = new Grade();
							Stu stu=allStus.get(snoCmb.getSelectedIndex()-1);
							grade.setSno(stu.getSno());
							grade.setSname(stu.getSname());
							Course course = new Course();
							course = allCourses.get(cnameCmb.getSelectedIndex()-1);
							grade.setCno(course.getCno());
							grade.setCname(course.getCname());
							grade.setGrade(g);
							int credit = (g < 60) ? 0 : course.getCredit();
							grade.setCredit(credit);
							if (GradeDAO.isExist(grade.getSno(),grade.getCno())) {
								grade=null;
								tipJLabel.setText("成绩重复！");
								JOptionPane.showMessageDialog(null, tipJLabel, "操作失败", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				} else {
					tipJLabel.setText("非法操作！");
					JOptionPane.showMessageDialog(null, tipJLabel, "操作失败", JOptionPane.ERROR_MESSAGE);
				}
				dispose();
			}
		});
		btnPanel.add(btnConfirm);
		JPanel spacePanel2 = new JPanel();
		spacePanel2.setBorder(new EmptyBorder(0, 0, 0, 30));
		btnPanel.add(spacePanel2);
		JButton btnCancel = new JButton("取消");
		btnCancel.setFont(new Font("宋体", Font.PLAIN, 18));
		btnCancel.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnPanel.add(btnCancel);
	}

	public Grade getReturnGrade() {
		return grade;
	}

}

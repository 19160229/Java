package util;

import java.util.ArrayList;
import java.util.List;

import entity.Grade;

public class Utility {
	public static List<String> getCourseName(List<Grade> grades){
		List<String> courseName=new ArrayList<>();
		for(int i=0;i<grades.size();i++){
			String cname=grades.get(i).getCname();
			if (!courseName.contains(cname)) {
				courseName.add(cname);
			}
		}
		return courseName;
	}
	
	public static List<String> getStuNos(List<Grade> grades) {
		// TODO Auto-generated method stub
		List<String> stuNos=new ArrayList<>();
		for(int i=0;i<grades.size();i++){
			String sno=grades.get(i).getSno();
			if (!stuNos.contains(sno)) {
				stuNos.add(sno);
			}
		}
		return stuNos;
	}
	
	public static List<Grade> getGradesByCName(List<Grade> grades,String cname){
		List<Grade> cGrades=new ArrayList<>();
		for(int i=0;i<grades.size();i++){
			Grade grade=grades.get(i);
			if (cname.equals(grade.getCname())) {
				cGrades.add(grade);
			}
		}
		return cGrades;
	}

	public static List<Grade> getGradesBySno(List<Grade> grades, String sno) {
		List<Grade> sGrades=new ArrayList<>();
		for(int i=0;i<grades.size();i++){
			Grade grade=grades.get(i);
			if (sno.equals(grade.getSno())) {
				sGrades.add(grade);
			}
		}
		return sGrades;
	}

	public static List<Grade> getGradesBySnoCname(List<Grade> grades, String sno, String cname) {
		List<Grade> tmpGrades=new ArrayList<>();
		for(int i=0;i<grades.size();i++){
			Grade grade=grades.get(i);
			if (sno.equals(grade.getSno())&&cname.equals(grade.getCname())) {
				tmpGrades.add(grade);
			}
		}
		return tmpGrades;
	}

}

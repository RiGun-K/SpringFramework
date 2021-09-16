package com.example.mymug.data;

import java.util.ArrayList;
import java.util.List;

// 각각의 class teacher 데이터를 담는곳 (더미 데이터)

public class DataGenerator {
	private List<ClassVO> classList;
	private List<TeacherVO> teacherList;

	public DataGenerator() {
		classList = new ArrayList<>();
		teacherList = new ArrayList<>();

		
		// 배열 채우기
		ClassVO c1 = new ClassVO("C001","자바","자바기초",20,"TOO1","제니퍼");
		ClassVO c2 = new ClassVO("C002","자바","자바기초",20,"TOO1","제니퍼");
		ClassVO c3 = new ClassVO("C011","스프링","스프링기초",10,"TOO2","토마스");
		ClassVO c4 = new ClassVO("C012","DB","DB기초",20,"TOO3","토마스");
		
		classList.add(c1);
		classList.add(c2);
		classList.add(c3);
		classList.add(c4);
		
		List<ClassVO> l1 = new ArrayList<>();	// 제니퍼용 수업 리스트
		l1.add(c1);
		l1.add(c2);
		
		List<ClassVO> l2 = new ArrayList<>();	// 토마스용 수업 리스트
		l2.add(c3);
		l2.add(c4);
		
		teacherList.add(new TeacherVO("T001","제니퍼","Java/CSS 전문",l1));
		teacherList.add(new TeacherVO("T002","토마스","웹 전문",l2));
	}
	
	public List<ClassVO> getClassList() {
		return classList;
	}
	public List<TeacherVO> getTeacherList() {
		return teacherList;
	}
	
	// 하나씩 담아서  / return null 까지오면 못찾았다는것 (없는 주소)
	public ClassVO getClassInfo(String classId) {
		for(ClassVO cv:classList) {
			if(cv.classId.equals(classId))
				return cv;
		}
		return null;
	}
	
	public TeacherVO getTeacherInfo(String teacherId) {
		for(TeacherVO tv:teacherList) {
			if(tv.teacherId.equals(teacherId))
				return tv;
		}
		return null;
	}


}

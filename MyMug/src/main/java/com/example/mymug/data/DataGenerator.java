package com.example.mymug.data;

import java.util.ArrayList;
import java.util.List;

// ������ class teacher �����͸� ��°� (���� ������)

public class DataGenerator {
	private List<ClassVO> classList;
	private List<TeacherVO> teacherList;

	public DataGenerator() {
		classList = new ArrayList<>();
		teacherList = new ArrayList<>();

		
		// �迭 ä���
		ClassVO c1 = new ClassVO("C001","�ڹ�","�ڹٱ���",20,"TOO1","������");
		ClassVO c2 = new ClassVO("C002","�ڹ�","�ڹٱ���",20,"TOO1","������");
		ClassVO c3 = new ClassVO("C011","������","����������",10,"TOO2","�丶��");
		ClassVO c4 = new ClassVO("C012","DB","DB����",20,"TOO3","�丶��");
		
		classList.add(c1);
		classList.add(c2);
		classList.add(c3);
		classList.add(c4);
		
		List<ClassVO> l1 = new ArrayList<>();	// �����ۿ� ���� ����Ʈ
		l1.add(c1);
		l1.add(c2);
		
		List<ClassVO> l2 = new ArrayList<>();	// �丶���� ���� ����Ʈ
		l2.add(c3);
		l2.add(c4);
		
		teacherList.add(new TeacherVO("T001","������","Java/CSS ����",l1));
		teacherList.add(new TeacherVO("T002","�丶��","�� ����",l2));
	}
	
	public List<ClassVO> getClassList() {
		return classList;
	}
	public List<TeacherVO> getTeacherList() {
		return teacherList;
	}
	
	// �ϳ��� ��Ƽ�  / return null �������� ��ã�Ҵٴ°� (���� �ּ�)
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

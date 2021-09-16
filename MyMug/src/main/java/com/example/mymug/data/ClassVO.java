package com.example.mymug.data;

public class ClassVO {

	// ������ ���� ���� ����
	public String classId;
	public String className;
	public String classDescription;
	public int maxStudent;
	public int currentStudent;
	public String teacherId;
	public String teacherName;
	
	// ������ ����
	public ClassVO() {}
	
	public ClassVO(String classId, String className, String classDescription,
				   int maxStudent, String teacherId, String teacherName)
	{
		this.classId = classId;
		this.className = className;
		this.classDescription = classDescription;
		this.maxStudent = maxStudent;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.currentStudent = 0;
		
	}

	
}

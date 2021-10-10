package com.example.mymug.data;

import java.util.List;

public class TeacherVO {
	public String teacherId;
	public String teacherName;
	public String teacherDescription;
	
	
	public List<ClassVO> teachClasses;

	public TeacherVO() {}
	
	public TeacherVO(
		String teacherId,
		String teacherName,
		String teacherDescription,
		List<ClassVO> teachClasses) {
		
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherDescription = teacherDescription;
		this.teachClasses = teachClasses;
		}


}

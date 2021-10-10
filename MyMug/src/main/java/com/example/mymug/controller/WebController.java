package com.example.mymug.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mymug.data.DataGenerator;
import com.example.mymug.data.Point;

@Controller
public class WebController {

	// Controller ���� ���� ����� = DataGenerator�� �ִ� �����Ͱ� ����
	private DataGenerator data = new DataGenerator();
	
	/* Ŭ���̾�Ʈ���� ��û�� ������ (�ּҷ� ����, �̺�Ʈ ��û ��)
	 * Controller���� �ش� View�� ���� ó���� �� �� �ٽ� View�� ��ȯ�Ѵ�.
	 */
	
	// return ���� /templates/index.html�� ��ȯ
	@GetMapping("/")
	public String index() {
		return "index";
	}
	 
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("title", "�ȳ��ϻ��");
		model.addAttribute("img1", "images/dd.jpg");
		return "home";
	}
	
	// Get �� Post �Լ� �߰�
	@GetMapping("/update")
	public String updateView() {
		return "updatePoint";
	}
	
	// name �� �߿��ϴٰ� �ϼ���
	// �Է¹��� userid point ���� ��ü�� ������ addAttribute �Ͽ� View�� ��ȯ  
	@PostMapping("/update")
	public String updateResult(
			@RequestParam(name="userid") String userid,
			@RequestParam(name="point") int point,
			Model model) {
		model.addAttribute("result", userid + "��" + point);
		return "updatePoint";
	}
	
	// �ּ�â�� userid ���� �޾ƿͼ� �� ���� String�� Model ��ü�� �����.
	// �� userid ��ü�� View�� �̵���Ų�� 
	@GetMapping("/mypoint/{userid}")
	public String myPoint(@PathVariable("userid") String userid, Model model) {
		Point p = new Point(userid, 20);
		model.addAttribute("point", p);
		
//		model.addAttribute("userid", userid);
//		model.addAttribute("point", 2000);
		return "mypoint";
	}
	
	@GetMapping("/adduser")
	public String user() {
		return "addUser";
	}
///////////////////////////////////////////////////////////////////
	
	// class_list ���� ���������� �־�ߵ����� Model�� �ָ��
	
	@GetMapping("/classes")
	public String getclasses(Model model) {
		model.addAttribute("classList", data.getClassList());
		return "class_list";
	}
	
	// class_info ���� classId ���� �޾ƿ;��ϱ� ������ @PathVariable �ۼ� 
	
	@GetMapping("/classes/{classId}")
	public String getClassInfo(@PathVariable("classId") String classId,
			Model model) {
		model.addAttribute("classInfo", data.getClassInfo(classId));
		return "class_info";
	}
	
	@GetMapping("/teachers")
	public String getTeachers(Model model) {
		model.addAttribute("teacherList", data.getTeacherList());
		return "teacher_list";
	}
	
	@GetMapping("/teachers/{teacherId}")
	public String getTeacherInfo(@PathVariable("teacherId") String teacherId,
			Model model) {
		model.addAttribute("teacherInfo", data.getTeacherInfo(teacherId));
		return "teacher_info";
	}
	
	
	
}

package mypack;

import java.util.List;

public class StudentBO {
	
	StudentDAO studentdao;
	public StudentBO ( StudentDAO studentdao) {
		this.studentdao = studentdao;
	}
	
	public void addStudent(Student student) {
		studentdao.addStudent(student);
	}
	
	public List<Student> getStudent() {
		List<Student> student = studentdao.getListStudent();
		return student;
	}
}

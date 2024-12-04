package mypack;

import java.util.List;

public interface StudentDAO {
	
	void addStudent(Student st);
	List<Student> getListStudent();
}

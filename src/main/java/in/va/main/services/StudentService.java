package in.va.main.services;

import java.util.List;

import in.va.main.entities.Student;

public interface StudentService {
	public Student createStudent(Student employee);
	public List<Student> getStudents();
	public void deleteStudent(long id);
}

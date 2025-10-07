package in.va.main.services;

import java.util.List;
import java.util.Optional;

import in.va.main.entities.Student;

public interface StudentService {
	public Student createStudent(Student student);
	public List<Student> getStudents();
	public Optional<Student> getStudent(long id);
	public void deleteStudent(long id);
}

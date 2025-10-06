package in.va.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.va.main.entities.Student;

public interface StudentService {
	public Student createStudent(Student student);
	public List<Student> getStudents();
}

package in.va.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.va.main.entities.Student;
import in.va.main.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudent(long id) {
		return studentRepository.findById(id);
	}
	
	@Override
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}

}

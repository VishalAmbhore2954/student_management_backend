package in.va.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.va.main.entities.Student;
import in.va.main.repositories.EmployeeRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Student createStudent(Student employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Student> getStudents() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteStudent(long id) {
		employeeRepository.deleteById(id);
	}
	
}

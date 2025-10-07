package in.va.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.va.main.entities.StudentLogs;
import in.va.main.repositories.StudentLogsRepository;

@Service
public class StudentLogsServiceImpl implements StudentLogsService{
	
	@Autowired
	private StudentLogsRepository studentLogsRepository;

	@Override
	public StudentLogs createStudentLogs(StudentLogs logs) {
		return studentLogsRepository.save(logs);
	}

	@Override
	public List<StudentLogs> getStudentsLogs() {
		return studentLogsRepository.findAll();
	}
	
}

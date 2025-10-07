package in.va.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.va.main.entities.StudentLogs;
import in.va.main.services.StudentLogsService;

@RestController
public class StudentLogsController {
	
	@Autowired
	private StudentLogsService studentlogsService;
	
	@GetMapping("studentslogs")
	public List<StudentLogs> getStudentlogs(){
		return studentlogsService.getStudentsLogs();
	}
}

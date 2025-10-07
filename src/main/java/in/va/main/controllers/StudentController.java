package in.va.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.va.main.entities.Student;
import in.va.main.entities.StudentLogs;
import in.va.main.services.StudentLogsService;
import in.va.main.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentLogsService studentLogsService;
	
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@GetMapping("students")
	public List<Student> getStudents(){
		return studentService.getStudents();
		
	}
	
	@GetMapping("students/{id}")
	public Optional<Student> getStudent(@PathVariable long id){
		return studentService.getStudent(id);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable long id,@RequestParam String deletedByEmail) {
		Optional<Student> studentOpt = studentService.getStudent(id);
		
		if(studentOpt.isPresent()) {
	        Student student = studentOpt.get();

	        // Create log
	        StudentLogs log = new StudentLogs();
//	        log.setId(id);
	        log.setName(student.getFullname());
	        log.setDeletedby(deletedByEmail);
	        log.setEmail(student.getEmail());
	        log.setMobilenumber(student.getMobilenumber());
	        log.setDeleted_at(java.time.LocalDateTime.now());

	        studentLogsService.createStudentLogs(log);

	        // Delete student
	        studentService.deleteStudent(id);
	        
	        Map<String, String> response = new HashMap<>();
		    response.put("message", "Student deleted successfully");
		    
		    return ResponseEntity.ok(response);
	    } else {
	        throw new RuntimeException("Student not found with ID " + id);
	    }
		
	}
}

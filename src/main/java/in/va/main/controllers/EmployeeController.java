package in.va.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.va.main.entities.Student;
import in.va.main.services.StudentService;

@RestController
public class EmployeeController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@GetMapping("/student")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable long id){
		studentService.deleteStudent(id);
		Map<String, String> response = new HashMap<>();
	    response.put("message", "Student deleted successfully");
	    
	    return ResponseEntity.ok(response);
	}
}

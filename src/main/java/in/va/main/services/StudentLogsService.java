package in.va.main.services;

import java.util.List;

import in.va.main.entities.StudentLogs;

public interface StudentLogsService {
	public StudentLogs createStudentLogs(StudentLogs logs);
	public List<StudentLogs> getStudentsLogs();
}

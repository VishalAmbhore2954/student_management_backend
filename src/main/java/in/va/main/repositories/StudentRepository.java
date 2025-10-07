package in.va.main.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import in.va.main.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
	
}

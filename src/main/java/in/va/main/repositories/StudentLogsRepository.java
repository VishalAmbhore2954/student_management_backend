package in.va.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.va.main.entities.StudentLogs;

@Repository
public interface StudentLogsRepository extends JpaRepository<StudentLogs,Long>{

}
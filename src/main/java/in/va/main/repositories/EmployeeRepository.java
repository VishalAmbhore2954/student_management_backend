package in.va.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.va.main.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}

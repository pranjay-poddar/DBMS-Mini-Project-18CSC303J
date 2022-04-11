package net.ems.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Formula;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.ems.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	//@Query("select new net.ems.springboot.dto.EmployeeSearchDto(e.first_name, e.last_name, e.position, e.leaves, e.posting, e.email_id, e.phone) from employees e where lower(e.firstname) like lower(concat('%', :str, '%')) nativeQuery = true")
	List<Employee> findByfirstnameStartingWith(@Param("str") String str);




	
//	@Query("select new net.ems.springboot.dto.EmployeeSearchDto(e.first_name, e.last_name, e.position, e.leaves, e.posting, e.email_id, e.phone) from employees e")
//	List<Employee> searchByfirst_name(String str);


	


}

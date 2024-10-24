package nauka.test.repository;

import nauka.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM Employee WHERE id=?1;", nativeQuery = true)
    Employee findEmployeeBy(Long employeeId);

    @Query(value = "SELECT name FROM Employee GROUP BY name;", nativeQuery = true)
    Set<String> groupByName();

    @Query(value = "SELECT * FROM Employee WHERE birth_date>=?1 AND birth_date<=?2;", nativeQuery = true)
    List<Employee> findBetweenBirthDate(LocalDate from, LocalDate to);
}

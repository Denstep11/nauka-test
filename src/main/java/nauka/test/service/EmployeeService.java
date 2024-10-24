package nauka.test.service;

import lombok.RequiredArgsConstructor;
import nauka.test.model.Employee;
import nauka.test.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee findById(Long id) {
        Employee employee = employeeRepository.findEmployeeBy(id);
        if (employee == null) {
            System.out.println("Employee not found");
        }
        else {
            System.out.println(employee);
        }
        return employee;
    }

    public Set<String> groupByName() {
        Set<String> names = employeeRepository.groupByName();
        for (String name : names) {
            System.out.println(name);
        }
        return names;
    }

    public List<Employee> findBetween(LocalDate from, LocalDate to){
        List<Employee> employees = employeeRepository.findBetweenBirthDate(from, to);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        return employees;
    }
}

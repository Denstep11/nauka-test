package nauka.test;

import lombok.RequiredArgsConstructor;
import nauka.test.model.Employee;
import nauka.test.repository.EmployeeRepository;
import nauka.test.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class TestApplication {

	private final EmployeeService employeeService;
	private final EmployeeRepository employeeRepository;

	public static void main(String[] args){
		SpringApplication.run(TestApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunnerBean() {
		return (args) -> {
			//заполнение таблицы
			employeeRepository.save(Employee.builder().name("Александр")
					.surname("Пушкин").birthDate(LocalDate.of(1989, 1, 12))
					.department("it").salary(215000L).build());

			employeeRepository.save(Employee.builder().name("Саша")
					.surname("Иванов").birthDate(LocalDate.of(2000, 1, 12))
					.department("finance").salary(80000L).build());

			employeeRepository.save(Employee.builder().name("Саша")
					.surname("Смирнов").birthDate(LocalDate.of(2003, 1, 12))
					.department("it").salary(60000L).build());

			employeeRepository.save(Employee.builder().name("Андрей")
					.surname("Лисицин").birthDate(LocalDate.of(1995, 1, 12))
					.department("analytics").salary(350000L).build());

			//поиск по id
			employeeService.findById(1L);
			employeeService.findById(3L);
			employeeService.findById(5L);

			//группировка по имени
			employeeService.groupByName();

			//поиск между датами
			employeeService.findBetween(LocalDate.of(1995, 6, 21),
					LocalDate.of(2004, 10, 22));

		};
	}
}

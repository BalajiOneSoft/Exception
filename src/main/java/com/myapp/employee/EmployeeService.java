package com.myapp.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmployee(List<Employee> e) {

		return empDao.addEmployee(e);
	}

	public Employee getEmployee(int id) {
		return empDao.getEmployee(id);
	}

	public String postEmployee(@RequestBody Employee e) {

		return empDao.postEmployee(e);
	}

	public List<Employee> findEmployee() {
		return empDao.findEmployee();
	}

	public String deleteEmployee(int id) {
		return empDao.deleteEmployee(id);

	}

	public String updateEmployee(@RequestBody Employee e) {
		return empDao.updateEmployee(e);

	}

	public List<Employee> getIncreaseSalary() {
		List<Employee> a = empDao.getAllEmployees();

		return a.stream().map(x -> {
			if (x.getAge() >= 30 && x.getAge() <= 35)

			{
				x.setSalary(x.getSalary() + x.getSalary() * 10 / 100);

			}
			if (x.getAge() >= 35 && x.getAge() <= 40) {
				x.setSalary(x.getSalary() + x.getSalary() * 20 / 100);

			}
			if (x.getAge() >= 40 && x.getAge() <= 50)

			{
				x.setSalary(x.getSalary() + x.getSalary() * 10 / 100);

			}
			return x;
		}).collect(Collectors.toList());
	}

	public List<Employee> getByGender(String gender) {

		List<Employee> a = empDao.getAllEmployees();
		return a.stream().filter(x -> x.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
	}

	public List<Employee> getByAge(int age) {

		List<Employee> b = empDao.getAllEmployees();
		return b.stream().filter(x -> x.getAge() == age).collect(Collectors.toList());
	}

	public List<Employee> getBySalary(int salary) {

		List<Employee> b = empDao.getAllEmployees();
		return b.stream().filter(x -> x.getSalary() == salary).collect(Collectors.toList());
	}

	public List<Employee> getById(int id) {

		List<Employee> b = empDao.getAllEmployees();
		return b.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
	}

	public List<Employee> getEmployeesBySalary(@PathVariable int salary) {
		return empDao.getEmployeesBySalary(salary);

	}

	public List<Employee> getEmployeesByAge(@PathVariable int age) {
		return empDao.getEmployeesByAge(age);

	}

	public int getMaxSalary() {
		return empDao.getMaxSalary();
	}

	public String addEmployees(Employee e) throws InvalidAgeException {
		try {
			if (e.getAge() < 18) {
				throw new InvalidAgeException("age below 18");
			} else {

				return empDao.addEmployees(e);
			}
		} catch (InvalidAgeException ae) {
			return ae.getMessage();
		}
	}

	public List<Employee> getEmployeesByName(@PathVariable String name) throws InvalidNameException {

		List<Employee> li = empDao.getEmployeesByName(name);
		if (li.isEmpty()) {
			throw new InvalidNameException("name not found");
		} else {

			return empDao.getEmployeesByName(name);
		}
	}
	
	public List<Employee> getEmployeesById(int id)throws InvalidIdException {
		List<Employee> li = empDao.getEmployeesById(id);
		List<Employee> lii = li.stream().filter(x->x.getId()==(id)).collect(Collectors.toList());
		if(li.isEmpty()) {
			throw new InvalidIdException("id not found");
		}else {
			return lii;
		}
	}
	
	
	

}

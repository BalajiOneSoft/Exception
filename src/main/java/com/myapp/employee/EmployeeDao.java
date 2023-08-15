package com.myapp.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;

	public String addEmployee(List<Employee> e) {

		empRepo.saveAll(e);
		return "successfully added";
	}

	public Employee getEmployee(int id) {

		return empRepo.findById(id).get();
	}

	public String postEmployee(Employee e) {

		empRepo.save(e); 
		return "successfully added";
	}

	public List<Employee> findEmployee() {
		return empRepo.findAll();
	}
	public String deleteEmployee(int id) {
		empRepo.deleteById(id);
		return "successfully deleted";

}
	public String updateEmployee( Employee e) {
	empRepo.save(e);
	return "updated successfully";
}
	public String deleteeAll() {
	empRepo.deleteAll();
	return "deleted successfully";
}
	 public List<Employee> getAllEmployees(){
		 return empRepo.findAll();
	 }
	 
	 public List<Employee>getEmployeesBySalary(int salary){
		 
		 return empRepo.getEmployeesBySalary(salary);
		 
	 }
      public List<Employee>getEmployeesByAge(int age){
		 
		 return empRepo.getEmployeesByAge(age);
		 
	 }
      public List<Employee>getEmployeesById(int id){
 		 
 		 return empRepo.getEmployeesById(id);
      } 
      List<Employee>getEmployeesByName(String name){
 		 
 		 return empRepo.getEmployeesByName(name);
 		 
}
       public int getMaxSalary() {
    	   return empRepo.getMaxSalary();
       }
       
       public String addEmployees(Employee e) {
       empRepo.save(e);
       return "Successfully added";
}
       
}



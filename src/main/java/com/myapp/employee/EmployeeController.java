package com.myapp.employee;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empSer;

	@PostMapping(value = "/add")
	public String addEmployee(@RequestBody List<Employee> e) {
		return empSer.addEmployee(e);
	}

	@GetMapping(value = "/get/{id}")
	public Employee getEmployee(@PathVariable int id) {

		return empSer.getEmployee(id);
	}

	@PostMapping(value = "/post")
	public String postEmployee(@RequestBody Employee e) {
		return empSer.postEmployee(e);
	}
	
	

	@GetMapping(value = "/find")
	public List<Employee> findEmployee() {
		return empSer.findEmployee();

	}
	
	@GetMapping (value="/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return empSer.deleteEmployee(id);
	}
	@PutMapping(value="/update")
	public String updateEmployee(@RequestBody Employee e) {
		return empSer.updateEmployee(e);
	}
    
     
     @PutMapping(value="/increasesalary")
     public List<Employee> getIncreaseSalary(){
    	 
    	return empSer.getIncreaseSalary();
     }
     
//     getbygender
     
     @GetMapping(value = "/getByGender/{gender}")
     public  List<Employee> getByGender(@PathVariable String gender){
    	 return empSer.getByGender(gender);
     }
     
//     getbyage
     
     @GetMapping(value = "/getByAge/{age}")
     public  List<Employee> getByGender(@PathVariable int age){
    	 return empSer.getByAge(age);
     }
     
     @GetMapping(value = "/getBySalaries/{salary}")
     public  List<Employee> getBySalary(@PathVariable int salary){
    	 return empSer.getBySalary(salary);
     }
     
     @GetMapping(value = "/getById/{id}")
     public  List<Employee> getById(@PathVariable int id){
    	 return empSer.getById(id);
     
     }
     @GetMapping(value = "/getEmployeeBySalaries/{salary}")
     public  List<Employee> getEmployeesBySalary(@PathVariable int salary){
    	 return empSer.getEmployeesBySalary(salary);
     }
     
     @GetMapping(value = "/getEmployeeByAges/{age}")
     public  List<Employee> getEmployeesByAge(@PathVariable int age){
    	 return empSer.getEmployeesByAge(age);
     }
    
     
     
      
     @GetMapping (value = "/getMaxiSalary")
     public int  getMaxSalary(){
    	 return empSer.getMaxSalary();
     }
     

 	@PostMapping(value = "/addException")
 	public String addEmployees(@RequestBody Employee e)throws InvalidAgeException {
 		return empSer.addEmployees(e);
 	}
 	
 	@GetMapping(value ="/nameException/{name}")
 	public List<Employee> getEmployeeByName( @PathVariable String name) throws InvalidNameException {
 		return empSer.getEmployeesByName(name);
 	}
 	@GetMapping(value ="/idException/{id}")
 	public List<Employee> getEmployeesById( @PathVariable int id) throws InvalidIdException {
 		return empSer.getEmployeesById(id);
 	}
 	
 

	
		RestTemplate rest = new RestTemplate();
		
		@GetMapping(value="/getCarViaEmployee")
		public List<Car> findCars() {
			
			String Url = "http://localhost:8081/car/find";
			
			ResponseEntity <List<Car>> arr =  rest.exchange(Url,HttpMethod.GET,null,new ParameterizedTypeReference<List<Car>>() {});
			List<Car> value = (List<Car>) arr.getBody();
			return value;
			
		}
         RestTemplate rest1 = new RestTemplate();
		
		@GetMapping(value="/getCarViaEmployeeId/{id}")
		public Car findCarsById(@PathVariable int id) {
			
			String Url = "http://localhost:8081/car/get/";
			
			ResponseEntity <Car> arr1 =  rest.exchange(Url+id,HttpMethod.GET,null,Car.class);
			Car value1 =  arr1.getBody();
			return value1;
			
		


     
}
		public void hi() {
		     System.out.println("hello");
		}
}


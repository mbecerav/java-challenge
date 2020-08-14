package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.retrieveEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee){
        //Validate the data to prevent NULL records
        if(employee.getDepartment() == null || employee.getName() == null
        		|| employee.getSalary() == null)
        	return "Check the correct structure of the data";
        
        else {
        	employeeService.saveEmployee(employee);
        System.out.println("Employee Saved Successfully");
        return "Employee Saved Successfully";
        }
    }
    
    //Add a descriptive response for the user
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        try {
        	employeeService.deleteEmployee(employeeId);
        }
        catch(Error e) {
        	System.out.println("Error: "+e);
        	return "Error: "+e;
        }
    	System.out.println("Employee Deleted Successfully");
    	return "Employee Deleted Successfully";
    }

    @PutMapping("/employees/{employeeId}")
    public String updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name="employeeId")Long employeeId){
        Employee emp = employeeService.getEmployee(employeeId);
        
        if(emp.getId()!=null) {
        
	        if(emp != null){
	        	//Set ID from request to Update the requested record
	        	//and not create a new record (if Id is not sended on body)
	        	employee.setId(employeeId);
	        	
	        	//check modifications to build the new object to update
	        	if (employee.getDepartment()==null)
	        		employee.setDepartment(emp.getDepartment());
	        	
	        	if (employee.getName()==null)
	        		employee.setName(emp.getName());
	        	
	        	if (employee.getSalary()==null)
	        		employee.setSalary(emp.getSalary());
	        	
	            employeeService.updateEmployee(employee);
	        }
	        return "Employee Updated Successfully";
        }
        else
        	return "The Employee with ID "+ employeeId +" does not exist!";

    }

}

package net.ngg.example.controller.exercise;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.ngg.example.entity.exercise.Employee;
import net.ngg.example.service.exercise.EmployeeService;

@Controller
@RequestMapping(value="/example")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/listEmployee", method=RequestMethod.GET)
	public String listEmployees(ModelMap map) {
		map.addAttribute("employee", new Employee());
		map.addAttribute("employeeList", employeeService.getAllEmployees());
		return "employeeList";
	}
	
	// ModelMap与Map的区别：http://stackoverflow.com/questions/2902706/modelmap-usage-in-spring
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String listEmployees(Map<String, Object> map) {
		map.put("employee", new Employee());
		map.put("employeeList", employeeService.getAllEmployees());
		return "employeeList";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addEmployee(@ModelAttribute(value="employee") Employee employee, BindingResult result) {
		employeeService.addEmployee(employee);
		return "redirect:/";   // 或者"redirect:/index"
	}
	
	@RequestMapping("/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		employeeService.deleteEmployee(employeeId);
		return "redirect:/";   // 或者"redirect:/index"
	}
}

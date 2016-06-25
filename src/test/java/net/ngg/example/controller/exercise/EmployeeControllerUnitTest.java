package net.ngg.example.controller.exercise;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.beans.HasPropertyWithValue;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import net.ngg.example.entity.exercise.Employee;
import net.ngg.example.service.exercise.EmployeeService;

/**
 * 从下面的网址看spring如何做测试
 * https://github.com/spring-projects/spring-mvc-showcase
 * 主要使用了如下4个东西：
 * 1. JUnit -- General unit test framework.
 * 2. Mockito -- To mock EmployeeService.
 * 3. Spring MVC Test Framework -- To properly test the controller
 * 4. Hamcrest -- To clean way to assert the actual result is correct.
 *
 */

public class EmployeeControllerUnitTest {
	@Mock
	private EmployeeService employeeService;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}

	@Test
	public void testGetEmployee() throws Exception {
		when(employeeService.getEmployee(1)).thenReturn(new Employee(1, "牛", "宏睿"));
		mockMvc.perform(get("/example/employee/{id}", 1))
			.andExpect(status().isOk())
			.andExpect(view().name("employeeView"))
			.andExpect(model().attribute("employeeData", 
										 AllOf.allOf(hasProperty("id", Is.is(1)),
										 HasPropertyWithValue.hasProperty("firstname", is("牛")),
										 hasProperty("lastname", is("宏睿")))));
	}
}

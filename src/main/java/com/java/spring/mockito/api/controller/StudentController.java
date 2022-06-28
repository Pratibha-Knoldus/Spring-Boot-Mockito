package com.java.spring.mockito.api.controller;

import java.util.List;

import com.java.spring.mockito.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.mockito.api.model.Student;

/**
 * The type Student controller.
 */
@RestController
public class StudentController {
	@Autowired
	private StudentService service;

	/**
	 * Save student student.
	 *
	 * @param student the student
	 * @return the student
	 */
	@PostMapping(value = "/save")
	public Student saveStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}

	/**
	 * Find all students list.
	 *
	 * @return the list
	 */
	@GetMapping("/getStudents")
	public List<Student> findAllStudents() {
		return service.getStudents();
	}

	/**
	 * Find student by address list.
	 *
	 * @param address the address
	 * @return the list
	 */
	@GetMapping("/getStudentByAddress/{address}")
	public List<Student> findStudentByAddress(@PathVariable String address) {
		return service.getStudentbyAddress(address);
	}

	/**
	 * Remove student student.
	 *
	 * @param student the student
	 * @return the user
	 */
	@DeleteMapping(value="/remove")
	public Student removeStudent(@RequestBody Student student) {
		service.deleteStudent(student);
		return student;
	}
}

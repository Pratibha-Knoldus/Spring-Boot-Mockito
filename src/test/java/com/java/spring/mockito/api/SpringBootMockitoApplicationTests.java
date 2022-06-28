package com.java.spring.mockito.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.spring.mockito.api.dao.StudentRepository;
import com.java.spring.mockito.api.model.Student;
import com.java.spring.mockito.api.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The type Spring boot mockito application tests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoApplicationTests {

	@Autowired
	private StudentService service;

	@MockBean
	private StudentRepository repository;

	/**
	 * Gets students test.
	 */
	@Test
	public void getStudentsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Student(376, "sneha", 31, "USA"), new Student(958, "abhi", 15, "UK")).collect(Collectors.toList()));
		assertEquals(2, service.getStudents().size());
	}

	/**
	 * Gets studentby address test.
	 */
	@Test
	public void getStudentByAddressTest() {
		String address = "Mumbai";
		when(repository.findByAddress(address))
				.thenReturn(Stream.of(new Student(376, "sneha", 31, "USA")).collect(Collectors.toList()));
		assertEquals(1, service.getStudentbyAddress(address).size());
	}

	/**
	 * Save student test.
	 */
	@Test
	public void saveStudentTest() {
		Student student = new Student(999, "Pranya", 33, "Pune");
		when(repository.save(student)).thenReturn(student);
		Assert.assertEquals(student, service.addStudent(student));
	}

	/**
	 * Delete student test.
	 */
	@Test
	public void deleteStudentTest() {
		Student student = new Student(999, "Pranya", 33, "Pune");
		service.deleteStudent(student);
		verify(repository, times(1)).delete(student);
	}

}

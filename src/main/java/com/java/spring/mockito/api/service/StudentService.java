package com.java.spring.mockito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.mockito.api.dao.StudentRepository;
import com.java.spring.mockito.api.model.Student;

/**
 * The type Student service.
 */
@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;


	/**
	 * Add student student.
	 *
	 * @param student the student
	 * @return the student
	 */
	public Student addStudent(Student student) {
		return repository.save(student);
	}

	/**
	 * Gets students.
	 *
	 * @return the students
	 */
	public List<Student> getStudents() {
		List<Student> students = repository.findAll();
		System.out.println("Getting data from DB : " + students);
		return students;
	}

	/**
	 * Gets student by address.
	 *
	 * @param address the address
	 * @return the student by address
	 */
	public List<Student> getStudentbyAddress(String address) {
		return repository.findByAddress(address);
	}

	/**
	 * Delete student.
	 *
	 * @param student the student
	 */
	public void deleteStudent(Student student) {
		repository.delete(student);
	}
}

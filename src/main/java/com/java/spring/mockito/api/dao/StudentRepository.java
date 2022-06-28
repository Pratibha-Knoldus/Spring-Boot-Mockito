package com.java.spring.mockito.api.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.spring.mockito.api.model.Student;

/**
 * The interface Studnet repository.
 */
public interface StudentRepository extends MongoRepository<Student, Integer>{

	/**
	 * Find by address list.
	 *
	 * @param address the address
	 * @return the list
	 */
	List<Student> findByAddress(String address);

}

package com.mapping.service;

import java.util.List;

import com.mapping.dto.StudentDto;
import com.mapping.entity.Student;

public interface StudentService {

	// create
	Student createStudent(StudentDto studentDto);

	
	StudentDto getById(Long id);

	// getAll
	List<StudentDto> getAllStudent();

	//deleteById
	void deleteById(Long id);

	Student findById(Long id);
	
	void softDeletedById(Long id);
	
//	List<StudentDto> findByName(String query);

}

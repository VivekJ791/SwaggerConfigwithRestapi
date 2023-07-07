package com.mapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mapping.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

//	@Query("select count(s) from Student s where address Like Concat('%,:query,'%')")
//	List<Student> findByName(String query);
	
}

package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
	

}

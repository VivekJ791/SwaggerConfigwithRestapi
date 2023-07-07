package com.mapping.service;

import java.util.List;

import com.mapping.dto.SubjectDto;
import com.mapping.entity.Subject;

public interface SubjectService {

	// create

	Subject createSubject(SubjectDto subjectDto);

	// getById

	SubjectDto getById(Long id);

	// getAll

	List<SubjectDto> getAll();

	// deleteById

	void deleteById(Long id);

}

package com.mapping.helper;

import org.springframework.stereotype.Component;

import com.mapping.dto.SubjectDto;
import com.mapping.entity.Subject;

@Component
public class SubjectHelper {

	public SubjectDto getSubjectDto(Subject subject) {
		return SubjectDto.builder().id(subject.getSubjectId()).maths(subject.getMaths())
				.chemistry(subject.getChemistry()).physics(subject.getPhysics())
				.studentId(subject.getStudent() != null ? subject.getStudent().getId() : null)
				.build();
	}
	
	public Subject getSubjectFromDto(SubjectDto subjectDto) {
		return Subject.builder().subjectId(subjectDto.getId()).maths(subjectDto.getMaths())
				.chemistry(subjectDto.getChemistry()).physics(subjectDto.getPhysics()).build();
	}

}

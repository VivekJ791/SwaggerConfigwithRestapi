package com.mapping.helper;

import org.springframework.stereotype.Component;

import com.mapping.dto.StudentDto;
import com.mapping.entity.Student;

@Component
public class StudentHelper {

	public StudentDto getStudentDto(Student student) {
		return StudentDto.builder().id(student.getId()).address(student.getAddress()).name(student.getName())
			//	.createdOn(student.getCreatedOn()).active(student.getActive()).deleted(student.getDeleted())
				//.updatedOn(student.getUpdatedOn())
				.rollNo(student.getRollNo()).build();
	}

	public Student getStudentFromDto(StudentDto studentDto) {
		return Student.builder().address(studentDto.getAddress()).name(studentDto.getName())
				.rollNo(studentDto.getRollNo()).build();
	}

}

package com.mapping.dto;

import java.util.Date;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {

	Long id;
	String name;
	String address;
	int rollNo;

	Date createdOn;
	Date updatedOn;
	Boolean deleted = false;
	Boolean active = true;

	List<SubjectDto> subjectDtos;
}

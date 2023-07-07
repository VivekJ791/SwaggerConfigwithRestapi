package com.mapping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectDto {

	private Long id;
	private String maths;
	private String physics;
	private String chemistry;
	private Long studentId;

//	private StudentDto studentDto;

}

package com.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.dto.StudentDto;
import com.mapping.entity.Student;
import com.mapping.helper.StudentHelper;
import com.mapping.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentHelper studentHelper;

	@PostMapping("/student")
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
		Student createStudent = this.studentService.createStudent(studentDto);
		StudentDto studentDto2 = this.studentHelper.getStudentDto(createStudent);
		return new ResponseEntity<StudentDto>(studentDto2, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> getById(@PathVariable Long id) {
		StudentDto studentDto = this.studentService.getById(id);
		return ResponseEntity.ok(studentDto);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<StudentDto>> getAll() {

		return ResponseEntity.ok(this.studentService.getAllStudent());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<StudentDto> deleteById(@PathVariable Long id) {
		this.studentService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/softDeleted/{id}")
	public ResponseEntity<StudentDto> softDeletedById(@PathVariable Long id){
		this.studentService.softDeletedById(id);
		return new ResponseEntity<StudentDto>(HttpStatus.OK);
	}
	
//	@GetMapping("/byName")
//	public ResponseEntity<List<StudentDto>> getByNmae(@RequestParam("query") String query){
//		List<StudentDto> findByName = this.studentService.findByName(query);
//		return new ResponseEntity<List<StudentDto>>(findByName,HttpStatus.OK);
//	}
}

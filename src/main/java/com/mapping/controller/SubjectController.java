package com.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.dto.SubjectDto;
import com.mapping.service.SubjectService;

@RestController
@RequestMapping("/api/sub")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@PostMapping("/createUpdate")
	public ResponseEntity<SubjectDto> createUpdate(@RequestBody SubjectDto subjectDto) {
		this.subjectService.createSubject(subjectDto);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<SubjectDto> getById(@PathVariable Long id) {
		SubjectDto byId = this.subjectService.getById(id);
		return ResponseEntity.ok(byId);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<SubjectDto>> getAll() {
		List<SubjectDto> all = this.subjectService.getAll();
		return ResponseEntity.ok(all);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<SubjectDto> deleteById(@PathVariable Long id) {
		this.subjectService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}

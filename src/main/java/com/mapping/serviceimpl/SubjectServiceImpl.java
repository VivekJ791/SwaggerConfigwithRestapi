package com.mapping.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.dto.SubjectDto;
import com.mapping.entity.Student;
import com.mapping.entity.Subject;
import com.mapping.helper.StudentHelper;
import com.mapping.repository.StudentRepository;
import com.mapping.repository.SubjectRepository;
import com.mapping.service.StudentService;
import com.mapping.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private StudentService studentService;
	
	//private StudentHelper studentHelper;

	@Override
	public Subject createSubject(SubjectDto subjectDto) {
		Subject subject;
		if (subjectDto.getId() != null) {
			subject = this.subjectRepository.findById(subjectDto.getId())
					.orElseThrow(() -> new NoSuchElementException());
		} else {
			subject = new Subject();
		}
		subject.setMaths(subjectDto.getMaths());
		subject.setChemistry(subjectDto.getChemistry());
		subject.setPhysics(subjectDto.getPhysics());
		subject.setStudent(studentService.findById(subjectDto.getStudentId()));
//		Student student = studentService.createStudent(subjectDto.getStudentDto());
//		subject.setStudent(student);
		this.subjectRepository.save(subject);
		return subject;

	}

	@Override
	public SubjectDto getById(Long id) {
		Optional<Subject> findById = this.subjectRepository.findById(id);

		return this.subjectToDto(findById.get());
	}

	@Override
	public List<SubjectDto> getAll() {
		List<Subject> findAll = this.subjectRepository.findAll();
		List<SubjectDto> collect = findAll.stream().map(this::subjectToDto).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deleteById(Long id) {
		this.subjectRepository.deleteById(id);

	}

	private Subject dtoToSubject(SubjectDto subjectDto) {

		Subject subject = new Subject();
		subject.setMaths(subjectDto.getMaths());
		subject.setChemistry(subjectDto.getChemistry());
		subject.setPhysics(subjectDto.getPhysics());

		return subject;

	}

	private SubjectDto subjectToDto(Subject subject) {
		SubjectDto subjectDto = new SubjectDto();
		subjectDto.setId(subject.getSubjectId());
		subjectDto.setChemistry(subject.getChemistry());
		subjectDto.setPhysics(subject.getPhysics());
		subjectDto.setMaths(subject.getMaths());

		return subjectDto;
	}
}

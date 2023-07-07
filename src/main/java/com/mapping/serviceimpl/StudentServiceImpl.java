package com.mapping.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.dto.StudentDto;
import com.mapping.dto.SubjectDto;
import com.mapping.entity.Student;
import com.mapping.entity.Subject;
import com.mapping.helper.StudentHelper;
import com.mapping.helper.SubjectHelper;
import com.mapping.repository.StudentRepository;
import com.mapping.repository.SubjectRepository;
import com.mapping.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private SubjectHelper subjectHelper;

	@Autowired
	private StudentHelper studentHelper;

	@Override
	public Student createStudent(StudentDto studentDto) {
		Student student;
		if (studentDto.getId() != null) {
			student = this.studentRepository.findById(studentDto.getId())
					.orElseThrow(() -> new NoSuchElementException());

		} else {
			student = new Student();
		}
		student.setName(studentDto.getName());
		student.setRollNo(studentDto.getRollNo());
		student.setAddress(studentDto.getAddress());
//		List<Subject> subjectList = studentDto.getSubjectDtos().stream().map(subjectHelper::getSubjectFromDto)
//				.collect(Collectors.toList());
//		for (Subject subject : subjectList) {
//			subject.setStudent(student);
//		}
//		subjectRepository.saveAll(subjectList);
//		student.setSubjects(subjectList);
		this.studentRepository.save(student);
		return student;
	}

//	@Override
//	public StudentDto updateStudent(StudentDto studentDto, Long id) {
//
//		Student existingStudent = this.studentRepository.findById(id).orElseThrow(()->new NoSuchElementException());
//		
//		Student student = this.studentRepository.findById(id).orElse(new Student());
//		
//		return null;
//	}

	@Override
	public StudentDto getById(Long id) {

		Student orElseThrow = this.studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student Not Found"));
		StudentDto studentDto = this.studentHelper.getStudentDto(orElseThrow);
		return studentDto;
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> findAll = this.studentRepository.findAll();
		return findAll.stream().map(studentHelper::getStudentDto).collect(Collectors.toList());

	}

	@Override
	public void deleteById(Long id) {
		this.studentRepository.deleteById(id);

	}

	public StudentDto dtoToStudent(StudentDto studentDto) {
		StudentDto student = new StudentDto();
		student.setName(studentDto.getName());
		student.setRollNo(studentDto.getRollNo());
		student.setAddress(studentDto.getAddress());

		return student;

	}

	public StudentDto studentToDto(Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setId(student.getId());
		studentDto.setAddress(student.getAddress());
		studentDto.setName(student.getName());
		studentDto.setRollNo(student.getRollNo());
		List<Subject> subjects = student.getSubjects();
		List<SubjectDto> subjectDtos = subjects.stream().map(subjectHelper::getSubjectDto).collect(Collectors.toList());
		studentDto.setSubjectDtos(subjectDtos);
		return studentDto;
	}

	@Override
	public Student findById(Long id) {
		return this.studentRepository.findById(id).orElseThrow((() -> new RuntimeException("not found ")));
	}

	@Override
	public void softDeletedById(Long id) {
		Student student = this.studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student Not Found"));
	//	student.setDeleted(true);
		this.studentRepository.save(student);
	}

//	@Override
//	public List<StudentDto> findByName(String query) {
//		List<Student> byName = this.studentRepository.findByName(query);
//		return byName.stream().map(studentHelper::getStudentDto).collect(Collectors.toList());
//	}


}

package com.example.VueFullStack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VueFullStack.model.Student;
import com.example.VueFullStack.repository.IStudentRepository;
import com.example.VueFullStack.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	@Autowired
	IStudentRepository studentRepository;

	@Override
	public Student insertStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.insertStudent(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.getAllStudent();
	}

	@Override
	public Student updateStudent(int id, Student student) {
		// TODO Auto-generated method stub
		return studentRepository.updateStudent(id, student);
	}

	@Override
	public Student deleteStudent(int id) {
		// TODO Auto-generated method stub
		return studentRepository.deleteStudent(id);
	}

	@Override
	public Student getIdStudent(long id) {
		// TODO Auto-generated method stub
		return studentRepository.CariIdStudent(id);
	}

}

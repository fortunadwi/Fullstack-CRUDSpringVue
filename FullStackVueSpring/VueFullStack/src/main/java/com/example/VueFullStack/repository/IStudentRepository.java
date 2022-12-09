package com.example.VueFullStack.repository;

import java.util.List;

import com.example.VueFullStack.model.Student;

public interface IStudentRepository {
	public Student insertStudent(Student student);
	public List<Student> getAllStudent();
	public Student updateStudent(int id, Student student);
	public Student deleteStudent(int id);
	public Student CariIdStudent(long id);
}

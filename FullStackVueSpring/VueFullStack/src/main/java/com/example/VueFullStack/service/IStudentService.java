package com.example.VueFullStack.service;

import java.util.List;
import com.example.VueFullStack.model.Student;

public interface IStudentService {
	public Student insertStudent(Student student);
	public Student updateStudent(int id, Student student);
	public Student deleteStudent(int id);
	public List<Student> getAllStudent();
	public Student getIdStudent(long id);
}

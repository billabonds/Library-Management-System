package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entity.Student;

import java.util.List;

public interface StudentService {

    public String addStudent(Student student);

    public String deleteStudent(int studentId);

    public String updateStudentId(int studentId);

    public String findStudentId(int studentId);

    public List<String> allStudents(Student student);
}

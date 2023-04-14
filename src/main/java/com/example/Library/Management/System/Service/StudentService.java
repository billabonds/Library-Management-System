package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.DTO.RequestDto.StudentRequestDto;
import com.example.Library.Management.System.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.UpdateStudentMobResponseDto;
import com.example.Library.Management.System.Entity.Student;
import com.example.Library.Management.System.Exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentService {

    public String addStudent(StudentRequestDto studentRequestDto);


    public UpdateStudentMobResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException;

    public Student getStudentById(int id);


    // ---------------------------------------------------------------------------------


    public String deleteStudent(int studentId);

    public String updateStudentId(int studentId);

    public String findStudentId(int studentId);

    public List<String> allStudents(Student student);
}

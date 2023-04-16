package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.DTO.RequestDto.StudentRequestDto;
import com.example.Library.Management.System.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.StudentResponseDto;
import com.example.Library.Management.System.DTO.ResponseDto.UpdateStudentMobResponseDto;
import com.example.Library.Management.System.Entity.Student;
import com.example.Library.Management.System.Exception.StudentNotFoundException;
import com.example.Library.Management.System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

//    @PostMapping("/add")
//    public String addStudent(@RequestBody Student student){
//
//        return studentService.addStudent(student);
//    }

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){

        return studentService.addStudent(studentRequestDto);
    }

    @PutMapping("update_mobile")
    public UpdateStudentMobResponseDto updateMobNo(@RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {


        return studentService.updateMobNo(updateStudentMobRequestDto);
    }

    @GetMapping("get_student")
    public StudentResponseDto getStudentBtId(@RequestParam int id){

        return studentService.getStudentById(id);
    }



    // ------------------------------- Work (12-04-2023) --------------------------------------

                    // 1. Delete a student by id
                    // 2. Update the student by id
                    // 3. Find a student by id
                    // 4. Find all the students

    // ---------------------------------------------------------------------------------------------

    @DeleteMapping("/delete")                                                                    // 1st API
    public String deleteStudent(@RequestParam int studentId){

        return studentService.deleteStudent(studentId);
    }

    @PutMapping("/updateId")                                                                     // 2nd API
    public String updateStudentId(@RequestParam int studentId){

        return studentService.updateStudentId(studentId);
    }

    @GetMapping("/findStudentId")                                                                // 3rd API
    public String findStudentId(@RequestParam int studentId){

        return studentService.findStudentId(studentId);
    }

    @GetMapping("allStudents")                                                                   // 4th API
    public List<String> allStudents(@RequestBody Student student){

        return studentService.allStudents(student);
    }
}

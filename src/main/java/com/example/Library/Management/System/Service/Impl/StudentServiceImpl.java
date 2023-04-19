package com.example.Library.Management.System.Service.Impl;

import com.example.Library.Management.System.DTO.RequestDto.StudentRequestDto;
import com.example.Library.Management.System.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.CardResponseDto;
import com.example.Library.Management.System.DTO.ResponseDto.StudentResponseDto;
import com.example.Library.Management.System.DTO.ResponseDto.UpdateStudentMobResponseDto;
import com.example.Library.Management.System.Entity.Card;
import com.example.Library.Management.System.Entity.Student;
import com.example.Library.Management.System.Enum.CardStatus;
import com.example.Library.Management.System.Enum.Department;
import com.example.Library.Management.System.Exception.StudentNotFoundException;
import com.example.Library.Management.System.Repository.StudentRepository;
import com.example.Library.Management.System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

        Student student = new Student();

        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2024-12-02");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);
        return "Student added successfully";

        // without - DTO's

//        Card card = new Card();                                       // generate new card for the student
//        card.setCardStatus(CardStatus.ACTIVATED);
//        card.setValidTill("2024-12-30");                              // Format of date - YY:MM:DD
//        card.setStudent(student);
//
//        student.setCard(card);                                        // set card for the student
//        studentRepository.save(student);
//
//        return "Student added successfully";
    }

    @Override
    public UpdateStudentMobResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {


        try{
            Student student = studentRepository.findById(updateStudentMobRequestDto.getId()).get();
            student.setMobNo(updateStudentMobRequestDto.getMobNo());
            Student updateStudent = studentRepository.save(student);

                                // prepare response DTO  (Conversion Entity to DTO)

            UpdateStudentMobResponseDto updateStudentMobResponseDto = new UpdateStudentMobResponseDto();

            updateStudentMobResponseDto.setName(updateStudent.getName());
            updateStudentMobResponseDto.setMobNo(updateStudentMobRequestDto.getMobNo());

            return updateStudentMobResponseDto;
        }
        catch (Exception e){
            throw new StudentNotFoundException("Invalid student Id");
        }

    }

    @Override
    public StudentResponseDto getStudentById(int id) {

        Student student = studentRepository.findById(id).get();

        // prepare studentResponseDto

        StudentResponseDto studentResponseDto = new StudentResponseDto();

        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setMobNo(student.getMobNo());

        CardResponseDto cardResponseDto =  new CardResponseDto();

        cardResponseDto.setId(student.getCard().getId());
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setUpdateOn(student.getCard().getUpdateOn());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setValidTill(student.getCard().getValidTill());

        studentResponseDto.setCardResponseDto(cardResponseDto);

        return studentResponseDto;
    }




    // ------------------------------- Home-Work (12-04-2023) --------------------------------------

    // 1. Delete a student by id
    // 2. Update the student by id
    // 3. Find a student by id
    // 4. Find all the students

    // ---------------------------------------------------------------------------------------------


//    @Override
//    public String deleteStudent(int studentId) {
//
//        return "Student delete successfully";
//    }
//
//    @Override
//    public String updateStudentId(int studentId) {
//        return "Update studentId successfully";
//    }
//
//    @Override
//    public String findStudentId(int studentId) {
//        return "StudentId Found successfully";
//    }
//
//    @Override
//    public List<String> allStudents(Student student) {
//
//        List<String> ans = null;
//
//        return ans;
//    }

}

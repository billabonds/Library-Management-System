package com.example.Library.Management.System.Service.Impl;

import com.example.Library.Management.System.Entity.Card;
import com.example.Library.Management.System.Entity.Student;
import com.example.Library.Management.System.Enum.CardStatus;
import com.example.Library.Management.System.Repository.StudentRepository;
import com.example.Library.Management.System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(Student student) {

        Card card = new Card();                                       // generate new card for the student
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2024-12-30");                              // Format of date - YY:MM:DD
        card.setStudent(student);

        student.setCard(card);                                        // set card for the student
        studentRepository.save(student);

        return "Student added successfully";
    }


    // ------------------------------- Home-Work (12-04-2023) --------------------------------------

    // 1. Delete a student by id
    // 2. Update the student by id
    // 3. Find a student by id
    // 4. Find all the students

    // ---------------------------------------------------------------------------------------------


    @Override
    public String deleteStudent(int studentId) {

        return "Student delete successfully";
    }

    @Override
    public String updateStudentId(int studentId) {
        return "Update studentId successfully";
    }

    @Override
    public String findStudentId(int studentId) {
        return "StudentId Found successfully";
    }

    @Override
    public List<String> allStudents(Student student) {

        List<String> ans = null;

        return ans;
    }

}

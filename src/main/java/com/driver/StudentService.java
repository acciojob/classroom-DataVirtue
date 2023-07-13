package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository = new StudentRepository(); // for accio backened object is required

    public boolean addStudent(Student student) {

        return studentRepository.addStudent(student);
    }

    public boolean addTeacher(Teacher teacher) {
        return studentRepository.addTeacher(teacher);
    }

    public boolean addStudentTeacherPair(String student, String teacher) {
        return studentRepository.addStudentTeacherPair(student,teacher);

    }

    public Student getStudentByName(String name) {

        return studentRepository.getStudentByName(name);

    }

    public Teacher getTeacherByName(String name) {

        return studentRepository.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {

        return studentRepository.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents() {

        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {

       studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}

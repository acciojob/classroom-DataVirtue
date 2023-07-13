package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class StudentRepository {
    Map<String,Student> studentMap = new HashMap<>();
    Map<String, Teacher> teacherMap =  new HashMap<>();

    Map<String,String> studentTeacherMap =  new HashMap<>();

    public StudentRepository() {

    }

    public boolean addStudent(Student student) {

//        if(student==null)
//            return false;

        studentMap.put(student.getName(), student);
        return true;
    }

    public boolean addTeacher(Teacher teacher) {

//        if(teacher==null)
//            return false;

         teacherMap.put(teacher.getName(),teacher);
         return true;
    }

    public boolean addStudentTeacherPair(String student, String teacher) {

//        if(teacherMap.get(teacher)==null || studentMap.get(student) ==null)
//            return false;

        studentTeacherMap.put(student,teacher);
        Teacher t = teacherMap.get(teacher);
        t.setNumberOfStudents(t.getNumberOfStudents()+1); // increase the number of students
        return true;
    }

    public Student getStudentByName(String name) {
//        if(!studentMap.containsKey(name))
//            return null;

        return  studentMap.get(name);
    }

    public Teacher getTeacherByName(String name) {
//        if(!teacherMap.containsKey(name))
//            return null;

        return teacherMap.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        List<String> list = new ArrayList<>();

        for(String student: studentTeacherMap.keySet()){
            if(studentTeacherMap.get(student).equals(teacher)){
                list.add(student);
            }
        }
        return list;
    }

    public List<String> getAllStudents() {
        List<String> list = new ArrayList<>();

        for(String student: studentMap.keySet()){
            list.add(student);
        }
        return list;
    }

    public void deleteTeacherByName(String teacher) {
//        if(!teacherMap.containsKey(teacher)){
//            return;
//        }
        teacherMap.remove(teacher);
        for(String student: studentTeacherMap.keySet()){
            if(studentTeacherMap.get(student).equals(teacher))
                studentTeacherMap.remove(student); // teacher no longer exisits
        }


    }

    public void deleteAllTeachers() {
        teacherMap.clear();
        studentTeacherMap.clear();
    }
}

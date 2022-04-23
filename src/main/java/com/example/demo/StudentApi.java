package com.example.demo;

import org.springframework.web.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentApi {

    private List<Student> studentList;

    public StudentApi(){
        this.studentList = new ArrayList<>();
    }

    @PostMapping("/AddStudent")
    public boolean addStudent(@RequestBody Student student) {
        return studentList.add(student);
    }

    @GetMapping("/StudentList")
    public List<Student> getStudentList(){
        return studentList;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentList.stream().filter(student -> student.getId()==id).findFirst().get();}

    @GetMapping("/name/{name}")
    public Student getStudentByName(@PathVariable String name){
        return studentList.stream().filter(student -> student.getName().equals(name)).findFirst().get();}

    @GetMapping("/surname/{surname}")
    public Student getStudentBySurname(@PathVariable String surname){
        return studentList.stream().filter(student -> student.getSurname().equals(surname)).findFirst().get();}


    @GetMapping("/delete/{id}")
    public boolean deleteStudentById(@PathVariable int id){
         Student student00 =studentList.stream().filter(student -> student.getId()==id).findFirst().get();
        return studentList.remove(student00);
    }

    @GetMapping("/delete/name/{name}")
    public boolean deleteStudentByName(@PathVariable String name) {
        Student student00 = studentList.stream().filter(student -> student.getName().equals(name)).findFirst().get();
        return studentList.remove(student00);
    }

    @GetMapping("/delete/surname/{surname}")
    public boolean deleteStudentBySurname(@PathVariable String surname) {
        Student student00 = studentList.stream().filter(student -> student.getSurname().equals(surname)).findFirst().get();
        return studentList.remove(student00);
    }

    }






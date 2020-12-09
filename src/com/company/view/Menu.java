package com.company.view;

import com.company.DataExceptions;
import com.company.controller.RegistrationSystem;
import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);
    RegistrationSystem regSys;

    public Menu(RegistrationSystem regSys) {
        this.regSys = regSys;
    }

    public void menu() throws DataExceptions {

        boolean opt = true;
        while(opt) {

            System.out.println("1 -> New student");
            System.out.println("2 -> Delete student");
            System.out.println("3 -> New teacher");
            System.out.println("4 -> New course");
            System.out.println("5 -> Delete course  ONLY FOR TEACHER!");
            System.out.println("6 -> Register for a specified course");
            System.out.println("7 -> Show all courses");
            System.out.println("8 -> Courses with free places");
            System.out.println("9 -> Show enrolled students for a course");
            System.out.println("10 -> Show students");
            System.out.println("11 -> Show teachers");
            System.out.println("0 -> Exit");

            System.out.println("Choose your option: ");
            String option = scan.next();

            switch (option) {
                case "1" -> regSys.insert_stud();
                case "2" -> regSys.delete_stud();
                case "3" -> regSys.insert_teacher();
                case "4" -> regSys.insert_course();
                case "5" -> regSys.delete_course();
                case "6" -> opt6();
                case "7" -> opt7();
                case "8" -> opt8();
                case "9" -> opt9();
                case "10" -> opt10();
                case "11" -> opt11();
                case "0" -> opt = false;
            }
        }
    }

    public void opt6() throws DataExceptions {
        try{
        System.out.println("Insert student id");
        long id_student = scan.nextLong();
        regSys.register(id_student);}
        catch (InputMismatchException e) {
            throw new DataExceptions("The student id should be of type long");}
    }

    public void opt7(){
        //afisam fiecare curs in parte
        List<Course> curs = regSys.getAllCourses();
        for(Course course : curs ){
            System.out.println(course.toString());
        };
    }

    public void opt8() throws DataExceptions {
        //afisam fiecare curs cu locuri libere in parte
        List<Course> curs = regSys.retrieveCoursesWithFreePlaces();
        for(Course course : curs ){
            List<Student> studenti = course.getStudentsEnrolled();
            System.out.println(course.getId() + " " + course.getName() + " " + course.getTeacher().getLastName() + " " + course.getMaxEnrolled() + " " + course.getCredits() + " Studenti inrolati: " + studenti);
        };
    }

    public void opt9() throws DataExceptions {
        try {
            System.out.println("Insert course id to show enrolled students: ");
            long id_course = scan.nextLong();
            List<Student> enrolled_students = regSys.retrieveStudentsEnrolledForACourse(id_course);
            for (Student student : enrolled_students) {
                System.out.println(student.getStudentId() + " " + student.getFirstName() + " " + student.getLastName() + " " + student.getTotalCredits());
            }
        }
        catch (InputMismatchException e) {
            throw new DataExceptions("The course id should be of type long");}
    }

    public void opt10(){
        //afisam fiecare student in parte
        List<Student> stud = regSys.getAllStudents();
        for(Student student : stud ){
            System.out.println(student.toString());
        }
    }

    public void opt11(){
        //afisam fiecare profesor in parte
        List<Teacher> teach = regSys.getAllTeachers();
        for(Teacher teacher : teach ){
            System.out.println(teacher.toString());
        }
    }
}


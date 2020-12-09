package com.company;

import com.company.FileRepo.CourseFileRepository;
import com.company.FileRepo.StudentFileRepository;
import com.company.FileRepo.TeacherFileRepository;
import com.company.controller.RegistrationSystem;
import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.repository.CourseRepository;
import com.company.repository.StudentRepository;
import com.company.repository.TeacherRepository;
import com.company.view.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Main class where program starts.
 */
public class StartApp {

    /**
     * Start point of the application
     * @param args command line arguments
     */
    public static void main(String[] args) throws DataExceptions {

        System.out.println("Start point");

        List<Course> c1 = new ArrayList<Course>();
        List<Course> c2 = new ArrayList<Course>();
        List<Course> c3 = new ArrayList<Course>();
        List<Course> c4 = new ArrayList<Course>();

        Teacher t1 = new Teacher(411, "Claudiu", "Mino", c1);
        Teacher t2 = new Teacher( 412, "Dragos", "Ban", c2);

        Student s1 = new Student(111, "Ana", "Popoviciu", 15, c1);
        Student s2 = new Student(112, "Mirela", "Ionescu", 21, c2);
        Student s3 = new Student(113, "Darius", "Marinovici",17, c3);
        Student s4 = new Student(114, "Ion", "Popescu", 17, c4);

        List<Student> l1 = new ArrayList<Student>();
        List<Student> l2 = new ArrayList<Student>();

        l1.add(s1);
        l1.add(s2);
        l1.add(s3);
        l2.add(s2);
        l2.add(s4);

        Course curs1 = new Course(84912, "Baze de date", t1, 3, l1, 5);
        Course curs2 = new Course(84913, "Informatica aplicata", t2, 90, l2, 6 );
        Course curs3 = new Course(84914,"Arhitectura calculatoarelor", t1, 75, l2, 6);

        c1.add(curs1);
        c1.add(curs3);
        c2.add(curs2);

        t1.setCourses(c1);
        t2.setCourses(c2);

        List<Course> cursuri = new ArrayList<>();
        cursuri.add(curs1);
        cursuri.add(curs2);
        cursuri.add(curs3);

        List<Teacher> profi = new ArrayList<>();
        profi.add(t1);
        profi.add(t2);

        List<Student> studenti = new ArrayList<>();
        studenti.add(s1);
        studenti.add(s2);
        studenti.add(s3);
        studenti.add(s4);

        CourseFileRepository cf = new CourseFileRepository();
        TeacherFileRepository tf = new TeacherFileRepository();
        StudentFileRepository sf = new StudentFileRepository();

        cf.insert(cursuri);
        tf.insert(profi);
        sf.insert(studenti);

        List<Course> courses = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        CourseRepository courseRepo = new CourseRepository(courses);
        TeacherRepository teacherRepo = new TeacherRepository(teachers);
        StudentRepository studentRepo = new StudentRepository(students);

        CourseFileRepository courseFile = new CourseFileRepository();
        TeacherFileRepository teacherFile = new TeacherFileRepository();
        StudentFileRepository studentFile = new StudentFileRepository();

        RegistrationSystem regSys = new RegistrationSystem(courseRepo, teacherRepo, studentRepo, courseFile, teacherFile, studentFile);
        Menu menu = new Menu(regSys);

        System.out.println("Cursurile filtrate dupa numarul de credite:");
        System.out.println(RegistrationSystem.Filtercredits(cursuri));
        System.out.println("Studentii sortati alfabetic dupa numele lor:");
        Collections.sort(studenti, new RegistrationSystem.NameSorter());
        System.out.println(studenti);

        menu.menu();

    }
}

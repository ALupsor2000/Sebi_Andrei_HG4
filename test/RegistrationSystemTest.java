import com.company.FileRepo.CourseFileRepository;
import com.company.FileRepo.StudentFileRepository;
import com.company.FileRepo.TeacherFileRepository;
import com.company.controller.RegistrationSystem;
import com.company.model.Course;
import com.company.model.Person;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.repository.CourseRepository;
import com.company.repository.StudentRepository;
import com.company.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class RegistrationSystemTest {

    CourseRepository courseRepo;
    TeacherRepository teacherRepo;
    StudentRepository studentRepo;

    CourseFileRepository courseFile;
    TeacherFileRepository teacherFile;
    StudentFileRepository studentFile;

    List<Course> courses = new ArrayList<>();
    List<Teacher> teachers = new ArrayList<>();
    List<Student> students = new ArrayList<>();

    @BeforeEach
    public void Initialize(){

    }


}

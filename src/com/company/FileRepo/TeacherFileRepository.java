package com.company.FileRepo;

import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class TeacherFileRepository implements CrudFileRepository<Teacher> {

    @Override
    public List<Teacher>insert(List<Teacher> entity) {

        try {
            // deschidem fisierul "Student.txt" si scriem folosind metoda append
            // cu ajutorul FileOutputStream
            FileOutputStream fos = new FileOutputStream("Teacher.txt",true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(entity);
            oos.close();
            fos.close();
            return entity;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Teacher> read_to_list() {

        List<Teacher> teachers;
        try{
            //cititm din fisier cu FileInputStream si adaugam in lista obiectul
            FileInputStream fis = new FileInputStream("Teacher.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            teachers = (List) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("Could not read list");
            return null;
        }
        return teachers;
    }

    @Override
    public List<Teacher> edit(List<Teacher> entity) {

        try {
            // pentru orice modificae adusa unui obiect din fisier
            // vom folosi o metoda asemanatoare cu cea de inserare in fisier
            // singura diferenta va fi ca nu vom folosi append, ci vom rescrie fisierul
            FileOutputStream fos = new FileOutputStream("Teacher.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(entity);
            oos.close();
            fos.close();
            return entity;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}

package com.company.FileRepo;

import com.company.model.Student;

import java.io.*;
import java.util.List;

public class StudentFileRepository implements CrudFileRepository<Student> {

    @Override
    public List<Student> insert(List<Student> entity) {

        try {
            // deschidem fisierul "Student.txt" si scriem folosind metoda append
            // cu ajutorul FileOutputStream
            FileOutputStream fos = new FileOutputStream("Student.txt",true);
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
    public List<Student> read_to_list() {

        List<Student> students;
        try{
            //cititm din fisier cu FileInputStream si adaugam in lista obiectul
            FileInputStream fis = new FileInputStream("Student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("Could not read list");
            return null;
        }
        return students;
    }

    @Override
    public List<Student> edit(List<Student> entity) {

        try {
            // pentru orice modificae adusa unui obiect din fisier
            // vom folosi o metoda asemanatoare cu cea de inserare in fisier
            // singura diferenta va fi ca nu vom folosi append, ci vom rescrie fisierul
            FileOutputStream fos = new FileOutputStream("Student.txt");
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
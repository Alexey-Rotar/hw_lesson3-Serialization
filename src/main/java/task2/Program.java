package task2;

import java.io.File;

public class Program {

    public static void main(String[] args) {
        Student student;
        File f = new File(FileIO.FILE_JSON);
        if (f.exists() && !f.isDirectory()) {
            student = FileIO.loadFromFile(FileIO.FILE_JSON);
            System.out.println("Десериализация:");
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getGPA());
        } else {
            student = new Student("Alexey", 29, 5);
            FileIO.saveToFile(FileIO.FILE_JSON, student);
            FileIO.saveToFile(FileIO.FILE_XML, student);
            System.out.println("Сериализация выполнена!");
        }
    }
}
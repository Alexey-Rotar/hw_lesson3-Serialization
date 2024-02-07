package task1;

import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student("Alexey", 39, 4.99);
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("GPA: " + student.getGPA());
        System.out.println();


        try (FileOutputStream fileOut = new FileOutputStream("student.bin");
             ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(student);
        }

        try (FileInputStream fileIn = new FileInputStream("student.bin");
             ObjectInputStream in = new ObjectInputStream(fileIn))
        {
            student = (Student)in.readObject();
        }

        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("GPA: " + student.getGPA());
    }

}

package task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class FileIO {

    public static final String FILE_JSON = "student.json";
    public static final String FILE_XML = "student.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void saveToFile(String fileName, Student student) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new java.io.File(fileName), student);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(student);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new java.io.File(fileName), student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student loadFromFile(String fileName) {
        Student student = new Student();
        java.io.File file = new java.io.File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    student = objectMapper.readValue(file, Student.class);
                } else if (fileName.endsWith(".xml")) {
                    student = xmlMapper.readValue(file, Student.class);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

}

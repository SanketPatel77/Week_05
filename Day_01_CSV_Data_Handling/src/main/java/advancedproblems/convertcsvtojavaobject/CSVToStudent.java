package advancedproblems.convertcsvtojavaobject;

import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + ", grade='" + grade + "'}";
    }
}

public class CSVToStudent {
    public static void main(String[] args) {
        String filePath = "src/main/java/advancedproblems/convertcsvtojavaobject/student.csv"; // Change this if needed
        List<Student> students = readCSV(filePath);

        // Print all students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static List<Student> readCSV(String filePath) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean headerSkipped = false;

            while ((line = br.readLine()) != null) {
                if (!headerSkipped) { // Skip the first line (header)
                    headerSkipped = true;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    String grade = data[3].trim();
                    students.add(new Student(id, name, age, grade));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}

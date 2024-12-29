import models.*;

import java.io.*;
import java.util.*;

public class MyApplication {
    public static void main(String[] args) throws IOException {
        School school = new School();

        readStudentsData(school);
        readTeachersData(school);
        giveTeacherRaises(school);

        System.out.println(school);
    }

    private static void readStudentsData(School school) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/students.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(" ");
            String name = data[0];
            String surname = data[1];
            int age = Integer.parseInt(data[2]);
            boolean male = data[3].equalsIgnoreCase("Male");

            ArrayList<Integer> grades = new ArrayList<>();
            for (int i = 4; i < data.length; i++) {
                grades.add(Integer.parseInt(data[i]));
            }
            school.addMember(new Student(name, surname, age, male, grades));
        }
    }

    private static void readTeachersData(School school) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/teachers.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(" ");
            String name = data[0];
            String surname = data[1];
            int age = Integer.parseInt(data[2]);
            boolean male = data[3].equalsIgnoreCase("Male");
            String subject = data[4];
            int years = Integer.parseInt(data[5]);
            int salary = Integer.parseInt(data[6]);

            school.addMember(new Teacher(name, surname, age, male, subject, years, salary));
        }
    }

    private static void giveTeacherRaises(School school) {
        for (Person person : school.members) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.yearsOfExperience > 10) {
                    teacher.giveRaise(10);
                }
            }
        }
    }
}



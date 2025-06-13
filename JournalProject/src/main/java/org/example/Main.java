package org.example;

import org.example.model.*;
import org.example.service.ScoreService;
import org.example.service.StudentService;
import org.example.util.JsonSerialization;
import org.example.xlsxReader.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            List<Group> groups = new GroupReader().read("src/main/resources/group.xlsx");
            List<Student> students = new StudentReader().read("src/main/resources/student.xlsx");
            List<Teacher> teachers = new TeacherReader().read("src/main/resources/teacher.xlsx");
            List<Subject> subjects = new SubjectReader().read("src/main/resources/subject.xlsx");
            List<Score> scores = new ScoreReader().read("src/main/resources/score.xlsx");
            List<Journal> journals = new JournalReader().read("src/main/resources/journal.xlsx");

            StudentService studentService = new StudentService();
            studentService.setGroups(groups);
            studentService.setStudents(students);

            ScoreService scoreService = new ScoreService();
            scoreService.setScores(scores);

            Student newStudent = new Student("Васин Вася", 100, 1);
            studentService.addStudent(newStudent);

            Group studentGroup = studentService.findGroupByStudentId(1);
            System.out.println("Студент с ID 1 состоит в группе: " + studentGroup.getName());

            Score newScore = new Score(1001, 5, 1, 1); // id, score, subjectId, studentId
            scoreService.addScore(newScore);

            JsonSerialization.serialize(students, new FileOutputStream("src/main/resources/data/students.json"));
            JsonSerialization.serialize(teachers, new FileOutputStream("src/main/resources/data/teachers.json"));
            JsonSerialization.serialize(subjects, new FileOutputStream("src/main/resources/data/subjects.json"));
            JsonSerialization.serialize(scores, new FileOutputStream("src/main/resources/data/scores.json"));
            JsonSerialization.serialize(journals, new FileOutputStream("src/main/resources/data/journals.json"));

            List<Student> deserializedStudents = JsonSerialization.deserializeList(
                    new FileInputStream("src/main/resources/data/students.json"),
                    Student.class
            );
            System.out.println("\nДесериализованные студенты:");
            deserializedStudents.forEach(s -> System.out.println(s.getName()));

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
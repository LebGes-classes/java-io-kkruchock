package org.example.service;

import org.example.model.Group;
import org.example.model.Student;
import org.example.util.JsonSerialization;
import org.example.util.Validator;

import java.io.FileOutputStream;
import java.util.List;

public class StudentService {

    private List<Group> groups;
    private List<Student> students;

    public void addStudent(Student student) throws Exception {
        Validator.validateStudent(student, groups);
        students.add(student);
        JsonSerialization.serialize(students, new FileOutputStream("src/main/resources/data/students.json"));
    }

    public Group findGroupByStudentId(int studentId) {

        Student targetStudent = null;
        for (Student student : students) {
            if (student.getId() == studentId) {
                targetStudent = student;
                break;
            }
        }

        if (targetStudent == null) {
            throw new IllegalArgumentException("Студент с ID " + studentId + " не найден");
        }

        int groupId = targetStudent.getGroupId();
        for (Group group : groups) {
            if (group.getId() == groupId) {
                return group;
            }
        }
        throw new IllegalArgumentException("Группа с ID " + groupId + " не найдена");
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
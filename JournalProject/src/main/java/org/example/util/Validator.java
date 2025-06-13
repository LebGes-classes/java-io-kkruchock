package org.example.util;

import org.example.model.Group;
import org.example.model.Score;
import org.example.model.Student;

import java.util.List;

public class Validator {

    public static void validateStudent(Student student, List<Group> groups) {

        boolean found = false;
        for (Group group : groups) {
            if (group.getId() == student.getGroupId()) {
                found = true;
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Group not found");
        }
    }

    public static void validateScore(Score score, List<Score> scores) {

        boolean found = false;
        for (Score curScore: scores) {
            if (curScore.getId() == score.getId()) {
                found = true;
                break;
            }
        }

        if (found) {
            throw new IllegalArgumentException("Score with this id already exist");
        }
    }
}
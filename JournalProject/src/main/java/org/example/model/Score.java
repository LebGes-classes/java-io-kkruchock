package org.example.model;

public class Score {

    private int id;
    private int score;
    private int subjectId;
    private int studentId;

    public Score() {
    }

    public Score(int id, int score, int subjectId, int studentId) {
        setId(id);
        setScore(score);
        setSubjectId(subjectId);
        setStudentId(studentId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score > 5 || score < 1) {
            throw new IllegalArgumentException("Id must be positive");
        }
        this.score = score;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        if (subjectId <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
        this.subjectId = subjectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
        this.studentId = studentId;
    }
}
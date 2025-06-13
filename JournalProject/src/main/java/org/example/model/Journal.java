package org.example.model;

public class Journal {

    private int teacherId;
    private int groupId;
    private int subjectId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        if (teacherId <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
        this.teacherId = teacherId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        if (teacherId <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
        this.groupId = groupId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        if (teacherId <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
        this.subjectId = subjectId;
    }
}

package org.example.model;

public class Student {

    private int id;
    private String name;
    private int groupId;

    public Student() {
    }

    public Student(String name, int id, int groupId) {
        setName(name);
        setId(id);
        setGroupId(groupId);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        if (groupId <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
        this.groupId = groupId;
    }
}

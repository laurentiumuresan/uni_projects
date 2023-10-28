package isp.lab6.exercise1;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String id;
    private Map<String, Integer> grade;

    public Student() {
    }

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student(String name, String id, Map<String, Integer> grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public void setGrade(HashMap<String, Integer> grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Map<String, Integer> getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", grade=" + grade +
                '}';
    }
}

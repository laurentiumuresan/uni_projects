package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.List;

public class GradeManagementSystem {
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void updateStudentInformation(Student student, String name, String subject, int grade) {
        student.setName(name);
        student.getGrade().put(subject, grade);
    }

    public double calculateAverageGrade(Student student) {
        double sum = 0;
        for (Integer grade : student.getGrade().values()) {
            sum += grade;
        }
        return sum / student.getGrade().values().size();
    }

    public void displayStudents(List<Student> students) {
        System.out.println(students);
    }


}

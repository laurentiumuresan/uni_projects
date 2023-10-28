package isp.lab6.exercise1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GradeManagementSystemTest {
    GradeManagementSystem gradeManagementSystem = new GradeManagementSystem();

    @Test
    public void testAddStudent() {
        Student student = new Student("Adi", "13d");
        gradeManagementSystem.addStudent(student);
        Assert.assertEquals(1, gradeManagementSystem.getStudents().size());
    }

    @Test
    public void testRemoveStudent() {
        Student student1 = new Student("Adi", "13d");
        gradeManagementSystem.addStudent(student1);
        Student student2 = new Student("Andrei", "1213d");
        gradeManagementSystem.addStudent(student2);
        gradeManagementSystem.removeStudent(student1);
        Assert.assertEquals(1, gradeManagementSystem.getStudents().size());
    }

    @Test
    public void testUpdateStudentInformation() {
        Map<String, Integer> grades = new HashMap<>();
        grades.put("math", 10);
        grades.put("bio", 8);
        Student student = new Student("aedc", "132sw", grades);
        gradeManagementSystem.updateStudentInformation(student, "qe", "math", 4);
        Assert.assertEquals("qe", student.getName());
        Assert.assertEquals(Integer.valueOf(4), student.getGrade().get("math"));
    }

    @Test
    public void testCalculateAverageGrade() {
        Map<String, Integer> grades = new HashMap<>();
        grades.put("math", 10);
        grades.put("bio", 8);
        Student student = new Student("aedc", "132sw", grades);
        gradeManagementSystem.calculateAverageGrade(student);
        Assert.assertEquals(9.0, gradeManagementSystem.calculateAverageGrade(student), 0);
    }

}

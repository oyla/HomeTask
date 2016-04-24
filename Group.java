/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Oyla
 */
class Group {

    private String title;
    private String specialization;
    private int course;
    private StudentArrayList students;

    public Group() {
        this(15);
    }

    public Group(int capacity) {
        this("", "", 0, new StudentArrayList(capacity));
    }

    public Group(Student... students) {
        this("", "", 0, students);
    }

    public Group(Group g) {
        this(g.title, g.specialization, g.course, g.students);
    }

    public Group(String title, String specialization, int course, Student... students) {
        setTitle(title);
        setSpecialization(specialization);
        setCourse(course);
        setStudents(students);
    }

    public Group(String title, String specialization, int course, StudentArrayList students) {
        setTitle(title);
        setSpecialization(specialization);
        setCourse(course);
        setStudents(students);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @return the course
     */
    public int getCourse() {
        return course;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        if (title.isEmpty()) {
            this.title = "Unknown";
        } else {
            this.title = title;
        }
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(String specialization) {
        if (specialization.isEmpty()) {
            this.specialization = "Unknown";
        } else {
            this.specialization = specialization;
        }
    }

    /**
     * @param course the course to set
     */
    public void setCourse(int course) {
        this.course = course;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(Student... students) {
        this.students = new StudentArrayList(students.length);
        if (students.length > 0) {
            this.students.setData(students);
        } else {
            this.students.randomFill();
        }
    }

    /**
     * @param students the students to set
     */
    public void setStudents(StudentArrayList students) {
        this.students = new StudentArrayList(students.getCapacity());
        if (students.isEmpty()) {
            this.students.randomFill();
        } else {
            this.students.setData(students.getData());
        }
    }

    public void addStudent(Student student) {
        students.addElement(student);
    }

    public Student getStudent(int index) {
        Student s = students.getElementAt(index);
        return s;
    }

    public void removeStudent(int index) {
        students.removeElementAt(index);
    }

    public String showData() {
        students.sortAsc();
        String s = "";
        s += "Group: " + title + "\n";
        s += "Specialization: " + specialization + "\n";
        s += "Course: " + course + "\n";
//        s += students.showStudents();
//        s += "\n";
        s += students.showStudentsWithRating();
        return s;
    }

    public void editGroupData(String title, String specialization, int course) {
        setTitle(title);
        setSpecialization(specialization);
        setCourse(course);
    }

    public void editStudentData(int index, Student student) {
        students.setElementAt(index, student);
    }

    public void transferStudent(Group g, int index) {
        students.addElement(g.getStudent(index));
        g.removeStudent(index);
    }

    public void excludeStudentBySession(int minRating) {
        students.removeByExams(minRating);
    }

    public void excludeByPoorProgress() {
        students.removeByProgress();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

/**
 *
 * @author Oyla
 */
public class StudentArrayList {

    private Student[] data;
    private int size = 0;
    private int capacity = 10;

    public StudentArrayList() {
        this(10);
    }

    public StudentArrayList(int capacity) {
        setCapacity(capacity);
    }

    /**
     * @return the data
     */
    public Student[] getData() {
        Student[] newData = new Student[size];
        for (int i = 0; i < size; i++) {
            newData[i] = getElementAt(i);
        }
        return newData;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param data the data to set
     */
    public void setData(Student... data) {
        ensureCapacity(data.length);
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
        size = data.length;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        if (isEmpty()) {
            if (capacity <= size) {
                capacity = 10;
            }
            data = new Student[capacity];
            this.capacity = capacity;

        } else if (capacity <= size) {
            trimToSize();
        } else {
            this.capacity = capacity;
            overwriteData(capacity);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void trimToSize() {
        capacity = size;
        overwriteData(size);
    }

    public void overwriteData(int newLength) {
        Student[] temp = new Student[newLength];
        for (int i = 0; i < size; i++) {
            temp[i] = getElementAt(i);
        }
        data = temp;
    }

    public Student getElementAt(int index) {
        if (index >= 0 && index < size) {
            Student s = new Student();
            s = data[index];
            return s;
        }
        return new Student();
    }

    public boolean setElementAt(int index, Student student) {
        if (index >= 0 && index < size) {
            Student s = new Student(student.getSurname(), student.getName(), student.getPatronymic(), student.getDOB(), student.getAddress(), student.getPhone(), new MyArrayList(), new MyArrayList(), new MyArrayList());
            s.setTestsData(student.getTestsList());
            s.setCoursesData(student.getCoursesList());
            s.setExamsData(student.getExamsList());
            data[index] = s;
            return true;
        }
        return false;
    }

    public boolean removeElementAt(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
            return true;
        }
        return false;
    }

    private void ensureCapacity(int arrLength) {
        if (arrLength > capacity) {
            int newLength = (arrLength * 3) / 2 + 1;
            setCapacity(newLength);
        }
    }

    public void randomFill() {
        size = capacity;
        int testsCount = generateNumber(5, 10);
        int coursesCount = generateNumber(5, 10);
        int examsCount = generateNumber(5, 10);
        int[] tests = new int[testsCount];
        int[] courses = new int[coursesCount];
        int[] exams = new int[examsCount];
        for (int i = 0; i < size; i++) {
            Student s = new Student(generateStringText(), generateStringText(), generateStringText());
            s.setDOB(new Date(generateNumber(1, 31), generateNumber(1, 12), generateNumber((2016 - 55), (2016 - 16))));
            s.setAddress(new Address(generateStringText(), generateStringText(), generateStringText(), generateNumber(1, 100), generateNumber(1, 200)));
            s.setPhone(new Phone(generateDigitText()));
            for (int j = 0; j < testsCount; j++) {
                tests[j] = generateNumber(0, 100);
            }
            s.setTestsData(tests);
            for (int j = 0; j < coursesCount; j++) {
                courses[j] = generateNumber(0, 100);
            }
            s.setCoursesData(courses);
            for (int j = 0; j < examsCount; j++) {
                exams[j] = generateNumber(30, 100);
            }
            s.setExamsData(exams);
            data[i] = s;
        }
    }

    public String generateText(int minSymbol, int maxSymbol, int min, int max) {
        String s = "";
        int c;
        int lengthText = min + (int) (Math.random() * ((max - min) + 1));
        for (int i = 0; i < lengthText; i++) {
            c = (int) (Math.random() * (maxSymbol - minSymbol) + minSymbol);
            s += (char) c;
            if (i == 0) {
                s = s.toUpperCase();
            }
        }
        return s;
    }

    public int generateNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public String generateStringText() {
        return generateText(97, 123, 4, 10);
    }

    public String generateDigitText() {
        return generateText(48, 58, 7, 10);
    }

    public String showStudents() {
        String s = "Students: ";
        if (isEmpty()) {
            s += "no students";
        } else {
            s += "\n";
            Student student;
            for (int i = 0; i < size; i++) {
                student = getElementAt(i);
                s += (i + 1) + ". ";
                s += String.join(" ", student.getSurname(), student.getName(), student.getPatronymic()) + "\n";
            }
        }
        return s;
    }

    public String showStudentsWithRating() {
        String s = "";
        if (isEmpty()) {
            s += "no students";
        } else {
            s += "Students (with ratings):\n";
            Student student;
            for (int i = 0; i < size; i++) {
                student = getElementAt(i);
                s += (i + 1) + ". ";
                s += student.getSurname() + " " + student.getName() + "\n";
                s += "\tTests: ";
                if (student.getTestsList().length > 0) {
                    for (int test : student.getTestsList()) {
                        s += test + " ";
                    }
                } else {
                    s += "no ratings ";
                }
                s += "(Sum = " + countTestsRatings(i) + ")\n";
                s += "\tCourses: ";
                if (student.getCoursesList().length > 0) {
                    for (int course : student.getCoursesList()) {
                        s += course + " ";
                    }
                } else {
                    s += "no ratings ";
                }
                s += "(Sum = " + countCoursesRatings(i) + ")\n";
                s += "\tExams: ";
                if (student.getExamsList().length > 0) {
                    for (int exam : student.getExamsList()) {
                        s += exam + " ";
                    }
                } else {
                    s += "no ratings ";
                }
                s += "(Sum = " + countExamsRatings(i) + ")\n";
            }
        }
        return s;
    }

    public void sortAsc() {
        StudentArrayList sort = new StudentArrayList(size);
        sort.setData(getData());
        String s1, s2;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                Student st1 = sort.getElementAt(i);
                Student st2 = sort.getElementAt(j);
                s1 = st1.getSurname() + sort.getElementAt(i).getSurname();
                s2 = st2.getSurname() + sort.getElementAt(j).getSurname();
                if (compareSymbols(s1, s2) == 1) {
                    sort.setElementAt(i, st2);
                    sort.setElementAt(j, st1);
                }
            }
            setElementAt(i, sort.getElementAt(i));
        }
        setElementAt(size - 1, sort.getElementAt(size - 1));
    }

    public int compareSymbols(String s1, String s2) {
        int index = 0;
        while (s1.charAt(index) == s2.charAt(index)) {
            if (index == s1.length() - 1 && s1.length() == s2.length()) {
                return 0;
            } else if (index == s1.length() - 1) {
                return 1;
            } else if (index == s2.length() - 1) {
                return -1;
            }
            index++;
        }
        if (s1.charAt(index) > s2.charAt(index)) {
            return 1;
        }
        return -1;
    }

    public void addElement(Student student) {
        ensureCapacity(size + 1);
        setElementAt(size++, student);
    }

    public int countTestsRatings(int index) {
        int ratings = 0;
        int[] tests = getElementAt(index).getTestsList();
        for (int test : tests) {
            ratings += test;
        }
        return ratings;
    }

    public int countCoursesRatings(int index) {
        int ratings = 0;
        int[] courses = getElementAt(index).getCoursesList();
        for (int course : courses) {
            ratings += course;
        }
        return ratings;
    }

    public int countExamsRatings(int index) {
        int ratings = 0;
        int[] exams = getElementAt(index).getExamsList();
        for (int exam : exams) {
            ratings += exam;
        }
        return ratings;
    }

    public void removeByExams(int minRating) {
        Student[] s = getData();
        for (int i = size - 1; i >= 0; i--) {
            int[] exams = s[i].getExamsList();
            if (exams.length > 0) {
                for (int exam : exams) {
                    if (exam < minRating) {
                        removeElementAt(i);
                        break;
                    }
                }
            } else {
                removeElementAt(i);
            }
        }
    }

    public void removeByProgress() {
        int min = -1;
        int sum = 0;
        int minIndex = 0;
        for (int i = 0; i < size; i++) {
            sum = countTestsRatings(i) + countCoursesRatings(i) + countExamsRatings(i);
            if (min == -1 || min > sum) {
                min = sum;
                minIndex = i;
            }
        }
        removeElementAt(minIndex);
    }
}

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
class Student {

    private String surname;
    private String name;
    private String patronymic;
    private Date DOB = new Date();
    private Address address = new Address();
    private Phone phone = new Phone();
    private MyArrayList testsList;
    private MyArrayList coursesList;
    private MyArrayList examsList;

    public Student() {
        this("", "", "");
    }

    public Student(String surname, String name, String patronymic) {
        this(surname, name, patronymic, new Date(), new Address(), new Phone());
    }

    public Student(String surname, String name, String patronymic, Date DOB, Address address, Phone phone) {
        this(surname, name, patronymic, DOB, address, phone, new MyArrayList(), new MyArrayList(), new MyArrayList());
    }

    public Student(String surname, String name, String patronymic, Date DOB, Address address, Phone phone, MyArrayList testsList, MyArrayList coursesList, MyArrayList examsList) {
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setDOB(DOB);
        setAddress(address);
        setPhone(phone);
        setTestsList(testsList);
        setCoursesList(coursesList);
        setExamsList(examsList);
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * @return the DOB
     */
    public Date getDOB() {
        return DOB;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @return the phone
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * @return the testsList
     */
    public int[] getTestsList() {
        return testsList.getData();
    }

    /**
     * @return the coursesList
     */
    public int[] getCoursesList() {
        return coursesList.getData();
    }

    /**
     * @return the examsList
     */
    public int[] getExamsList() {
        return examsList.getData();
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        if (surname.isEmpty()) {
            this.surname = "Unknown";
        } else {
            this.surname = surname;
        }
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param patronymic the patronymic to set
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(Date DOB) {
        this.DOB = new Date(DOB.getDay(), DOB.getMonth(), DOB.getYear());
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address.setCountry(address.getCountry());
        this.address.setCity(address.getCity());
        this.address.setStreet(address.getStreet());
        this.address.setBld(address.getBld());
        this.address.setFlat(address.getFlat());
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(Phone phone) {
        this.phone.setNumber(phone.getNumber());
    }

    /**
     * @param testsList the testsList to set
     */
    public void setTestsList(MyArrayList testsList) {
        this.testsList = testsList.clone();
    }

    /**
     * @param coursesList the coursesList to set
     */
    public void setCoursesList(MyArrayList coursesList) {
        this.coursesList = coursesList.clone();
    }

    /**
     * @param examsList the examsList to set
     */
    public void setExamsList(MyArrayList examsList) {
        this.examsList = examsList.clone();
    }

    public void setTestsData(int... tests) {
        this.testsList.setData(tests);
    }

    public void setCoursesData(int... courses) {
        this.coursesList.setData(courses);
    }

    public void setExamsData(int... exams) {
        this.examsList.setData(exams);
    }

    public String showStudent() {
        String s = "";
        if (getSurname().isEmpty() && getName().isEmpty() && getPatronymic().isEmpty()) {
            s += "Unknown name";
        } else {
            s += getSurname() + " " + getName() + " " + getPatronymic() + "\n";
        }
        s += DOB.showDate() + "\n";
        s += address.showAddress() + "\n";
        s += phone.showPhone() + "\n";
        s += "Tests: ";
        if (testsList.isEmpty()) {
            s += "no ratings\n";
        } else {
            for (int test : getTestsList()) {
                s += test + " ";
            }
            s += "\n";
        }
        s += "Courses: ";
        if (coursesList.isEmpty()) {
            s += "no ratings\n";
        } else {
            for (int course : getCoursesList()) {
                s += course + " ";
            }
            s += "\n";
        }
        s += "Exams: ";
        if (examsList.isEmpty()) {
            s += "no ratings\n";
        } else {
            for (int exam : getExamsList()) {
                s += exam + " ";
            }
            s += "\n";
        }
        return s;
    }

}

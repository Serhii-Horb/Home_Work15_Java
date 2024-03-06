package org.example.Task4;

public class Employee {
    private String surname, name, patronymic;
    private String jobTitle;
    private String Department;
    private double salary;

    public Employee(String surname, String name, String patronymic, String jobTitle, String department, double salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.jobTitle = jobTitle;
        Department = department;
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "surname = '" + surname + '\'' +
                ", name = '" + name + '\'' +
                ", patronymic = '" + patronymic + '\'' +
                ", jobTitle = '" + jobTitle + '\'' +
                ", Department = '" + Department + '\'' +
                ", salary = " + salary +
                '}';
    }
}

package com.model;

public class StudentForm {
    private Integer id;
    private String name;
    private String roll_no;
    private String branch;
    public StudentForm() {
    }


    public StudentForm(Integer id, String name, String roll_no, String branch) {
        this.id = id;
        this.name = name;
        this.roll_no = roll_no;
        this.branch = branch;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "StudentForm{" +
                "name='" + name + '\'' +
                ", rollNo='" + roll_no + '\'' +
                ", className='" + branch + '\'' +
                '}';
    }
}


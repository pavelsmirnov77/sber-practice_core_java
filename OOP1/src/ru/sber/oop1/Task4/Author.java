package ru.sber.oop1.Task4;

public class Author {
    String name;
    Sex sex;
    String email;

    Author(String name, Sex sex, String email){
        this.name = name;
        this.sex = sex;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

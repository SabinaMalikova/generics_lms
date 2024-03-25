package model;

import enums.Gender;

public class Animal {
    private Long id;
    private String name;
    private Gender gender;

    public Animal() {
    }

    public Animal(Long id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\nAnimal" + "\n"+
                "id: " + id + "\n"+
                "name: " + name + "\n" +
                "gender: " + gender+"\n"+
                "---------------";
    }
}

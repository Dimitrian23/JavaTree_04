package com.tree.myapp.entity;

import com.tree.myapp.interfaces.Nameable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Human implements Serializable, Nameable, Comparable<Human> {

    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<Human> children;
    private Human father;
    private Human mother;
    private Gender gender;

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth) {
       this(name,  gender, dateOfBirth,null);
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public Gender getGender() {
        return gender;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "Человек{" +
                "имя='" + name + '\'' +
                ", дата рождения=" + dateOfBirth +
                ", дата смерти=" + (dateOfDeath != null ? dateOfDeath : "Alive") +
                ", пол=" + gender +
                '}';
    }


    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.getName());
    }

}

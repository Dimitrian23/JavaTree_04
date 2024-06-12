package com.tree.myapp;

import com.tree.myapp.handler.FileHandler;
import com.tree.myapp.interfaces.Nameable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Comparable<T> & Serializable & Nameable> implements Iterable<T> {
    private List<T> familyMembers;

    public FamilyTree() {
        this.familyMembers = new ArrayList<>();
    }

    public void addMember(T member) {
        familyMembers.add(member);
    }

    public T findMember(String name) {
        for (T member : familyMembers) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public void printFamilyTree() {
        for (T member : familyMembers) {
            System.out.println(member);
        }
    }

    public List<T> getFamilyMembers() {
        return familyMembers;
    }

    public void save(String filename) {
        FileHandler<T> handler = new FileHandler<>();
        handler.save(this, filename);
    }

    public FamilyTree<T> load(String filename) {
        FileHandler<T> handler = new FileHandler<>();
        return handler.load(filename);
    }

    @Override
    public Iterator<T> iterator() {
        return familyMembers.iterator();
    }

    public void sortByName() {
        Collections.sort(familyMembers, Comparator.comparing(T::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(familyMembers, Comparator.comparing(T::getDateOfBirth));
    }
}

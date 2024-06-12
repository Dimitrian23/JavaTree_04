package com.tree.myapp.interfaces;

import com.tree.myapp.FamilyTree;

import java.io.Serializable;

public interface Writable<T extends Comparable<T> & Serializable & Nameable> {

     void save(FamilyTree<T> tree, String filename);

     FamilyTree<T> load(String filename);
}

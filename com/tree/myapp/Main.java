package com.tree.myapp;

import com.tree.myapp.entity.Gender;
import com.tree.myapp.entity.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Создаем новый объект семейного дерева
        FamilyTree<Human> familyTree = new FamilyTree();

        // Создаем членов семьи
        Human grandFather1 = new Human("Игорь", Gender.MALE, LocalDate.of(1930, 1, 1),LocalDate.of(2000, 8, 5));
        Human grandMother2 = new Human("Валентина", Gender.FEMALE, LocalDate.of(1935, 4, 5), LocalDate.of(2005, 3, 4));

        Human grandFather = new Human("Сергей", Gender.MALE, LocalDate.of(1931, 2, 5),LocalDate.of(2000, 8, 5));
        Human grandMother = new Human("Мария", Gender.FEMALE, LocalDate.of(1934, 5, 9), LocalDate.of(2005, 3, 4));
        Human father = new Human("Аллександр", Gender.MALE, LocalDate.of(1960, 10, 10));
        Human mother = new Human("Екатерина", Gender.FEMALE, LocalDate.of(1965, 12, 12));
        Human child = new Human("Виктория", Gender.FEMALE, LocalDate.of(1990, 7, 7));

        // Устанавливаем родителей и детей
       
        father.setFather(grandFather);
        father.setMother(grandMother);
        mother.setFather(grandFather1);
        mother.setMother(grandMother2);
        child.setFather(father);
        child.setMother(mother);

        grandFather1.addChild(father);
        grandFather.addChild(mother);
        grandMother2.addChild(father);
        grandMother.addChild(mother);
        father.addChild(child);
        mother.addChild(child);
        // Добавляем членов семьи в семейное дерево
        familyTree.addMember( grandFather1);
        familyTree.addMember(grandMother2);

        familyTree.addMember(grandFather);
        familyTree.addMember(grandMother);
        familyTree.addMember(father);
        familyTree.addMember(mother);
        familyTree.addMember(child);


        // Выполняем сортировку членов по имени
        //familyTree.sortByName();

        // Выполняем сортировку членов по дате рождения
        familyTree.sortByBirthDate();


        // Выводим всех членов семьи
        familyTree.printFamilyTree();

        //Сохраняем семейное дерево в файл
        familyTree.save("familyTree.txt");



        // Загружаем семейное дерево из файла
        //FamilyTree loadedTree = FamilyTree.load("familyTree.txt");

        // Выводим всех членов загруженного семейного дерева
        //loadedTree.printFamilyTree();
    }
}
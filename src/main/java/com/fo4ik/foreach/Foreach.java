package com.fo4ik.foreach;

import java.security.spec.RSAOtherPrimeInfo;

public class Foreach {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Person person = new Person("John", 20);
        Person person1 = new Person("David", 22);
        Person person2 = new Person("Mike", 24);
        Person[] persons = {person, person1, person2};

         /*i -> is the index of the element
           arr -> is the object we are iterating over*/
        for (int i : arr) {
            System.out.println(i);
        }

        //We can also iterate over objects
        printPerson(persons);

    }

    static void printPerson(Person[] persons) {
        for (Person p: persons) {
            System.out.println(p.getName());
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person: " +
                "name :'" + name + '\'' +
                ", age: " + age;
    }
}

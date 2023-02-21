package com.fo4ik.serialization;

import java.io.*;

public class Serialization {
    public static void main(String[] args) throws Exception {
        //Serialization is a mechanism of writing the state of an object into a byte stream.
        //Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory.
        //This mechanism is used to persist the object.

        Sword sword = new Sword();
        sword.damage = 10;

        User user = new User();
        user.hp = 55;
        user.staticHp = 56;
        user.sword = sword; //10

        UserChild userChild = new UserChild();
        userChild.hp = 65;

        String path = "src/main/java/com/fo4ik/serialization/user";

        //We need to create a FileOutputStream to write the object to a file
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.writeObject(userChild);
        objectOutputStream.close();

        //When we try to rewrite the data in class User.hp = 100, we will get the same result as before 55, because we didn`t rewrite the data in file
        //But then we rewrite the data in class User.staticHp = 100, we will get the result 100, because we rewrite the data not in file but in class
        user.hp = 100;
        user.staticHp = 100;

        //We need to create a FileInputStream to read the object from a file
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        //We need to cast the object to the User class
        User user1 = (User) objectInputStream.readObject();
        UserChild userChild1 = (UserChild) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("HP: " + user1.hp);
        System.out.println("Static HP: " + user1.staticHp);
        System.out.println("Sword damage: " + user1.sword.damage);
    }
}

class User implements Serializable {
    //Static fields are not serialized
    static int staticHp;
    int hp;
    //Create object Sword

    //transient fields are not serialized
    //In this code we will get the result null, because we didn`t serialize the object Sword

    //transient Sword sword;

    Sword sword;
}

class Sword implements Serializable {
    //If we don`t want to serialize the field, we get the error
    int damage;
}

class UserChild extends User implements Serializable {
    int mana;
}

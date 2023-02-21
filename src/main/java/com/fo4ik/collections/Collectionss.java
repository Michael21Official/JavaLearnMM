package com.fo4ik.collections;

import java.util.*;

public class Collectionss {
    public static void main(String[] args) {
        //Collection is a group of objects represented as a single unit.
        //Java Collections Framework provides many interfaces (Set, List, Queue, Deque) and classes (ArrayList, Vector, LinkedList, PriorityQueue, HashSet, LinkedHashSet, TreeSet).

        Collection collection = new ArrayList<>();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        collection.add("4");

        collection.remove("2");

        //Iterator is an object that can be used to loop through collections, like ArrayList and HashSet. It is called an iterator because "iterating" is the technical term for looping.
        Iterator iterator = collection.iterator();

        //hasNext() returns true if the iteration has more elements.
        /*while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

        //New for loop, check package com.fo4ik.foreach
        for (Object o : collection) {
            System.out.println(o);
        }
        System.out.println("_____________________________");

        //List is an ordered Collection (sometimes called a sequence). Lists may contain duplicate elements.
        List list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        list.remove("2");

        System.out.println("List get 1: " + list.get(1));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        /*for (Object o : list) {
            System.out.println(o);
        }*/

        //We can use set to set value to specific index
        list.set(1, "4");
        //We can use add to add value to specific index
        list.add(3, "5");

        list.forEach(System.out::println);
        System.out.println("_____________________________");


        //Set is a Collection that cannot contain duplicate elements.
        Set set = new HashSet<>();
        //Queue is a collection designed for holding elements prior to processing.
        Queue queue = new PriorityQueue<>();
        //Map is an object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
        Map map = new HashMap<>();


    }
}

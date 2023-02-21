package com.fo4ik.hashCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeExamples {

    public static void main(String[] args) {
        /*hashCode is a method that returns a hash code value for the object.
        This method is supported for the benefit of hash tables such as those provided by HashMap.
        The general contract of hashCode is:
        Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified.
        This integer need not remain consistent from one execution of an application to another execution of the same application.
        If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
        It is not required that if two objects are unequal according to the equals(java.lang.Object) method, then calling the hashCode method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.
        As much as is reasonably practical, the hashCode method defined by class Object does return distinct integers for distinct objects.
         (This is typically implemented by converting the internal address of the object into an integer, but this implementation technique is not required by the JavaTM programming language.)
        The hashCode method for class Object is implemented by simply returning the result of the expression System.identityHashCode(this).
        Note that the hash code values returned by this method are not guaranteed to be unique in the lifetime of an application.
        The hash code values may be the same for different objects at different times of an application's execution.
        */

        Book book = new Book();
        book.Author = "Karnegy";
        book.Name = "How to win friends and influence people";

        //Our ticket to the HashMap

        UserTicket userTicket = new UserTicket();
        userTicket.ticketNumber = 123;
        userTicket.libraryName = "Library";

        //We cant get the same result, because we have different objects, but we can do Override hashCode method to get the same result
        UserTicket userTicketInLibrary = new UserTicket();
        userTicketInLibrary.ticketNumber = 123;
        userTicket.libraryName = "Library";

        //Map is an interface that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
        Map<UserTicket, Book> library = new HashMap();
        library.put(userTicket, book);

        Book Kargagey = library.get(userTicketInLibrary);
        System.out.println("Author: " + Kargagey.Author + "\nName: " + Kargagey.Name);

    }
}

class Book {
    String Author, Name;
}

class UserTicket {
    int ticketNumber;
    String libraryName;

    //We need to override the method hashCode and equals to get the same result

    //Equals method is used to compare the current object with the specified object.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTicket that = (UserTicket) o;

        if (ticketNumber != that.ticketNumber) return false;
        return Objects.equals(libraryName, that.libraryName);
    }

    //HashCode method is used to get the hash code value of the object.
    @Override
    public int hashCode() {
        int result = ticketNumber;
        result = 31 * result + (libraryName != null ? libraryName.hashCode() : 0);
        return result;
    }
}
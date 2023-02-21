package com.fo4ik.exeptions;

public class Exeptions {

    public static void main(String[] args) {
        new Exeptions().printSome();
    }

    void printSome() {
        //Try-catch block is used to handle exceptions
        //Catch block is used to catch the exception
        //Finally block is used to execute some code after the try-catch block
        try {
            Object obj = null;
            //This will throw a NullPointerException
            obj.toString();
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception catched");
        } catch (RuntimeException e) {
            System.out.println("Runtime exception catched");
        } catch (Exception e) {
            System.out.println("Exception catched");
        } finally {
            System.out.println("Finally block executed");
        }
    }
}

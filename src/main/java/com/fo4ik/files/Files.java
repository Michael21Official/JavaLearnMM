package com.fo4ik.files;

import java.io.*;

public class Files {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/fo4ik/files/test.txt");
        //Create a new file, but it`s not created on the disk
        //It`s created only when we call the createNewFile() method
        //In this 'if' will be print "This is not a file or directory"
        if (file.isDirectory()) {
            System.out.println("This is a directory");
        } else if (file.isFile()) {
            System.out.println("This is a file");
        } else {
            System.out.println("This is not a file or directory");
        }

        //There will be printed "File doesn`t exist", because we didn`t create it.
        if (file.exists()) {
            System.out.println("File exists");
        } else {
            System.out.println("File doesn`t exist");
        }

        /**Create a new file on the disk
         * @code file.createNewFile();
         *
         * Create a new directory on the disk
         * {@code File file = new File("test");}
         **/

        System.out.println("\nCreate a new file on the disk");
        file.createNewFile();

        //FileReader and FileWriter are used to read and write data from a file
        FileReader reader = new FileReader(file);
        FileWriter writer = new FileWriter(file);

        if (file.canWrite()) {
            writer.write("str1 \n");
            writer.write("str2 \n");
            //We need to flush the writer to write the data to the file
            //We need to close the writer, because we need to save the data
            writer.flush();
            //writer.close();
        }

        if (file.canRead()) {
            //In while loop we read the data from the file
           char[] chars = new char[10];
           reader.read(chars);
            System.out.println(chars);
        }

        //There we delete the file from the disk
       //file.delete();


        //These methods to read and write data it`s not the best way
        //We can use BufferedReader and BufferedWriter

        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        BufferedReader bufferedReader = new BufferedReader(reader);

        //We can use the same methods as in the FileWriter and FileReader
        bufferedWriter.write("str4");
        bufferedWriter.newLine();
        bufferedWriter.write("str5");
       bufferedWriter.flush();
        bufferedWriter.close();

        //Get the data from the file
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }
    }
}

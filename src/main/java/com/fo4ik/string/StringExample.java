package com.fo4ik.string;

public class StringExample {

    public static void main(String[] args) {
        String str = new String("abc");
        str.concat("def");
        System.out.println(str);    //abc
        String str2 = str.concat("def");
        System.out.println(str2);   //abcdef
    }
}

class StringBufferExample {
    //StringBuffer the same as StringBuilder but it`s synchronized
    //StringBuffer used to work with multiple threads

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("def");
        System.out.println(stringBuffer);    //def
    }
}

class StringBuilderExample {
    //StringBuilder the same as StringBuffer but it`s not synchronized
    //StringBuilder is not thread safe but faster than StringBuffer

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abc");
        stringBuilder.append("def");
        System.out.println(stringBuilder);    //abcdef

        stringBuilder.insert(3, "ghi");
        System.out.println(stringBuilder);    //abcghidef

        stringBuilder.delete(3, 6);
        System.out.println(stringBuilder);    //abcdef
    }
}

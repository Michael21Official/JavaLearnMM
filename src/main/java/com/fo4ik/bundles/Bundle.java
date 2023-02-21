package com.fo4ik.bundles;

import java.util.Locale;
import java.util.ResourceBundle;

public class Bundle {
    public static void main(String[] args) {

        Locale locale = Locale.getDefault();
        locale.setDefault(new Locale("en"));
        ResourceBundle bundle = ResourceBundle.getBundle("lang", locale);


        /*System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getCountry());*/

        System.out.println(bundle.getString("name"));

    }
}

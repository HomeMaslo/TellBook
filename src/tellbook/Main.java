/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tellbook;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author pavel
 */
public class Main {

    private static String path = "book/";

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter r or a or s");
        ArrayList tells = new ArrayList();
        Book Book = new Book();
        String nextLine = scanner.nextLine();
        String aPath = "";
        if ("r".equalsIgnoreCase(nextLine)) {

            File folder = new File(path);
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                System.out.println(listOfFiles[i].getName());
                aPath = path + listOfFiles[i].getName();
                tells = Book.readContact(aPath);

                for (Object tell : tells) {
                    System.out.println(aPath);
                    System.out.println(tell);
                }
            }

        } else if ("a".equalsIgnoreCase(nextLine)) {

            ArrayList<String> lineList = new ArrayList<>();
            System.out.println("enter name");
            lineList.add(scanner.nextLine());
            System.out.println("enter tell");
            lineList.add(scanner.nextLine());
            System.out.println("enter skype");
            lineList.add(scanner.nextLine());
            Book.addContact(lineList);

        } else if ("s".equalsIgnoreCase(nextLine)) {
            System.out.println("enter name");
            String getLine = scanner.nextLine();
            Map<String, ArrayList> hashmap = new HashMap<>();
            File folder = new File(path);
            File[] listOfFiles = folder.listFiles();
            for (File listOfFile : listOfFiles) {
                aPath = path + listOfFile.getName();
                tells = Book.readContact(aPath);
                //  tells.rangeCheck(1);
                if (tells.size() > 1.) {
                    hashmap.put(aPath, tells);
                    //   System.out.println("name - " + tells.get(0));
                }
                for (String key : hashmap.keySet()) {
                    //  System.out.println(hashmap.get(key).get(0));
                    int pos = 0;
                    String lines = (String) hashmap.get(key).get(0);
                    pos = lines.indexOf(getLine);
                    if (pos > -1) {
                        aPath = key;
                    }
                }
            }
            tells = Book.readContact(aPath);

            for (Object tell : tells) {
                System.out.println(tell);
            }
        } else {
            System.out.println("error");
        }
    }

}

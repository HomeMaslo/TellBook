/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tellbook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author pavel
 */
public class Book {

    private static String path = "book/";

    public static void addContact(ArrayList lineList) {
        String line = "";
        try {
            line = String.join("\r", lineList);
            System.out.println(line);
            long time = System.currentTimeMillis();
            String tname = path + Long.toString(time) + ".txt";
            FileOutputStream fis = new FileOutputStream(tname);

            byte[] bytes = line.getBytes();
            fis.write(bytes);
//                fos.flush();
            System.out.println(Arrays.toString(bytes));
            fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static ArrayList readContact(String path) {
        ArrayList tell = new ArrayList();
        try (BufferedReader fis = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = fis.readLine()) != null) {
                // System.out.println(line);
                tell.add(line);
            }

            fis.close();
        } catch (IOException ex) {
        }
        return tell;
    }
}

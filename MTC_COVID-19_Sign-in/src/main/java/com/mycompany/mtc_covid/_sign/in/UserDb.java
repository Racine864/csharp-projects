/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mtc_covid._sign.in;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class UserDb {

    private static final String FILENAME = "Users.txt";
    private static final String COLUMN_SEP = "\t";

    public static ArrayList<User> getAll() {
        var products = new ArrayList<User>();
        try (BufferedReader in
                = new BufferedReader(
                        new FileReader(FILENAME))) {
            String line = in.readLine();
            while (line != null) {
                String[] columns = line.split(COLUMN_SEP);
                String user = columns[0];
                
                User u = new User(user);
                products.add(u);
                line = in.readLine();
            }
            return products;
        } catch (FileNotFoundException e) {
            System.out.println(FILENAME
                    + " doesn't exist.");
            return null;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static void saveAll(ArrayList<User> users) {
        try (PrintWriter out
                = new PrintWriter(
                        new BufferedWriter(
                                new FileWriter(FILENAME)))) {
// write all products to the file
            for (User u : users) {
                out.print(u.getName() + COLUMN_SEP);
                
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
      
}



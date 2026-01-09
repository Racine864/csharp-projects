/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mtc_covid._sign.in;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class MTC_COVID19_SignIn {

    public static void main(String[] args) throws IOException {
        Collection<User> user = new ArrayList<User>();
        String myAdminName = "";
        String myAdminPassword = "";
        String mySelection = "";
        String allName = "";
        String myName = "";

        Scanner sc = new Scanner(System.in);
        System.out.println("What is your Admin name: ");
        myAdminName = sc.nextLine();
        System.out.println("What is your Admin Password: ");
        myAdminPassword = sc.nextLine();
        String myMenu = "\nMain Menu:\n 1: User Time Check-In \n 2: Admin → To display all checkin(or admin work.) \n 3: Close and save users on text (exits program) \n Select your Chose: ";
        String myAdminMenu = "\nAdmin Menu:\n 1: Display All \n 2:Back to Main Menu \n Select your Chose: ";
        int choice = 0;
        int adminChoice = 0;
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter("Users.txt", true))); // write a string and an object to the file
        out.print("This application was run on ");
        LocalDateTime currentDateTime = LocalDateTime.now();
        out.println(currentDateTime);
        // flush data to the file and close the output stream

        // flush data to the file and close the output stream
        System.out.print(myMenu);

        try {
            choice = Integer.parseInt(sc.nextLine());
            while (choice != 3) {
                switch (choice) {
                    case 1 -> {
                        mySelection = "User Time Check-In";
                        System.out.print("User Time Check-In\n ");
                        //Check in case -->Same as MTC SignIN

                        System.out.println("What is your name: ");
                        myName = sc.nextLine();
                        
                        allName += myName + " | ";
                        
                        //Keep adding others like MTC signIN
                        System.out.println("Your information is : " + myName);
                        
                    }

                    case 2 -> {
                        mySelection = "Administrator";
                        //Admin Case
                        System.out.println("\nWhat is your Admin Name: ");
                        myAdminName = sc.nextLine();
                        System.out.println("What is your Password: ");
                        myAdminPassword = sc.nextLine();

                        if (myAdminName.equals(myAdminName) && myAdminPassword.equals(myAdminPassword)) {
                            System.out.print(myAdminMenu);
                            adminChoice = Integer.parseInt(sc.nextLine());
                            while (adminChoice != 2) {
                                
                                switch (adminChoice) {
                                    case 1 -> {
                                        System.out.print("All users signed-in : \n");
                                       
                                        System.out.print(allName);
                                    }
                                    case 2 -> {
                                        System.out.println("Exit admin. \n");
                                    }
                                }

                                System.out.print(myAdminMenu);
                                adminChoice = Integer.parseInt(sc.nextLine());
                            }
                        } else {
                            System.out.print("Wrong admin authentication.\n");
                        }

                    }

                    case 3 ->
                        mySelection = "Exit";

                }
                //System.out.print(mySelection);
                System.out.print(myMenu + "\n");

                choice = Integer.parseInt(sc.nextLine());

            }

        } catch (NumberFormatException e) {
            System.out.println("Error! cannot accept string value value.");

        }

        out.println(allName);

        out.close();

    }

}

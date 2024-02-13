/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myjava1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author Ali Raza
 */
public class CustomerList {

    private ArrayList<Customer> clients;

    public CustomerList() {
        this.clients = null;
    }

    public void create() {
        this.clients = new ArrayList<Customer>();
    }

    public void add(Customer src) {
        this.clients.add(src);
    }

    public void remove(Customer src) {
        clients.remove(src);
    }
    public int size(){
        return this.clients.size();
    }
    public Customer remove(String surname) {
        Customer removed = null;
        boolean isChange = false;
        for (int i = 0; i < clients.size(); ++i) {
            if (clients.get(i).getSurName().equals(surname)) {
                removed = clients.remove(i);
                isChange = true;
                break;
            }
        }
        if(isChange)
            saveToFile();
        return removed;
    }//remove

    public Customer search(String surname) {
        Customer toReturn = null;

        for (Customer c : clients) {
            if (c.getSurName().toLowerCase().equals(surname.toLowerCase())) {
                toReturn = c;
                break;
            }
        }
        return toReturn;
    }

    public void Display(JTextArea jClientsTextArea) {

        for (int i = 0; i < clients.size(); ++i) {
            clients.get(i).Display(jClientsTextArea);
        }

    }

    public void loadFromFile() {
        try {
            Scanner read = new Scanner(new File("clients.txt"));
            String allRawData = "";
            while (read.hasNext()) {
                String line = read.nextLine();
                if (line.trim().length() > 0) {
                    allRawData += line + "\n";
                }//if

            }//while

            String[] rawDataArray = allRawData.trim().split("##");
            System.out.println("No of Clients in raw: " + rawDataArray.length);
            if (rawDataArray.length > 0) {
                this.create();

                for (int i = 0; i < rawDataArray.length; ++i) {
                    String[] singleCustomerArray = rawDataArray[i].trim().split("\n");
                    System.out.println("Single length: " + singleCustomerArray.length);
                    if (singleCustomerArray.length == 12) {

                        String firstName, surName;
                        Date dob, customerSince;
                        String name, housename, street, area, postcode, town, country;
                        int houseNo;
                        surName = singleCustomerArray[0];
                        firstName = singleCustomerArray[1];
                        dob = new Date(singleCustomerArray[2]);
                        customerSince = new Date(singleCustomerArray[3]);

                        name = singleCustomerArray[4];
                        housename = singleCustomerArray[5];
                        houseNo = Integer.parseInt(singleCustomerArray[6]);
                        street = singleCustomerArray[7];
                        area = singleCustomerArray[8];
                        postcode = singleCustomerArray[9];
                        town = singleCustomerArray[10];
                        country = singleCustomerArray[11];

                        Customer temp = new Customer(firstName, surName, dob, customerSince);
                        temp.EditAddress(name, street, houseNo, housename, area, postcode, town, country);
                        this.clients.add(temp);

                    }//inner-if
                }//for
            }//outer-if
            System.out.println("No of clients in list: " + this.clients.size());
        } catch (Exception e) {
            System.out.println("CustomerList data not read");
        }
    }//loadFromFile

    public void saveToFile() {
        try{
        FileWriter writer = new FileWriter(new File("clients.txt"));
        writer.write("");
        writer.close();
        for (Customer c : clients) {

            c.SaveToFile(true);
        }
        }catch (Exception e){
            System.out.println("clients txt file not found");
        }
       
    }

}//class

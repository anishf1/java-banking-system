/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myjava1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Ali Raza
 */
public class Customer {
    private String FirstName;
    private String SurName;
    private IAddress HomeAddress;
    private Date DOB;
    private Date CustomerSince;
    

    public static SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy");
    
   public Customer(){
       HomeAddress= new IAddress();
       HomeAddress.Edit(" "," "," "," "," "," "," ",0);
   } 

    public Customer(String FirstName, String SurName, Date DOB, Date CustomerSince) {
        this();
        this.Edit(FirstName, SurName, DOB, CustomerSince);
    }
   
   
   public void Edit(String fname,String sname,Date dob, Date customerSince){
        
       this.FirstName = fname;
       this.SurName = sname;
       this.DOB = dob;
       this.CustomerSince = customerSince;
    }
   
    public void EditAddress(String Name, String Street, int HouseNo, String HouseName, String Area, String PostCode, String Town, String Country ){
        HomeAddress.Edit(Name, HouseName, Street, Area, PostCode, Town, Country, HouseNo);
    }

    public String getSurName() {
        return SurName;
    }
    
    public IAddress getIAddress() {
        return HomeAddress;
    }
    
    public void Display(JTextArea jClientsTextArea){
        
        jClientsTextArea.setLineWrap(true);
        jClientsTextArea.append(this.toString());
        DisplayAddress(jClientsTextArea);
        jClientsTextArea.append("\n");
        
    }
      private void DisplayAddress (JTextArea jClientsTextArea){
     
         HomeAddress.Display(jClientsTextArea);
 
    }
    @Override
    public String toString(){
        return FirstName+" "+SurName+" "+sdf.format(DOB)+" "+sdf.format(CustomerSince)+"\n";
    }
    
    public void SaveToFile(boolean append){
        try{
            FileWriter writer;
            writer = new FileWriter("clients.txt", append);
            String string = SurName + "\n" + FirstName + "\n" + sdf.format(DOB)+"\n"+sdf.format(CustomerSince);
            writer.write(string+System.getProperty("line.separator"));
            HomeAddress.SaveToFile(writer);
            writer.flush();
            writer.close();
            writer = null;
           
        }
        catch(IOException ioe){
            System.out.println("Could Not Save");
        }
    }
   
   
     public void LoadFromFile(){
        FileReader reader;
        try{
            reader = new FileReader("clients.txt");
            BufferedReader bin = new BufferedReader(reader);
            this.SurName = bin.readLine();
            this.FirstName = bin.readLine();
            this.DOB = new Date(bin.readLine());
            this.CustomerSince = new Date(bin.readLine());
            String name, housename, street, area, postcode, town, country;
            int houseNo = 0;
            name = bin.readLine();
            housename = bin.readLine();
            houseNo = Integer.valueOf(bin.readLine());
            street = bin.readLine();
            area = bin.readLine();
            postcode = bin.readLine();
            town = bin.readLine();
            country = bin.readLine();
            this.EditAddress(name, street, houseNo, housename, area, postcode, town, country);
            
        }
        catch(IOException ioe){
            System.out.println("Could Not load");
        }
    }
   
    public static void main(String[] args) {
       Customer c = new Customer("Anish", "Patel", new Date(), new Date());
       c.EditAddress("Fidous", "J-3", 93, "Hotel", "Street", "39", "Uxbridge", "England");
       c.SaveToFile(true);
    }
    
}//customer

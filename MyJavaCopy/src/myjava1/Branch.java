/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author 2022127
 */
public class Branch {
   
    private String working_hours;
    private String sort_code;
    private String manager;
    private IAddress theAddress;
   
   
   
    public Branch(String Sworking_hours,String Ssort_code,String Smanager){
   
       this.Edit(Sworking_hours, Ssort_code, Smanager);
   
    }
    public Branch(){
    theAddress= new IAddress();
   theAddress.Edit(" "," "," "," "," "," "," ",0);
     
 
   
   
    }
   
    public void Edit(String Sworking_hours,String Ssort_code,String Smanager){
        working_hours=Sworking_hours;
        sort_code=Ssort_code;
        manager=Smanager;
 
   
    }
    public void Display (JTextArea jTextAreaAddress){
     
        jTextAreaAddress.setLineWrap(true);
        jTextAreaAddress.append(this.toString());
 
    }
    
     public void DisplayAddress (JTextArea jTextAreaAddress){
     
         theAddress.Display(jTextAreaAddress);
 
    }
    
   
    public void EditAddress(String Name, String Street, int HouseNo, String HouseName, String Area, String PostCode, String Town, String Country ){
        theAddress.Edit(Name, HouseName, Street, Area, PostCode, Town, Country, HouseNo);
    }
   
       
    public String toString(){
    return (working_hours+" "+sort_code+" "+manager+" ");
   
    }
   public void SaveToFile(boolean append){
        try{
            FileWriter writer;
            writer = new FileWriter("branches.txt", append);
            String string = manager + "\n" + sort_code + "\n" + working_hours;
            writer.write(string+System.getProperty("line.separator"));
            theAddress.SaveToFile(writer);
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
            reader = new FileReader("branches.txt");
            BufferedReader bin = new BufferedReader(reader);
            String record,Name,Street,HouseName,Area,PostCode,Town,Country;
            Integer HouseNo;
            record = new String();
            record=bin.readLine();
            manager = record;
            record=bin.readLine();
            sort_code = record;
            record=bin.readLine();
            working_hours = record;
            record=bin.readLine();
            Name = record;
            record=bin.readLine();
            HouseName = record;
            record=bin.readLine();
            HouseNo = Integer.valueOf(record);
            System.out.println(HouseNo);
            record=bin.readLine();
            Street = record;
            record=bin.readLine();
            Area = record;
            record=bin.readLine();
            PostCode = record;
            record=bin.readLine();
            Town = record;
            record=bin.readLine();
            Country = record;
            record=bin.readLine();
            this.EditAddress(Name, Street, HouseNo, HouseName, Area, PostCode, Town, Country);
            //theAddress.LoadFromFile(bin);
           
        }
        catch(IOException ioe){
            System.out.println("Could Not load");
        }
    }
   
   
   
   
   
}
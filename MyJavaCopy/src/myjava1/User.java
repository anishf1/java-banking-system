package myjava1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author 2022127
 */
public class User {
   
    private String name;
    private String role="";
    private String password;
    private String filename="login.txt";

   
   
    public void User(){}
   
    public boolean  isRegistered(String newName, String newPassword,String newRole){
    boolean isRegistered;
    name= newName;
    password= newPassword;
    role=newRole;
    FileWriter writer;
    try {
        writer=new FileWriter(filename, true );
        writer.write(name+System.getProperty("line.separator"));
         writer.write("##"+System.getProperty("line.separator"));
        writer.write(password+System.getProperty("line.separator"));
         writer.write("##"+System.getProperty("line.separator"));
            writer.write(role+System.getProperty("line.separator"));      
        writer.write("##"+System.getProperty("line.separator"));
        isRegistered=true;
        writer.flush();
        writer.close();
        writer =null;
   
   
    }catch (IOException ioe){
        isRegistered = false;
   
    }
    return isRegistered;
   
    }
   
    public boolean isUser(String newName, String newPassword){
   
    name=newName;
    boolean isFound =false;
    String record;
    FileReader reader;
    try{
        reader = new FileReader(filename);
        BufferedReader bin = new BufferedReader(reader);
        record = new String();
        while((record=bin.readLine())!=null){
           if (newName.contentEquals(record)){
               record= bin.readLine();
               record= bin.readLine();
               
               if (newPassword.contentEquals(record)){
                   isFound= true;
                   
                }
                   
                   
                }
           
            }
                               
            bin.close();
            bin = null;            
                       
       
    }catch(IOException ioe){
        isFound=false;
   
    }
    return isFound;
   
   
   
   
    }
public String getRole(String username,String Password){
     String role="";
    String record;
    FileReader reader;
    try{
        reader = new FileReader(filename);
        BufferedReader bin = new BufferedReader(reader);
        record = new String();
        while((record=bin.readLine())!=null){
           if (username.contentEquals(record)){
               record= bin.readLine();
               record= bin.readLine();
               
               if (Password.contentEquals(record)){
                   record= bin.readLine();
                   record= bin.readLine();
                 role=record;  
                }
                   
                   
              }
           
            }
                               
            bin.close();
            bin = null;            
                       
    }catch(IOException ioe){
      role="unavailable";
   
    }
    return role;
}
 


public boolean usernameunique(String username){
   
    boolean unique = true;
    String record;
    FileReader reader;
    try{
        reader = new FileReader(filename);
        BufferedReader bin = new BufferedReader(reader);
        record = new String();
        while((record=bin.readLine())!=null){
           if (username.contentEquals(record)){
               unique = false;
              
                }
           
            }
                               
            bin.close();
            bin = null;            
                       
       
    }catch(IOException ioe){
        unique = false;
   
    }
    return unique;
   
    }

}





//manager
        //admin
                //advisor
                        //customer
                
//Add these permissions as these are the different people who can login
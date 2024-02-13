package myjava1;

import java.io.File;
import java.util.Date;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author 2022127
 */
public class person {
   
    private String first_name;
    private String surname;
    private IAddress home_address;
    private Date DOB;
    private person account_holder;
   
    public person (String Sfirst_name,String Ssurname,IAddress IAhome_address,Date DDOB,person Caccount_holder){
   
    this.Edit(Sfirst_name, Ssurname, IAhome_address, DDOB, Caccount_holder);
   
    }

   public person() {
       
    }
   
    public String toString(){
   
        return (first_name+" "+surname+" "+ home_address+" "+DOB);
   
    }
    public void Display(JTextArea jTextAreaAddres){
       
        jTextAreaAddres.append(first_name+" "+surname+" "+ home_address+" "+DOB);
   
    }

public void Edit(String Sfirst_name,String Ssurname,IAddress IAhome_address,Date DDOB,person Caccount_holder){
   
    first_name=Sfirst_name;
    surname=Ssurname;
    home_address=IAhome_address;
    DOB=DDOB;
    account_holder=Caccount_holder;
   
}
public boolean  checkDOB(String GivenDOB){
if (DOB.toString()==GivenDOB){
   return true;
}
else{
    return false;
}
}




}
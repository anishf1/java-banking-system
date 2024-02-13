package myjava1;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author 2022127
 */
public class IAddress {

    private String name;
    private String house_name;
    private String street;
    private String area;
    private String post_code;
    private String town;
    private String country;
    private Integer house_no;

    public String toString() {
        return (name + "\n" + house_name + "\n" + String.valueOf(house_no) + "\n" + street + "\n" + area + "\n" + post_code + "\n" + town + "\n" + country)+"\n";

    }

    public IAddress() {

        this.Edit("", "", "", "", "", "", "", 0);

    }

    public IAddress(String Sname, String Shouse_name, String Sstreet, String Sarea, String Spost_code, String Stown, String Scountry, Integer Ihouse_no) {

        this.Edit(Sname, Shouse_name, Sstreet, Sarea, Spost_code, Stown, Scountry, Ihouse_no);

    }

    public void Display(JTextArea jTextAreaAddress) {
        jTextAreaAddress.setLineWrap(true);
        jTextAreaAddress.append(toString());

    }

    public void Edit(String Sname, String Shouse_name, String Sstreet, String Sarea, String Spost_code, String Stown, String Scountry, Integer Ihouse_no) {

        name = Sname;
        house_name = Shouse_name;
        street = Sstreet;
        area = Sarea;
        post_code = Spost_code;
        town = Stown;
        country = Scountry;
        house_no = Ihouse_no;

    }

    public void SetHouseNO(int NUMB) {
        if (NUMB > 0) {
            house_no = NUMB;
        } else {
            System.err.println("error");
        }

    }

    public void SaveToFile(FileWriter writer) {
        try {
            String string;
            string = name + "\n" + house_name + "\n" + house_no.toString() + "\n" + street + "\n" + area + "\n" + post_code + "\n" + town + "\n" + country + "\n";
            writer.write(string + System.getProperty("line.separator"));
            writer.write("##" + System.getProperty("line.separator"));
        } catch (IOException ioe) {
            System.out.println("Couldn't save");
        }
    }

    public void LoadFromFile(BufferedReader bin) {
        String record;
        try {
            record = new String();
            while ((record = bin.readLine()) != null) {
                name = record;
                record = bin.readLine();
                house_name = record;
                record = bin.readLine();
                house_no = Integer.getInteger(record);
                record = bin.readLine();
                street = record;
                record = bin.readLine();
                area = record;
                record = bin.readLine();
                post_code = record;
                record = bin.readLine();
                town = record;
                record = bin.readLine();
                country = record;
                record = bin.readLine();
                this.Edit(name, house_name, street, area, post_code, town, country, house_no);
            }
        } catch (IOException ioe) {
            System.out.println("Couldn't load");
        }
    }

}

// This program saves the Person object data to a .dat file with a name chosen by the user. It is called to
// by Demo.java

import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Person implements Serializable, Comparable<Person> {
    String name;
    long accountNumber;
    double balance;
    boolean cBack;

    public Person (String name, long accountNumber, double balance, boolean cBack) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.cBack = cBack;
    }

    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }

    public String toString() {
        String cBackVerbal;

        if (this.cBack) {
            cBackVerbal = "Yes";
        }
        else {
            cBackVerbal = "No";
        }

        String returnString = String.format("%20s%20d%10.2f%10s", this.name, this.accountNumber, this.balance, cBackVerbal);
        return returnString;
    }

    public void save() {
        String fileName = accountNumber + ".dat";
        Person temp = new Person(this.name, this.accountNumber, this.balance, this.cBack);
        FileOutputStream oStream = null;

        try{
            oStream = new FileOutputStream(fileName);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectOutputStream saveFile = null;

        try {
            saveFile = new ObjectOutputStream(oStream);
            saveFile.writeObject(temp);
            oStream.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
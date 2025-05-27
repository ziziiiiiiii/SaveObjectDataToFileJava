// This file stores customer banking information in an object, then saves it in a .dat file with
// a name chosen by the user.

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person test1 = new Person("Eachelle Balderstone",
                30526110612015L,
                9866.30,
                false);

        Person test2 = new Person("Brand Hallam",
                3573877643495486L,
                9985.21,
                false);

        Person test3 = new Person("Tiphanie Oland",
                5100172198301454L,
                9315.15,
                true);

        test1.save();
        test2.save();
        test3.save();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter file name");
        String filename = keyboard.nextLine();

        FileInputStream istream = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(istream);
        Person p = (Person)ois.readObject();
        ois.close();
        System.out.println(p);
    }
}

/**
* to run test.java - type java test.java
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test{
    public static void main(String[] args) {
        int a = 123;
        a = a-- - --a;
        System.out.println(a);
        String s = "Date: 01-02-2022; 10:00:00 Name: Seminar";
        saveEvent("calendar.txt",s);
    }

    public static void saveEvent(String path, String event){
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.append(String.format("%s\n", event));
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }   
    }
 }




//  public void save() {

//     try (FileWriter writer = new FileWriter(path, false)) {
//         for (int i = 0; i < currentBook.count(); i++) {
//             Contact contact = currentBook.getCotact(i);
//             writer.append(String.format("%s\n", contact.firstName));
//             writer.append(String.format("%s\n", contact.lastName));
//             writer.append(String.format("%s\n", contact.description));
//         }
//         writer.flush();
//         writer.close();
//     } catch (IOException ex) {
//         System.out.println(ex.getMessage());
//     }
// }

// public void load() {
//     try {
//         File file = new File(path);
//         FileReader fr = new FileReader(file);
//         BufferedReader reader = new BufferedReader(fr);
//         String fname = reader.readLine();
//         while (fname != null) {
//             String lname = reader.readLine();
//             String description = reader.readLine();
//             this.currentBook.add(new Contact(fname, lname, description));
//             fname = reader.readLine();
//         }
//         reader.close();
//         fr.close();
//     } catch (Exception e) {
//         e.printStackTrace();
//     }
// }

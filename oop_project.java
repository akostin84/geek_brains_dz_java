// создание нового проекта "Календарь": задача создать календарь в котором есть возможность делать записи на определенный день. 
// Работа через консоль. Должна быть реализована возможность просмотра календаря, просмотра записей на определенный день, 
// добавление записей (например "в 14:00 стоматолог"). Реализована возможность сохранения календаря в файл и восстановление из файла. 
// Этот проект должен быть выполнен также с учетом принципов SOLID’а

import java.util.*;
import java.text.*;
import java.io.*;

public class oop_project {
    public static void main(String[] args) {
        String initialMsg = String.format("%s\n%s\n%s\n%s\n%s", "Final project: CALENDAR",
        "Select mode:", "1 - Load the whole calendar", "2 - Load the selected day", "3 - Create new calendar"); 
        System.out.println(initialMsg);
        int mode = readIntFromTerminal("You select:");
        Calendar c = new Calendar("calendar.txt");
        System.out.println(c);  
    }

    static int readIntFromTerminal(String message) {
        Scanner reader = new Scanner(System.in);
        System.out.print(message);
        String strNumber = reader.nextLine(); 
        int Number = Integer.parseInt(strNumber);
        reader.close();
        return Number;
    }
}

interface Saveable {
    void save();
}

interface Loadable {
    void load();
}

class Calendar{
    public ArrayList<Event> events = new ArrayList<Event>();

    public Calendar(String path){
        ArrayList<String> eventsStr = readContent(path);
        for (int i = 0; i < eventsStr.size(); i++){
            String[] splittedStr = eventsStr.get(i).split("/");
            String date_part = splittedStr[0];
            String time_part = splittedStr[1];
            String name_part = splittedStr[2];
            Event e = new Event(date_part, time_part);
            e.setName(name_part);
            this.events.add(e);
        }  
    };

    @Override
    public String toString(){
        String output = "";
        for (int i = 0; i < this.events.size(); i++){
            output += this.events.get(i) + "\n";
        }
        return output;            
    }

    private ArrayList<String> readContent(String path){
        ArrayList<String> words = new ArrayList<String>();
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                try{
            reader.close();
            } catch (Exception exp) {}
        }
        return words;
    }

}

class Event implements Saveable{
    private Date EventTime;
    private String Name;
    private static final String PATH = "calendar.txt";
    
    public Event(String day, String time){
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy; HH:mm:ss");
        String DateString = String.format("%s; %s", day, time);
        try {
            EventTime = sf.parse(DateString);
            Name = "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy; HH:mm:ss");
        String output = String.format("Date: %s Name: %s\n", df.format(EventTime), Name);
        return output;            
    }

    public String toFile(){
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy; HH:mm:ss");
        String output = String.format("%s/%s", df.format(EventTime), Name);
        return output;            
    }

    public void setName(String n){
        this.Name = n;
    }

    public Date getTime(){
        return this.EventTime;
    }

    public String getName(){
        return this.Name;
    }

    public void save(){
        try (FileWriter writer = new FileWriter(PATH, true)) {
            writer.append(String.format("%s\n", this.toFile()));
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

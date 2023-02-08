// создание нового проекта "Календарь": задача создать календарь в котором есть возможность делать записи на определенный день. 
// Работа через консоль. Должна быть реализована возможность просмотра календаря, просмотра записей на определенный день, 
// добавление записей (например "в 14:00 стоматолог"). Реализована возможность сохранения календаря в файл и восстановление из файла. 
// Этот проект должен быть выполнен также с учетом принципов SOLID’а

import java.util.*;
import java.text.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;

public class oop_project {
    public static void main(String[] args) {
        Event a = new Event("01-01-2022", "12:23:10");
        a.setName("Surgery");
        System.out.println(a);
        System.out.println(a.getName());
        System.out.println(a.getTime());
        a.save();
    } 
}

interface Saveable {
    void save();
}

interface Loadable {
    void load();
}

class Calendar{
    private List<Event> events;

    public Calendar(String path){
        
    };

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
            writer.append(String.format("%s\n", this.toString()));
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

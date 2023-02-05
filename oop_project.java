// создание нового проекта "Календарь": задача создать календарь в котором есть возможность делать записи на определенный день. 
// Работа через консоль. Должна быть реализована возможность просмотра календаря, просмотра записей на определенный день, 
// добавление записей (например "в 14:00 стоматолог"). Реализована возможность сохранения календаря в файл и восстановление из файла. 
// Этот проект должен быть выполнен также с учетом принципов SOLID’а

import java.util.*;
import java.text.*;
import java.time.*;

public class oop_project {
    public static void main(String[] args) {
        Event a = new Event("01-01-2022", "12:23:10");
        a.setName("name a");
        a.setDescription("in somethere");
        System.out.println(a);
    }

    static class Event{
        public Date EventTime;
        public String Name;
        public String Description;
        
        public Event(String day, String time){
            SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy; HH:mm:ss");
            String DateString = String.format("%s; %s", day, time);
            try {
                EventTime = sf.parse(DateString);
                Name = "";
                Description = "";
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString(){
            String output = String.format("Date: %s \n Name: %s \n Description: %s \n", EventTime, Name, Description);
            return output;            
        }

        public void setName(String n){
            Name = n;
        }

        public void setDescription(String d){
            Description = d;
        }
    }
    
}

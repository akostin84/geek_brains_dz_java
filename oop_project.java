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
        "Select mode:", "1 - Load the whole calendar", "2 - Load the selected day", 
        "3 - Add new note"); 
        System.out.println(initialMsg);
        Scanner reader = new Scanner(System.in);
        int userMode = readIntFromTerminal("You select:", reader);
        //switch case
        switch (userMode) {
            case  (1):
                Calendar c = new Calendar("calendar.txt");
                System.out.println(c); 
                break;
            case (2):
                String userDay1 = readStrFromTerminal("Enter day [dd-MM-yyyy]: ", reader);
                Calendar c1 = new Calendar("calendar.txt");
                ArrayList<Event> e = c1.events;
                for (int i = 0; i < e.size(); i++)
                    if (e.get(i).isUserDay(userDay1)){
                        System.out.println(e.get(i));
                    }  
                break;
            case (3):
                String userDay = readStrFromTerminal("Enter day [dd-MM-yyyy]: ", reader);
                String userTime = readStrFromTerminal("Enter time [HH:mm:ss]: ", reader);
                String userName = readStrFromTerminal("Enter name: ", reader);
                Event newEvent = new Event(userDay, userTime);
                newEvent.setName(userName);
                newEvent.save();
                break;
            default:
                System.out.println("Wrong selection");
                break;
        }
        reader.close();
 
    }

    static int readIntFromTerminal(String message, Scanner reader) {
        System.out.print(message);
        String strNumber = reader.nextLine(); 
        int Number = Integer.parseInt(strNumber);
        return Number;
    }

    static String readStrFromTerminal(String message, Scanner reader) {
        System.out.print(message);
        String strUser = reader.nextLine();
        return strUser;
    }
}

interface Saveable {
    void save();
}

class Calendar{
    public ArrayList<Event> events = new ArrayList<Event>();

    // создание календаря из содержимого файла
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
    // построчный вывод для чтения содержимого календаря
    @Override
    public String toString(){
        String output = "";
        for (int i = 0; i < this.events.size(); i++){
            output += this.events.get(i) + "\n";
        }
        return output;            
    }
    // чтение файла календаря как список строк
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

// класс для единичной записи с указанием времени и заголовка
class Event implements Saveable{
    private Date EventTime; // время события
    private String Name; // сущность события
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

    // проверка, что событие произошло в указанный день
    public boolean isUserDay(String user_day){
        String start_user_day = user_day + "; 00:00:00";
        String end_user_day = user_day + "; 23:59:00";
        SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy; HH:mm:ss");
        Date start_day = new Date();
        Date end_day = new Date();
        try {
            start_day = sfd.parse(start_user_day);
            end_day = sfd.parse(end_user_day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        if (end_day.after(this.getTime()) && start_day.before(this.getTime())) {
            return true;
        } else {
            return false;
        }
    }

    // при выводе на экран для пользователя добавляются поля Date: и Name:
    @Override
    public String toString(){
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy; HH:mm:ss");
        String output = String.format("Date: %s Name: %s\n", df.format(EventTime), Name);
        return output;            
    }
    // при записи в файл поля разделяются слешем /
    public String toFile(){
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy/HH:mm:ss");
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
// метод для сохранения нового события
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

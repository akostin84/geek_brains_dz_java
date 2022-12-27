// Урок 6. Хранение и обработка данных ч3: множество коллекций Set
// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

public class Notebook {
    private String Model;
    private int Memory;
    private int HardDrive;
    private String OperatingSystem;
    private String Color;

    public Notebook(){};

    public Notebook(String name, int m, int hd, String os, String c){
        this.setModel(name);
        this.setMemory(m);
        this.setHardrive(hd);
        this.setOperatingSystem(os);
        this.setColor(c);
    };

    public String getModel(){
        return Model;
    }

    public int getMemory(){
        return Memory;
    }

    public int getHardDrive(){
        return HardDrive;
    }

    public String getOperatingSystem(){
        return OperatingSystem;
    }

    public String getColor(){
        return Color;
    }

    public void setModel(String n){
        Model = n;
    }

    public void setMemory(int m){
        Memory = m;
    }

    public void setHardrive(int hd){
        HardDrive = hd;
    }

    public void setOperatingSystem(String os){
        OperatingSystem = os;
    }

    public void setColor(String c){
        Color = c;
    }

    @Override
    public String toString(){
        return String.format("%s %s with %d Gb memory, %d Gb disk,", 
        Color, Model, Memory, HardDrive); 
    }
    
}

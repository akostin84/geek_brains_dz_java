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
    private int Memory;
    private int HardDrive;
    private String OperatingSystem;
    private String Color;

    public Notebook(){};

    public Notebook(int m, int hd, String os, String c){
        this.setMemory(m);
        this.setHardrive(hd);
        this.setOperatingSystem(os);
        this.setColor(c);
    };

    public int getMemory(){
        return this.Memory;
    }

    public int getHardDrive(){
        return this.HardDrive;
    }

    public String getOperatingSystem(){
        return this.OperatingSystem;
    }

    public String getColor(){
        return this.Color;
    }

    public void setMemory(int m){
        this.Memory = m;
    }

    public void setHardrive(int hd){
        this.HardDrive = hd;
    }

    public void setOperatingSystem(String os){
        this.OperatingSystem = os;
    }

    public void setColor(String c){
        this.Color = c;
    }
    
}

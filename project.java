import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class project {
    public static void main(String[] args) {
        Notebook n1 = new Notebook("lenovo", 8, 500, "Windows", "gray");
        System.out.println(n1);

        Notebook n2 = new Notebook("hp", 32, 500, "Windows", "white");
        System.out.println(n2);

        Notebook n3 = new Notebook("lenovo 2", 16, 256, "DOS", "black");
        System.out.println(n3);

        Notebook n4 = new Notebook("asus", 16, 256, "Linux", "black");
        System.out.println(n4);

        Notebook n5 = new Notebook("msi", 32, 500, "Linux", "red");
        System.out.println(n5);


        var notebooks = new HashSet<Notebook>(Arrays.asList(n1, n2, n3, n4, n5));
        
        Scanner reader = new Scanner(System.in);

        String message = "Select filter:\n 1 - Operating System\n 2 - Disk Size\n 3 - Memory size\n 4 - Color";
        
        int filter = readIntFromTerminal(message, reader);

        switch (filter){
            case 1:
                filterOS(notebooks, reader);
                break;
            case 4:
                filterColor(notebooks, reader);
                break;
            case 2:
                filterDiskSize(notebooks, reader);
                break;
            case 3:
                filterMemorySize(notebooks, reader);
                break;
            default:
                System.out.println("Wrong number");
                break;
        }
    }

    static int readIntFromTerminal(String message, Scanner reader) {
        System.out.println(message);
        String strNumber = reader.nextLine(); 
        int Number = Integer.parseInt(strNumber);
        return Number;
    }


    static String getFilter(String message, Scanner reader){
        System.out.println(message);
        String operation = reader.nextLine();
        return operation;
    }


    static void filterOS(HashSet<Notebook> notebooks, Scanner reader){
        String UserSystem = getFilter("Enter Operating System:", reader);
        for (Notebook n : notebooks) {
            if (UserSystem.equals(n.getOperatingSystem())) {
                System.out.println(n);
            }
        }
    }


    static void filterColor(HashSet<Notebook> notebooks, Scanner reader){
        String UserColor= getFilter("Enter Color:", reader);
        for (Notebook n : notebooks) {
            if (UserColor.equals(n.getColor())) {
                System.out.println(n);
            }
        }
    }


    static void filterDiskSize(HashSet<Notebook> notebooks, Scanner reader){
        int UserMin = readIntFromTerminal("Enter Min Disk Size:", reader);
        int UserMax = readIntFromTerminal("Enter Max Disk Size:", reader);
        for (Notebook n : notebooks) {
            if (n.getHardDrive() >= UserMin && n.getHardDrive() <= UserMax) {
                System.out.println(n);
            }
        }
    }


    static void filterMemorySize(HashSet<Notebook> notebooks, Scanner reader){
        int UserMin = readIntFromTerminal("Enter Min Memory Size:", reader);
        int UserMax = readIntFromTerminal("Enter Max Memory Size:", reader);
        for (Notebook n : notebooks) {
            if (n.getMemory() >= UserMin && n.getMemory() <= UserMax) {
                System.out.println(n);
            }
        }
    }
}

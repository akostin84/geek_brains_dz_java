import java.util.Arrays;
import java.util.HashSet;

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
        //System.out.println(notebooks.size());
        
        for (Notebook n : notebooks) {
            System.out.println(n.getMemory());
        }

    }
    
}

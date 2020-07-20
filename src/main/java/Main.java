import core.Database;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args){
        try {
            Database db = new Database();
            int[] tab = db.getArrayOfNumbers();
            for(int i = 0 ; i < tab.length ; i++)
                System.out.println(i + 1 + " " + tab[i]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import core.Database;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            Database db = new Database();
            System.out.println(db.getNumberOfRecords());
            int[] tab = db.getArrayOfNumbers();
            for(int i = 0 ; i < tab.length ; i++)
                System.out.println(i + 1 + " " + tab[i]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

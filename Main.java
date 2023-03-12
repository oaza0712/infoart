import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args){

       

        readFile("atrikli.txt");
        //napravi klasu s praznim konstruktorom kojia ima atrribute za izlaznu datoteku
        //

        /*
         * • šifru artikla, artikl.txt
         * • naziv artikla, artikl.txt
         * • cijenu artikla u eurima, cjenik.txt
         * • količinu artikla u svim prodavaonicama, stanje.txt
         * • jedinicu mjere artikla, artikl.txt
         * • ukupnu vrijednost artikla u svim prodavaonicama u eurima, uzmi za 1 artikl cijenu iz cjenik.txt i onda 
         * • ukupnu vrijednost artikla u svim prodavaonicama u odabranoj stranoj valuti -- povuči s apija za valutu zadanu u argumentu
         * • broj prodavaonica u kojima se artikl nalazi. -generiraš sama pretraživanjem fajla stanje.txt
         */

    }

    public static void readFile(String pathName){
        try {

            File file = new File(pathName);
            BufferedReader reader = new BufferedReader(new FileReader(file.getCanonicalPath()));
            String line;
        
            while((line = reader.readLine()) != null) {
                  System.out.println(line);
            }

            reader.close();

        } catch(IOException e) {
              e.printStackTrace();
        }

    }

}


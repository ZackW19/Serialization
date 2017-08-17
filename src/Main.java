import java.io.*;
import java.util.ArrayList;
import java.util.List;

//podejście do odczytu/zapisu do ver Java 1.7
//od wersji 1.8 korzystamy z metod Files

public class Main {
    public static void main(String[] args) {
        File file = new File("leniwiec.jpg");  //klasa File wskazuje na plik - sciezka itp
        File fileCopy = new File("leniwiec1.jpg");

        if(!fileCopy.exists()){
            try {
                fileCopy.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        try {
            //dzięki strumieniom Stream otwieramy . dodajemy i zamykamy plik
            //odczyt z pliku
             FileInputStream fileInputStream = new FileInputStream(file);

            int read = 0;
            List<Integer> bytes = new ArrayList<>();

            while (read != -1 ){                    //petla while odczytuje bajt po bajcie
            //System.out.print((char)read);         //bez rzutowania (char)read dostaniemy kody Ascii
                read = fileInputStream.read();
                bytes.add(read);
            }

            fileInputStream.close();            //strumienie należy zamykać aby nie doszło do wycieku pamięci!!

            //zapis do pliku
            //przy tekście - poprzednie cwiczenie zapis jest przed odczytem
            //FileOutputStream fileOutputStream = new FileOutputStream(file, true);  //append true dopisuje nowy wiersz i nie usuwa starych
            FileOutputStream fileOutputStream = new FileOutputStream(fileCopy, true);

            for (Integer aByte : bytes) {
                fileOutputStream.write(aByte);
            }

            //fileOutputStream.write("Ala ma kota \n".getBytes());
            fileOutputStream.close();           //strumienie należy zamykać aby nie doszło do wycieku pamięci!!

         }catch (FileNotFoundException e) {
               e.printStackTrace();
         }catch (IOException e){
             e.printStackTrace();
    }
    }
}

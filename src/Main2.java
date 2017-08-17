import java.io.*;

public class Main2 {
    public static void main(String[] args) {
        File file = new File("seria.bin");
        Person person = new Person("Oskar", "Polak", 3);

       // if(!file.exists()){  //bez if bedzie tworzył plik za kazdym razem
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }

        try {

                //zapis do pliku
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(person);

                //odczyt z pliku
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream(file));
            Person openPerson = (Person) objectInputStream.readObject();
            System.out.println("Odczytano klase(" + openPerson.getName() + ")");


        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

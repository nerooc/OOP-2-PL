import java.lang.*;
import java.util.*;
import java.io.*;

public class lab08 {
    public static void main(String[] args) throws Exception {

        try{

            // Jeśli w argumentach wykonania jest inna ilość argumentów niż 2, rzucamy błąd
            if( args.length != 2){
                throw new Exception();
            }

            // Zmienna w której zapiszemy sumę wszystkim elementów z pliku
            double sum = 0.0;
            
            // Zmienna opisująca ilość elementów w pliku
            int count = 0;

            // Zmienna opisująca wynikową średnią
            double avg = 0.0;

            try{
                // Zmienna opisująca aktualną liczbę w pliku
                double curNum;

                // Scanner obsługujący plik, który wczytujemy
                Scanner scanner = new Scanner(new File(args[0]));

                // Czytamy liczby z pliku, pętla przerywa się gdy następna nie istnieje (gdy liczby sie kończą)
                while(scanner.hasNextDouble()){
                    curNum = scanner.nextDouble();

                    // Sprawdzamy czy wartości nie przekraczają zakresu
                    if ( (curNum == Double.POSITIVE_INFINITY) || (curNum == Double.NEGATIVE_INFINITY) ){
                        throw new RuntimeException();
                    }

                    // Dodajemy aktualny element do sumy
                    sum += curNum;

                    // Zwiększamy licznik
                    count++;
                }

                // Jeśli nie było żadnych elementów w pliku
                if(count == 0) {
                    throw new ArithmeticException();
                }

                // Liczymy średnią
                avg = sum / count;
            }

            // Lapiemy błąd w momencie gdy elementy nie istnieją lub są np. literami
            catch(ArithmeticException e){
                System.out.println("ERROR: Brak elementów w pliku wejściowym lub zły format zapisu. Przykład: \"1 2 3\"");
            }

            // Lapiemy błąd w momencie gdy plik nie istnieje
            catch(FileNotFoundException e) {
                System.out.println("ERROR: Plik o takiej nazwie nie istnieje, sprawdź czy dobrze podałeś nazwę.");
            }

            // Lapiemy błąd w momencie gdy elementy przekraczają zakres
            catch(RuntimeException e){
                System.out.println("ERROR: Jedną z wartości jest nieskończoność!");
            }

            finally{
                
                try{
                    // Za pomocą FileWriter'avg tworzymy nowy plik o nazwie podanej w argumentach i wpisujemy do niego wynik działania.
                    FileWriter result = new FileWriter(new File(args[1]));

                    // Zapisujemy naszą średnią zamienioną w Stringa (bo tak wymaga metoda write FileWriter'a)
                    result.write(Double.toString(avg));

                    // Zamykamy plik
                    result.close();
                }

                // Lapiemy błąd z zapisem do pliku
                catch(IOException e){
                    System.out.println("ERROR: Wystąpił błąd z zapisem do pliku");
                }
            }
        }

        // Lapiemy rzucany przez nas błąd z linii 13 oznaczający nieprawidlową ilość argumentów
        catch(Exception e){
            System.out.println("ERROR: Podano złą liczbę argumentów. Liczba argumentów musi wynosić 2!");
        }
    }
}
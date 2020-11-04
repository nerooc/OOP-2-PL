import java.lang.*;

/**
 * Klasa lab04string oferuje kilka metod operujących na stringach.
 *
 * @author  Tomasz Gajda
 * @version 1.0
 * @since   2020-11-04
 */

public class lab04string {

    /**
     * Ta metoda zwraca długość przekazanego do niej Stringa.
     *
     * @param slowo Parametr przedstawia słowo, którego długość chcemy poznać.
     * @return int Zwraca długość Stringa przekazanego jako parametr "slowo".
     */

    public static int dlugosc(String slowo){
       return slowo.length();
    }

    /**
     * Ta metoda sprawdza ile razy dana litera powtarza się w danym slowie.
     *
     * @param slowo Parametr przedstawia słowo, w którym liczymy wystąpienia litery.
     * @param litera Litera, której wystąpienia liczymy.
     * @return int Zwraca ilość wystąpień "litery" w "slowie".
     */

    public static int ile_razy_literka_wystepuje(String slowo, char litera){
       int ile_razy = 0;

       for (char el : slowo.toCharArray()){
           if (el == litera){
               ile_razy++;
           }
       }

       return ile_razy;
    }

    /**
     * Ta metoda sprawdza sprawdza czy dwa Stringi są jednakowe.
     *
     * @param slowo1 Parametr przedstawia pierwsze slowo, które sprawdzamy.
     * @param slowo2 Parametr przedstawia drugie slowo, które sprawdzamy.
     * @return boolean Zwraca czy prawdą jest, że oba parametry są jednakowe.
     */

    public static boolean czy_takie_same(String slowo1, String slowo2){
       return slowo1.equals(slowo2);
    }

    /**
     * Ta metoda odwraca String przekazany jako argument i go zwraca.
     *
     * @param wyrazenie Parametr przedstawia wyrazenie, które chcemy odwrócić.
     * @return String Zwraca odwróconego Stringa z parametru.
     */

    public static String wspak(String wyrazenie) {
       return new StringBuilder(wyrazenie).reverse().toString();
    }

    /**
     * Ta metoda sprawdza czy dany String jest palindromem.
     *
     * @param wyrazenie Parametr przedstawia wyrazenie, które sprawdzamy (czy jest palindromem).
     * @return boolean Zwraca czy prawdą jest, że wyrażenie jest palindromem.
     */

    public static Boolean czy_plaindrom(String wyrazenie) {
       return wyrazenie.equals(wspak(wyrazenie));
    }

    /**
     * Ta metoda sprawdza czy litery w Stringu występują w kolejności alfabetycznej.
     *
     * @param wyrazenie Parametr przedstawia wyrazenie, które sprawdzamy.
     * @return boolean Zwraca czy prawdą jest, że litery wyrażena występują w kolejności alfabetycznej.
     */

    public static Boolean czy_abecadlowe(String wyrazenie) {
        for (int i = 0; i < wyrazenie.length(); i++) {
            char litera = wyrazenie.charAt(i);
            for(int j = i; j < wyrazenie.length(); j++){
                if (litera > wyrazenie.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Ta metoda pozwala na zakodowanie lub odkodowanie wcześniej zakodowanej wiadomości za pomocą kodowania rot13.
     *
     * @param wyrazenie Parametr przedstawia wyrazenie, które chcemy zakodować lub odkodować.
     * @return String Zwraca odkodowane lub zakodowane (zależy od stanu parametru) wyrażenie.
     */

    public static String rot13(String wyrazenie) {

        String wynik = "";

        for (int i = 0; i < wyrazenie.length(); i++) {
            // zapisujemy litere na danej pozycji i do zmiennej x
            char x = wyrazenie.charAt(i);

            // obsługa małych liter
            if (x >= 'a' && x <= 'z') {
                char letter = (char)((x + 13) % 'z');
                if (letter < 'a') letter += 'a' - 1;
                wynik += letter;
            }

            // obsługa duzych liter
            else if (x >= 'A' && x <= 'Z') {
                char letter = (char)((x + 13) % 'Z');
                if (letter < 'A') letter += 'A' - 1;
                wynik += letter;
            } else {
                wynik += x;
            }
        }
        return wynik;
    }
}
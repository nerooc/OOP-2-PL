import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class lab09 {

    public static void main(String[] args){
        // Zmienna w której przechowamy ilość dzieci (pierwszą wartosc z pliku)
        int childrenCount;
        // Scanner, którym będziemy przeglądać plik
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(args[0]));
        } catch (IOException e){
            e.printStackTrace();
        }

        // Pobieramy ilość dzieci z pliku
        childrenCount = scanner.nextInt();

        // Tworzymy tablicę tablic na przechowanie danych
        int[][] children = new int[childrenCount][4];

        // Wypełniamy tablice
        for(int i = 0; i < childrenCount; i++){
            for(int j = 0; j < 4; j++){
                children[i][j] = scanner.nextInt();
            }
        }

        // Zmienne w której przechowamy najodleglejsze współrzędne, w których można kopać
        int max_x = 0;
        int max_y = 0;

        // Szukamy tych największych wartości
        for(int i = 0; i < childrenCount; i++){
            for(int j = 0; j < 4; j++){
                if(j == 3 && children[i][j] > max_x){
                    max_x = children[i][j];
                }

                if(j == 2 && children[i][j] > max_y){
                    max_y = children[i][j];
                }
            }
        }

        // Dwuwymiarowa tablica przedstawiająca ogródek i stopień przekopania kwadratów
        int [][] garden = new int[max_x + 1][max_y + 1];

        // Zmienna w której przechowamy ilość nieprzekopanych dokładnie kwadratów
        int result = 0;

        // Wypełniamy tablicę ogródka bazując na tym ile razy zostały przekopane
        for (int[] child : children) {
            for (int k = child[1]; k <= child[3]; k++) {
                for (int l = child[0]; l <= child[2]; l++) {
                    garden[k][l] += 1;
                }
            }
        }

        // Liczymy pola, które mają mniej niż (n-1) przekopań
        for (int i = 0; i < max_x + 1; ++i) {
            for(int j = 0; j < max_y + 1; ++j) {
                if(garden[i][j] < childrenCount-1) {
                    result++;
                }
            }
        }

        // Wypisujemy wynik
        System.out.println(result);
    }
}


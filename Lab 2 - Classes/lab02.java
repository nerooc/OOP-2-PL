import java.util.Random;


//TREŚĆ ZADANIA//
public class lab02
{
    public static void main(String args[])
    {
        //Rnd(N,k)
        //N - ilość liczb
        //k - każda (z tych 'N') jest sumą'k' liczb losowych z przedziału <0;1.0)
        Rnd x=new Rnd(10,100);
        x.Print();
        System.out.println("minimum = "+x.Min());
        System.out.println("maksimum = "+x.Max());
        System.out.println("avg = "+x.Average());
        x.Draw();
    }
}

//ROZWIĄZANIE//
class Rnd{

    //tablica w której będziemy trzymać nasze wygenerowane elementy
    double[] arr ;

    //generator liczb pseudolosowych
    Random generator;

    //konstruktor klasy Rnd
    Rnd(int N, int k){
        //inicjalizujemy nasz generator
        generator = new Random();

        //inicjalizujemy tablicę typów double
        arr = new double [10];

        //pętla służąca do wypełniania tablicy arr wygenerowanymi elementami
        for(int i = 0; i < N; i++){
            double elem = 0;

            //pętla służąca do obliczenia poszczególnych elementów (suma k losowych liczb z przedziału <0;1.0))
            for(int j = 0; j < k; j++) {
                //generujemy nową liczbę losową (k razy)
                double rand = generator.nextDouble();
                //dodajemy do elementu
                elem += rand;
            }
            
            //zapisujemy element na określonej pozycji w tablicy
            arr[i] = elem;
        }
    }

    //metoda wypisująca naszą tablicę
    void Print(){
        //pętla służąca do wypisania poszczególnych elementów tablicy
        for(int i = 0; i < arr.length; i++) {
            //wypisujemy indeks w nawiasach kwadratowych
            System.out.print("[" + i + "]=");
            //wypisujemy wartość znajdującą się w tablicy i łamiemy linię
            System.out.print(arr[i] + "\n");
        }
    }

    //metoda znajdująca najmniejszy element tablicy
    double Min(){
        //na początku uznajemy pierwszy element tablicy za najmniejszy
        double curr_min = arr[0];

        //pętla służąca do porównywania elementów tablicy z aktualnie najmniejszym elementem
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < curr_min) {
                //jeśli dany element tablicy jest mniejszy niż aktualnie najmniejszy element, nadpisujemy
                curr_min = arr[i];
            }
        }

        //zwracamy minimalny element tablicy
        return curr_min;
    }

    //metoda znajdująca największy element tablicy
    double Max(){

        //na początku uznajemy pierwszy element tablicy za największy
        double curr_max = arr[0];

        //pętla służąca do porównywania elementów tablicy z aktualnie największym elementem
        for(int i = 0; i < arr.length; i++){
            if(i > curr_max) {
                //jeśli dany element tablicy jest większy niż aktualnie największy element, nadpisujemy
                curr_max = i;
            }
        }

        //zwracamy największy element tablicy
        return curr_max;
    }

    //metoda obliczająca średnią z elementów naszej tablicy
    double Average(){

        //zmienna w której przechowamy sumę wszystkich elementów tablicy
        double sum = 0;

        //zmienna w której przechowamy średnią
        double avg = 0;

        //pętla służąca do obliczenia sumy wszystkich elementów tablicy
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        //obliczamy średnią
        avg = sum/arr.length;

        //zwracamy średnią
        return avg;
    }

    //metoda rysująca gwiazdki
    void Draw(){

        //pętla służąca do obliczenia ilości i wypisania gwiazdek dla każdego elementu tablicy
        for(int i = 0; i < arr.length; i++){

            //obliczamy ilość gwiazdek którą trzeba wypisać dla danego elementu tablicy
            double count = (arr[i] - this.Min()) / (this.Max() - this.Min()) * 50;

            //wypisujemy indeks elementu tablicy
            System.out.print("[" + i + "]:");

            //wypisujemy obliczoną wcześniej ilość gwiazdek
            for(int j = 0; j < count; j++) {
                System.out.print("*");
            }

            //łamiemy linię
            System.out.print("\n");
        }
    }

}
import java.util.Scanner;
import java.util.ArrayList;

public class lab06 {
    
    public static void main(String[] args) {
        
        // Lista produktow (korzystamy z ArrayList bo udostępnia przydatne metody)
        ArrayList<Produkt> produkty = new ArrayList<>();

        // Poczatkowy bilans
        int bilans = 0;
        
        // Poczatkowa data
        int data = 0;

        // Instancja klasy scanner do czytania inputu
        Scanner input = new Scanner(System.in);

        while(true) {

            // Posługując się interfejsem pokazujemy menu sklepu
            sklepAPI.pokazMenu();

            // Zapisujemy numer pierwszej komendy
            String komenda = input.next();

            // Jesli wybrane zostalo X, program sie konczy
            // (nie udało mi się wbić jakoś tego X'a w switcha)
            if (komenda.equals("X")){

                // Korzystamy z funkcji interfejsu konczącej program
                sklepAPI.zakonczProgram();

            } else {

                // Za pomocą switch wykonujemy metody bazujac na wybranej komendzie
                switch (Integer.parseInt(komenda)){

                    case 1: {

                        // Dodajemy produkt
                        sklepAPI.dodajProdukt();
                        int produkt = input.nextInt();

                        System.out.print("Podaj nazwe: \n");
                        String nazwa = input.next();

                        System.out.print("Podaj cenę zakupu: (czyli za ile kupiliśmy towar w hurtowni) \n");
                        int cenaZakupu = input.nextInt();
                        bilans -= cenaZakupu;

                        System.out.print("Podaj cenę sprzedaży: (czyli za ile będziemy to sprzedawać) \n");
                        int cenaSprzedazy = input.nextInt();

                        switch(produkt){
                            case 1: {
                                produkty.add(new owoc(nazwa, cenaZakupu, cenaSprzedazy));
                                break;
                            }

                            case 2: {
                                produkty.add(new warzywo(nazwa, cenaZakupu, cenaSprzedazy));
                                break;
                            }

                            case 3: {
                                produkty.add(new drobneAgd(nazwa, cenaZakupu, cenaSprzedazy));
                                break;
                            }
                        }
                    }
                    
                    break;

                    case 2:{

                        // Wybieramy produkt do sprzedania lub wyswietlamy informacje ze brak produktow
                        if (produkty.size() != 0){

                            for (int i = 0; i < produkty.size(); i++){
                                System.out.println((i + 1) + ") " + produkty.get(i).wypisz());
                            }

                            System.out.println("Który produkt chcesz sprzedać?");

                            int numer = input.nextInt() - 1;

                            // Dodajemy cenę sprzedaży do bilansu, wypisujemy co zostalo sprzedane i usuwamy produkt z listy
                            bilans += produkty.get(numer).cenaSprzedazy;
                            System.out.println("Sprzedano '" + produkty.get(numer).wypisz() + "'! \n");
                            produkty.remove(numer);

                        } else {
                            System.out.println("Brak produktów! \n");
                        }
                    }

                    break;

                    case 3:{

                        // Zwiekszamy date o 1
                        data++;

                        // Sprawdzamy czy produkty nie przekroczyly daty waznosci
                        for (int i = 0; i < produkty.size(); i++){
                            if (produkty.get(i).sprawdzDate(data)){
                                produkty.remove(i);
                            }
                        }
                    }

                    break;

                    case 4:{
                        // Wyswietlamy bilans
                        System.out.println("Stan konta: " + bilans + "\n");
                    }

                    break;
                }
            }

        }
    }
}

// Klasa abstrakcyjna opisująca produkt w sklepie
abstract class Produkt implements produktITF {

    // Dane na temat produktu
    String nazwa;
    int cenaZakupu;
    int cenaSprzedazy;
    int data;

    // Konstruktor produktu
    public Produkt(String nazwa, int cenaZakupu, int cenaSprzedazy, int data){
        this.data = data;
        this.nazwa = nazwa;
        this.cenaZakupu = cenaZakupu;
        this.cenaSprzedazy = cenaSprzedazy;
    }

    // Nadpisujemy metodę z produktITF wypisujaca produkt
    @Override
    public String wypisz() {
        return "Nazwa: '" + nazwa + '\'' + ", Data ważności: " + data;
    }

    // Nadpisujemy metodę z produktITF sprawdzającą czy zostala przekroczona data waznosci
    @Override
    public boolean sprawdzDate(int data) {
        return this.data < data;
    }
}

// Klasy dziedziczace po klasie produkt, przedstawiajace poszczegolne rodzaje produktow
class owoc extends Produkt {
    public owoc(String nazwa,int cenaZakupu,int cenaSprzedazy) {
        super(nazwa, cenaZakupu, cenaSprzedazy, 1);
    }
}

class warzywo extends Produkt {
    public warzywo(String nazwa,int cenaZakupu,int cenaSprzedazy) {
        super(nazwa, cenaZakupu, cenaSprzedazy, 2);
    }
}

class drobneAgd extends Produkt {
    public drobneAgd(String nazwa,int cenaZakupu,int cenaSprzedazy) {
        super(nazwa, cenaZakupu, cenaSprzedazy, 9999);
    }
}
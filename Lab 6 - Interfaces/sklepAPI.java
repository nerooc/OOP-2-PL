// Nie byłem pewny jak mamy zaimplementować interfejsy, więc zaimplementowałem dwa: jeden dla produktów, drugi dla samego sklepu,
// jako API z którego mozemy wywoływać statyczne metody

public interface sklepAPI{

    // Pokazuje pierwsze menu gdzie wybieramy glowna funkcje sklepu
    static void pokazMenu(){
        System.out.println("1) Dodaj towar \n2) Sprzedaj towar \n3) Kolejny dzień\n4) Bilans\nX) Koniec programu");
    }

    // Pokazuje drugie menu wyboru gdzie wybieramy jaki produkt chcemy dodac
    static void dodajProdukt(){
        System.out.println("1) dodaj owoc \n2) dodaj warzywo \n3) dodaj drobne agd");
    }

    // Konczy program ze statusem 0 (successful termination)
    static void zakonczProgram(){
        System.exit(0);
    }
}
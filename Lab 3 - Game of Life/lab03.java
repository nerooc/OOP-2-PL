public class lab03 {
    public static void main(String[] args) {
        // Przyjmujemy parametry i za pomocą metody parseInt() parsujemy ze Stringa na Int'a.

        // Rozmiar x planszy
        int size_x = Integer.parseInt(args[0]);

        // Rozmiar y planszy
        int size_y = Integer.parseInt(args[1]);

        // Ilość kroków w symulacji
        int steps = Integer.parseInt(args[2]);

        // Predefiniowana plansza
        int preset = Integer.parseInt(args[3]);

        // Instancjonujemy obiekt klasy Grid, opisujący planszę i działania na niej wykonywane
        Grid game = new Grid(size_x, size_y);

        // Za pomocą wyrażenia switch, decydujemy od jakiego rozkładu startujemy
        switch (preset) {
            // Jeżeli użytkownik wpisał 0 - rozkład losowy
            case 0:
                game.startRandom();
                break;

            // Jeżeli użytkownik wpisał 1 - łódź
            case 1:
                game.startBoat();
                break;

            // Jeżeli użytkownik wpisał 2 - oscylator
            case 2:
                game.startBlinker();
                break;

            // Jeżeli użytkownik wpisał 3 - szybowiec
            case 3:
                game.startSpaceship();
                break;
        }

        // Robimy pętlę ograniczoną przez zdefiniowaną liczbę kroków
        // Każdą generację wyświetlamy i generujemy kolejną
        for (int i = 1; i <= steps; i++) {
            game.show(i);
            game.nextStep();
        }
    }
}
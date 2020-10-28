import java.util.Random;

// Klasa przedstawiająca siatkę/planszę, którą będziemy wykorzystywać w naszej grze
public class Grid {

    // Dwuwymiarowa tablica, w której będziemy przechowywać nasze plansze 
    private int[][] board;

    // Generator do tworzenia losowych rozkładów na planszy
    private Random generator;

    // Rozmiar x i rozmiar y planszy
    private int size_x;
    private int size_y;

    // Konstruktor klasy Grid przyjmujący wysokość i szerokość planszy
    Grid(int size_x, int size_y) {

        // Tworzymy nową instancję planszy jako tablicy dwuwymiarowej "intów"
        this.board = new int[size_x][size_y];
        // Jest ona automatycznie wypełniona "0", więc musimy wstawiać tylko "1". Specyfika Javy.

        // Inicjalizujemy generator liczb losowych
        this.generator = new Random();

        // Przypisujemy poszczególne rozmiary podane w konstruktorze
        this.size_x = size_x;
        this.size_y = size_y;
    }

    // PRESET 0: Metoda generująca losowy rozkład (jeżeli użytkownik wybierze 0)
    public void startRandom() {
        for (int i = 0; i < this.size_x; i++) {
            for (int j = 0; j < this.size_y; j++) {
                // Przesyłamy 2 jako argument, by wylosować zmienną 0 lub 1
                this.board[i][j] = generator.nextInt(2);
            }
        }
    }

    // PRESET 1: Metoda generująca układ z łodzią (niezmiennikiem)
    public void startBoat() {
        // Staramy się umieścić nasze obiekty na środku planszy (gdy nieparzysta wielkość) lub prawie na środku (gdy parzysta)
        // Dlatego ustalamy środek planszy:
        int center_x = (this.size_x) / 2;
        int center_y = (this.size_y) / 2;

        // Wypełniamy planszę według schematu łodzi
        this.board[center_x - 1][center_y - 1] = 1;
        this.board[center_x - 1][center_y] = 1;
        this.board[center_x][center_y - 1] = 1;
        this.board[center_x + 1][center_y] = 1;
        this.board[center_x][center_y + 1] = 1;
    }

    // PRESET 2: Metoda generująca układ z oscylatorem (blinker'em)
    public void startBlinker() {
        // Ustalamy środek planszy:
        int center_x = (size_x) / 2;
        int center_y = (size_y) / 2;

        // Wypełniamy planszę według schematu oscylatora
        this.board[center_x][center_y] = 1;
        this.board[center_x][center_y - 1] = 1;
        this.board[center_x][center_y + 1] = 1;
    }

    // PRESET 3: Metoda generująca układ z szybowcem (spaceship'em)
    public void startSpaceship() {
        // Ustalamy środek planszy:
        int center_x = (size_x) / 2;
        int center_y = (size_y) / 2;

        // Wypełniamy planszę według schematu szybowca
        this.board[center_x - 1][center_y - 1] = 1;
        this.board[center_x][center_y - 1] = 1;
        this.board[center_x + 1][center_y - 1] = 1;
        this.board[center_x - 1][center_y] = 1;
        this.board[center_x][center_y + 1] = 1;
    }


    // Metoda print, pozwalająca nam na wypisanie aktualnego stanu planszy
    public void show(int it) {
        // Wypisujemy informację, która to iteracja i rozdzielamy generacje myślnikami
        System.out.println(" -------- " + it + " --------");

        // Wypisujemy naszą planszę podwójną pętlą
        for (int i = 0; i < this.size_x; i++) {
            for (int j = 0; j < this.size_y; j++) {
                // Wypisujemy X jak napotkamy 1 (komórka jest żywa) i . jeżeli spotkamy 0 (komórka martwa)
                if(this.board[i][j] == 1) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" . ");
                }
            }
            // łamiemy linię
            System.out.println();
        }
    }

    // Metoda generująca następną generację komórek
    public void nextStep() {

        // Tworzymy nową tablicę dwuwymiarową w której chwilowo przechowamy planszę następnej generacji
        int[][] nextStepArray = new int[size_x][size_y];

        
        for (int i = 1; i < this.size_x - 1; i++) {
            for (int j = 1; j < this.size_y - 1; j++) {

                // Ustawiamy ilość żywych sąsiednich komórek na zero
                int aliveNeighbourCells = 0;

                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        // Znajdujemy ilość żywych komórek sąsiadujących
                        aliveNeighbourCells += this.board[i + k][j + l];
                    }
                }

                // Usuwamy tą komórkę, ponieważ została policzona wcześniej
                aliveNeighbourCells -= this.board[i][j];

                // Sprawdzamy warunki gry i decydujemy czy dana komórka jest żywa czy martwa

                // Komórka jest samotna i umiera
                if ((this.board[i][j] == 1) && (aliveNeighbourCells < 2)) {
                    nextStepArray[i][j] = 0;
                // Komórka jest zatłoczona i umiera
                } else if ((this.board[i][j] == 1) && (aliveNeighbourCells > 3)) {
                    nextStepArray[i][j] = 0;
                // Nowa komórka zostaje narodzona
                } else if ((this.board[i][j] == 0) && (aliveNeighbourCells == 3)) {
                    nextStepArray[i][j] = 1;
                // Reszta komórek pozostaje bez zmian
                } else {
                    nextStepArray[i][j] = this.board[i][j];
                }
            }
        }

        // Przepisujemy chwilową tablicę do naszej głównej planszy
        this.board = nextStepArray;
    }
}
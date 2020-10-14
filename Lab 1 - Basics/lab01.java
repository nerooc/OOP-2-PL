public class lab01 {

    //metoda rozruchowa main
    public static void main(String args[]) {
        draw_line(28,65,28,84);
		draw_line(28,84,34,83);
		draw_line(34,83,38,79);
		draw_line(38,79,37,76);
		draw_line(37,76,34,73);
		draw_line(28,72,37,76);
		draw_line(58,25,53,23);
		draw_line(53,23,47,23);
		draw_line(47,23,44,25);
		draw_line(74,65,63,65);
		draw_line(63,65,73,74);
		draw_line(73,74,73,79);
		draw_line(73,79,70,82);
		draw_line(70,82,66,82);
		draw_line(66,82,63,80);
		draw_circle(50,74,9);
		draw_circle(50,29,14);
		draw_circle(55,34,2);
		draw_circle(46,34,2);
    }

    //metoda draw_line przyjmuje dwa punkty (w układzie kartezjańskim) docelowo przedstawiające linię
    public static void draw_line(double x_1, double y_1, double x_2, double y_2) {

        //ustalamy dokładność określając liczbę punktów
        int points = 100;

        //kroki otrzymujemy dzieląc deltę poszczególnych współrzędnych przez wybraną ilość punktów
        double step_x = (x_2 - x_1) / points;
        double step_y = (y_2 - y_1) / points;

        //zapisujemy współrzędne pierwszego punktu w nowych zmiennych, by móc do nich dodawać kroki w pętli
        double x = x_1;
        double y = y_1;

        //pętla for odpowiedzialna za wypisanie współrzędnych punktów oraz przesuwanie ich o odpowiednie kroki
        for (int i = 0; i <= points; i++) {

			//wypisujemy współrzędne
            System.out.println(x + " " + y); 

			//obliczamy współrzędne nowego punktu
            x += step_x; 
            y += step_y;
        }
    }

    //metoda draw_circle przyjmuje punkt (x_1, y_1) który jest środkiem koła, oraz promień tego koła (rad)
    public static void draw_circle(double x_1, double y_1, double rad) {

        //zwiększam tutaj liczbę punktów, ponieważ okręgi wyglądają na mało dokładne gdy korzystamy ze 100 punktów
        int points = 400;

        //obliczamy jak wielki jest krok kąta w stosunku do pełnego okręgu
        double step_angle = (2 * Math.PI) / points;

        //w tej zmiennej zachowuję aktualny kąt (obliczany w pętli)
        double angle = 0;

        //pętla for odpowiedzialna za wypisanie punktów oraz obliczanie kolejnych współrzędnych
        for (int i = 0; i <= points; i++) {

			//aktualizujemy kąt mnożąc krok przez indeks i
            angle = i * step_angle; 

			//obliczamy współrzędne nowego punktu
            double x = x_1 + rad * Math.cos(angle); 
            double y = y_1 + rad * Math.sin(angle);

			//wypisujemy współrzędne
            System.out.println(x + " " + y); 
        }
    }
}
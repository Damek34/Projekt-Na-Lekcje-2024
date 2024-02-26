import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Symulator {

    public static List<Drzewo> lista_drzew;
    public static List<Trawa> lista_traw;
    public static int nowe_drzewa = 0;
    public static int nowe_trawy = 0;

    public static void main(String[] args) {

        lista_drzew = new ArrayList<>();
        lista_traw = new ArrayList<>();
        Scanner skaner = new Scanner(System.in);
        int liczba_cyklow = 0, ile_drzew, ile_traw;
       // boolean kontynuacja_setup = true;

        System.out.println("Witaj w symulatorze ekosystemu!");
        liczba_cyklow = ileCykli();


        System.out.println("Świetnie!");
        ile_drzew = ileDrzew();

        for(int i = 0; i < ile_drzew; i++){
            noweDrzewo();
        }

        System.out.println("Okej!");

        ile_traw = ileTraw();

        for(int i = 0; i < ile_traw; i++){
            nowaTrawa();
        }

        for(int i = 1; i <= liczba_cyklow; i++){
            System.out.println("\nCykl " + i);
            Drzewo.aktualizuj(lista_drzew);
            Trawa.aktualizuj(lista_traw);

            boolean kontynuacja = false;
            while(!kontynuacja){
                String nastepny_cykl = "N";
                System.out.println("Przewinąć do kolejnego cyklu? (Wpisz literę 'T')");
                nastepny_cykl = skaner.next();

                switch (nastepny_cykl){
                    case "T":

                    case "t":
                        kontynuacja = true;
                        break;

                    default:
                        System.out.println("Został wprowadzony niepoprawny znak!");

                }
            }

        }

        System.out.println("=================STATYSTYKI KOŃCOWE=================");
        System.out.println("Liczba drzew: " + Drzewo.ile_organizmow_zyje);
        System.out.println("Liczba obumarłych drzew: " + Drzewo.ile_organizmow_ubumarlo);
        System.out.println("Łącznie istniało " + (Drzewo.ile_organizmow_ubumarlo + Drzewo.ile_organizmow_zyje) + " drzew");


        System.out.println("\nLiczba traw: " + Trawa.ile_organizmow_zyje);
        System.out.println("Liczba obumarłych traw: " + Trawa.ile_organizmow_ubumarlo);
        System.out.println("Łącznie istniało " + (Trawa.ile_organizmow_ubumarlo + Trawa.ile_organizmow_zyje) + " traw");

    }

    static int ileCykli(){
        Scanner skaner = new Scanner(System.in);
        int liczba_cyklow;

        System.out.println("Ile cyklów symulacji chcesz przeprowadzić?");

        try{
            liczba_cyklow = skaner.nextInt();

        }
        catch (InputMismatchException e){
            System.out.println("Wprowadzono niewłaściwą liczbę!");
            liczba_cyklow = ileCykli();
        }
        return liczba_cyklow;
    }

    static int ileTraw(){
        Scanner skaner = new Scanner(System.in);
        int liczba_traw;

        System.out.println("Ile traw ma pojawić się w 1 cyklu symulacji?");

        try{
            liczba_traw = skaner.nextInt();

        }
        catch (InputMismatchException e){
            System.out.println("Wprowadzono niewłaściwą liczbę!");
            liczba_traw = ileTraw();
        }
        return liczba_traw;
    }

    static int ileDrzew(){
        Scanner skaner = new Scanner(System.in);
        int liczba_drzew;

        System.out.println("Ile drzew ma pojawić się w 1 cyklu symulacji?");

        try{
            liczba_drzew = skaner.nextInt();

        }
        catch (InputMismatchException e){
            System.out.println("Wprowadzono niewłaściwą liczbę!");
            liczba_drzew = ileDrzew();
        }
        return liczba_drzew;
    }

    static void noweDrzewo(){
        Drzewo drzewo = new Drzewo(true, Drzewo.nadajCzasZycia(), Drzewo.nadajCzasDoRozmnazania());
        lista_drzew.add(drzewo);
        nowe_drzewa++;
    }

    static void nowaTrawa(){
        Trawa trawa = new Trawa(true, Trawa.nadajCzasZycia(), Trawa.nadajCzasDoRozmnazania());
        lista_traw.add(trawa);
        nowe_trawy++;
    }
}

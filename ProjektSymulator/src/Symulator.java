import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Symulator {

    public static List<Drzewo> lista_drzew;
    public static int nowe_drzewa = 0;
    public static void main(String[] args) {

        lista_drzew = new ArrayList<>();
        Scanner skaner = new Scanner(System.in);
        int liczba_cyklow = 0, ile_drzew;
        boolean kontynuacja_setup = true;

        System.out.println("Witaj w symulatorze ekosystemu!");
        liczba_cyklow = ileCykli();


        System.out.println("Świetnie!");
        ile_drzew = ileDrzew();

        for(int i = 0; i < ile_drzew; i++){
            noweDrzewo();
        }

        for(int i = 1; i <= liczba_cyklow; i++){
            System.out.println("Cykl " + i);
            Drzewo.aktualizuj(lista_drzew);

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
}

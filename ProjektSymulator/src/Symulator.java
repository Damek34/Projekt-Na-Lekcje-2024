import javax.swing.plaf.metal.OceanTheme;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Symulator {

    public static List<Drzewo> lista_drzew;
    public static List<Trawa> lista_traw;
    public static List<Krolik> lista_krolikow;
    public static List<Owca> lista_owiec;
    public static List<Wilk> lista_wilkow;
    public static List<Lis> lista_lisów;
    public static int nowe_drzewa = 0;
    public static int nowe_trawy = 0;
    public static int nowe_kroliki = 0;
    public static int nowe_owce = 0;
    public static int nowe_wilki = 0;
    public static int nowe_lisy = 0;

    public static void main(String[] args) {

        lista_drzew = new ArrayList<>();
        lista_traw = new ArrayList<>();
        lista_krolikow = new ArrayList<>();
        lista_owiec = new ArrayList<>();
        lista_wilkow = new ArrayList<>();
        lista_lisów = new ArrayList<>();

        Scanner skaner = new Scanner(System.in);
        int liczba_cyklow = 0, ile_drzew, ile_traw, ile_krolikow, ile_owiec, ile_wilkow, ile_lisow;
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


        System.out.println("Okej!");

        ile_krolikow = ileKrolikow();


        for(int i = 0; i < ile_krolikow; i++){
            nowyKrolik();
        }
        System.out.println("Super!");

        ile_owiec = ileOwiec();

        for(int i = 0; i < ile_owiec; i++){
            nowaOwca();
        }
        System.out.println("Świetnie!");

        ile_wilkow = ileWilkow();

        for(int i = 0; i < ile_wilkow; i++){
            nowyWilk();
        }


        System.out.println("Superancko!");

        ile_lisow = ileLisow();

        for(int i = 0; i < ile_lisow; i++){
            nowyLis();
        }
        //////////////////

        for(int i = 1; i <= liczba_cyklow; i++){
            System.out.println("\nCykl " + i);
            Drzewo.aktualizuj(lista_drzew);
            Trawa.aktualizuj(lista_traw);
            Krolik.aktualizuj(lista_krolikow);
            Owca.aktualizuj(lista_owiec);
            Wilk.aktualizuj(lista_wilkow);
            Lis.aktualizuj(lista_lisów);

            boolean kontynuacja = false;
            while(!kontynuacja){
                String nastepny_cykl = "N";
                System.out.println("\nPrzewinąć do kolejnego cyklu? (Wpisz literę 'T')");
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


        System.out.println("\nLiczba królików: " + Krolik.ile_organizmow_zyje);
        System.out.println("Liczba zmarłych królików: " + Krolik.ile_organizmow_ubumarlo);
        System.out.println("Łącznie istniało " + (Krolik.ile_organizmow_ubumarlo + Krolik.ile_organizmow_zyje) + " królików");


        System.out.println("\nLiczba owiec: " + Owca.ile_organizmow_zyje);
        System.out.println("Liczba zmarłych owiec: " + Owca.ile_organizmow_ubumarlo);
        System.out.println("Łącznie istniało " + (Owca.ile_organizmow_ubumarlo + Owca.ile_organizmow_zyje) + " owiec");


        System.out.println("\nLiczba wilków: " + Wilk.ile_organizmow_zyje);
        System.out.println("Liczba zmarłych wilków: " + Wilk.ile_organizmow_ubumarlo);
        System.out.println("Łącznie istniało " + (Wilk.ile_organizmow_ubumarlo + Wilk.ile_organizmow_zyje) + " wilków");

        System.out.println("\nLiczba lisów: " + Lis.ile_organizmow_zyje);
        System.out.println("Liczba zmarłych lisów: " + Lis.ile_organizmow_ubumarlo);
        System.out.println("Łącznie istniało " + (Lis.ile_organizmow_ubumarlo + Lis.ile_organizmow_zyje) + " lisów");

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

    static int ileKrolikow(){
        Scanner skaner = new Scanner(System.in);
        int liczba_krolikow;

        System.out.println("Ile królików ma pojawić się w 1 cyklu symulacji?");

        try{
            liczba_krolikow = skaner.nextInt();

        }
        catch (InputMismatchException e){
            System.out.println("Wprowadzono niewłaściwą liczbę!");
            liczba_krolikow = ileKrolikow();
        }
        return liczba_krolikow;
    }

    static int ileOwiec(){
        Scanner skaner = new Scanner(System.in);
        int liczba_owiec;

        System.out.println("Ile owiec ma pojawić się w 1 cyklu symulacji?");

        try{
            liczba_owiec = skaner.nextInt();

        }
        catch (InputMismatchException e){
            System.out.println("Wprowadzono niewłaściwą liczbę!");
            liczba_owiec = ileOwiec();
        }
        return liczba_owiec;
    }

    static int ileWilkow(){
        Scanner skaner = new Scanner(System.in);
        int liczba_wilkow;

        System.out.println("Ile wilków ma pojawić się w 1 cyklu symulacji?");

        try{
            liczba_wilkow = skaner.nextInt();

        }
        catch (InputMismatchException e){
            System.out.println("Wprowadzono niewłaściwą liczbę!");
            liczba_wilkow = ileWilkow();
        }
        return liczba_wilkow;
    }

    static int ileLisow(){
        Scanner skaner = new Scanner(System.in);
        int liczba_lisow;

        System.out.println("Ile lisów ma pojawić się w 1 cyklu symulacji?");

        try{
            liczba_lisow = skaner.nextInt();

        }
        catch (InputMismatchException e){
            System.out.println("Wprowadzono niewłaściwą liczbę!");
            liczba_lisow = ileLisow();
        }
        return liczba_lisow;
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

    static void nowyKrolik(){
        Krolik krolik = new Krolik(true, Krolik.nadajCzasZycia(), Krolik.nadajCzasDoRozmnazania());
        lista_krolikow.add(krolik);
        nowe_kroliki++;
    }

    static void nowaOwca(){
        Owca owca = new Owca(true, Owca.nadajCzasZycia(), Owca.nadajCzasDoRozmnazania());
        lista_owiec.add(owca);
        nowe_owce++;
    }

    static void nowyWilk(){
        Wilk wilk = new Wilk(true, Wilk.nadajCzasZycia(), Wilk.nadajCzasDoRozmnazania());
        lista_wilkow.add(wilk);
        nowe_wilki++;
    }

    static void nowyLis(){
        Lis lis = new Lis(true, Lis.nadajCzasZycia(), Lis.nadajCzasDoRozmnazania());
        lista_lisów.add(lis);
        nowe_lisy++;
    }
}

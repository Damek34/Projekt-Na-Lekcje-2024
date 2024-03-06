import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Wilk {
    private boolean czy_zyje;
    private int dlugosc_zycia;
    private int czas_do_rozmnazania;

    static int ile_organizmow_zyje = 0;
    static int ile_organizmow_ubumarlo = 0;


    public Wilk(boolean czy_zyje, int dlugosc_zycia, int czas_do_rozmnazania) {
        this.czy_zyje = czy_zyje;
        this.dlugosc_zycia = dlugosc_zycia;
        this.czas_do_rozmnazania = czas_do_rozmnazania;
        ile_organizmow_zyje++;
    }

    public boolean isCzy_zyje() {
        return czy_zyje;
    }

    public void setCzy_zyje(boolean czy_zyje) {
        this.czy_zyje = czy_zyje;
    }

    public int getDlugosc_zycia() {
        return dlugosc_zycia;
    }

    public void setDlugosc_zycia(int dlugosc_zycia) {
        this.dlugosc_zycia = dlugosc_zycia;
    }

    public int getCzas_do_rozmnazania() {
        return czas_do_rozmnazania;
    }

    public void setCzas_do_rozmnazania(int czas_rozmnazania) {
        this.czas_do_rozmnazania = czas_rozmnazania;
    }

    public static int nadajCzasZycia(){
        Random random = new Random();
        return 8 + random.nextInt(5);
    }

    public static int nadajCzasDoRozmnazania(){
        Random random = new Random();
        return 4 + random.nextInt(3);
    }

    public boolean czyCzasZyciaDobieglKonca() {
        return dlugosc_zycia <= 0;
    }

    /* TODO

    public static void aktualizuj(List<Krolik> krolik) {
        Random generator_smierci = new Random();
        int rodzaj_smierci;
        int naturalna = 0;
        int upolowana = 0;


        int martwe_krolki = 0;
        for (int i = 0; i < krolik.size(); i++) {
            if (krolik.get(i).czyCzasZyciaDobieglKonca()) {
                krolik.get(i).setCzy_zyje(false);
                martwe_krolki++;
                ile_organizmow_zyje--;
                krolik.remove(krolik.get(i));


                rodzaj_smierci = generator_smierci.nextInt(4);

                //if(Wilk.)

                    if(rodzaj_smierci %2 == 0){
                        naturalna++;
                    }
                    else{
                        upolowana++;
                    }


            } else {
                krolik.get(i).setDlugosc_zycia(krolik.get(i).getDlugosc_zycia() - 1);
                if (krolik.get(i).getCzas_do_rozmnazania() == 0 && Krolik.ile_organizmow_zyje >= 2) {
                    Symulator.nowyKrolik();
                }
                krolik.get(i).setCzas_do_rozmnazania(krolik.get(i).getCzas_do_rozmnazania() - 1);
            }
        }
        if (martwe_krolki != 0) {
            System.out.println(martwe_krolki + " królików zmarło w tym cyklu!");
            ile_organizmow_ubumarlo += martwe_krolki;
        }
        if (Symulator.nowe_drzewa != 0) {
            System.out.println("Powstało " + Symulator.nowe_drzewa + " nowych drzew!");
            Symulator.nowe_drzewa = 0;
        }
    }


     */
}

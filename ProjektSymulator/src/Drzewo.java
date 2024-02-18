import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Drzewo {
    private boolean czy_zyje;
    private int dlugosc_zycia;
    private int czas_do_rozmnazania;

    static int ile_organizmow_zyje = 0;
    static int ile_organizmow_ubumarlo = 0;


    public Drzewo(boolean czy_zyje, int dlugosc_zycia, int czas_do_rozmnazania) {
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
        return 18 + random.nextInt(4);
    }

    public static int nadajCzasDoRozmnazania(){
        Random random = new Random();
        return 8 + random.nextInt(3);
    }

    public boolean czyCzasZyciaDobieglKonca() {
        return dlugosc_zycia <= 0;
    }


    public static void aktualizuj(List<Drzewo> drzewa) {
        int martwe_drzewa = 0;
        for (int i = 0; i < drzewa.size(); i++) {
            if (drzewa.get(i).czyCzasZyciaDobieglKonca()) {
                drzewa.get(i).setCzy_zyje(false);
                martwe_drzewa++;
                ile_organizmow_zyje--;
                drzewa.remove(drzewa.get(i));
            } else {
                drzewa.get(i).setDlugosc_zycia(drzewa.get(i).getDlugosc_zycia() - 1);
                if (drzewa.get(i).getCzas_do_rozmnazania() == 0) {
                    Symulator.noweDrzewo();
                }
                drzewa.get(i).setCzas_do_rozmnazania(drzewa.get(i).getCzas_do_rozmnazania() - 1);
            }
        }
        if (martwe_drzewa != 0) {
            System.out.println(martwe_drzewa + " drzew obumarło w tym cyklu!");
            ile_organizmow_ubumarlo += martwe_drzewa;
        }
        if (Symulator.nowe_drzewa != 0) {
            System.out.println("Powstało " + Symulator.nowe_drzewa + " nowych drzew!");
            Symulator.nowe_drzewa = 0;
        }
    }

}

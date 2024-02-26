import java.util.List;
import java.util.Random;

public class Trawa {
    private boolean czy_zyje;
    private int dlugosc_zycia;
    private int czas_do_rozmnazania;

    static int ile_organizmow_zyje = 0;
    static int ile_organizmow_ubumarlo = 0;


    public Trawa(boolean czy_zyje, int dlugosc_zycia, int czas_do_rozmnazania) {
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
        return 4 + random.nextInt(3);
    }

    public static int nadajCzasDoRozmnazania(){
        Random random = new Random();
        return 1 + random.nextInt(2);
    }

    public boolean czyCzasZyciaDobieglKonca() {
        return dlugosc_zycia <= 0;
    }


    public static void aktualizuj(List<Trawa> trawy) {
        int martwe_trawy = 0;
        for (int i = 0; i < trawy.size(); i++) {
            if (trawy.get(i).czyCzasZyciaDobieglKonca()) {
                trawy.get(i).setCzy_zyje(false);
                martwe_trawy++;
                ile_organizmow_zyje--;
                trawy.remove(trawy.get(i));
            } else {
                trawy.get(i).setDlugosc_zycia(trawy.get(i).getDlugosc_zycia() - 1);
                if (trawy.get(i).getCzas_do_rozmnazania() == 0) {
                    Symulator.nowaTrawa();
                }
                trawy.get(i).setCzas_do_rozmnazania(trawy.get(i).getCzas_do_rozmnazania() - 1);
            }
        }
        if (martwe_trawy != 0) {
            System.out.println(martwe_trawy + " traw obumarło w tym cyklu!");
            ile_organizmow_ubumarlo += martwe_trawy;
        }
        if (Symulator.nowe_trawy != 0) {
            System.out.println("Powstało " + Symulator.nowe_trawy + " nowych traw!");
            Symulator.nowe_trawy = 0;
        }
    }

}

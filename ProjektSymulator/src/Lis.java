import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Lis {
    private boolean czy_zyje;
    private int dlugosc_zycia;
    private int czas_do_rozmnazania;

    static int ile_organizmow_zyje = 0;
    static int ile_organizmow_ubumarlo = 0;


    public Lis(boolean czy_zyje, int dlugosc_zycia, int czas_do_rozmnazania) {
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
        return 18 + random.nextInt(5);
    }

    public static int nadajCzasDoRozmnazania(){
        Random random = new Random();
        return 10 + random.nextInt(3);
    }

    public boolean czyCzasZyciaDobieglKonca() {
        return dlugosc_zycia <= 0;
    }



    public static void aktualizuj(List<Lis> lis) {
        Random generator_smierci = new Random();
        int rodzaj_smierci;
        int naturalna = 0;
        int upolowana = 0;


        int martwe_lisy = 0;
        for (int i = 0; i < lis.size(); i++) {
            if (lis.get(i).czyCzasZyciaDobieglKonca()) {
                lis.get(i).setCzy_zyje(false);
                martwe_lisy++;
                ile_organizmow_zyje--;
                lis.remove(lis.get(i));


                rodzaj_smierci = generator_smierci.nextInt(4);

                if(Wilk.ile_organizmow_zyje > 0){
                    if(rodzaj_smierci %2 == 0){
                        naturalna++;
                    }
                    else{
                        upolowana++;
                    }
                }




            } else {
                lis.get(i).setDlugosc_zycia(lis.get(i).getDlugosc_zycia() - 1);
                if (lis.get(i).getCzas_do_rozmnazania() == 0 && Lis.ile_organizmow_zyje >= 2) {
                    Symulator.nowyLis();
                }
                lis.get(i).setCzas_do_rozmnazania(lis.get(i).getCzas_do_rozmnazania() - 1);
            }
        }
        if (martwe_lisy != 0) {
            System.out.println(martwe_lisy + " lisów zmarło w tym cyklu!");

            if(upolowana > 0){
                System.out.println(upolowana + " lisów zostało upolowanych");
            }

            ile_organizmow_ubumarlo += martwe_lisy;
        }
        if (Symulator.nowe_lisy != 0) {
            System.out.println("Urodziło się " + Symulator.nowe_lisy + " nowych lisów!");
            Symulator.nowe_lisy = 0;
        }
    }



}

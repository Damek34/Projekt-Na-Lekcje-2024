import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Owca {
    private boolean czy_zyje;
    private int dlugosc_zycia;
    private int czas_do_rozmnazania;

    static int ile_organizmow_zyje = 0;
    static int ile_organizmow_ubumarlo = 0;


    public Owca(boolean czy_zyje, int dlugosc_zycia, int czas_do_rozmnazania) {
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
        return 12 + random.nextInt(5);
    }

    public static int nadajCzasDoRozmnazania(){
        Random random = new Random();
        return 6 + random.nextInt(4);
    }

    public boolean czyCzasZyciaDobieglKonca() {
        return dlugosc_zycia <= 0;
    }


    public static void aktualizuj(List<Owca> owca) {
        Random generator_smierci = new Random();
        int rodzaj_smierci;
        int naturalna = 0;
        int upolowana = 0;


        int martwe_owce = 0;
        for (int i = 0; i < owca.size(); i++) {
            if (owca.get(i).czyCzasZyciaDobieglKonca()) {
                owca.get(i).setCzy_zyje(false);
                martwe_owce++;
                ile_organizmow_zyje--;
                owca.remove(owca.get(i));


                rodzaj_smierci = generator_smierci.nextInt(4);

                if(Wilk.ile_organizmow_zyje > 0 || Lis.ile_organizmow_zyje > 0){
                    if(rodzaj_smierci %2 == 0){
                        naturalna++;
                    }
                    else{
                        upolowana++;
                    }
                }
                else{
                    naturalna++;
                }




            } else {
                owca.get(i).setDlugosc_zycia(owca.get(i).getDlugosc_zycia() - 1);
                if (owca.get(i).getCzas_do_rozmnazania() == 0 && Owca.ile_organizmow_zyje >= 2) {
                    Symulator.nowaOwca();
                }
                owca.get(i).setCzas_do_rozmnazania(owca.get(i).getCzas_do_rozmnazania() - 1);
            }
        }
        if (martwe_owce != 0) {
            System.out.println(martwe_owce + " owiec zmarło w tym cyklu!");

            if(upolowana > 0){
                System.out.println(upolowana + " owiec zostało upolowanych");
            }

            ile_organizmow_ubumarlo += martwe_owce;
        }
        if (Symulator.nowe_owce != 0) {
            System.out.println("Urodziło się " + Symulator.nowe_owce + " nowych owiec!");
            Symulator.nowe_owce = 0;
        }
    }

}

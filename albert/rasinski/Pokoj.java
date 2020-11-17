package albert.rasinski;

import java.util.Comparator;
import java.util.Scanner;

public class Pokoj{
    private String nazwaPomieszczenia;
    private double szerokosc;
    private double dlugosc;
    private double wysokosc;
    private static int liczbaPokoi = 0;

    private static double kosztPodlogi;
    private static double kosztScian;

    public Pokoj(){
        this.nazwaPomieszczenia = "nazwaPomieszczenia";
        this.szerokosc = 4.0;
        this.dlugosc = 2.0;
        this.wysokosc = 2.5;
        this.liczbaPokoi++;
    }

    public Pokoj(String nazwaPomieszczenia, double szerokosc, double dlugosc, double wysokosc){
        this.nazwaPomieszczenia = nazwaPomieszczenia;
        this.szerokosc = szerokosc;
        this.dlugosc = dlugosc;
        this.wysokosc = wysokosc;
        this.liczbaPokoi++;
    }

    public double objetosc(){
        return szerokosc * dlugosc * wysokosc;
    }

    public double powierzchniaScian(){
        return 2.0 * szerokosc * wysokosc + 2.0 * dlugosc * wysokosc;
    }

    public double powierzchniaPodlogi(){
        return szerokosc * dlugosc;
    }

    public String getNazwaPomieszczenia(){
        return nazwaPomieszczenia;
    }


    public void printThis(){
        System.out.println("" + nazwaPomieszczenia + "  " + szerokosc + "   " + dlugosc + "   " + wysokosc);
    }


    public static void setKosztPodlogi(double cena){
        kosztPodlogi = cena;
    }

    public static void setKosztScian(double cena){
        kosztScian = cena;
    }

    public static Pokoj wczytajDane(){
        Scanner scanner;

        boolean loop = true;
        String nazwaPomieszczenia = "";
        double szerkosc = 0;
        double dlugosc = 0;
        double wysokosc1 = 0;

        while(loop){
            try{
                scanner = new Scanner(System.in);

                System.out.println("podaj nazwe:");
                nazwaPomieszczenia = scanner.next();

                System.out.println("podaj szerokosc:");
                szerkosc = scanner.nextDouble();

                System.out.println("podaj dlugosc:");
                dlugosc = scanner.nextDouble();

                System.out.println("podaj wysokosc");
                wysokosc1 = scanner.nextDouble();

                break;
            }catch(Exception e){
                System.out.println("BLAD, podane bledne typy danych. Sprobuj jeszcze raz");
            }
        }

        return new Pokoj(nazwaPomieszczenia, szerkosc, dlugosc, wysokosc1);
    }

    public double kosztMalowania(){
        return powierzchniaScian() * kosztScian;
    }

    public double kosztPodlogi(){
        return powierzchniaPodlogi() * kosztPodlogi;
    }

    public double kosztRemontu() { return kosztMalowania() + kosztPodlogi();}
}

class SortKosztRemontu implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Pokoj pokoj1, pokoj2;

        pokoj1 = (Pokoj)o1;
        pokoj2 = (Pokoj)o2;

        if (pokoj1.kosztRemontu() != pokoj2.kosztRemontu()){
            return ((int)(pokoj1.kosztRemontu() * 100.0) - (int)(pokoj2.kosztRemontu() * 100.0));
        }else{
            return pokoj1.getNazwaPomieszczenia().compareTo(pokoj2.getNazwaPomieszczenia());
        }
    }
}

class SortPojemnosc implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Pokoj pokoj1, pokoj2;

        pokoj1 = (Pokoj)o1;
        pokoj2 = (Pokoj)o2;


        if (pokoj1.kosztRemontu() != pokoj2.kosztRemontu()){
            return ((int)(pokoj1.objetosc() * 100.0) - (int)(pokoj2.objetosc() * 100.0));
        }else{
            return pokoj1.getNazwaPomieszczenia().compareTo(pokoj2.getNazwaPomieszczenia());
        }
    }
}
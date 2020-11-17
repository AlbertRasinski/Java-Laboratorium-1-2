package albert.rasinski;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
	    Pokoj[] pokojeTablica = new Pokoj[3];

        Pokoj.setKosztPodlogi(30.80);
        Pokoj.setKosztScian(20.50);

        for (int i = 0; i < pokojeTablica.length; ++i){
            pokojeTablica[i] = Pokoj.wczytajDane();
        }

        for (int i = 0; i < pokojeTablica.length; ++i){
            pokojeTablica[i].printThis();
        }

        Arrays.sort(pokojeTablica, new SortPojemnosc());

        for (int i = 0; i < pokojeTablica.length; ++i){
            pokojeTablica[i].printThis();
        }
    }
}

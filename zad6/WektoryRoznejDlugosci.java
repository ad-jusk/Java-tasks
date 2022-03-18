
public class WektoryRoznejDlugosci extends Exception{
    WektoryRoznejDlugosci(int size1, int size2){
        System.out.println("Wektory maja rozne dlugosci!");
        System.out.println("Dlugosc pierwszego wektora to " + size1 + ", a drugiego to " + size2);
    }
}
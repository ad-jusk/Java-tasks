import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
        Vector vector1 = new Vector();
        Vector vector2 = new Vector();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ciag liczb do wektora 1 (odzielony spacjami):");
        vector1.FillVector(scanner);
        System.out.println("Podaj ciag liczb do wektora 2 (odzielony spacjami):");
        vector2.FillVector(scanner);
        
        Vector result;
        try{
            result = vector1.AddVector(vector2);
        }
        catch(WektoryRoznejDlugosci e){
            return;
        }
        result.PrintVector();
    }
}
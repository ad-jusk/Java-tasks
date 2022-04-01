import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
        MyVector vector1 = new MyVector();
        MyVector vector2 = new MyVector();
        Scanner scanner = new Scanner(System.in);
        MyVector result;
        
        while(true){
            System.out.println("Podaj ciag liczb do wektora 1 (odzielony spacjami):");
            vector1.FillVector(scanner);
            System.out.println("Podaj ciag liczb do wektora 2 (odzielony spacjami):");
            vector2.FillVector(scanner);
            try{
                result = vector1.AddVector(vector2);
            }
            catch(WektoryRoznejDlugosci e){
                vector1.ClearVector();
                vector2.ClearVector();
                continue;
            }
            try{
                result.PrintVector();
            }
            catch(IOException e){
                System.out.println("Nie udalo sie zapisac do pliku!");
                break;
            }
            break;
        }
        scanner.close();
    }
}
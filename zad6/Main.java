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
            vector1.fillVector(scanner);
            System.out.println("Podaj ciag liczb do wektora 2 (odzielony spacjami):");
            vector2.fillVector(scanner);
            try{
                result = vector1.addVector(vector2);
            }
            catch(WektoryRoznejDlugosci e){
                vector1.clearVector();
                vector2.clearVector();
                continue;
            }
            try{
                result.printVector();
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
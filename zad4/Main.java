import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        
        List AvailableProducts = new List();
        try{
            AvailableProducts.FillList("products.txt");
        }
        catch(IOException e){
            System.out.println("Blad odczytu dostepntch produktow z pliku!");
            return;
        }

        List UserList = new List();
        String product;
        int op = 0;
        Scanner scanner = new Scanner(System.in);
        

        if(new File("moja_lista.txt").exists()){
            System.out.println("Czy chcesz wczytac ostatnio utworzona liste? (1 - tak, 0 - nie)");
            try{
                op = scanner.nextInt();
                scanner.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println("Zla wartosc, robie pusta liste");
                scanner.nextLine();
            }
        }

        if(op == 1){
            try{
                UserList.FillList("moja_lista.txt");
            }
            catch(IOException e){
                System.out.println("Nie udalo sie wczytac listy z pliku");
            }
        }

        while(true){
            System.out.println("Co chcesz zrobic?");
            System.out.println("1 - dodaj do listy");
            System.out.println("2 - usun produkt z listy");
            System.out.println("3 - wyczysc liste");
            System.out.println("4 - wyswietl liste");
            System.out.println("5 - zapisz liste");
            System.out.println("6 - zakoncz");
            try{
                op = scanner.nextInt();
                scanner.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println("Zla wartosc!");
                continue;
            }
            if(op == 6){
                break;
            }

            switch(op){
                case 1:
                    while(true){
                        System.out.println("Podaj produkt:");
                        product = scanner.nextLine();
                        if(UserList.SearchForProduct(AvailableProducts, product)){
                            System.out.println("Dodano produkt do listy");
                            break;
                        }
                        else{
                            System.out.println("Produkt nie jest dostepny");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Podaj produkt do usuniecia:");
                    product = scanner.nextLine();
                    UserList.RemoveProduct(product);
                    break;
                case 3:
                    UserList.ClearList();
                    System.out.println("Wyszyszczono liste");
                    break;
                case 4:
                    UserList.PrintList();
                    break;
                case 5:
                    try{
                        UserList.WriteListToFile("moja_lista.txt");
                    }
                    catch(IOException e){
                        System.out.println("Blad zapisu do pliku");
                        break;
                    }
                    System.out.println("Zapisano liste do pliku");
                    break;
                default:
                    System.out.println("Zla wartosc!");
                    break;
            }
        }
        scanner.close();
    }
}
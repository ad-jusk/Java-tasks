import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        
        List AvailableProducts = new List();
        if(AvailableProducts.FillList("products.txt") == 1){
            System.out.println("Blad odczytu dostepntch produktow z pliku!");
        }

        List UserList = new List();
        String product;
        int op;
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Co chcesz zrobic?");
            System.out.println("1 - dodaj do listy");
            System.out.println("2 - usun produkt z listy");
            System.out.println("3 - wyczysc liste");
            System.out.println("4 - wyswietl liste");
            System.out.println("5 - zapisz liste");
            System.out.println("6 - zakoncz");

            op = scanner.nextInt();
            scanner.nextLine();
            if(op == 6){
                break;
            }

            switch(op){
                case 1:
                    System.out.println("Podaj produkt:");
                    product = scanner.nextLine();
                    if(UserList.SearchForProduct(AvailableProducts, product)){
                        System.out.println("Dodano produkt do listy");
                    }
                    else{
                        System.out.println("Produkt nie jest dostepny");
                    }
                    break;
                case 2:
                    System.out.println("Podaj produkt do usuniecia:");
                    product = scanner.nextLine();
                    UserList.RemoveProduct(product);
                    break;
                case 3:
                    UserList.ClearList();
                    break;
                case 4:
                    UserList.PrintList();
                    break;
                case 5:
                    UserList.WriteListToFile("moja_lista.txt");
                    break;
                default:
                    System.out.println("Zla wartosc!");
                    break;
            }
        }
        scanner.close();
    }
}
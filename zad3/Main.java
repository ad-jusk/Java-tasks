import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Wrong number of parameters!");
            return;
        }
        int N = 0;
        try{
            N = Integer.parseInt(args[0]);
        }
        catch(NumberFormatException e){
            System.out.println("Failed to parse argument to int");
            return;
        }
        if(N <= 0){
            System.out.println("Argument must be a positive integer!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 1;
        int guess = 0;
        int number = random.nextInt(N + 1);
        while(true){
            System.out.println("Enter your guess:");
            try{
                guess = scanner.nextInt();
                scanner.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println("Incorrect input");
                scanner.nextLine();
                continue;
            }
            if(guess == number){
                System.out.println("You won with " + count + " guesses!\nPlay again? (YES/NO)");
                String answer = "";
                answer = scanner.nextLine();
                answer = answer.toLowerCase();
                while(answer.equals("yes") == false && answer.equals("no") == false){
                    System.out.println("Incorrect input\nPlay again? (YES/NO)");
                    answer = scanner.nextLine();
                    answer = answer.toLowerCase();
                }
                if(answer.equals("yes")){
                    count = 1;
                    number = random.nextInt(N + 1);
                }
                else{
                    System.out.println("Thanks for playing!");
                    break;
                }
            }
            else if(guess < number){
                System.out.println("Generated number is higher");
                count++;
            }
            else{
                System.out.println("Generated number is lower");
                count++;
            }
        }
        scanner.close();
    }
}

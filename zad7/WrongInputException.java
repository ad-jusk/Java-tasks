
public class WrongInputException extends Exception{
    WrongInputException(){
        System.out.println("Couldn't parse given time to int!");
    }
}
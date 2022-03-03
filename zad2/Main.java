
public class Main{
    public static void main(String[] args){
        
        if(args.length != 3){
            System.out.println("Wrong number of arguments!");
            return;
        }
        String word = args[0];
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        if(a > b){
            System.out.println("Second index must be greater than first!");
            return;
        }
        if(a < 0){
            a = 0;
        } 
        if(b > word.length() - 1){
            b = word.length() - 1;
        }
        System.out.println(word.substring(a, b+1));
    }
}
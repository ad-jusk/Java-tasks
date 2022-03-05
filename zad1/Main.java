

public class Main{
    public static void main(String[] args){
        
        if(args.length != 3){
            System.out.println("Wrong number of parameters!");
            return;
        }
        double a, b, c;
        try{
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);
        }
        catch(NumberFormatException e){
            System.out.println("Failed to parse arguments!");
            return;
        }
        Equation eq = new Equation(a, b, c);
        if(eq.roots_exist() == false){
            System.out.println("Equation cannot be solved");
        }
        else{
            eq.solve();
        }
    }
}
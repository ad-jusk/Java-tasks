

public class Main{
    public static void main(String[] args){
        
        if(args.length != 3){
            System.out.println("Wrong number of parameters!");
            return;
        }
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        Equation eq = new Equation(a, b, c);
        if(eq.roots_exist() == false){
            System.out.println("Equation cannot be solved");
        }
        else{
            eq.solve();
        }
    }
}
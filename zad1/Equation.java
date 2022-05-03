
public class Equation{
    private double a;
    private double b;
    private double c;
    private double delta;

    public Equation(double A, double B, double C){
        a = A;
        b = B;
        c = C;
        delta = B*B - (4*A*C);
    }
    public boolean roots_exist(){
        if(delta < 0){
            return false;
        }
        return true;
    }
    public void solve(){
        if(delta == 0){
            double x1 = -b/(2*a);
            System.out.println("Root: " + x1);
        }
        else{
            double x1 = (-b - Math.sqrt(delta))/(2*a);
            double x2 = (-b + Math.sqrt(delta))/(2*a);
            System.out.print("Roots: " + x1 + ", " + x2 + "\n");
        }
    }
}

public class Equation{
    double a;
    double b;
    double c;
    double delta;
    Equation(double A, double B, double C){
        this.a = A;
        this.b = B;
        this.c = C;
        this.delta = B*B - (4*A*C);
    }
    boolean roots_exist(){
        if(this.delta < 0){
            return false;
        }
        return true;
    }
    void solve(){
        if(this.delta == 0){
            double x1 = -this.b/(2*this.a);
            System.out.println("Root: " + x1);
        }
        else{
            double x1 = (-this.b - Math.sqrt(this.delta))/(2*this.a);
            double x2 = (-this.b + Math.sqrt(this.delta))/(2*this.a);
            System.out.print("Roots: " + x1 + ", " + x2 + "\n");
        }
    }
}
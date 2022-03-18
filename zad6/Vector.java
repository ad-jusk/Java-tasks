import java.util.ArrayList;
import java.util.Scanner;

public class Vector{
    public ArrayList<Integer> vector;

    Vector(){
        this.vector = new ArrayList<Integer>();
    }
    void FillVector(Scanner scanner){
        int temp = 0;
        String input = scanner.nextLine();
        String[] nums = input.split(" ");

        for(String s : nums){
            try{
                temp = Integer.parseInt(s);       
            }
            catch(NumberFormatException e){
                continue;
            }
            this.vector.add(temp);
        }
    }
    void PrintVector(){
        System.out.println("Wynik:");
        for(Integer value : this.vector){
            System.out.print(value + " ");
        }
        System.out.print("\n");
    }
    boolean CheckIfSameLength(Vector v){
        if(this.vector.size() != v.vector.size()){
            return false;
        }
        return true;
    }
    Vector AddVector(Vector v) throws WektoryRoznejDlugosci{
        if(this.CheckIfSameLength(v) == false){
            throw new WektoryRoznejDlugosci(this.vector.size(), v.vector.size());
        }
        Vector result = new Vector();
        for(int i = 0;i<this.vector.size();i++){
            result.vector.add(this.vector.get(i) + v.vector.get(i));
        }
        return result;
    } 
}
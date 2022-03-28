import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Vector{
    ArrayList<Integer> vector;

    Vector(){
        this.vector = new ArrayList<Integer>();
    }
    void FillVector(Scanner scanner){
        int temp = 0;
        String input = scanner.nextLine();
        while(!this.checkIfVectorIsCorrect(input)){
            System.out.println("Zly wektor!");
            input = scanner.nextLine();
        }
        String[] nums = input.split(" ");
        for(String s : nums){
            temp = Integer.parseInt(s);       
            this.vector.add(temp);
        }
    }
    boolean checkIfVectorIsCorrect(String input){
        for(int i = 0;i<input.length();i++){
            if(!Character.isDigit(input.charAt(i)) && input.charAt(i) != ' '){
                return false;
            }
        }
        return true;
    }
    void PrintVector() throws IOException{
        System.out.println("Wynik:");
        for(Integer value : this.vector){
            System.out.print(value + " ");
        }
        System.out.print("\nZapisywane wyniku do pliku...\n");
        this.SaveVector();
    }
    boolean CheckIfSameLength(Vector v){
        if(this.vector.size() != v.GetVectorSize()){
            return false;
        }
        return true;
    }
    Vector AddVector(Vector v) throws WektoryRoznejDlugosci{
        if(this.CheckIfSameLength(v) == false){
            throw new WektoryRoznejDlugosci(this.vector.size(), v.GetVectorSize());
        }
        Vector result = new Vector();
        for(int i = 0;i<this.vector.size();i++){
            result.vector.add(this.vector.get(i) + v.GetVectorElement(i));
        }
        return result;
    }
    void SaveVector() throws IOException{
        FileWriter writer = new FileWriter("result.txt");
        for(Integer number : this.vector){
            writer.write(number.toString() + " ");
        }
        writer.close();
    }
    void ClearVector(){this.vector.clear();}
    int GetVectorElement(int index) {return this.vector.get(index);}
    int GetVectorSize() {return this.vector.size();} 
}
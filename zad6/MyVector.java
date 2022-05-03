import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MyVector{
    private ArrayList<Integer> vector;

    public MyVector(){
        this.vector = new ArrayList<Integer>();
    }

    public void fillVector(Scanner scanner){
        int temp = 0;
        String input = scanner.nextLine();
        while(!checkIfVectorIsCorrect(input)){
            System.out.println("Zly wektor!");
            input = scanner.nextLine();
        }
        String[] nums = prepareVector(input);
        for(String s : nums){
            temp = Integer.parseInt(s);       
            vector.add(temp);
        }
    }

    public boolean checkIfVectorIsCorrect(String input){
        for(int i = 0;i<input.length();i++){
            if(!Character.isDigit(input.charAt(i)) && input.charAt(i) != ' '){
                return false;
            }
        }
        return true;
    }

    public void printVector() throws IOException{
        System.out.println("Wynik:");
        for(Integer value : vector){
            System.out.print(value + " ");
        }
        System.out.print("\nZapisywane wyniku do pliku...\n");
        saveVector();
    }

    public boolean checkIfSameLength(MyVector v){
        return vector.size() == v.getVectorSize();
    }

    public String[] prepareVector(String input){
        String[] inputDivided = input.split(" ");
        ArrayList<String> inputDividedAsArray = new ArrayList<String>(Arrays.asList(inputDivided));

        //This loop removes empty strings when user types more than 1 space
        for(String string : inputDivided){
            if(string.isEmpty()){
                inputDividedAsArray.remove(string);
            }
        }
        inputDivided = inputDividedAsArray.toArray(new String[0]);
        return inputDivided;
    }

    public MyVector addVector(MyVector v) throws WektoryRoznejDlugosci{
        if(checkIfSameLength(v) == false){
            throw new WektoryRoznejDlugosci(vector.size(), v.getVectorSize());
        }
        MyVector result = new MyVector();
        for(int i = 0;i<vector.size();i++){
            result.vector.add(vector.get(i) + v.getVectorElement(i));
        }
        return result;
    }

    public void saveVector() throws IOException{
        FileWriter writer = new FileWriter("result.txt");
        for(Integer number : vector){
            writer.write(number.toString() + " ");
        }
        writer.close();
    }

    public void clearVector() {vector.clear();}
    public int getVectorElement(int index) {return vector.get(index);}
    public int getVectorSize() {return vector.size();} 
}
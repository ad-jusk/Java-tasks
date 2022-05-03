import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class List{

    private ArrayList<Category> allProducts;
    private int numOfCategories;

    public List(){
        allProducts = new ArrayList<Category>();
        numOfCategories = -1;
    }

    public void fillList(String filename) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        while(line != null){
            if(line.length() > 0 && line.charAt(0) == '-'){
                allProducts.get(numOfCategories).add(line.substring(1,line.length()));
            }
            else if(line.length() > 0 && Character.isUpperCase(line.charAt(0))){
                allProducts.add(new Category(line));
                numOfCategories++;
            }
            line = reader.readLine();
        }
        reader.close();
    }

    public void writeListToFile(String filename) throws IOException{
        FileWriter writer = new FileWriter(filename);
        for(int i = 0;i<allProducts.size();i++){
            writer.write(allProducts.get(i).getCategoryName() + "\n");
            for(int j = 0;j<allProducts.get(i).getProductsQuantity();j++){
                writer.write("-" + allProducts.get(i).getIndividualProduct(j) + "\n");
            }
        }
        writer.close();
    }

    public void printList(){
        if(allProducts.size() == 0){
            System.out.println("Lista jest pusta");
        }
        else{
            for(Category c : allProducts){
                c.printCategory();
            }
        }
    }

    public boolean searchForProduct(List list, String product){
        for(Category c : list.allProducts){
            if(c.isProductAvailable(product)){
                int count = 0;
                for(Category i : allProducts){
                    if(i.getCategoryName().equals(c.getCategoryName())){
                        allProducts.get(count).add(product);
                        return true;
                    }
                    count++;
                }
                allProducts.add(new Category(c.getCategoryName()));
                numOfCategories++;
                allProducts.get(numOfCategories).add(product);
                return true;
            }
        }
        return false;
    }

    void removeProduct(String product){
        for(int i = 0;i<allProducts.size();i++){
            if(!allProducts.get(i).remove(product) && i == allProducts.size() - 1){
                System.out.println("Nie udalo sie usunac produktu");
                return;
            }
            if(allProducts.get(i).getProductsQuantity() == 0){
                allProducts.remove(allProducts.get(i));
                numOfCategories--;
                break;
            }
        }
    }

    public void clearList(){
        allProducts.clear();
        numOfCategories = -1;
    }
}
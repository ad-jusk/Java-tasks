import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class List{

    ArrayList<Category> AllProducts;
    int NumOfCategories;
    List(){
        this.AllProducts = new ArrayList<Category>();
        this.NumOfCategories = -1;
    }
    void FillList(String filename) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        while(line != null){
            if(line.length() > 0 && line.charAt(0) == '-'){
                AllProducts.get(NumOfCategories).add(line.substring(1,line.length()));
            }
            else if(line.length() > 0 && Character.isUpperCase(line.charAt(0))){
                AllProducts.add(new Category(line));
                this.NumOfCategories++;
            }
            line = reader.readLine();
        }
        reader.close();
    }
    void WriteListToFile(String filename) throws IOException{
        FileWriter writer = new FileWriter(filename);
        for(int i = 0;i<this.AllProducts.size();i++){
            writer.write(this.AllProducts.get(i).GetCategoryName() + "\n");
            for(int j = 0;j<this.AllProducts.get(i).GetProductsQuantity();j++){
                writer.write("-" + this.AllProducts.get(i).GetIndividualProduct(j) + "\n");
            }
        }
        writer.close();
    }
    void PrintList(){
        if(this.AllProducts.size() == 0){
            System.out.println("Lista jest pusta");
        }
        else{
            for(Category c : this.AllProducts){
                c.printCategory();
            }
        }
    }
    boolean SearchForProduct(List list, String product){
        for(Category c : list.AllProducts){
            if(c.IsProductAvailable(product)){
                int count = 0;
                for(Category i : this.AllProducts){
                    if(i.GetCategoryName().equals(c.GetCategoryName())){
                        this.AllProducts.get(count).add(product);
                        return true;
                    }
                    count++;
                }
                this.AllProducts.add(new Category(c.GetCategoryName()));
                this.NumOfCategories++;
                this.AllProducts.get(this.NumOfCategories).add(product);
                return true;
            }
        }
        return false;
    }
    void RemoveProduct(String product){
        for(int i = 0;i<this.AllProducts.size();i++){
            if(!this.AllProducts.get(i).remove(product) && i == this.AllProducts.size() - 1){
                System.out.println("Nie udalo sie usunac produktu");
                return;
            }
            if(this.AllProducts.get(i).GetProductsQuantity() == 0){
                this.AllProducts.remove(this.AllProducts.get(i));
                this.NumOfCategories--;
                break;
            }
        }
    }
    void ClearList(){
        AllProducts.clear();
        this.NumOfCategories = -1;
    }
}
import java.util.ArrayList;

public class Category{

    String CategoryName;
    ArrayList<String> Products;

    Category(String name){
        this.CategoryName = name;
        this.Products = new ArrayList<String>();
    }
    void add(String product){
        this.Products.add(product);
    }
    void remove(String product){
        this.Products.remove(product);
    }
    void printCategory(){
        System.out.println(CategoryName + ":");
        for (String string : Products) {
            System.out.println("- " + string);
        }
    }
    boolean IsProductAvailable(String name){
        for(String product : Products){
            if(name.equals(product)){
                return true;
            }
        }
        return false;
    }
    String GetCategoryName() {return this.CategoryName;}
    int GetProductsQuantity() {return Products.size();}
    String GetIndividualProduct(int index) {return this.Products.get(index);}
}
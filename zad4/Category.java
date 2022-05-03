import java.util.ArrayList;

public class Category{

    private String categoryName;
    private ArrayList<String> products;

    public Category(String name){
        categoryName = name;
        products = new ArrayList<String>();
    }
    public void add(String product){
        products.add(product);
    }
    public boolean remove(String product){
        return products.remove(product);
    }
    public void printCategory(){
        System.out.println(categoryName + ":");
        for (String string : products) {
            System.out.println("- " + string);
        }
    }
    public boolean isProductAvailable(String name){
        for(String product : products){
            if(name.equals(product)){
                return true;
            }
        }
        return false;
    }

    public String getCategoryName() {return categoryName;}
    public int getProductsQuantity() {return products.size();}
    public String getIndividualProduct(int index) {return products.get(index);}
}
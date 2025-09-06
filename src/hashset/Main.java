package hashset;

import java.util.HashSet;
import java.util.Set;

class Product{
    String name;
    String category;
    int price;

    public Product(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
public class Main {

    public static Product mostExpensive(Set<Product> products){
        Product maxProduct=null; int price= -10;
        for(Product p : products){
            if(p.price>price){
                price=p.price;
                maxProduct=p;
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        Set<Product> products= new HashSet<>();
        products.add(new Product("Samsung","phone",5000));
        products.add(new Product("Iphone","Phone",2000));
        products.add(new Product("Oneplus","Phone",1500));
        products.add(new Product("Sony","Phone",12033));


        Product maxi=mostExpensive(products);
        System.out.println(maxi);
        //System.out.println(products);
    }
}

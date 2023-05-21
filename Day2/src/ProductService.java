import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProduct(String name){
        for (Product p : products){
            if (p.getName().equals(name))
                return p;
        }
        return null;
    }

    public List<Product> getProductWithText(String text){
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for (Product p : products){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if (name.contains(str) || type.contains(str) || place.contains(str)){
                prods.add(p);
            }
        }

        return prods;
    }

    public List<Product> productsFromPlace(String place) {
        List<Product> matchingProds = new ArrayList<>();

        for (Product p : products) {
            if (p.getPlace().equalsIgnoreCase(place)) {
                matchingProds.add(p);
            }
        }
        return matchingProds;
    }

    public List<Product> outOfWarrantyProds() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR); //Using java Calendar class
        List<Product> outOfWarrantyProds = new ArrayList<>();

        for (Product p : products) {
            if (p.getWarranty() < currentYear) {
                outOfWarrantyProds.add(p);
            }
        }

        return outOfWarrantyProds;
    }

    }

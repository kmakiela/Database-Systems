import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int categoryID;

    public String getCategoryName() {
        return CategoryName;
    }

    private String CategoryName;
    @OneToMany(mappedBy = "Category")
    private List<Product> Products = new ArrayList<>();

    public Category(String categoryName){
        this.CategoryName =  categoryName;
    }

    public Category(){

    }

    public void addProduct(Product product){
        Products.add(product);
        product.setCategory(this);
    }

    public List<Product> getProducts() {
        return Products;
    }
}
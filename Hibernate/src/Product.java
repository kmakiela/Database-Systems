import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int productID;

    @ManyToMany(mappedBy = "Products")
    private Set<Invoice> Invoices = new HashSet<>(0);

    private String ProductName;
    private int UnitsOnStock;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category Category;

    @ManyToOne
    private Supplier supplier;

    public Product(String ProductName, int UnitsOnStock){
        this.ProductName = ProductName;
        this.UnitsOnStock = UnitsOnStock;
    }

    public Product(String ProductName, int UnitsOnStock, Set<Invoice> invoices){
        this.ProductName = ProductName;
        this.UnitsOnStock = UnitsOnStock;
        this.Invoices = invoices;
    }

    public Product(){

    }


    public String getProductName() {
        return ProductName;
    }

    public Set<Invoice> getInvoices(){
        return Invoices;
    }

    public void setSupplier(Supplier supplier){
        this.supplier = supplier;
    }

    public void setCategory(Category category) {
        Category = category;
    }

    public void addToInvoice(Invoice invoice){
        this.Invoices.add(invoice);
    }
}
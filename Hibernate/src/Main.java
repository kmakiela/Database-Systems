import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args){

        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

       Scanner inputScanner = new Scanner(System.in);
        System.out.println("enter product name: ");
        String prodName = inputScanner.nextLine();
        System.out.println("enter product count: ");
        String newLine = inputScanner.nextLine();
        int unitsInStock = Integer.parseInt(newLine);

        System.out.println("enter category name: ");
        String categoryName = inputScanner.nextLine();
        Category category = new Category(categoryName);


        Product product1 = new Product(prodName,unitsInStock);
        session.save(product1);
        category.addProduct(product1);
        session.save(category);
/*
        System.out.println("enter company name: ");
        String companyName = inputScanner.nextLine();
        System.out.println("enter street: ");
        String street = inputScanner.nextLine();
        System.out.println("enter city: ");
        String city = inputScanner.nextLine();

        Supplier supplier = new Supplier(companyName,street,city);
        session.save(supplier);
        Product prodFound = session.get(Product.class,1);
        prodFound.setSupplier(supplier);

        Category category2 = session.get(Category.class,5);
        System.out.println("category: " + category.getCategoryName());
        List<Product> prods = category2.getProducts();
        for(Product p : prods) {
            System.out.println(p.getProductName());
        }
        Address ad1 = new Address("Niebieska","Radom");
        String companyName1 = "Cicada";
        Supplier sup1 = new Supplier(companyName1,ad1);
        sup1.setDelivery_address(new Address("studencka 12","Krakow"));
        session.save(sup1);
*/
/*
        Customer cust1 = new Customer("Customer1","customerStreet","customerCity","666-666",15);
        Supplier supp1 = new Supplier("supplier1","supplierstreet","suppcity","66-666-66","12345676853256856");
        session.save(cust1);
        session.save(supp1);
        tx.commit();
*/
        session.close();

    }

    private static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
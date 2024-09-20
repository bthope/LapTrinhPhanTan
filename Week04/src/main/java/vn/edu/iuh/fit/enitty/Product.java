package vn.edu.iuh.fit.enitty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(columnDefinition = "varchar(50)")
    private String product_id;
    @Column(columnDefinition = "varchar(50)")
    private String model;
    @Column(columnDefinition = "varchar(50)")
    private String description;
    @Column(columnDefinition = "int")
    private int quantity;
    @Column(columnDefinition = "double")
    private double price;
    @Column(columnDefinition = "varchar(255)")
    private String imgURL;

    public Product() {
    }

    public Product(String model, String description, int quantity, double price, String imgURL) {
        this.model = model;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.imgURL = imgURL;
    }

    public Product(String product_id, String model, String description, int quantity, double price, String imgURL) {
        this.product_id = product_id;
        this.model = model;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.imgURL = imgURL;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id='" + product_id + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}

package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;
    @Column(name = "product_name", columnDefinition = "varchar(50)")
    private String productName;

    private int price;
    private int quantity;
    @Column(columnDefinition = "varchar(150)")
    private String author;
    @Column(columnDefinition = "varchar(250)")
    private String urlImg;

    public Product() {
    }

    public Product(long productId, String productName, int price, int quantity, String author, String urlImg) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.author = author;
        this.urlImg = urlImg;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", author='" + author + '\'' +
                ", urlImg='" + urlImg + '\'' +
                '}';
    }
}

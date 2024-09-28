package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double total;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public ProductDetail() {
    }

    public ProductDetail(long id, double total, int quantity, Product product) {
        this.id = id;
        this.total = total;
        this.quantity = quantity;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", total=" + total +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}

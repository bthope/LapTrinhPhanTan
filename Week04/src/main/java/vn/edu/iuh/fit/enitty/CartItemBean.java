package vn.edu.iuh.fit.enitty;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_item_bean")
public class CartItemBean {
    @Id
    @Column(columnDefinition = "varchar(50)")
    private String cartItemBean_id;

    @Column(columnDefinition = "varchar(50)")
    private String partNumber;

    @Column(columnDefinition = "varchar(50)")
    private String description;

    @Column(columnDefinition = "double")
    private double unitCost;

    @Column(columnDefinition = "int")
    private int quantity;

    @Column(columnDefinition = "double")
    private double totalCost;

    @ManyToOne
    @JoinColumn(name = "cart_bean_id") // Ensure this matches the column in your DB
    private CartBean cartBean;

    public CartItemBean() {
    }

    public CartItemBean(String cartItemBean_id, String partNumber, String description, double unitCost, int quantity, double totalCost, CartBean cartBean) {
        this.cartItemBean_id = cartItemBean_id;
        this.partNumber = partNumber;
        this.description = description;
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.totalCost = totalCost;
        this.cartBean = cartBean;
    }

    public String getCartItemBean_id() {
        return cartItemBean_id;
    }

    public void setCartItemBean_id(String cartItemBean_id) {
        this.cartItemBean_id = cartItemBean_id;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public CartBean getCartBean() {
        return cartBean;
    }

    public void setCartBean(CartBean cartBean) {
        this.cartBean = cartBean;
    }

    @Override
    public String toString() {
        return "CartItemBean{" +
                "cartItemBean_id='" + cartItemBean_id + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", description='" + description + '\'' +
                ", unitCost=" + unitCost +
                ", quantity=" + quantity +
                ", totalCost=" + totalCost +
                ", cartBean=" + cartBean +
                '}';
    }
}

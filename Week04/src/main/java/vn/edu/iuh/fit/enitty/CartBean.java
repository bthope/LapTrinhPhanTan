package vn.edu.iuh.fit.enitty;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enitty.CartItemBean;

import java.util.List;

@Entity
@Table(name = "cart_bean")
public class CartBean {

    @Column(columnDefinition = "double")
    private double orderTotal;

    @OneToMany(mappedBy = "cartBean", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItemBean> cartItemBeans;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public CartBean() {
    }

    public CartBean(double orderTotal, List<CartItemBean> cartItemBeans, Product product) {
        this.orderTotal = orderTotal;
        this.cartItemBeans = cartItemBeans;
        this.product = product;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public List<CartItemBean> getCartItemBeans() {
        return cartItemBeans;
    }

    public void setCartItemBeans(List<CartItemBean> cartItemBeans) {
        this.cartItemBeans = cartItemBeans;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartBean{" +
                "orderTotal=" + orderTotal +
                ", cartItemBeans=" + cartItemBeans +
                ", product=" + product +
                '}';
    }
}

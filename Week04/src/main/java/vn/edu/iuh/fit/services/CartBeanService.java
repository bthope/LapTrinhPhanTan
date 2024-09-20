package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.enitty.CartBean;
import vn.edu.iuh.fit.repository.CartBeanDao;

import java.util.List;

public class CartBeanService {
    private static CartBeanDao cartBeanDao = new CartBeanDao();

    public static void insertCartBean(CartBean cartBean){
        cartBeanDao.insertCartBean(cartBean);
    }
    public static List<CartBean> getCartBean(){
        return cartBeanDao.getCartBean();
    }
}

package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.enitty.CartItemBean;
import vn.edu.iuh.fit.repository.CartItemBeanDao;

import java.util.List;

public class CartItemBeanService {
    private static CartItemBeanDao cartItemBeanDao = new CartItemBeanDao();

    public static void insertCartItemBean(CartItemBean cartItemBean){
        cartItemBeanDao.insertCartItemBean(cartItemBean);
    }
    public static List<CartItemBean> getCartItemBean(){
        return cartItemBeanDao.getCartItemBean();
    }
    public static void delCartItemBean(String id){
        cartItemBeanDao.delCartItemBeanDao(id);
    }
    public static CartItemBean getCartItemById(String id){
        return cartItemBeanDao.getCartItemById(id);
    }
}

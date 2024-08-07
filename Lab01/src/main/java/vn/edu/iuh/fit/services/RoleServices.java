package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.repositories.RoleDao;

import java.util.List;

public class RoleServices {
    private static RoleDao roleDao = new RoleDao();
    public static void insertRole(Role role){
        roleDao.insertRole(role);
    }
    public static List<Role> getRoles(){
        return roleDao.getRoles();
    }
}

package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.entities.Role;

import java.util.List;

public class RoleDao {
    private EntityManager em;

    public RoleDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }

    //Them Role
    public void insertRole(Role role){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(role);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
    // Xem danh sach Role
    public List<Role> getRoles(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql ="select * from Role";
            List<Role> roles = em.createNativeQuery(sql, Role.class).getResultList();

            tr.commit();
            return roles;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}

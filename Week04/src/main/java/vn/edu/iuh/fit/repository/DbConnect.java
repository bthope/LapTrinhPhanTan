package vn.edu.iuh.fit.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbConnect {
    private static DbConnect instance;
    private EntityManagerFactory emf;

    public DbConnect() {
        emf = Persistence.createEntityManagerFactory("lab04");
    }

    public static DbConnect getInstance() {
        if(instance == null)
            instance = new DbConnect();
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}

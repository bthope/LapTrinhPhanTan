package en.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbConnect {
    private static DbConnect instance;
    private EntityManagerFactory emf;

    public DbConnect() {
        emf = Persistence.createEntityManagerFactory("test01");
    }

    public static DbConnect getInstance() {
        if (instance == null)
            instance = new DbConnect();
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}

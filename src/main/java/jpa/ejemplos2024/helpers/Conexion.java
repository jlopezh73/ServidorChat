package jpa.ejemplos2024.helpers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conexion {
    private static EntityManager em=null;
    protected Conexion() {

    }

    public static EntityManager obtenerEM() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursos");
            em = emf.createEntityManager();
        }
        return em;
    }

}

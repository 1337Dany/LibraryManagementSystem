package data.crud;

import data.entity.Copy;
import domain.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class CopyCRUD {
    public static void createCopy() {
    }

    public static List<Copy> readCopy() {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            return session.createQuery("from Copy", Copy.class).list();
        }
    }

    public void udateCopy() {
    }

    public void deleteCopy() {
    }
}

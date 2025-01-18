package data.crud;

import data.entity.Borrowing;
import domain.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class BorrowingCRUD {
    public static void createBorrowing() {
    }

    public static List<Borrowing> readBorrowing() {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            return session.createQuery("from Borrowing", Borrowing.class).list();
        }
    }

    public void updatingBorrowing() {
    }

    public void deleteBorrowing() {
    }
}

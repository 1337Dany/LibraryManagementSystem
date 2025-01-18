package data.crud;

import data.entity.Librarian;
import domain.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class LibrarianCRUD {
    public static void createLibrarian() {
    }

    public static List<Librarian> readLibrarian() {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            return session.createQuery("from Librarian", Librarian.class).list();
        }
    }

    public void updateLibrarian() {
    }

    public void deleteLibrarian() {
    }
}

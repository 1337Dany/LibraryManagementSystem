package data.crud;

import data.entity.Book;
import domain.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookCRUD {
    public static void createBook(Book book) {
        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static List<Book> readBook() {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            return session.createQuery("from Book", Book.class).list();
        }
    }

    public void updateBook() {
    }

    public void deleteBook() {
    }
}

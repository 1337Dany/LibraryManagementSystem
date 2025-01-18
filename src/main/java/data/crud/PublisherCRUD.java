package data.crud;

import data.entity.Publisher;
import domain.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class PublisherCRUD {
    public static void createPublisher() {
    }

    public static List<Publisher> readPublisher() {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            return session.createQuery("from Publisher", Publisher.class).list();
        }
    }

    public void updatePublisher() {
    }

    public void deletePublisher() {
    }
}

package data.crud;

import data.entity.Member;
import domain.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MemberCRUD {
    public static void createMember(Member member) {
        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(member);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static List<Member> readMember() {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            return session.createQuery("from Member", Member.class).list();
        }
    }

    public void updateMember() {
    }

    public void deleteMember() {
    }
}

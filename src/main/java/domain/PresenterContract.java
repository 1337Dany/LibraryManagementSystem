package domain;

import data.entity.*;

import java.util.List;

public interface PresenterContract {
    List<Book> getBooks();
    void createBook(Book book);
    List<Member> getMembers();
    void createMember(Member member);
    List<Copy> getCopies();
    List<Borrowing> getBorrowings();
    List<Librarian> getLibrarians();
    List<Publisher> getPublishers();
}

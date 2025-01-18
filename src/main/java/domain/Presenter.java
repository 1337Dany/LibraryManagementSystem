package domain;

import data.crud.*;
import data.entity.*;

import java.util.List;

public class Presenter implements PresenterContract{

    @Override
    public List<Book> getBooks() {
        return BookCRUD.readBook();
    }

    @Override
    public void createBook(Book book) {
        BookCRUD.createBook(book);
    }

    @Override
    public List<Member> getMembers() {
        return MemberCRUD.readMember();
    }

    @Override
    public void createMember(Member member) {
        MemberCRUD.createMember(member);
    }

    @Override
    public List<Copy> getCopies() {
        return CopyCRUD.readCopy();
    }

    @Override
    public List<Borrowing> getBorrowings() {
        return BorrowingCRUD.readBorrowing();
    }

    @Override
    public List<Librarian> getLibrarians() {
        return LibrarianCRUD.readLibrarian();
    }

    @Override
    public List<Publisher> getPublishers() {
        return PublisherCRUD.readPublisher();
    }
}

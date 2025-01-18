package ui;

import data.entity.*;

import java.util.List;

public interface ViewContract {
    void logout();
    List<Book> downloadBookData();
    void createBook(Book book);
    List<Member> downloadMemberData();
    void createMember(Member member);
    List<Copy> downloadCopyData();
    List<Borrowing> downloadBorrowingData();
    List<Librarian> getLibrarians();
    List<Publisher> getPublishers();
}

package data.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "borrowing")
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "MEMBERID", nullable = false)
    private data.entity.Member member;

    @ManyToOne
    @JoinColumn(name = "COPYID", nullable = false)
    private data.entity.Copy copy;


    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date borrowDate;

    @Temporal(TemporalType.DATE)
    private Date returnDate;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public data.entity.Member getMember() {
        return member;
    }

    public void setMember(data.entity.Member member) {
        this.member = member;
    }

    public data.entity.Copy getCopy() {
        return copy;
    }

    public void setCopy(data.entity.Copy copy) {
        this.copy = copy;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

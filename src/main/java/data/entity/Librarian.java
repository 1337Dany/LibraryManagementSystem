package data.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "librarian")
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "memberId", nullable = false)
    private data.entity.Member member;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date employmentDate;

    @Column(nullable = false)
    private String position;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public data.entity.Member getUser() {
        return member;
    }

    public void setUser(data.entity.Member member) {
        this.member = member;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // toString
    @Override
    public String toString() {
        return getUser().getName();
    }
}

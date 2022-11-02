package ua.koss.author.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "BLOG_USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate birthday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_AUTHOR",
            joinColumns = {
                    @JoinColumn(name = "USERS_FK", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "AUTHORS_FK", referencedColumnName = "id")
            })
    private Author author;
}

package model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_table")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(
            name = "secondName",
            unique = false,
            nullable = true,
            insertable = true,
            updatable = true,
            length = 250
    )
    private String surname;


    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(String name) {
        this.name = name;
    }
}

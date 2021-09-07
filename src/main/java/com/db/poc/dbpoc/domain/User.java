package com.db.poc.dbpoc.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String username;
    String name;
    String city;
    String country;

    public User(String uName, String name, String city, String country) {
        this.username = uName;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public User update(User newSrc) {
        this.setName(newSrc.getName());
        this.setCity(newSrc.getCity());
        this.setCountry(newSrc.getCountry());

        return this;
    }

}

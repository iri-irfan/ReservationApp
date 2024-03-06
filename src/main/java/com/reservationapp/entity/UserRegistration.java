package com.reservationapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.el.stream.StreamELResolverImpl;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_registration")
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private String email;
    private String password;

    @Lob
    @Column(name = "profile_picture", length = 101024)
    private byte[] profilePicture;

}

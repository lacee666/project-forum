package com.forum.forum.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column(nullable = false, unique = true, length = 16)
    private String username;

    @Column(nullable = false, length = 16)
    private String password;

    @Column(nullable = false, unique = true)
    private boolean isAdmin;

    //using Date
    @Column(nullable = false)
    private String registrationDate;

    @ElementCollection
    @CollectionTable(name = "user_upvotes", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> upvotes = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "user_downvotes", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> downvotes = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "user_forumthreads", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> forumthreads = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "user_subscribedTo", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> subscribedTo = new HashSet<>();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        GUEST, USER, ADMIN
    }


}

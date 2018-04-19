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
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column(nullable = false, unique = true, length = 16)
    private String username;

    @Column(nullable = false, length = 16)
    private String password;

    @Column(nullable = false)
    private String email;

    //using Date
    @Column(name = "rdate", nullable = false)
    private String registrationDate;

    @ElementCollection
    @CollectionTable(name = "user_upvotes", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> upVotedCommentIds = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "user_downvotes", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> downVotedCommentIds = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "user_forumcomments", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> myForumCommentIds = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "user_forumthreads", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> myForumThreadIds = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "user_forums", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> myForumIds = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "user_subscribedTo", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> subscribedForumIds = new HashSet<>();

    //not sure if this works
    @Lob
    @Column(name="USER_PICTURE")
    private byte[] picture;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        GUEST, USER, ADMIN
    }

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String username, String password, String email, byte[] picture){
        this.username = username;
        this.password = password;
        this.email = email;
        this.picture = picture;
    }
	
}

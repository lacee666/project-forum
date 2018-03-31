package com.forum.forum.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FORUM")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Forum extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String forumName;
    /*
    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = User.class)
    private ArrayList<User> subscribedUsers;
    */
    @Column(nullable = false)
    private String creationDate;


    @Column(nullable = false)
    private long forumAdminId;

}

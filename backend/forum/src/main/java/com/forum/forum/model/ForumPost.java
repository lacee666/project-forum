package com.forum.forum.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name = "FORUMPOST")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ForumPost extends BaseEntity {
    /*
    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = User.class)
     */
    @Column(nullable = false)
    private String creationDate;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;
}
package com.forum.forum.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "FORUMPOST")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ForumPost extends BaseEntity {

    @Column(nullable = false)
    private String creationDate;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String description;
    //We have annotated the comments field in the Post entity with @OneToMany annotation to declare that the Post entity has a one-to-many association with the Comment entity.
    //We use the mappedBy attribute in the Post entity to declare that it is not responsible for the relationship and hibernate
    // should look for a field named post in the Comment entity to find the configuration for the JoinColumn/ForeignKey Column.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();

    public ForumPost(String title, String description) {
        this.title = title;
        this.description = description;
    }
}

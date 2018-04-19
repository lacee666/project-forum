package com.forum.forum.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name = "COMMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Comment extends BaseEntity {

    @Column(nullable = false)
    private String creationDate;

    @Column(nullable = false, length = 300)
    private String text;

    @Column()
    private int upVoteCount;

    @Column()
    private int downVoteCount;

    //We use @OneToMany and @ManyToOne annotations to declare a bi-directional one-to-many relationship between two entities.
    //Similarly, We have annotated the post field in the Comment entity with @ManyToOne annotation and defined a @JoinColumn which is used as the foreign key column in the Comment entity.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private ForumPost post;

    public Comment(String text){
        this.text = text;
    }
}

package com.forum.forum.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "FORUM")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Forum extends BaseEntity {

    @Column(nullable = true, unique = true, length = 50)
    private String forumName;

    @Column(nullable = false, unique = true, length = 100)
    private String description;

    @Column(nullable = true)
    private String creationDate;

    @Column(nullable = true)
    private long forumAdminId;

    //not sure if this works
    @Lob
    @Column(name="FORUM_PICTURE")
    private byte[] picture;

    @ElementCollection
    @CollectionTable(name = "forum_users", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> subscribedUserIds = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forum")
    private Set<ForumPost> forumPosts = new HashSet<>();

    public Forum(String forumName, String description, long forumAdminId, byte[] picture) {
        this.forumName = forumName;
        this.description = description;
        this.forumAdminId = forumAdminId;
        this.picture = picture;
    }

    public Forum(String forumName, String description, long forumAdminId) {
        this.forumName = forumName;
        this.description = description;
        this.forumAdminId = forumAdminId;
    }
}

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

    @Column(nullable = false, unique = true, length = 50)
    private String forumName;

    @Column(nullable = false, unique = true, length = 50)
    private String description;

    @Column(nullable = false)
    private Date creationDate;

    @Column(nullable = false)
    private long forumAdminId;

    //not sure if this works
    @Lob
    @Column(name="POST_PICTURE")
    private byte[] profilePic;

    @ElementCollection
    @CollectionTable(name = "forum_users", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> subscribedUsers = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forum")
    private Set<ForumPost> comments = new HashSet<>();

    public Forum(String forumName, String description, long forumAdminId, byte[] profilePic) {
        this.forumName = forumName;
        this.description = description;
        this.forumAdminId = forumAdminId;
        this.profilePic = profilePic;
    }
}

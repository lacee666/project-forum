package com.forum.forum.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "FORUM")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIdentityInfo( scope = Forum.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Forum extends BaseEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String forumName;

    @Column(nullable = false, unique = true, length = 100)
    private String description;

    @Column(nullable = false)
    private String creationDate;

    @Column(nullable = false)
    private long forumAdminId;

    //not sure if this works
    @Lob
    @Column(name="FORUM_PICTURE")
    private byte[] picture;



    @ElementCollection
    @CollectionTable(name = "forum_users", joinColumns = @JoinColumn(name = "iduser"))
    private Set<Long> subscribedUserIds = new HashSet<>();



    @JsonIgnore
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
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(ForumPost f: forumPosts){
            sb.append(f.getTitle() + ", ");
        }
        return "[" + forumName + ", " + description + ", " + creationDate + ", " + forumAdminId + ", forumPost titles: " + sb.toString() + "]";
    }
}

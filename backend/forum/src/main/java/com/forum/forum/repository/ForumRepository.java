package com.forum.forum.repository;


import com.forum.forum.model.Forum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ForumRepository extends CrudRepository<Forum, Long> {
    Forum findById(long id);
    //Forum findByForumName(String forumname);
    Iterable<Forum> findAll();
    /*
    @Query("SELECT * FROM ((SELECT id FROM FORUM where id = forumId) join FORUMPOST where forum.postId = postId)")
    ForumPost findByForumPost(@Param("forumId")long forumId, @Param("postId")long postId);
    */

}

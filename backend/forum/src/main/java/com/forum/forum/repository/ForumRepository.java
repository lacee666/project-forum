package com.forum.forum.repository;


import com.forum.forum.model.Forum;
import com.forum.forum.model.ForumPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {
    Forum findById(long id);
    Forum findByForumName(String forumName);
/*
    @Query("SELECT * FROM ((SELECT id FROM FORUM where id = forumId) join FORUMPOST where forum.postId = postId)")
    ForumPost findByForumPost(@Param("forumId")long forumId, @Param("postId")long postId);
    */

}

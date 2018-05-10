package com.forum.forum.repository;


import com.forum.forum.model.Forum;
import com.forum.forum.model.ForumPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumPostRepository extends CrudRepository<ForumPost, Long> {
    Iterable<ForumPost> findAll();
}
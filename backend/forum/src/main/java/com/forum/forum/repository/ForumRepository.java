package com.forum.forum.repository;


import com.forum.forum.model.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {
    Forum findById(long id);
}

package com.forum.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.forum.model.*;
import com.forum.forum.repository.*;


import java.util.Date;

@Service
public class ForumService {
    @Autowired
    private ForumRepository forumRepository;

    private User user;

    public Forum create(String name, String description, byte[] picture, long adminId) {
        Forum forum = new Forum(name, description, adminId, picture);
        forum.setCreationDate(new Date().toString());
        forumRepository.save(forum);
        System.out.println("Forum created.");
        return forum;
    }
    public String getForum(long id){
        return forumRepository.findById(id).getForumName();
    }
}
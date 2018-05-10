package com.forum.forum.service;

import com.forum.forum.service.exception.ForumNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.forum.model.*;
import com.forum.forum.repository.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ForumService {
    @Autowired
    private ForumRepository forumRepository;

    private User user;

    //String name, String description, byte[] picture, long adminId
    public Forum create(Forum forum) throws ForumNotValidException {
        try {
            Forum newForum = new Forum(forum.getForumName(), forum.getDescription(), forum.getForumAdminId(), forum.getPicture());
            newForum.setCreationDate(new Date().toString());
            forumRepository.save(newForum);
            System.out.println("New Forum created.");
            return newForum;
        } catch (Exception e) {
            throw new ForumNotValidException();
        }
    }

    public List<Forum> getAllForums() throws ForumNotValidException {
        try {
            return (List<Forum>) forumRepository.findAll();
        } catch (Exception e) {
            System.out.println("rip");
            throw new ForumNotValidException();
        }
    }

    public Forum getForumByForumId(long id) throws ForumNotValidException {
        try {
            return null;
        } catch (Exception e) {
            throw new ForumNotValidException();
        }

    }

    public Forum getForumByForumName(String forumName) throws ForumNotValidException {
        try {
            Forum returnForum = forumRepository.findByForumName(forumName);
            System.out.println("Return forum: " + returnForum);
            return returnForum;
        } catch (Exception e) {
            throw new ForumNotValidException();
        }
    }

    public ForumPost getForumPost(long forumId, long postId) throws ForumNotValidException {
        try {
            return null;
            //return forumRepository.findByForumPost(forumId, postId);
        } catch (Exception e) {
            throw new ForumNotValidException();
        }
    }
}
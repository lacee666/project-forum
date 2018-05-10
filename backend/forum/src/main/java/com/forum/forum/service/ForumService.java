package com.forum.forum.service;

import com.forum.forum.service.exception.ForumNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.forum.model.*;
import com.forum.forum.repository.*;
import org.springframework.transaction.annotation.Transactional;


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
    public List<ForumPost> getAllForumPosts() throws ForumNotValidException {
        try {
            return (List<ForumPost>) forumPostRepository.findAll();
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

    @Autowired
    private ForumPostRepository forumPostRepository;

    public ForumPost addForumPost(ForumPost forumPost, long id) throws ForumNotValidException {
        try {

            forumPost.setCreationDate(new Date().toString());
            System.out.println("ForumPost: " + forumPost.toString());

            Forum forum = forumRepository.findById(id);
            System.out.println("OK Forum with: "+ id + ". id found: " + forum.toString());

            forumPost.setForum(forum);

            return forumPostRepository.save(forumPost);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error. ForumPost not added.");
            throw new ForumNotValidException();
        }
    }
}
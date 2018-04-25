package com.forum.forum.service;

import com.forum.forum.service.exception.ForumNotValidException;
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

    //String name, String description, byte[] picture, long adminId
    public Forum create(Forum forum) throws  ForumNotValidException {
        try{
            Forum newForum = new Forum(forum.getForumName(), forum.getDescription(), forum.getForumAdminId(), forum.getPicture());
            newForum.setCreationDate(new Date().toString());
            forumRepository.save(newForum);
            System.out.println("New Forum created.");
            return newForum;
        }catch (Exception e){
            throw  new ForumNotValidException();
        }
    }

    public Forum getForumByForumId(long id) throws ForumNotValidException {
        try{
            return forumRepository.findById(id);
        }catch (Exception e){
            throw new ForumNotValidException();
        }

    }
    public Forum getForumByForumName(String forumName)throws ForumNotValidException {
        try{
            return forumRepository.findByForumName(forumName);
        }catch (Exception e){
            throw new ForumNotValidException();
        }
    }

    public ForumPost getForumPost(long forumId, long postId) throws ForumNotValidException {
        try{
            return null;
           //return forumRepository.findByForumPost(forumId, postId);
        }catch (Exception e){
            throw new ForumNotValidException();
        }
    }
}
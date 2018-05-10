package com.forum.forum.api;

import com.forum.forum.model.Forum;
import com.forum.forum.model.ForumPost;
import com.forum.forum.service.ForumService;
import com.forum.forum.service.exception.ForumNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//for testing purposes
@CrossOrigin(origins = "*")
@RequestMapping("/api/f")
public class ForumApiController {

    @Autowired
    private ForumService forumService;


    @GetMapping("/all")
    public List<Forum> getAllForums() {
        try {
            System.out.println("Getting all forums...");
            return forumService.getAllForums();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @GetMapping("/allposts")
    public List<ForumPost> getAllForumPosts() {
        try {
            System.out.println("Getting all forumsposts...");
            return forumService.getAllForumPosts();
        } catch (Exception e) {
            return null;
        }
    }
    @GetMapping("{forumName}")
    public ResponseEntity<Forum> getForumByForumName(@PathVariable String forumName) {
        try {
            System.out.println("Getting forum back with name: " + forumName + ".");
            return ResponseEntity.ok(forumService.getForumByForumName(forumName));
        } catch (ForumNotValidException e) {
            System.out.println("Error occured while finding a forum named: " + forumName + ".");
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/{id}/addForumPost")
    public ResponseEntity<ForumPost> addForumPost(@RequestBody ForumPost forumPost, @PathVariable long id) {
        System.out.println("Adding forumpost...");
        try {
            return ResponseEntity.ok(forumService.addForumPost(forumPost, id));
        } catch (ForumNotValidException e) {
            System.out.println("error wtf forumpost");
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Forum> create(@RequestBody Forum forum) {
        System.out.println("Registering user...");
        try {
            return ResponseEntity.ok(forumService.create(forum));
        } catch (ForumNotValidException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //@Role({USER, ADMIN})
    @GetMapping("{id}/{postId}")
    public ResponseEntity<ForumPost> getForumByForumName(@PathVariable long id, @PathVariable long postId) {
        try {
            return ResponseEntity.ok(forumService.getForumPost(id, postId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

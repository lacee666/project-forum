package com.forum.forum.api;

import com.forum.forum.model.Forum;
import com.forum.forum.model.ForumPost;
import com.forum.forum.repository.ForumPostRepository;
import com.forum.forum.service.ForumService;
import com.forum.forum.model.User;
import com.forum.forum.service.exception.ForumNotValidException;
import com.forum.forum.service.exception.UserNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
//for testing purposes
@CrossOrigin(origins = "*")
@RequestMapping("/api/f")
public class ForumApiController {
    @Autowired
    private ForumService forumService;

    @Autowired
    private ForumPostRepository userRepository;


    @GetMapping("/all")
    public List<Forum> getAllForums(){
        try{
            System.out.println("ok");
            return forumService.getAllForums();
        }catch(Exception e){
            System.out.println("F");
            ArrayList<Forum> f = new ArrayList<Forum>();
            f.add(new Forum("asd", "asd", 1));
            f.add(new Forum("asd", "asd", 1));
            f.add(new Forum("asd", "asd", 1));
            return f;
        }
    }
    //@Role({USER, ADMIN})
    @GetMapping("{forumName}")
    public ResponseEntity<Forum> getForumByForumName(@PathVariable String forumName) {
        try {

            return ResponseEntity.ok(forumService.getForumByForumName(forumName));
        } catch (ForumNotValidException e) {

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

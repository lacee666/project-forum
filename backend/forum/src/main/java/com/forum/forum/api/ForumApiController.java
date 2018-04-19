package com.forum.forum.api;

import com.forum.forum.model.Forum;
import com.forum.forum.repository.ForumPostRepository;
import com.forum.forum.service.ForumService;
import com.forum.forum.model.User;
import com.forum.forum.service.exception.ForumNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
//for testing purposes
@CrossOrigin(origins = "*")
@RequestMapping("/api/forum")
public class ForumApiController {
    /*@Autowired
    private ForumService forumService;

    @Autowired
    private ForumPostRepository userRepository;


    @GetMapping("/{id}")
    public String getForum(@PathVariable long id) {
        return forumService.getForum(id);
    }


    @PostMapping("/create")
    public ResponseEntity<Forum> createForum(@RequestBody Forum forum) {
        System.out.println("Creating a new forum...");
        try {
            return ResponseEntity.ok(forumService.create(forum.getForumName(), forum.getDescription(), forum.getProfilePic(), forum.getForumAdminId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }*/



}

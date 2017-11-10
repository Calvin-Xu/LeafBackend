package com.leafproject.proj;

import com.leafproject.proj.request.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping(path = "/comments")
public class MainController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path="/test")
    public String test () {
        return "";
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewComment (@RequestBody CommentRequest cr) {

        Comments n = new Comments();
        n.setName(cr.getName());
        n.setStars(cr.getStars());
        n.setBody(cr.getBody());
        n.setAuthor(cr.getAuthor());
        n.setTime(new Timestamp(System.currentTimeMillis()));
        commentRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Comments> getAllComments() {
        return commentRepository.findAll();
    }

    @GetMapping(path="/{name}")
    public @ResponseBody Iterable<Comments> getOne (@PathVariable String name) {
        return commentRepository.findByName(name);
    }
}

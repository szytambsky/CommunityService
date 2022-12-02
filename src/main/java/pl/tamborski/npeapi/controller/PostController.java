package pl.tamborski.npeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tamborski.npeapi.model.Post;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PostController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello wordl!";
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        throw new IllegalArgumentException("Not implemented yet!");
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable("id") long id) {
        throw new IllegalArgumentException("Not implemented yet!");
    }
}

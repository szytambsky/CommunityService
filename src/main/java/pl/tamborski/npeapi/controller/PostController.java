package pl.tamborski.npeapi.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tamborski.npeapi.model.Post;
import pl.tamborski.npeapi.service.PostService;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Api(tags = "Post Resource")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable("id") long id) {
        throw new IllegalArgumentException("Not implemented yet!");
    }
}

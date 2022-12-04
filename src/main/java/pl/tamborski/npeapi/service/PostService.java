package pl.tamborski.npeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.tamborski.npeapi.model.Post;
import pl.tamborski.npeapi.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts(int page) {
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }
}

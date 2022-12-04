package pl.tamborski.npeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.tamborski.npeapi.model.Comment;
import pl.tamborski.npeapi.model.Post;
import pl.tamborski.npeapi.repository.CommentRepository;
import pl.tamborski.npeapi.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public List<Post> getPosts(int page) {
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }

    public List<Post> getPostsWithComments(int page) {
        List<Post> allPosts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE));
        List<Long> postIds = allPosts.stream()
                .map(Post::getId)
                .toList();

        List<Comment> comments = commentRepository.findAllByPostIdIn(postIds);
        allPosts.forEach(post -> post.setComment(extractComments(comments, post.getId())));
        return allPosts;
    }

    private List<Comment> extractComments(List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }
}

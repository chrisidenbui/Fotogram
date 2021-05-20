package rmit.fotogram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.fotogram.model.Post;
import rmit.fotogram.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImplement implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImplement(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        Post post;
        Optional<Post> result = postRepository.findById(id);

        if (result.isPresent()) {
            post = result.get();
        }
        else {
            throw new RuntimeException("The post with id = " + id + " is not found!");
        }
        return post;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}

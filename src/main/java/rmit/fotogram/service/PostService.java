package rmit.fotogram.service;

import rmit.fotogram.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(Long id);
    void save(Post post);
    void deleteById(Long id);
}

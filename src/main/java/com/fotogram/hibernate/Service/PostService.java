package com.fotogram.hibernate.Service;

import com.fotogram.hibernate.Repository.PostRepository;
import com.fotogram.hibernate.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPost(){
        return this.postRepository.findAll();
    }

}

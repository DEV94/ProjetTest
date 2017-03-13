package com.polytech.business;

import com.polytech.repository.*;

import java.util.List;

/**
 * Created by dev on 3/13/17.
 */
public class PublicationService {
    private PostRepository postRepository;


    public PublicationService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public void post(Post post) {
        postRepository.save(post);
    }

    public List<Post> fetchAll(){
        return postRepository.findAll();
    }
}

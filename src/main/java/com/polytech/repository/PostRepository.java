package com.polytech.repository;

import com.polytech.business.Post;

import java.util.List;

/**
 * Created by dev on 3/13/17.
 */
public interface PostRepository {
    List<Post> findAll();

    void save(Post post);
}

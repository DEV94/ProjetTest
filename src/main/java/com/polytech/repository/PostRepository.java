package com.polytech.repository;

import com.polytech.business.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 3/13/17.
 */
public class PostRepository {
    private List<Post> db = new ArrayList<Post>();

    public List<Post> findAll() {
        return db;
    }

    public void save(Post post) {
        db.add(post);
    }
}

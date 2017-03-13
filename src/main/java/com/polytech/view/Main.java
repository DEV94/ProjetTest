package com.polytech.view;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import com.polytech.repository.PostRepository;

/**
 * Created by dev on 3/13/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("CouCou Polytech ");
        PostRepository postRepository = new PostRepository();
        PublicationService publicationService = new PublicationService(postRepository);

        Post post = new Post("Luminy");
        publicationService.post(post);
        System.out.println(publicationService.fetchAll());
    }
}

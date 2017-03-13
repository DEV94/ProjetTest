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
        Post post1 = new Post("Etoil");
        Post post2 = new Post("Test");
        publicationService.post(post);
        publicationService.post(post1);
        publicationService.post(post2);

        System.out.println(publicationService.fetchAll());
    }
}

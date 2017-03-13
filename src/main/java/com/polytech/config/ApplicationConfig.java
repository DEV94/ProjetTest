package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.repository.PostRepository;
import com.polytech.repository.PostRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dev on 3/13/17.
 */
@Configuration
public class ApplicationConfig {
    @Bean
    public PostRepository postRepository(){
        return new PostRepositoryImpl();
    }

    @Bean
    public PublicationService publicationService(PostRepository postRepository){
        return  new PublicationService(postRepository);
    }
}

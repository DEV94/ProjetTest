package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.repository.PostRepository;
import com.polytech.repository.JDBCPostRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by dev on 3/13/17.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("create-schema.sql").build();
    }

    @Bean
    public PostRepository postRepository(DataSource dataSource){
        return new JDBCPostRepository(dataSource);
    }

    @Bean
    public PublicationService publicationService(PostRepository postRepository){
        return  new PublicationService(postRepository);
    }
}

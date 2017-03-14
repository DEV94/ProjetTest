package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.repository.PostRepository;
import com.polytech.repository.JDBCPostRepository;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Created by dev on 3/13/17.
 */
@Configuration
@PropertySource("classpath:applicationContext.properties")
public class ApplicationConfig {

    @Autowired
    private Environment environment;

    /*@Value("datasource.driverClassName")
    private String driverClassName;
    @Value("datasource.url")
    private String url;
    @Value("datasource.userName")
    private String userName;
    @Value("datasource.password")
    private String password;*/


    @Bean
    public DataSource dataSource(){
        String driverClassName = environment.getProperty("datasource.driverClassName");
        String url = environment.getProperty("datasource.url");
        String userName = environment.getProperty("datasource.userName");
        String password = environment.getProperty("datasource.password");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    /*@Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("create-schema.sql").build();
    }*/

    @Bean
    public PostRepository postRepository(DataSource dataSource){
        return new JDBCPostRepository(dataSource);
    }

    @Bean
    public PublicationService publicationService(PostRepository postRepository){
        return  new PublicationService(postRepository);
    }
}

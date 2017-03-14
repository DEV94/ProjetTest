package com.polytech.repository;

import com.polytech.business.Post;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 3/13/17.
 */
public class JDBCPostRepository implements PostRepository {
    private DataSource dataSource;

    public JDBCPostRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Post> findAll() {
        List<Post> allPosts = new ArrayList<Post>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM POST");
            while (resultSet.next()){
                allPosts.add(new Post(resultSet.getString("CONTENT")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return allPosts;
    }

    public void save(Post post) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST (CONTENT) VALUES(?)");
            preparedStatement.setString(1,post.getContent());
            preparedStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

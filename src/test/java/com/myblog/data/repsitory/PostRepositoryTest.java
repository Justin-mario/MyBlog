package com.myblog.data.repsitory;

import com.myblog.data.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/insert_post.sql"})
class PostRepositoryTest {
    @Autowired
    PostRepository postRepositoryImpl;


    @BeforeEach
    void setUp() {
    }

    @Test
    void CreatePostTest(){
      Post  post = new Post ();
        post.setTitle ( "Welcome To My Blog" );
        post.setBody ( "Lets see if this works" );
        assertThat(post).isNotNull ();
        assertThat ( post .getId ()).isNull ();
        log.info ( "Post before saving --> {}", post );
        postRepositoryImpl.save ( post );
        assertThat ( post .getId ()).isNotNull ();
        log.info ( "Post After saving --> {}", post );
    }

    @Test
    @Transactional
    void findExistingPostByIdTest(){
        Post existingPost = postRepositoryImpl.findById ( 10L ).orElse ( null );
        assertThat ( existingPost ).isNotNull ();
        log.info ( "Post --> {}", existingPost );

    }

    @Test
    void deleteExistingPostByIdTest(){
        assertThat ( postRepositoryImpl.findById ( 10L ).orElse ( null ) ).isNotNull ();
        postRepositoryImpl.deleteById ( 10L );
        assertThat ( postRepositoryImpl.findById ( 10L ).orElse ( null ) ).isNull ();
    }

    @Test
    @Transactional
    void whenFindAllPostIsCalledAllPostIsReturnedTest(){
        List<Post> posts = postRepositoryImpl.findAll ();
        assertThat ( posts ).hasSize ( 2 );
        log.info ( "Post Returned From Database --> {}", posts );
    }

}
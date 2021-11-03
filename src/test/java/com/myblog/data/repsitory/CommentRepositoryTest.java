package com.myblog.data.repsitory;

import com.myblog.data.model.Comment;
import com.myblog.data.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepositoryImpl;

    @Test
    void CreateCommentTest(){
        Post post = new Post ();
        post.setTitle ( "Welcome To My Blog" );
        post.setBody ( "Lets see if this works" );
        assertThat(post).isNotNull ();
        assertThat ( post .getId ()).isNull ();
        log.info ( "Post before saving --> {}", post );
        postRepositoryImpl.save ( post );
        assertThat ( post .getId ()).isNotNull ();
        log.info ( "Post After saving --> {}", post );

    }

}

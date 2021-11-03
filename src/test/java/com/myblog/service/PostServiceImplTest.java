package com.myblog.service;

import com.myblog.data.repsitory.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = {"/db/insert_post.sql"})
@Slf4j
public class PostServiceImplTest {
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postServiceImpl;

//    @Test
//    void updatePostTest(){
//        Post post = postRepository.findById ( 10L ).orElse ( null );
//        log.info ( "Before assertions --> {}", post );
//        assertThat(post).isNotNull ();
//        assertThat ( post.getTitle () ).isEqualTo ( "first post" );
//        log.info ( "assertions --> {}", post );
//
//    }

}

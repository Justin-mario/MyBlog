package com.myblog.service;

import com.myblog.data.model.Post;
import com.myblog.data.repsitory.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.*;

@Slf4j
public class PostServiceImplMockTest {

    @Mock
    PostRepository postRepository;

    @InjectMocks
    PostService postServiceImpl;

    @BeforeEach
    void setUp(){
        postServiceImpl = new PostServiceImpl ();
        MockitoAnnotations.openMocks ( this );
    }

    @Test
    void savePostMockTest(){
        Post post = new Post ();
        when(postServiceImpl.addPost (post)).thenReturn ( post );
        postServiceImpl.addPost ( post );
        log.info ( "Post After Saving --> {}", post );
        verify ( postRepository, times ( 1 ) ).save ( post );
    }


}

package com.myblog.controller;

import com.myblog.data.model.Post;
import com.myblog.dto.request.UpdatePostRequest;
import com.myblog.exception.BlogException;
import com.myblog.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/post")
public class PostController {

        PostService postServiceImpl;

        @Autowired
        public PostController(PostService postServiceImpl){
            this.postServiceImpl = postServiceImpl;
        }

        @GetMapping("/")
        public List<Post> getAllPost(){
            return postServiceImpl.findAll ();
        }

        @PostMapping("/")
        public Post save(@RequestBody Post post){
            log.info ( "Post Request --> {}", post );
            return postServiceImpl.addPost ( post );
        }

        @DeleteMapping ("/{id}")
        public ResponseEntity<?> deleteById(@PathVariable Long id){
            postServiceImpl.delete ( id );
          return   ResponseEntity.noContent ().build ();
        }

        @GetMapping("/{id}")
        public Post findById(@PathVariable Long id){
            return postServiceImpl.findById ( id );
        }


    @PatchMapping("/")
    public ResponseEntity<?> updatePost(  @RequestBody UpdatePostRequest updatePost){
            Post post = null;
            try {
                post = postServiceImpl.update ( updatePost );
            }catch (BlogException ex){
                log.info ( ex.getMessage () );
                ResponseEntity.badRequest ().body ( ex.getMessage () );
            }
            return ResponseEntity.ok ().body ( post );

    }

}

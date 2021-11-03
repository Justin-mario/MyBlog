package com.myblog.service;

import com.myblog.data.model.Post;
import com.myblog.data.repsitory.PostRepository;
import com.myblog.dto.request.UpdatePostRequest;
import com.myblog.exception.BlogException;
import com.myblog.utilities.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostMapper postMapper;

    @Override
    public Post addPost(Post post) {
        return postRepository.save ( post );
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById ( id ).orElse ( null );
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById ( id );

    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll ();
    }

    @Override
    public Post update(UpdatePostRequest updatePost) {
        Optional<Post> result = postRepository.findById ( updatePost.getId () );
        if (result.isEmpty ()) throw new BlogException ( "Post does not exist" );
            Post post = result.get ();
            postMapper.mapDtoToUpdatePostRequest ( updatePost, post );
            return postRepository.save ( post );
    }
}

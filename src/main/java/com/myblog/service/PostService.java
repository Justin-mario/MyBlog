package com.myblog.service;

import com.myblog.data.model.Post;
import com.myblog.dto.request.CreatePostRequest;
import com.myblog.dto.request.UpdatePostRequest;
import org.springframework.stereotype.Service;


import java.util.List;

public interface PostService {
    Post addPost(Post post);
    Post findById(Long id);
    void delete(Long id);
    List<Post> findAll();
    Post update(UpdatePostRequest postRequest);
}

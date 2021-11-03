package com.myblog.service;

import com.myblog.data.model.Comment;
import com.myblog.data.model.Post;
import com.myblog.data.repsitory.CommentRepository;
import com.myblog.data.repsitory.PostRepository;
import com.myblog.dto.request.AddCommentRequest;
import com.myblog.dto.response.CreatePostResponse;
import com.myblog.exception.BlogException;
import com.myblog.utilities.CommentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Slf4j
public class CommentServiceImpl implements CommentService{

    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentRepository commentRepository;

    @Override
    public CreatePostResponse addComment(AddCommentRequest addCommentRequest) {
        Optional<Post> post = postRepository.findById ( addCommentRequest.getPostId () );
        if (post.isEmpty ()) throw new BlogException ( "Post does not exist" );

        Comment comment =new Comment ();
          commentMapper.mapDtoToCommentRequest ( addCommentRequest, comment );
          log.info ( "Before saving Comment ---->{}", comment );
            Post updatedPost = post.get ();

        comment = commentRepository.save(comment);
        log.info ( "After saving Comment ---->{}", comment );
            updatedPost.getComment ().add ( comment );
          updatedPost =  postRepository.save (updatedPost);
        return commentMapper.map ( updatedPost);

    }

}

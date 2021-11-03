package com.myblog.controller;


import com.myblog.dto.request.AddCommentRequest;
import com.myblog.dto.response.CreatePostResponse;
import com.myblog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/comment")
public class CommentController {


    CommentService commentServiceImpl;
    @Autowired
    public CommentController(CommentService commentServiceImpl){
       this.commentServiceImpl = commentServiceImpl;
    }

    @PostMapping("/")
    public CreatePostResponse addComment(@RequestBody AddCommentRequest addCommentRequest){
        log.info ( "Adding Comment --> {}", addCommentRequest );
        return commentServiceImpl.addComment (addCommentRequest);
    }



}

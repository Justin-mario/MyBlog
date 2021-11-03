package com.myblog.service;

import com.myblog.dto.request.AddCommentRequest;
import com.myblog.dto.response.CreatePostResponse;

public interface CommentService {
    CreatePostResponse addComment(AddCommentRequest addCommentRequest);

}

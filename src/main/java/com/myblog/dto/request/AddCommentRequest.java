package com.myblog.dto.request;

import com.myblog.data.model.Comment;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class AddCommentRequest {
    private Long postId;
    private LocalDateTime time;
    private String commenter;
    private String comment;


}

package com.myblog.dto.response;

import com.myblog.data.model.Comment;
import com.myblog.data.model.Post;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class FindPostResponse {
    private String title;
    private String body;
    private LocalDateTime datePublished;
    private List<Comment> comments;

}

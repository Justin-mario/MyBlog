package com.myblog.dto.request;

import lombok.Data;


@Data
public class CreatePostRequest {
    private String title;
    private String body;

}

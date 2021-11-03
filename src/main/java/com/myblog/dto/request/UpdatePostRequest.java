package com.myblog.dto.request;

import lombok.Data;

@Data
public class UpdatePostRequest {
    private String title;
    private Long id;
}

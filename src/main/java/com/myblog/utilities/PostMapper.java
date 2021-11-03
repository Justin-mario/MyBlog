package com.myblog.utilities;

import com.myblog.data.model.Post;
import com.myblog.dto.request.CreatePostRequest;
import com.myblog.dto.request.UpdatePostRequest;
import com.myblog.dto.response.CreatePostResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapDtoToPostRequest(CreatePostRequest createPostRequest, @MappingTarget Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapDtoToPostResponse(CreatePostResponse createPostResponse, @MappingTarget Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapDtoToUpdatePostRequest(UpdatePostRequest updatePostRequest, @MappingTarget Post post);

}

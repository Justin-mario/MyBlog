package com.myblog.utilities;

import com.myblog.data.model.Comment;
import com.myblog.data.model.Post;
import com.myblog.dto.request.AddCommentRequest;
import com.myblog.dto.response.CreatePostResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapDtoToCommentRequest(AddCommentRequest addCommentRequest, @MappingTarget Comment comment);



    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CreatePostResponse map(Post post);

}

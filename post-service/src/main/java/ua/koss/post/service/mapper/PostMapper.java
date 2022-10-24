package ua.koss.post.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ua.koss.post.service.dto.PostDto;
import ua.koss.post.service.model.Post;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper( PostMapper.class );
    @Mapping(target="authorId", source = "author.id")
    Post postDtoToPost(PostDto postDto);
    PostDto postToPostDto(Post post);
}

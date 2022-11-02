package ua.koss.author.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ua.koss.author.entity.User;
import ua.koss.author.model.UserDto;

@Mapper(uses = AuthorMapper.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    @Mapping( target = "author", source = "author", qualifiedByName = "authorToAuthorDto")
    UserDto userToUserDto(User user);
}

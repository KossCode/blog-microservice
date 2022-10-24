package ua.koss.author.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.koss.author.entity.Author;
import ua.koss.author.model.AuthorDto;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper( AuthorMapper.class );
    AuthorDto authorToAuthorDto(Author author);
}

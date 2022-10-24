package ua.koss.author.util;

import ua.koss.author.entity.Author;
import ua.koss.author.model.AuthorDto;

public class TestDataStorage {
    public final static String HEALTH_CHECK_MESSAGE = "Controller is ready to do some stuff";
    public static class AuthorStorage {
        public static final Author AUTHOR_1 = Author.builder().id(1L).firstName("Alex").secondName("Broken").build();
        public static final Author AUTHOR_2 = Author.builder().id(2L).firstName("Tony").secondName("Stark").build();
    }
    public static class AuthorDtoStorage {
        public static final AuthorDto AUTHOR_DTO_1 = AuthorDto.builder().id(1L).firstName("Alex").secondName("Broken").build();
        public static final AuthorDto AUTHOR_DTO_2 = AuthorDto.builder().id(2L).firstName("Tony").secondName("Stark").build();
    }

}

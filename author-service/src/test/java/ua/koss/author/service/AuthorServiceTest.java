package ua.koss.author.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.koss.author.entity.Author;
import ua.koss.author.model.AuthorDto;
import ua.koss.author.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static ua.koss.author.util.TestDataStorage.AuthorDtoStorage.AUTHOR_DTO_1;
import static ua.koss.author.util.TestDataStorage.AuthorDtoStorage.AUTHOR_DTO_2;
import static ua.koss.author.util.TestDataStorage.AuthorStorage.AUTHOR_1;
import static ua.koss.author.util.TestDataStorage.AuthorStorage.AUTHOR_2;

@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;
    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    public void shouldReturnAuthorDtoWhenCreateOrUpdateAuthorAuthor() throws Exception {
        Author author = Author.builder()
                .firstName("Alex")
                .secondName("Broken")
                .build();

        when(authorRepository.save(author)).thenReturn(AUTHOR_1);
        AuthorDto actual = authorService.createOrUpdateAuthor(author);

        verify(authorRepository, times(1)).save(author);
        assertNotNull(actual);
        assertEquals(actual, AUTHOR_DTO_1);
    }

    @Test
    public void shouldReturnAuthorDtoWhenFindById() {
        final long AUTHOR_ID = 1L;

        when(authorRepository.findById(AUTHOR_ID)).thenReturn(Optional.of(AUTHOR_1));
        AuthorDto actual = authorService.findById(AUTHOR_ID);

        verify(authorRepository, times(1)).findById(AUTHOR_ID);
        assertNotNull(actual);
        assertEquals(actual, AUTHOR_DTO_1);
    }

    @Test
    public void shouldReturnAuthorDtoListWhenFindAll() {

        List<AuthorDto> expected = List.of(AUTHOR_DTO_1, AUTHOR_DTO_2);
        List<Author> authors = List.of(AUTHOR_1, AUTHOR_2);

        when(authorRepository.findAll()).thenReturn(authors);
        List<AuthorDto> actual = authorService.findAll();

        verify(authorRepository, times(1)).findAll();
        assertNotNull(actual);
        assertEquals(actual.size(), 2);
        assertEquals(actual, expected);
    }
}

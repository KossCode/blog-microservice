package ua.koss.author.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ua.koss.author.model.AuthorDto;
import ua.koss.author.service.AuthorService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static ua.koss.author.util.TestDataStorage.AuthorDtoStorage.AUTHOR_DTO_1;
import static ua.koss.author.util.TestDataStorage.AuthorStorage.AUTHOR_1;

@RunWith(MockitoJUnitRunner.class)
public class AuthorControllerTest {

    @Mock
    private AuthorService authorService;
    @InjectMocks
    private AuthorController authorController;

    @Test
    public void index() {
        assertThat(authorController).isNotNull();
    }

    @Test
    public void shouldReturnResponseEntityAuthorDtoWhenCreateAuthor()
    {
        when(authorService.createOrUpdateAuthor(AUTHOR_1)).thenReturn(AUTHOR_DTO_1);
        ResponseEntity<AuthorDto> endpointResponse = authorController.createAuthor(AUTHOR_1);

        assertThat(endpointResponse).isNotNull();
        assertThat(endpointResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(endpointResponse.getBody()).isEqualTo(AUTHOR_DTO_1);
    }

}

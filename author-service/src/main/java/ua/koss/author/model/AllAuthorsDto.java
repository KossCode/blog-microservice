package ua.koss.author.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class AllAuthorsDto {
    private int quantity;
    private List<AuthorDto> authorsList;
}

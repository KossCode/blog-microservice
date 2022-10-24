package ua.koss.gateway.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Author {
    private Long id;
    private String firstname;
    private String secondName;
}

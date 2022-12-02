package pl.tamborski.npeapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {

    @Id
    private long id;
    private String title;
    private String content;
    private LocalDateTime created;
}

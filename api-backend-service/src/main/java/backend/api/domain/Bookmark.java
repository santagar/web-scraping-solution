package backend.api.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Bookmark
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false)
    private String url;

    @Column(columnDefinition = "Text")
    private String title;

    @Column(nullable=false)
    private Date created;

    private String note;
}

package com.myblog.data.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private String comment;
    private String commenter;
    private LocalDateTime time = LocalDateTime.now ();


    @Override
    public int hashCode() {
        return getClass ().hashCode ();
    }

}

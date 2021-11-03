package com.myblog.data.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDateTime time = LocalDateTime.now ();
    private String body;
    @OneToMany(fetch=FetchType.EAGER)
    private List<Comment> comment = new ArrayList<> ();

    @Override
    public int hashCode() {
        return getClass ().hashCode ();
    }

}

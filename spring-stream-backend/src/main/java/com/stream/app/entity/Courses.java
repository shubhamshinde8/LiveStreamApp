package com.stream.app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Courses {

    @Id
    private String courseId;

    private String title;

//    @OneToMany(mappedBy = "course")
//    private List<Video> list=new ArrayList<>();

}

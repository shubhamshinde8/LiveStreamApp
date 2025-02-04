package com.stream_app.services;

import com.stream_app.entities.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VideoService {

    Video save(Video video, MultipartFile file);
    Video get(String videoId);
    Video getByTitle(String title);
    List<Video> getAll();

}

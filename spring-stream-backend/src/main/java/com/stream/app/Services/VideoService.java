package com.stream.app.Services;


import com.stream.app.entity.Video;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public interface VideoService {

    // save video

    Video save(Video video, MultipartFile file);

    // get video

    Video get(String id);

    // get video by title

    Optional<Video> getVideoByTitle(String title);

    List<Video> getAllVideo();



}

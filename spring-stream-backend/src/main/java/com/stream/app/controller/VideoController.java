package com.stream.app.controller;


import com.stream.app.Services.VideoService;
import com.stream.app.Services.implementation.VideoServiceImpl;
import com.stream.app.entity.Video;
import com.stream.app.playload.CustomeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin
public class VideoController {

    @Autowired
    private VideoService videoService;

    public VideoController(VideoService videoService){
        this.videoService=videoService;
    }

    @PostMapping("/video")
    public ResponseEntity<?> create(
            @RequestParam("file")MultipartFile file,
            @RequestParam("title")String title,
            @RequestParam("description")String description
    )
    {
        Video video=new Video();
        video.setTitle(title);
        video.setDescription(description);
        video.setVideoId(UUID.randomUUID().toString());

        System.out.println(file.getSize());
        System.out.println(file.getName());
        System.out.println(file.getContentType());

        Video savedVideo=videoService.save(video,file);

        if (savedVideo!=null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(video);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/video")
    public ResponseEntity<List<Video>> getAllVideo(){

       List<Video> video=this.videoService.getAllVideo();

       if (video.isEmpty()){
           return ResponseEntity.noContent().build();
       }
       return ResponseEntity.ok(video);
    }
}


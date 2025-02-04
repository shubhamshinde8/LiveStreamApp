package com.stream_app.services.impl;

import com.stream_app.entities.Video;
import com.stream_app.repositoris.VideoRepository;
import com.stream_app.services.VideoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Value("${files.video}")
    String DIR;

    @Autowired
    private VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @PostConstruct
    public void init(){
        File file=new File(DIR);

        if (!file.exists()){
            file.mkdir();
            System.out.println("Folder created ");
        }else{
            System.out.println("Folder already created ");
        }
    }


    @Override
    public Video save(Video video, MultipartFile file) {

        try{
            String fileName=file.getOriginalFilename();
            String contentType=file.getContentType();
            InputStream inputStream=file.getInputStream();


            String cleanFileName=StringUtils.cleanPath(fileName);
            String cleanFolder=StringUtils.cleanPath(DIR);

            Path path=Paths.get(cleanFolder,cleanFileName);
            System.out.println(path);

            Files.copy(inputStream,path, StandardCopyOption.REPLACE_EXISTING);

            video.setContentType(contentType);
            video.setFilePath(path.toString());


            return videoRepository.save(video);

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Video get(String videoId) {
        return null;
    }

    @Override
    public Video getByTitle(String title) {
        return null;
    }

    @Override
    public List<Video> getAll() {
        return null;
    }
}

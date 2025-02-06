package com.stream.app.Services.implementation;

import com.stream.app.Services.VideoService;
import com.stream.app.entity.Video;
import com.stream.app.repositories.VideoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;


@Service
public class VideoServiceImpl implements VideoService {


    @Autowired
    private VideoRepository videoRepository;

    @Value("${files.video}")
    String dir;

    @PostConstruct
    public void init(){
        File file=new File(dir);

        if (!file.exists()){
            file.mkdir();
            System.out.println("Folder created ");
        }else {
            System.out.println("Folder already created..");
        }
    }

    @Override
    public Video save(Video video, MultipartFile file) {


        try {

            // file name

            String name = file.getOriginalFilename();

            String contentType = file.getContentType();

            InputStream is=file.getInputStream();

            // folder path

            String cleanFile = StringUtils.cleanPath(name);
            String cleanFolder = StringUtils.cleanPath(dir);

            Path path=Paths.get(cleanFolder,cleanFile);
            System.out.println(path);

            Files.copy(is,path, StandardCopyOption.REPLACE_EXISTING);

            // video metadata

            video.setContentType(contentType);
            video.setFilePath(path.toString());

            return videoRepository.save(video);


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Video get(String id) {
        Video video=this.videoRepository.findVideoByVideoId(id);
        return video;
    }


    @Override
    public Optional<Video> getVideoByTitle(String title) {

        Optional<Video> video=this.videoRepository.findVideoByTitle(title);
        return video;
    }

    @Override
    public List<Video> getAllVideo() {
        List<Video> list=this.videoRepository.findAll();
        return list;
    }
}

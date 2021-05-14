package com.imagga.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @CrossOrigin
    @GetMapping(value = "/")
    public String home() {
        return "ROUTES : / " +
                "face / " +
                "tag / " +
                "upload_img= \"NOM DE VOTRE FICHIER\"";
    }

    @CrossOrigin
    @GetMapping(value = "/face")
    public String face() throws IOException {
        return Get_faces_by_url
                .Face_url();
    }

    @CrossOrigin
    @GetMapping(value = "/tag")
    public String tags() throws IOException {
        return Get_tags_by_url
                .tag_url();
    }

    @CrossOrigin
    @RequestMapping(path = "/upload_img_cat={path}/{option}")
    public String send_img(@PathVariable("path") String path, @PathVariable("option") String option) throws IOException {
        return Upload_image
                .sendImg(path, option);
    }

}

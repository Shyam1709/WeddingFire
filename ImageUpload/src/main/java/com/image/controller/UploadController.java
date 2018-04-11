package com.image.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {
	
	 @RequestMapping("/test")
	    public String index() {
	        return "index";
	    }
	
	@PostMapping("/file/upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		String uploadPath = "src/main/resources/images/";
		File path = new File(uploadPath);
		if (!path.exists())
			path.mkdirs();
		System.out.println(uploadPath);
		try {
			Files.copy(file.getInputStream(), Paths.get(uploadPath, file.getOriginalFilename()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";

	}
    @RequestMapping(value = "/tns", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage() throws IOException {

        ClassPathResource imgFile = new ClassPathResource("images/test.jpeg");

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }
}

package com.sistema.inmobiliaria.inmo.rest;

import com.sistema.inmobiliaria.inmo.core.file.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        fileStorageService.store(file);
        return "Upload successful";
    }

}
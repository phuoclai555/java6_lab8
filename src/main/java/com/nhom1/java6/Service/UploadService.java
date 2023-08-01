package com.nhom1.java6.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UploadService {
   File save(MultipartFile file, String folder) ;

}

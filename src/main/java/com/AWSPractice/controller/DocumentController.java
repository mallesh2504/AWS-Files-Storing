package com.AWSPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.AWSPractice.dto.DocumentResponseDto;
import com.AWSPractice.service.DocumentService;

@RestController
@RequestMapping("/documents")

public class DocumentController {

	@Autowired
    private  DocumentService docService;

    @PostMapping("/upload")
    public ResponseEntity<DocumentResponseDto> uploadDocument(@RequestParam("file") MultipartFile file) throws Exception {
        DocumentResponseDto response = docService.uploadDocument(file);
        return ResponseEntity.ok(response);
    }
}


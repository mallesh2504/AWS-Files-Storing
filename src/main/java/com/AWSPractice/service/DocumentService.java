package com.AWSPractice.service;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.AWSPractice.dto.DocumentResponseDto;
import com.AWSPractice.entity.DocumentEntity;
import com.AWSPractice.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
    private  DocumentRepository documentRepository;
	
	@Autowired
    private  S3Service s3Service;

    public DocumentResponseDto uploadDocument(MultipartFile file) throws IOException {
        String s3Url = s3Service.uploadFile(file);

        DocumentEntity entity = DocumentEntity.builder()
                .fileName(file.getOriginalFilename())
                .fileType(file.getContentType())
                .fileSize(file.getSize())
                .s3Url(s3Url)
                .uploadedAt(LocalDateTime.now())
                .build();

        DocumentEntity saved = documentRepository.save(entity);

        return DocumentResponseDto.builder()
                .id(saved.getId())
                .fileName(saved.getFileName())
                .fileType(saved.getFileType())
                .fileSize(saved.getFileSize())
                .s3Url(saved.getS3Url())
                .build();
    }
}

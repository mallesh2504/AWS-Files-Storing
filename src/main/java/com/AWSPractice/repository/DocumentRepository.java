package com.AWSPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AWSPractice.entity.DocumentEntity;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
}


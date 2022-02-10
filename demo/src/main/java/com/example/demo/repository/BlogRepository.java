package com.example.demo.repository;

import com.example.demo.domain.entity.BlogPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogPostEntity,Integer> {
    BlogPostEntity findByTitle(String title);
}

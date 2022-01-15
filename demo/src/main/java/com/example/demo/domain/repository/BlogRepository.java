package com.example.demo.domain.repository;

import com.example.demo.domain.entity.BlogPostEntity;
import com.example.demo.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogPostEntity,Integer> {
    BlogPostEntity findByTitle(String title);
}

package com.pruebas.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebas.springboot.jpa.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	

}

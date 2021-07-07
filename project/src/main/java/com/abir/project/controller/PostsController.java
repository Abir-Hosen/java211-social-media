package com.abir.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abir.project.modal.Posts;
import com.abir.project.service.PostsService;


@RestController
@RequestMapping("/api/posts")
public class PostsController {
	
	@Autowired
	private PostsService postsService;
	
	@PostMapping
	Posts createPosts(@RequestBody Posts posts) {
		return postsService.save(posts);
	}
	
	@GetMapping("{id}")
	List<Posts> findByUser(@PathVariable Long id) {
		return postsService.findByUser(id);
	}
	
	@GetMapping("public/{id}")
	List<Posts> findByUserAndAllPublic(@PathVariable Long id) {
		return postsService.findAllPublic(id);
	}
}

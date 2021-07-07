package com.abir.project.service;

import java.util.List;

import com.abir.project.modal.Posts;

public interface PostsService {
	
	public Posts save(Posts post);
	public Posts findById(Long id);
	public List<Posts> findByUser(Long id);
	public List<Posts> findAllPublic(Long id);

}

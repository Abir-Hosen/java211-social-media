package com.abir.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abir.project.modal.Posts;
import com.abir.project.repository.PostsRepository;
import com.abir.project.service.PostsService;


@Service("postsService")
public class PostsServiceImpl implements PostsService {
	
	@Autowired
	PostsRepository postsRepository;

	@Override
	public Posts save(Posts post) {
		return postsRepository.save(post);
	}

	@Override
	public List<Posts> findByUser(Long id) {
		return postsRepository.findByUserId(id);
	}

	@Override
	public List<Posts> findAllPublic(Long id) {
		return postsRepository.findByUserIdAndPublic(id);
	}

}

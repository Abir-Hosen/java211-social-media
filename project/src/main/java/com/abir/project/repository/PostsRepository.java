package com.abir.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abir.project.modal.Posts;

@Repository("postsRepository")
public interface PostsRepository extends JpaRepository<Posts, Long> {

	@Query("select p from Posts p where p.isPublicPost=true OR p.user=?1 ")
	List<Posts> findByUserIdAndPublic(Long id);
	List<Posts> findByUserId(Long id);

}

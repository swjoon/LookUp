package app.lookup.lookup.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.lookup.lookup.domain.post.entity.Post;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
}

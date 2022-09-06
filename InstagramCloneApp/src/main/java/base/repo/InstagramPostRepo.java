package base.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.InstagramPost;

public interface InstagramPostRepo extends JpaRepository<InstagramPost, Integer> {

}

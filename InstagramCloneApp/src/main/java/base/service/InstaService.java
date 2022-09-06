package base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.InstagramPost;
import base.repo.InstagramPostRepo;

@Service
public class InstaService {

	@Autowired
	private InstagramPostRepo instaRepo;

	public List<InstagramPost> findAllInstaPosts() {
		return instaRepo.findAll();
	}

	public InstagramPost savePost(InstagramPost instaPost) {
		return instaRepo.save(instaPost);
	}

}

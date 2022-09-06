package base.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import base.entity.InstagramPost;
import base.service.InstaService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class InstaController {
	@Autowired
	private InstaService instaService;

	@GetMapping("/instaPosts")
	public ResponseEntity<List<InstagramPost>> findAllPosts() {
		List<InstagramPost> postsList = instaService.findAllInstaPosts();

		Collections.sort(postsList, new Comparator<InstagramPost>() {
			public int compare(InstagramPost o1, InstagramPost o2) {
				return o2.getCreatedDate().compareTo(o1.getCreatedDate());
				
			};
		});
		
		return new ResponseEntity<>(postsList, HttpStatus.OK);

	}
	
	@PostMapping("/savePost")
	public ResponseEntity<String> savePost(@RequestBody InstagramPost instaPost) {
		InstagramPost post=instaService.savePost(instaPost);
		
		if(post!=null && post.getPostId()!=null)
			return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("FAILURE", HttpStatus.OK);
	}
}

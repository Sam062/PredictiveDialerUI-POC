package base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import base.entity.TestDetails;
import base.service.TestService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TestsController {

	@Autowired
	private TestService testService;

	@GetMapping("/getAllTestDetails")
	public ResponseEntity<List<TestDetails>> findAllTestDetails() {
		List<TestDetails> testDetailsList = testService.findAllTestDetails();

		return new ResponseEntity<List<TestDetails>>(testDetailsList, HttpStatus.OK);

	}

	@PostMapping("/saveOrUpdateTestDetails")
	public ResponseEntity<TestDetails> saveOrUpdateTestDetails(@RequestBody TestDetails testDetails) {
		TestDetails savedData = null;
		try {
			savedData = testService.saveOrUpdateTestDetails(testDetails);

			return new ResponseEntity<TestDetails>(savedData, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<TestDetails>(savedData, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteTestDetails/{testId}")
	public ResponseEntity<String> deleteTestDetails(@PathVariable("testId") Integer testId) {
		try {
			Boolean isDeleted = testService.deleteTestDetails(testId);
			if (isDeleted) {
				return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No Data Found for the specified ID", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Deleted Failed", HttpStatus.BAD_REQUEST);
		}

	}

}

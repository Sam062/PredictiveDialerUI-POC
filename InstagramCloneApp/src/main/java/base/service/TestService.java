package base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.TestDetails;
import base.repo.TestRepo;

@Service
public class TestService {
	@Autowired
	private TestRepo testRepo;

	public TestDetails saveOrUpdateTestDetails(TestDetails testDetails) {
		return testRepo.save(testDetails);
	}

	public List<TestDetails> findAllTestDetails() {
		return testRepo.findAll();
	}

	public Boolean deleteTestDetails(Integer id) {
		Optional<TestDetails> testDetails = testRepo.findById(id);

		if (testDetails.isPresent()) {
			testRepo.delete(testDetails.get());
			return true;
		} else
			return false;
	}

}

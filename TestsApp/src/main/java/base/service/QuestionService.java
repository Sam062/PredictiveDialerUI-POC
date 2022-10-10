package base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.quiz.QuestionEntity;
import base.entity.quiz.QuestionOptions;
import base.entity.quiz.TestAssignmentEntity;
import base.entity.quiz.TestSetEntity;
import base.repo.QuestionOptionsRepo;
import base.repo.QuestionsRepo;
import base.repo.TestAssignmentRepo;
import base.repo.TestSetRepo;

@Service
public class QuestionService {

	@Autowired
	private TestAssignmentRepo testAssignmentRepo;

	@Autowired
	private TestSetRepo testSetRepo;

	@Autowired
	private QuestionsRepo quesRepo;

	@Autowired
	private QuestionOptionsRepo quesOptionRepo;

	public TestAssignmentEntity saveOrUpdateTestAssignment(TestAssignmentEntity testAssignment) {
		return testAssignmentRepo.save(testAssignment);
	}

	public TestSetEntity saveOrUpdateTestSet(TestSetEntity testSet) {
		return testSetRepo.save(testSet);
	}

	public QuestionEntity saveOrUpdateQuestion(QuestionEntity question) {
		return quesRepo.save(question);
	}

	public QuestionOptions saveOrUpdateQuestionOption(QuestionOptions options) {
		return quesOptionRepo.save(options);
	}

	public Integer validateCandidateDetails(String email, String code) {
		return testAssignmentRepo.validateCandidateDetails(email, code);
	}

	public List<TestAssignmentEntity> findByEmailAndCode(String email, String code) {
		return testAssignmentRepo.findByEmailAndSecretCode(email, code);
	}

	public List<String[]> findAllTestDetails(String email, String code) {
		return testAssignmentRepo.findAllDetails(email, code);
	}
}

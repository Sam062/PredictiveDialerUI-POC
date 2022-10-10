package base.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import base.entity.quiz.QuestionEntity;
import base.entity.quiz.QuestionOptions;
import base.entity.quiz.TestAssignmentEntity;
import base.entity.quiz.TestSetEntity;
import base.model.Options;
import base.model.QuestionModel;
import base.model.TestAssignmentModel;
import base.model.TestSetModel;
import base.service.QuestionService;

@RestController
@RequestMapping("/questions")
@CrossOrigin(value = "http://localhost:3000")
public class QuestionsController {

	@Autowired
	private QuestionService questionService;

	@PostMapping("/isValidCandidate")
	public ResponseEntity<Integer> validateCandidateDetails(@RequestBody TestAssignmentEntity testAssignmentEntity) {
		if (testAssignmentEntity != null) {
			Integer validateStatus = questionService.validateCandidateDetails(testAssignmentEntity.getEmail(),
					testAssignmentEntity.getSecretCode());

			System.out.println("validateStatus --->>> " + validateStatus);
			return new ResponseEntity<>(validateStatus, HttpStatus.OK);
		}
		return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getAllQuestions/{email}/{code}")
	public ResponseEntity<TestAssignmentModel> getAllTestData(@PathVariable("email") String email,
			@PathVariable("code") String code) throws JsonProcessingException {
		System.out.println("email == >" + email);
		System.out.println("email == >" + code);

		TestAssignmentModel testAssignmentModel = null;

		if (email != null && code != null && !email.isEmpty() && !code.isEmpty()) {
			List<String[]> obj = questionService.findAllTestDetails(email, code);
			System.out.println("obj ->> " + obj);

			if (obj != null & obj.size() > 0)
				testAssignmentModel = formatQuestionList(obj);

		}

		if (testAssignmentModel != null && testAssignmentModel.getTestSet() != null
				&& testAssignmentModel.getTestSet().size() > 0)
			return new ResponseEntity<>(testAssignmentModel, HttpStatus.OK);
		else
			return new ResponseEntity<>(new TestAssignmentModel(), HttpStatus.BAD_REQUEST);
	}

	private TestAssignmentModel formatQuestionList(List<String[]> obj) {
		TestAssignmentModel testAssignmentModel = new TestAssignmentModel();
		testAssignmentModel.setAssessmentId(obj.get(0)[0]);
		testAssignmentModel.setCandidateName(obj.get(0)[1]);
		testAssignmentModel.setDuration(obj.get(0)[2]);
		testAssignmentModel.setEmail(obj.get(0)[3]);
		testAssignmentModel.setCode(obj.get(0)[4]);
		testAssignmentModel.setStartTime(obj.get(0)[5]);

		TestSetModel testSet = new TestSetModel();
		testSet.setTestSetId(obj.get(0)[6]);
		testSet.setTestSetName(obj.get(0)[7]);

		LinkedList<TestSetModel> tsll = new LinkedList<>();
		LinkedList<QuestionModel> qmll = new LinkedList<>();
		LinkedList<String> questionIdList = new LinkedList<>();
		obj.stream().forEach(rs -> {
//			System.out.println("==========================");
//			System.out.println("RS ++++ >" + rs[8]);
//			System.out.println("RS ++++ >" + rs[9]);
//			System.out.println("RS ++++ >" + rs[10]);
//			System.out.println("RS ++++ >" + rs[11]);
//			System.out.println("RS ++++ >" + rs[12]);
//			System.out.println("RS ++++ >" + rs[13]);
//			System.out.println("RS ++++ >" + rs[14]);
//			System.out.println("RS ++++ >" + rs[15]);
//			System.out.println("RS ++++ >" + rs[16]);
//			System.out.println("RS ++++ >" + rs[17]);
//			System.out.println("RS ++++ >" + rs[18]);
//			System.out.println("==========================");

			if (questionIdList.contains(rs[9])) {
				qmll.forEach(q -> {
					if (q.getQid().equals(rs[9])) {
						Options options = q.getOptions();
						List<String> option = options.getOption();
						option.add(rs[17]);
					}
				});
			} else {
				QuestionModel qm = new QuestionModel();
				qm.setQid(rs[9]);
				qm.setCorrectAnswer(rs[10]);
				qm.setMarks(rs[11]);
				qm.setQuestionCategory(rs[12]);
				qm.setQuestionStatement(rs[13]);
				qm.setQuestionType(rs[14]);

				Options option = new Options();
				LinkedList<String> options = new LinkedList<>();
				options.add(rs[17]);
				option.setOptionId(rs[16]);
				option.setOption(options);

				qm.setOptions(option);
//				System.out.println("Question model added -> " + qm);

				questionIdList.add(rs[9]);
				qmll.add(qm);
				testSet.setQuestionList(qmll);
			}

		});
		tsll.add(testSet);
		testAssignmentModel.setTestSet(tsll);

		return testAssignmentModel;

	}

	@PostMapping("/saveOrUpdateTestAssignment")
	public ResponseEntity<TestAssignmentEntity> saveOrUpdateTestAssignment(
			@RequestBody TestAssignmentEntity testAssignment) {
		TestAssignmentEntity saveStatus = questionService.saveOrUpdateTestAssignment(testAssignment);
		if (saveStatus != null)
			return new ResponseEntity<>(saveStatus, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(saveStatus, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/saveOrUpdateTestSet")
	public ResponseEntity<TestSetEntity> saveOrUpdateTestSet(@RequestBody TestSetEntity testSet) {
		TestSetEntity saveStatus = questionService.saveOrUpdateTestSet(testSet);
		if (saveStatus != null)
			return new ResponseEntity<>(saveStatus, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(saveStatus, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/saveOrUpdateQuestion")
	public ResponseEntity<QuestionEntity> saveOrUpdateQuestion(@RequestBody QuestionEntity question) {
		QuestionEntity saveStatus = questionService.saveOrUpdateQuestion(question);
		if (saveStatus != null)
			return new ResponseEntity<>(saveStatus, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(saveStatus, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/saveOrUpdateQuestionOption")
	public ResponseEntity<QuestionOptions> saveOrUpdateQuestionOption(@RequestBody QuestionOptions option) {
		QuestionOptions saveStatus = questionService.saveOrUpdateQuestionOption(option);
		if (saveStatus != null)
			return new ResponseEntity<>(saveStatus, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(saveStatus, HttpStatus.BAD_REQUEST);
	}

}

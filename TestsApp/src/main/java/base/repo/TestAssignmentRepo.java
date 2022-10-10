package base.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import base.entity.quiz.TestAssignmentEntity;

public interface TestAssignmentRepo extends JpaRepository<TestAssignmentEntity, Integer> {

	@Query(nativeQuery = true, value = "select count(*) from test_assignment where email=:email and secret_code=:secret_code")
	public Integer validateCandidateDetails(String email, String secret_code);

	@Query(nativeQuery = true, value = "select ta.assignment_id, ta.candidate_name, ta.duration, ta.email, ta.secret_code, ta.start_time, "
			+ "ts.test_Set_Id, ts.test_set_name, ts.assignment_id as aid_fk, "
			+ "qd.qid, qd.correct_answer, qd.marks, qd.question_category, qd.question_statement, qd.question_type, qd.test_set_id as setId_fk, "
			+ "qo.option_id, qo.option_value, qo.question_id as qid_fk "
			+ "from test_assignment as ta, test_set as ts, question_data as qd, question_optn as qo "
			+ "where ta.email=:email and ta.secret_code=:code and ta.assignment_id= ts.assignment_id "
			+ "and ts.test_Set_Id= qd.test_Set_Id and qd.qid=qo.question_id")
	public List<String[]> findAllDetails(String email, String code);

	public List<TestAssignmentEntity> findByEmailAndSecretCode(String email, String secretCode);

}

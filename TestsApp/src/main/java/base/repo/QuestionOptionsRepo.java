package base.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.quiz.QuestionOptions;

public interface QuestionOptionsRepo extends JpaRepository<QuestionOptions, Integer> {

}

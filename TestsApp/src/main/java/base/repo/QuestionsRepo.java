package base.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.quiz.QuestionEntity;

public interface QuestionsRepo extends JpaRepository<QuestionEntity, Integer> {

}

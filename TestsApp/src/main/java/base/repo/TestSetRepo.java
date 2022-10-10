package base.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.quiz.TestSetEntity;

public interface TestSetRepo extends JpaRepository<TestSetEntity, Integer> {

}

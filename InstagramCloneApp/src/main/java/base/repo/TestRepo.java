package base.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.TestDetails;

public interface TestRepo extends JpaRepository<TestDetails, Integer>{

}

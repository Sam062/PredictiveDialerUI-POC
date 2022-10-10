package base.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.DialerDataEntity;

public interface DialerDataRepo extends JpaRepository<DialerDataEntity, Serializable> {
	
	public DialerDataEntity findByMobile1AndContactListId(String mobile1, Integer contactListId);

	public List<DialerDataEntity> findByContactListId(Integer contacListId);
	// Above is the same code without using Query
	// @Query(value = "FROM base.entity.DialerDataEntity where
	// contactListId=:contactListId")
	// public List<DialerDataEntity> findAllData(Integer contactListId);
}

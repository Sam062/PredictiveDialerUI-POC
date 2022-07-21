package base.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.DialerDataEntity;

public interface DialerDataRepo extends JpaRepository<DialerDataEntity, Serializable> {
}

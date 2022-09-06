package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.CampaignEntity;

public interface CampaignRepo extends JpaRepository<CampaignEntity, Integer> {

}

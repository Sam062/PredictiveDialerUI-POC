package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.CampaignSettingEntity;

public interface CampaignSettingRepo extends JpaRepository<CampaignSettingEntity, Integer> {

}

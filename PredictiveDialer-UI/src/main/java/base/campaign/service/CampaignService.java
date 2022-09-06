package base.campaign.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.CampaignEntity;
import base.entity.CampaignSettingEntity;
import base.repository.CampaignRepo;
import base.repository.CampaignSettingRepo;

@Service
public class CampaignService {

	@Autowired
	private CampaignRepo campRepo;

	@Autowired
	private CampaignSettingRepo campSettingsRepo;

	public List<CampaignEntity> getAllCampaigns() {
		return campRepo.findAll();
	}

	public CampaignEntity saveOrUpdateCampaign(CampaignEntity campaign) {
		return campRepo.save(campaign);
	}

	public boolean deleteCampaign(CampaignEntity camp) {
		try {
			campRepo.delete(camp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Optional<CampaignEntity> findCampaignById(Integer campaignId) {
		return campRepo.findById(campaignId);
	}

	public List<CampaignSettingEntity> getAllCampaignSettings() {
		return campSettingsRepo.findAll();
	}

	public CampaignSettingEntity saveOrUpdateCampaignSetting(CampaignSettingEntity campaign) {
		return campSettingsRepo.save(campaign);
	}

	public boolean deleteCampaignSetting(CampaignSettingEntity camp) {
		try {
			campSettingsRepo.delete(camp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Optional<CampaignSettingEntity> findCampaignSettingById(Integer campaignId) {
		return campSettingsRepo.findById(campaignId);
	}
}

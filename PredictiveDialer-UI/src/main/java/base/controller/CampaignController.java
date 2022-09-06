package base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import base.campaign.service.CampaignService;
import base.entity.CampaignEntity;
import base.entity.CampaignSettingEntity;
import base.util.DialerConstants;

@RestController
@RequestMapping("/campaign/")
public class CampaignController {

	@Autowired
	private CampaignService campaignService;

	@GetMapping("/getAllCampaigns")
	public ResponseEntity<List<CampaignEntity>> getAllCampaigns() {
		List<CampaignEntity> campList = campaignService.getAllCampaigns();
		System.out.println("getAllCampaigns() returning :: " + campList);

		if (campList != null)
			return new ResponseEntity<List<CampaignEntity>>(campList, HttpStatus.OK);
		else
			return new ResponseEntity<List<CampaignEntity>>(campList, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/saveOrUpdateCampaign")
	public ResponseEntity<String> saveOrUpdateCampaign(@RequestBody CampaignEntity camp) {
		if (camp != null) {
			CampaignEntity status = campaignService.saveOrUpdateCampaign(camp);
			if (status != null && status.getCampaignId() != null)
				return new ResponseEntity<String>(DialerConstants.SUCCESS, HttpStatus.CREATED);
			else
				return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.OK);
		}
		return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteCampaign/{campaignId}")
	public ResponseEntity<String> deleteCampaign(@PathVariable("campaignId") Integer campaignId) {
		if (campaignId != null) {
			boolean isDeleted = campaignService.findCampaignById(campaignId).map(campaignService::deleteCampaign).orElse(false);

			if (isDeleted)
				return new ResponseEntity<String>(DialerConstants.SUCCESS, HttpStatus.OK);
			else
				return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.OK);
		}
		return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getAllCampaignSettings")
	public ResponseEntity<List<CampaignSettingEntity>> getAllCampaignSettings() {
		List<CampaignSettingEntity> campList = campaignService.getAllCampaignSettings();
		System.out.println("getAllCampaignSettings() returning :: " + campList);

		if (campList != null)
			return new ResponseEntity<List<CampaignSettingEntity>>(campList, HttpStatus.OK);
		else
			return new ResponseEntity<List<CampaignSettingEntity>>(campList, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/saveOrUpdateCampaignSetting")
	public ResponseEntity<String> saveOrUpdateCampaignSetting(@RequestBody CampaignSettingEntity camp) {
		if (camp != null) {
			CampaignSettingEntity status = campaignService.saveOrUpdateCampaignSetting(camp);
			if (status != null && status.getCampaignId() != null)
				return new ResponseEntity<String>(DialerConstants.SUCCESS, HttpStatus.CREATED);
			else
				return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.OK);
		}
		return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteCampaignSetting/{campaignSettingId}")
	public ResponseEntity<String> deleteCampaignSetting(@PathVariable("campaignSettingId") Integer campaignId) {
		if (campaignId != null) {
			boolean isDeleted = campaignService.findCampaignSettingById(campaignId).map(campaignService::deleteCampaignSetting)
					.orElse(false);

			if (isDeleted)
				return new ResponseEntity<String>(DialerConstants.SUCCESS, HttpStatus.OK);
			else
				return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.OK);
		}
		return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.BAD_REQUEST);
	}

}

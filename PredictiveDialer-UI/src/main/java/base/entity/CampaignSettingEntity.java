package base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CAMPAIGN_SETTING")
public class CampaignSettingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer settingId;
	private Integer campaignId;
	private Integer contactListId;

	private Integer settingName;

	@Column(name = "SMS")
	private Boolean smsEnabled;
	@Column(name = "EMAIL")
	private Boolean emailEnabled;
	@Column(name = "OUTBOUND_CALL")
	private Boolean outboundCallEnabled;
	@Column(name = "CLICK_TO_CALL")
	private Boolean clickToCallEnabled;
	@Column(name = "NMBR_VALIDATION")
	private Boolean numberValidationEnabled;
	@Column(name = "CARRIER_CHECK")
	private Boolean carrierCheckEnabled;
	@Column(name = "CARRIER_TYPE")
	private Boolean carrierTypeEnabled;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

}

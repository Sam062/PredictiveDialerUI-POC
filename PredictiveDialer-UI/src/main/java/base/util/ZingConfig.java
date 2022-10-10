package base.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.CallsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.MakeCallParams;

import base.controller.DialerController;
import com.zang.api.domain.enums.HttpMethod;

@Service
public class ZingConfig {
	private static final Logger log = LogManager.getLogger(DialerController.class);

	@Value("${zing.authToken}")
	private String authToken;

	@Value("${zing.sid}")
	private String sid;

	@Value("${zing.fromNumber}")
	private String fromNumber;

	@Value("${zing.url}")
	private String url;

	@Value("${zing.timeout}")
	private Integer timeout;

	@Value("${zing.hideCallerId}")
	private Boolean hideCallerId;
	
	@Value("${zing.statusCallbackUrl}")
	private String statusCallbackUrl;

	public void dial(String countryCode, String number) throws ZangException {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setAuthToken(authToken);
		conf.setSid(sid);

		ZangConnectorFactory zangConnectorFactory = new ZangConnectorFactory(conf);
		CallsConnector connector = zangConnectorFactory.getCallsConnector();

		log.info("Trying to dial : " + countryCode + number);

		MakeCallParams makeCallParams = MakeCallParams.builder().setTo(countryCode + number).setFrom(fromNumber)
				.setUrl(url).setMethod(HttpMethod.GET)
				.setStatusCallbackMethod(HttpMethod.GET)
				.setStatusCallback(statusCallbackUrl+"getDialStatus")
				/*
				 * .setFallbackUrl("FallbackUrl") .setFallbackMethod(HttpMethod.POST)
				 * .setStatusCallback("StatusCallback") 
				 * .setStatusCallbackMethod(HttpMethod.GET)
				 * .setHeartbeatUrl("HeartbeatUrl") .setHeartbeatMethod(HttpMethod.GET)
				 * .setForwardedFrom("1234") .setPlayDtmf("123#")
				 */
				.setTimeout(timeout).setHideCallerId(hideCallerId)
				// .setRecord(true)
				// .setRecordCallback("RecordCallback")
				// .setRecordCallbackMethod(HttpMethod.GET)
				// .setTranscribe(true)
				// .setTranscribeCallback("TranscribeCallback")
				// .setStraightToVoicemail(true)
				// .setIfMachine(IfMachine.REDIRECT)
				// .setIfMachineUrl("IfMachineUrl")
				// .setIfMachineMethod(HttpMethod.GET)
				// .setSipAuthUsername("username")
				// .setSipAuthPassword("password")
				.build();
		com.zang.api.domain.Call call = connector.makeCall(makeCallParams);
		log.info("call sid is :: " + call.getSid());
	}

}

package base.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zang.api.exceptions.ZangException;

import base.model.DialerData;
import base.service.DialerService;
import base.util.DialerConstants;
import base.util.DialerUtils;
import base.util.ZingConfig;

@Controller
@CrossOrigin(origins = "http://localhost:3000", value = "http://localhost:3000")
public class DialerController {
	private static final Logger log = LogManager.getLogger(DialerController.class);

	@Autowired
	private DialerService service;

	@Autowired
	private ZingConfig zingDial;

	@GetMapping("/")
	public String homePage() {
		return "Dashboard";
	}

	@GetMapping(value = { "/getDialerData" })
	@ResponseBody
	public ResponseEntity<List<DialerData>> dialerDataPage(Model model) {
		List<DialerData> list = service.getAllDialerData();
		return new ResponseEntity<List<DialerData>>(list != null ? list : new ArrayList<>(), HttpStatus.OK);
	}

	@GetMapping("handledial")
	@ResponseBody
	public String dial(@RequestParam("countryCode") String countryCode, @RequestParam("number") String number) {
		log.info("Request to dial :" + countryCode + number);
		try {
			zingDial.dial(countryCode, number);

			DialerData dialerData = service.findByMobile1(number);
			if (dialerData != null) {
				dialerData.setStatus(DialerConstants.DIALED);
				try {
					service.updateDialerEntity(dialerData);
					log.info("Dial status updated for :" + dialerData.getMobile1());
				} catch (Exception e) {
					log.error("Failed to update dial status");
				}
			}
			return "Dialing " + number + " ...";
		} catch (ZangException e) {
			e.printStackTrace();
			return "Failed to dial";
		}
	}

	@GetMapping("hangup")
	@ResponseBody
	public String hangup() {
		return "Hung up from server : ";
	}

	@PostMapping("/importcsvdata/{contactList}")
	@ResponseBody
	public ResponseEntity<String> inportData(@RequestParam("file") MultipartFile[] file
			,@PathVariable("contactList") String contactList
			) {
		log.info("FILE NAME-> " + file[0].getOriginalFilename());
		log.info("Associated Contact List -> " + contactList);

		try {
			List<DialerData> readCsvDataList = DialerUtils.readCsvData(file[0].getInputStream());
			Boolean saveStatus = service.saveAll(contactList, readCsvDataList);
			if (saveStatus) {
				log.info("CSV data saved into DB.");
				return new ResponseEntity<String>(DialerConstants.SUCCESS, HttpStatus.OK);
			} else {
				log.info("CSV data couldn't save into DB.");
				return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.BAD_REQUEST);
			}

		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.BAD_REQUEST);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(DialerConstants.DATA_FORMAT_ERROR, HttpStatus.BAD_REQUEST);
		}
//		return "redirect:/welcome";
	}

	@GetMapping("/demo")
	public void statusCallback(HttpServletRequest req) {
		log.info("INSIDE CALLBACk======================="
//	+req.getQueryString()
		);
		log.info("Call status=======================" + req.getParameter("CallStatus"));

	}

}

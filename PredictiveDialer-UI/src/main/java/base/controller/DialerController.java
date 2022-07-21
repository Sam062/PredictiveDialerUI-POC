package base.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import base.model.DialerData;
import base.service.DialerService;
import base.util.DialerUtils;

@Controller
public class DialerController {

	@Autowired
	private DialerService service;

	@GetMapping(value = { "/", "/welcome" })
	public String welcomePage(Model model) {

		List<DialerData> list = service.getAllDialerData();

		model.addAttribute("dataList", list != null ? list : new ArrayList<>());

		return "index";
	}

	@GetMapping("handledial")
	@ResponseBody
	public String dial() {
		return "Dialed from server : ";
	}

	@GetMapping("hangup")
	@ResponseBody
	public String hangup() {
		return "Hung up from server : ";
	}

	@PostMapping("/importcsvdata")
	public String inportData(@RequestParam("file") MultipartFile[] file, RedirectAttributes model) {
		System.out.println("FILE NAME-> " + file[0].getOriginalFilename());

		try {
			List<DialerData> readCsvDataList = DialerUtils.readCsvData(file[0].getInputStream());

			Boolean saveStatus = service.saveAll(readCsvDataList);
			if (saveStatus)
				System.out.println("Add CSV data saved into DB.");
			else
				System.out.println("Add CSV data couldn't save into DB.");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/";
	}

}

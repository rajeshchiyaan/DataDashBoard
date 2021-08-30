package com.example.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {

	@Value("${csv_file_location}")
	private String csvFile;

	@GetMapping("/dashboard")
	public String getDashBoard(Model model) {

		List<Employee> list = CSVUtils.parse(csvFile);

		List<List<Map<Object, Object>>> canvasjsDataList = CSVUtils.getEmployeeDataList(list);

		model.addAttribute("dataPointsList", canvasjsDataList);
		
		List<List<Map<Object, Object>>> skillSetDataList = CSVUtils.getSkillSetList(list);
		
		model.addAttribute("skillSetDataList", skillSetDataList);
		
		List<List<Map<Object, Object>>> hydTfDataList = CSVUtils.getTfactorList(list,CSVUtils.HYDERABAD);
		
		model.addAttribute("hydTfDataList", hydTfDataList);
		
		List<List<Map<Object, Object>>> chTfDataList = CSVUtils.getTfactorList(list,CSVUtils.CHENNAI);
		
		model.addAttribute("chTfDataList", chTfDataList);

		return "home";
	}

}

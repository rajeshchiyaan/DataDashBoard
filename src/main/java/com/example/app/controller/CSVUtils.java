package com.example.app.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class CSVUtils {

	private static final String SEPERATOR = "$#&";
	private static final String JAVA = "JAVA";
	private static final String AI = "AI";
	private static final String PYTHON = "PYTHON";
	private static final String SELENIUM = "SELENIUM";
	private static final String SPRING = "SPRING";
	private static final String OTHERS = "OTHERS";
	private static final String HYDERABAD = "HYDERABAD";
	private static final String CHENNAI = "CHENNAI";
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Employee> parse(String csvFileLocation) {
		@SuppressWarnings("rawtypes")
		CsvToBean csvToBean = null;
		List<Employee> employeeList = null;

		Map<String, String> mapping = columnMappings();

		HeaderColumnNameTranslateMappingStrategy<Employee> strategy = new HeaderColumnNameTranslateMappingStrategy<Employee>();
		strategy.setType(Employee.class);
		strategy.setColumnMapping(mapping);

		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(csvFileLocation));
			csvToBean = new CsvToBean<>();
			employeeList = csvToBean.parse(strategy, csvReader);
		} catch (FileNotFoundException e) {

			employeeList = new ArrayList<>();
		}

		return employeeList;
	}

	private static Map<String, String> columnMappings() {
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("name", "Name");
		mapping.put("location", "Location");
		mapping.put("skillSet", "SkillSet");
		return mapping;
	}

	public static List<List<Map<Object, Object>>> getEmployeeDataList(List<Employee> listArg) {

		Map<Object, Object> mapHyd = new HashMap<>();
		Map<Object, Object> mapCh = new HashMap<>();

		List<Map<Object, Object>> dataPoints1 = new ArrayList<Map<Object, Object>>();
		List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();

		mapHyd.put("label", "Hyderabad");
		mapHyd.put("y", 0);

		mapCh.put("label", "Chennai");
		mapCh.put("y", 0);

		for (Employee data : listArg) {
			if ("Hyderabad".equalsIgnoreCase(data.getLocation())) {

				Integer localLnValue = (Integer) mapHyd.get("y");

				localLnValue++;

				mapHyd.put("y", localLnValue);

			} else if ("Chennai".equalsIgnoreCase(data.getLocation())) {

				Integer localLnValue = (Integer) mapCh.get("y");

				localLnValue++;

				mapCh.put("y", localLnValue);

			}

		}

		dataPoints1.add(mapHyd);
		dataPoints1.add(mapCh);

		list.add(dataPoints1);

		return list;
	}
	
	public static List<List<Map<Object, Object>>> getSkillSetList(List<Employee> listArg) {

		Map<Object, Object> mapCity = new HashMap<>();
		Map<String, Long> map = new HashMap<>();

		List<Map<Object, Object>> javaDataPoints = new ArrayList<Map<Object, Object>>();
		List<Map<Object, Object>> aiDataPoints = new ArrayList<Map<Object, Object>>();
		List<Map<Object, Object>> pythonDataPoints = new ArrayList<Map<Object, Object>>();
		List<Map<Object, Object>> springDataPoints = new ArrayList<Map<Object, Object>>();
		List<Map<Object, Object>> seleniumDataPoints = new ArrayList<Map<Object, Object>>();
		List<Map<Object, Object>> otherDataPoints = new ArrayList<Map<Object, Object>>();
		
		List<String> skillsets = Arrays.asList("JAVA","AI","SELENIUM","PYTHON","SPRING");
		
		List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
		
		map.put(JAVA+SEPERATOR+HYDERABAD, (long) 0);
		map.put(AI+SEPERATOR+HYDERABAD, (long) 0);
		map.put(PYTHON+SEPERATOR+HYDERABAD, (long) 0);
		map.put(SPRING+SEPERATOR+HYDERABAD, (long) 0);
		map.put(SELENIUM+SEPERATOR+HYDERABAD, (long) 0);
		map.put(OTHERS+SEPERATOR+HYDERABAD, (long) 0);
		map.put(JAVA+SEPERATOR+CHENNAI, (long) 0);
		map.put(AI+SEPERATOR+CHENNAI, (long) 0);
		map.put(PYTHON+SEPERATOR+CHENNAI, (long) 0);
		map.put(SPRING+SEPERATOR+CHENNAI, (long) 0);
		map.put(SELENIUM+SEPERATOR+CHENNAI, (long) 0);
		map.put(OTHERS+SEPERATOR+CHENNAI, (long) 0);
		
		

		for (Employee data : listArg) {
			
			String skillSet = data.getSkillSet().toUpperCase();
			String location = data.getLocation().toUpperCase();
			String key = skillSet+SEPERATOR+location;
			
			if(!skillsets.contains(skillSet))
			{
				key = "OTHERS"+SEPERATOR+location;
			}
			
			if(map.containsKey(key))
			{
				Long localLnValue = map.get(key);
				
				localLnValue++;
				
				map.put(key, localLnValue);
				
			}
			else
			{
				map.put(key, (long) 1);
			}

		}

		mapCity = new HashMap<Object,Object>(); mapCity.put("label", "Hyderabad"); mapCity.put("y", map.get(JAVA+SEPERATOR+HYDERABAD));javaDataPoints.add(mapCity);
		mapCity = new HashMap<Object,Object>(); mapCity.put("label", "Chennai"); mapCity.put("y", map.get(JAVA+SEPERATOR+CHENNAI));javaDataPoints.add(mapCity);
		
		mapCity = new HashMap<Object,Object>(); mapCity.put("label", "Hyderabad"); mapCity.put("y", map.get(AI+SEPERATOR+HYDERABAD));aiDataPoints.add(mapCity);
		mapCity = new HashMap<Object,Object>(); mapCity.put("label", "Chennai"); mapCity.put("y", map.get(AI+SEPERATOR+CHENNAI));aiDataPoints.add(mapCity);
		
		mapCity = new HashMap<Object,Object>(); mapCity.put("label", "Hyderabad"); mapCity.put("y", map.get(PYTHON+SEPERATOR+HYDERABAD));pythonDataPoints.add(mapCity);
		mapCity = new HashMap<Object,Object>(); mapCity.put("label", "Chennai"); mapCity.put("y", map.get(PYTHON+SEPERATOR+CHENNAI));pythonDataPoints.add(mapCity);
		
		mapCity = new HashMap<Object,Object>(); mapCity.put("label", "Hyderabad"); mapCity.put("y", map.get(SPRING+SEPERATOR+HYDERABAD));springDataPoints.add(mapCity);
		mapCity = new HashMap<Object,Object>(); mapCity.put("label", "Chennai"); mapCity.put("y", map.get(SPRING+SEPERATOR+CHENNAI));springDataPoints.add(mapCity);
		
		mapCity = new HashMap<Object,Object>(); mapCity.put("label", "Hyderabad"); mapCity.put("y", map.get(SELENIUM+SEPERATOR+HYDERABAD));seleniumDataPoints.add(mapCity);
		mapCity = new HashMap<Object,Object>(); mapCity.put("label", "Chennai"); mapCity.put("y", map.get(SELENIUM+SEPERATOR+CHENNAI));seleniumDataPoints.add(mapCity);
		
		mapCity = new HashMap<Object,Object>(); mapCity.put("label", "Hyderabad"); mapCity.put("y", map.get(OTHERS+SEPERATOR+HYDERABAD));otherDataPoints.add(mapCity);
		mapCity = new HashMap<Object,Object>(); mapCity.put("label", "Chennai"); mapCity.put("y", map.get(OTHERS+SEPERATOR+CHENNAI));otherDataPoints.add(mapCity);
		

		list.add(javaDataPoints);
		list.add(aiDataPoints);
		list.add(pythonDataPoints);
		list.add(springDataPoints);
		list.add(seleniumDataPoints);
		list.add(otherDataPoints);

		return list;
	}


}

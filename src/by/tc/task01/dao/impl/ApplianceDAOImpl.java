package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;


import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public Appliance find(Criteria criteria) {
		String categoryOfGoods;	
		Map<String, Object> criteriaSearchParams;
		
		categoryOfGoods = criteria.getGroupSearchName().replaceAll("\\s+", "");
		criteriaSearchParams = criteria.getCriteria();
		
		
		System.out.println("---: " + categoryOfGoods+" :---");
		System.out.println("Search criteria are ===>" + criteriaSearchParams);
		
		final String file = "resources/appliances_db.txt";
		String line = null;
		BufferedReader buff = null;
		
		Appliance appliance = new Appliance();
		
		
		try {
			Reader fileReader = new FileReader(file);
			buff = new BufferedReader(fileReader);
			
			
			while((line = buff.readLine()) != null) {
				if (line.contains(categoryOfGoods)) {
					
					for (Map.Entry<String, Object> entry : criteriaSearchParams.entrySet()) {
						
						String key = entry.getKey().toString().replaceAll("\\s+", "_").toUpperCase();
						String value = entry.getValue().toString();
						
						String match = key+"="+value;
						
						if (line.contains(match)) {
							
							Appliance.getApplianceinstance().add(line);
							
							}
						}
					}
				}
			buff.close();
			
			} catch(IOException e) {
				System.err.println("An IOException was caught :" + e.getMessage());
				} finally {
					try {
						if (buff != null) {
							buff.close();
							} 
					}catch(IOException e) {
						e.printStackTrace();
						}
					} 
		
		List <Object> temp = Appliance.getApplianceinstance(); 
		
		for (int i = 0; i <temp.size()-1; i++) {
			String st1 = temp.get(i).toString();
			
			for (int j = i+1; j < temp.size(); j++) {
				String st2 = temp.get(j).toString();
				
				if (st1.equals(st2)) {
					Appliance.getApplianceinstance().remove(j);
				}
			}
		}
		
		
		if (!Appliance.getApplianceinstance().isEmpty()) {
			return appliance;
		} else {
			return null;	
		}
	}

	
	@Override
	public Appliance clear(Appliance appliance) {
		Appliance.getApplianceinstance().clear();
		return appliance;
	}
}

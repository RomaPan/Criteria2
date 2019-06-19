package by.tc.task01.service.validation;



import java.util.Map;

import by.tc.task01.entity.criteria.Criteria;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {

		
		String groupName = criteria.getGroupSearchName();
		
		String regexGroup = "^[a-zA-Z\\s+]+$";
		String regexKeys = "^[a-zA-Z_\\s+]+$";
		String regexValue = "^[a-zA-Z0-9._-]+$";
		
		Map<String, Object> temp = criteria.getCriteria();
		boolean isKeyValid = true;
		boolean isValueValid = true;
			
		for (Map.Entry<String, Object>entry : temp.entrySet()) {
			String key = entry.getKey();
			String obj = entry.getValue().toString();
			if (!key.matches(regexKeys)) {
				isKeyValid = false;
				} else if (!obj.matches(regexValue)) {
					isValueValid = false;
					}	
			}
		
		if (groupName.matches(regexGroup) && !temp.isEmpty() && isKeyValid == true && isValueValid == true) { 
		    return true;
		} else {
			return false;
		}
	}

}


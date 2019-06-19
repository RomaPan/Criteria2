package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.main.PrintApplianceInfo;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public Appliance find(Criteria criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			PrintApplianceInfo.printCriteriaInvalid();
		} else {
			DAOFactory factory = DAOFactory.getInstance();
			ApplianceDAO applianceDAO = factory.getApplianceDAO();
			
			Appliance appliance = applianceDAO.find(criteria);
			
			return appliance;
		}
		
		return null;
	}

}
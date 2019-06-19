package by.tc.task01.main;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;


public class PrintApplianceInfo {
	
	public static void print(Appliance appliance) {
		
		if (Appliance.getApplianceinstance().isEmpty()){
			
			System.out.println("Nothing found, please try again with different search criteria");
	
			} else {
				System.out.println("Search results are:");
				int k = Appliance.getApplianceinstance().size();
				
				for (int i = 0; i < k; i++) {
					System.out.println(Appliance.getApplianceinstance().get(i));
					}
				DAOFactory factory = DAOFactory.getInstance();
				ApplianceDAO applianceDAO = factory.getApplianceDAO();
				
				applianceDAO.clear(appliance);
				System.out.println("\n");
				}
		}
	
	public static void printCriteriaInvalid() {
		
		System.out.println("Search criteria are empty or invalid, please define "
				+ "your search criteria and try again");
	}
	
	

}

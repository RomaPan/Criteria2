package by.tc.task01.main;



import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
		Appliance appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria("Oven");
		criteriaOven.add("width", 68);
		criteriaOven.add("Weight", 11);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		Criteria criteriaRefrigerator = new Criteria("Refrigerator");
		criteriaRefrigerator.add("Power consumption", 150);
		criteriaRefrigerator.add("width", 80);

		appliance = service.find(criteriaRefrigerator);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaVacuumCleaner = new Criteria ("Vacuum Cleaner");
		criteriaVacuumCleaner.add("bag type", "AA-89");
		
		appliance = service.find(criteriaVacuumCleaner);
		PrintApplianceInfo.print(appliance);
		
		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaNegativeTest = new Criteria("");
		criteriaNegativeTest.add("display inches", "15");
		
		appliance = service.find(criteriaNegativeTest);
		PrintApplianceInfo.print(appliance);

	}

}

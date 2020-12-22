package by.tc.task01.main;

import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.entity.exception.IncorrectParameterException;
import by.tc.task01.entity.exception.InvalidCriteriaException;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, IncorrectParameterException {
        List<Appliance> appliances;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();


        //////////////////////////////////////////////////////////////////

        Criteria criteriaOven = new Criteria(SearchCriteria.Oven.class.getSimpleName());//"Oven"

        criteriaOven.add(SearchCriteria.Oven.WEIGHT.toString(), 10);
        try {
            appliances = service.find(criteriaOven);
            PrintApplianceInfo.print(appliances);
        } catch (IncorrectParameterException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("there is no such appliance");
        } catch (InvalidCriteriaException ex) {
            System.out.println(ex.getMessage());
        }


        //////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria(Oven.class.getSimpleName());
        criteriaOven.add(SearchCriteria.Oven.HEIGHT.toString(), 40);
        criteriaOven.add(SearchCriteria.Oven.DEPTH.toString(), 60);
        try {
            appliances = service.find(criteriaOven);
            PrintApplianceInfo.print(appliances);
        } catch (IncorrectParameterException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("there is no such appliance");
        } catch (InvalidCriteriaException ex) {
            System.out.println(ex.getMessage());
        }


//        //////////////////////////////////////////////////////////////////
        Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
        criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR.toString(), "BLUE");
        criteriaTabletPC.add(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), 14);
        criteriaTabletPC.add(SearchCriteria.TabletPC.MEMORY_ROM.toString(), 8000);

        try {
            appliances = service.find(criteriaTabletPC);// find(Object...obj)
            PrintApplianceInfo.print(appliances);
        } catch (IncorrectParameterException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("there is no such appliance");
        }

//        //////////////////////////////////////////////////////////////////
        Criteria criteriaLaptop = new Criteria(Laptop.class.getSimpleName());
        criteriaLaptop.add(SearchCriteria.Laptop.OS.toString(), "WINDOWS");
        criteriaLaptop.add(SearchCriteria.Laptop.CPU.toString(), 3.2);

        try {
            appliances = service.find(criteriaLaptop);
            PrintApplianceInfo.print(appliances);
        } catch (IncorrectParameterException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("there is no such appliance");
        }
//
//        //////////////////////////////////////////////////////////////////
        Criteria criteriaSpeakers = new Criteria(Speakers.class.getSimpleName());
        criteriaSpeakers.add(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), "2-3.5");
        criteriaSpeakers.add(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), 17);
        try {
            appliances = service.find(criteriaSpeakers);
            PrintApplianceInfo.print(appliances);
        } catch (IncorrectParameterException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("there is no such appliance");
        }
//        //////////////////////////////////////////////////////////////////
        Criteria criteriaFridge = new Criteria(Refrigerator.class.getSimpleName());
        criteriaFridge.add(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), 100.0);
        try {
            appliances = service.find(criteriaFridge);
            PrintApplianceInfo.print(appliances);
        } catch (IncorrectParameterException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("there is no such appliance");
        }
//
//        //////////////////////////////////////////////////////////////////
//
        Criteria criteriaVacuumCleaner = new Criteria(VacuumCleaner.class.getSimpleName());
        criteriaVacuumCleaner.add(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(), "A");
        try {
            appliances = service.find(criteriaVacuumCleaner);
            PrintApplianceInfo.print(appliances);
        } catch (IncorrectParameterException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("there is no such appliance");
        }

    }

}

package by.tc.task01.service.validation;

import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.entity.exception.IncorrectParameterException;

import java.util.Map;

public class Validator {

    private static final double MINIMUM_POWER_CONSUMPTION = 10;
    private static final double MAXIMUM_POWER_CONSUMPTION = 4000;

    private static final double MINIMUM_SPEED_REGULATION = 2500;
    private static final double MAXIMUM_SPEED_REGULATION = 3500;

    private static final double MINIMUM_CLEANING_WIDTH = 10;
    private static final double MAXIMUM_CLEANING_WIDTH = 50;
    private static final String FILTER_TYPE_REGEX = "[A-Z]";

    private static final double MINIMUM_WEIGHT = 10;
    private static final double MAXIMUM_WEIGHT = 300;

    private static final double MINIMUM_CAPACITY = 1;
    private static final double MAXIMUM_CAPACITY = 400;

    private static final double MINIMUM_HEIGHT = 10;
    private static final double MAXIMUM_HEIGHT = 1000;

    private static final double MINIMUM_ROM = 1000;
    private static final double MAXIMUM_ROM = 20000;
    private static final String CPU_REGEX = "\\d[.]\\d";
    private static final double MINIMUM_DISPLAY_INCHES = 5;
    private static final double MAXIMUM_DISPLAY_INCHES = 25;

    private static final String FREQUENCY_REGEX = "[\\d]{1,2}[.]?[\\d]*[-][\\d]{1,2}[.]?[\\d]*";
    private static final int MINIMUM_NUMBER_OF_SPEAKERS = 1;
    private static final int MAXIMUM_NUMBER_OF_SPEAKERS = 10;
    private static final double MINIMUM_CORD_LENGTH = 1;
    private static final double MAXIMUM_CORD_LENGTH = 30;

    public static boolean criteriaValidator(Criteria criteria) {
        if (criteria == null)
            return false;
        switch (criteria.getGroupSearchName()) {
            case "Oven": {
                return validateOven(criteria.getCriteria());
            }
            case "Laptop": {
                return validateLaptop(criteria.getCriteria());
            }
            case "TabletPC": {
                return validateTabletPc(criteria.getCriteria());
            }
            case "Speakers": {
                return validateSpeakers(criteria.getCriteria());
            }
            case "Refrigerator": {
                return validateRefrigerator(criteria.getCriteria());
            }
            case "VacuumCleaner": {
                return validateVacuumCleaner(criteria.getCriteria());
            }
            default: {
                return false;
            }
        }
    }


    private static boolean validateVacuumCleaner(Map<String, Object> getCriteria) {

        if (getCriteria.containsKey(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()).toString());
            if (!(value >= MINIMUM_POWER_CONSUMPTION && value <= MAXIMUM_POWER_CONSUMPTION))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()).toString());
            if (!(value >= MINIMUM_SPEED_REGULATION && value <= MAXIMUM_SPEED_REGULATION))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()).toString());
            if (!(value >= MINIMUM_CLEANING_WIDTH && value <= MAXIMUM_CLEANING_WIDTH))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString())) {
            String value = getCriteria.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString()).toString();
            if (!value.matches(FILTER_TYPE_REGEX))
                return false;
        }
        return true;
    }

    private static boolean validateRefrigerator(Map<String, Object> getCriteria) {
        if (getCriteria.containsKey(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()).toString());
            if (!(value >= MINIMUM_POWER_CONSUMPTION && value <= MAXIMUM_POWER_CONSUMPTION))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Refrigerator.WEIGHT.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Refrigerator.WEIGHT.toString()).toString());
            if (!(value >= MINIMUM_WEIGHT && value <= MAXIMUM_WEIGHT))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()).toString());
            if (!(value >= MINIMUM_CAPACITY && value <= MAXIMUM_CAPACITY))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()).toString());
            if (!(value >= MINIMUM_CAPACITY && value <= MAXIMUM_CAPACITY))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Refrigerator.HEIGHT.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Refrigerator.HEIGHT.toString()).toString());
            if (!(value >= MINIMUM_HEIGHT && value <= MAXIMUM_HEIGHT))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Refrigerator.WIDTH.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Refrigerator.WIDTH.toString()).toString());
            if (!(value >= MINIMUM_HEIGHT && value <= MAXIMUM_HEIGHT))
                return false;
        }
        return true;
    }

    private static boolean validateOven(Map<String, Object> getCriteria) {

        if (getCriteria.containsKey(SearchCriteria.Oven.POWER_CONSUMPTION.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString()).toString());
            if (!(value >= MINIMUM_POWER_CONSUMPTION && value <= MAXIMUM_POWER_CONSUMPTION))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Oven.CAPACITY.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Oven.CAPACITY.toString()).toString());
            if (value < MINIMUM_CAPACITY || value > MAXIMUM_CAPACITY)
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Oven.DEPTH.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Oven.DEPTH.toString()).toString());
            if (!(value >= MINIMUM_HEIGHT && value <= MAXIMUM_HEIGHT))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Oven.HEIGHT.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Oven.HEIGHT.toString()).toString());
            if (!(value >= MINIMUM_HEIGHT && value <= MAXIMUM_HEIGHT))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Oven.WIDTH.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Oven.WIDTH.toString()).toString());
            if (!(value >= MINIMUM_HEIGHT && value <= MAXIMUM_HEIGHT))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Oven.WEIGHT.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Oven.WEIGHT.toString()).toString());
            if (!(value >= MINIMUM_WEIGHT && value <= MAXIMUM_WEIGHT))
                return false;
        }
        return true;

    }

    private static boolean validateLaptop(Map<String, Object> getCriteria) {
        if (getCriteria.containsKey(SearchCriteria.Laptop.BATTERY_CAPACITY.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString()).toString());
            if (!(value >= MINIMUM_CAPACITY && value <= MAXIMUM_CAPACITY))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Laptop.MEMORY_ROM.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Laptop.MEMORY_ROM.toString()).toString());
            if (!(value >= MINIMUM_ROM && value <= MAXIMUM_ROM))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Laptop.SYSTEM_MEMORY.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString()).toString());
            if (!(value >= MINIMUM_ROM && value <= MAXIMUM_ROM))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Laptop.CPU.toString())) {
            String value = getCriteria.get(SearchCriteria.Laptop.CPU.toString()).toString();
            if (!value.matches(CPU_REGEX))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Laptop.DISPLAY_INCHES.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Laptop.DISPLAY_INCHES.toString()).toString());
            if (!(value >= MINIMUM_DISPLAY_INCHES && value <= MAXIMUM_DISPLAY_INCHES))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Laptop.OS.toString())) {
            String value = (String) getCriteria.get(SearchCriteria.Laptop.OS.toString());
            try {
                Laptop.OS.fromString(value);
            } catch (IncorrectParameterException ex) {
                return false;
            }
        }
        return true;

    }

    private static boolean validateTabletPc(Map<String, Object> getCriteria) {
        if (getCriteria.containsKey(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()).toString());
            if (!(value >= MINIMUM_CAPACITY && value <= MAXIMUM_CAPACITY))
                return false;
        }

        if (getCriteria.containsKey(SearchCriteria.TabletPC.DISPLAY_INCHES.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString()).toString());
            if (!(value >= MINIMUM_DISPLAY_INCHES && value <= MAXIMUM_DISPLAY_INCHES))
                return false;
        }

        if (getCriteria.containsKey(SearchCriteria.TabletPC.MEMORY_ROM.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.TabletPC.MEMORY_ROM.toString()).toString());
            if (!(value >= MINIMUM_ROM && value <= MAXIMUM_ROM))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()).toString());
            if (!(value >= MINIMUM_CAPACITY && value <= MAXIMUM_CAPACITY))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.TabletPC.COLOR.toString())) {
            String value = (String) getCriteria.get(SearchCriteria.TabletPC.COLOR.toString());
            try {
                TabletPC.Color.fromString(value);
            } catch (IncorrectParameterException ex) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateSpeakers(Map<String, Object> getCriteria) {
        if (getCriteria.containsKey(SearchCriteria.Speakers.FREQUENCY_RANGE.toString())) {
            String value = getCriteria.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString()).toString();
            if (!value.matches(FREQUENCY_REGEX))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Speakers.POWER_CONSUMPTION.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString()).toString());
            if (!(value >= MINIMUM_POWER_CONSUMPTION && value <= MAXIMUM_POWER_CONSUMPTION))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString())) {
            int value = (Integer) getCriteria.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString());
            if (!(value >= MINIMUM_NUMBER_OF_SPEAKERS && value <= MAXIMUM_NUMBER_OF_SPEAKERS))
                return false;
        }
        if (getCriteria.containsKey(SearchCriteria.Speakers.CORD_LENGTH.toString())) {
            double value = Double.parseDouble(getCriteria.get(SearchCriteria.Speakers.CORD_LENGTH.toString()).toString());
            if (!(value >= MINIMUM_CORD_LENGTH && value <= MAXIMUM_CORD_LENGTH))
                return false;
        }
        return true;
    }

}

//you may add your own new classes
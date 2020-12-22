package by.tc.task01.entity;

import by.tc.task01.entity.exception.IncorrectParameterException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ApplianceFactory  {
        public Map<String, Object> createMapFromString(String s) throws IncorrectParameterException {
        Map<String, Object> map = new HashMap<>();
        String[] parameters = s.split("[:;\\s,=]+");
        switch (parameters[0]) {
            case "Oven":
            case "Refrigerator": {
                for (int i = 1; i < parameters.length - 1; i++)
                    map.put(parameters[i], Double.parseDouble(parameters[i += 1]));
                break;
            }
            case "Laptop": {
                map.put(parameters[1], Double.parseDouble(parameters[2]));
                map.put(parameters[3], Laptop.OS.fromString(parameters[4]));
                map.put(parameters[5], Double.parseDouble(parameters[6]));
                map.put(parameters[7], Double.parseDouble(parameters[8]));
                map.put(parameters[9], Double.parseDouble(parameters[10]));
                map.put(parameters[11], Double.parseDouble(parameters[12]));
                break;
            }
            case "VacuumCleaner": {
                map.put(parameters[1], Double.parseDouble(parameters[2]));
                map.put(parameters[3], parameters[4]);
                map.put(parameters[5], parameters[6]);
                map.put(parameters[7], parameters[8]);
                map.put(parameters[9], Double.parseDouble(parameters[10]));
                map.put(parameters[11], Double.parseDouble(parameters[12]));
                break;
            }
            case "TabletPC": {
                map.put(parameters[1], Double.parseDouble(parameters[2]));
                map.put(parameters[3], Double.parseDouble(parameters[4]));
                map.put(parameters[5], Double.parseDouble(parameters[6]));
                map.put(parameters[7], Double.parseDouble(parameters[8]));
                map.put(parameters[9], TabletPC.Color.fromString(parameters[10]));
                break;
            }
            case "Speakers": {
                map.put(parameters[1], Double.parseDouble(parameters[2]));
                map.put(parameters[3], Integer.parseInt(parameters[4]));
                map.put(parameters[5], parameters[6]);
                map.put(parameters[7], Double.parseDouble(parameters[8]));
            }


        }
        return map;
    }
    public Appliance createAppliance(String type, Map<String, Object> parameters) throws IncorrectParameterException {
        switch (type) {
            case "Oven": {
                Oven oven = new Oven();
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    String name = entry.getKey();
                    Object value = entry.getValue();
                    switch (name) {
                        case "POWER_CONSUMPTION": {
                            oven.setPowerConsumption((Double) value);
                            break;
                        }
                        case "WEIGHT": {
                            oven.setWeight((Double) value);
                            break;
                        }
                        case "CAPACITY": {
                            oven.setCapacity((Double) value);
                            break;
                        }
                        case "DEPTH": {
                            oven.setDepth((Double) value);
                            break;
                        }
                        case "HEIGHT": {
                            oven.setHeight((Double) value);
                            break;
                        }
                        case "WIDTH": {
                            oven.setWidth((Double) value);
                            break;
                        }
                        default: {
                            throw new IncorrectParameterException("Incorrect parameter in map during creating Appliance");
                        }

                    }
                }
                return oven;
            }
            case "Laptop": {
                Laptop laptop = new Laptop();
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    String name = entry.getKey();
                    Object value = entry.getValue();
                    switch (name) {
                        case "BATTERY_CAPACITY": {
                            laptop.setBatteryCapacity((Double) value);
                            break;
                        }
                        case "OS": {
                            laptop.setOs((Laptop.OS) value);
                            break;
                        }
                        case "MEMORY_ROM": {
                            laptop.setMemoryRom((Double) value);
                            break;
                        }
                        case "SYSTEM_MEMORY": {
                            laptop.setSystemMemory((Double) value);
                            break;
                        }
                        case "CPU": {
                            laptop.setCpu((Double) value);
                            break;
                        }
                        case "DISPLAY_INCHS": {
                            laptop.setDisplayInches((Double) value);
                            break;
                        }
                        default: {
                            throw new IncorrectParameterException("Incorrect parameter in map during creating Appliance");
                        }
                    }

                }
                return laptop;
            }
            case "Refrigerator": {
                Refrigerator refrigerator = new Refrigerator();
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    String name = entry.getKey();
                    Object value = entry.getValue();
                    switch (name) {
                        case "POWER_CONSUMPTION": {
                            refrigerator.setPowerConsumption((Double) value);
                            break;
                        }
                        case "WEIGHT": {
                            refrigerator.setWeight((Double) value);
                            break;
                        }
                        case "FREEZER_CAPACITY": {
                            refrigerator.setFreezerCapacity((Double) value);
                            break;
                        }
                        case "OVERALL_CAPACITY": {
                            refrigerator.setOverallCapacity((Double) value);
                            break;
                        }
                        case "HEIGHT": {
                            refrigerator.setHeight((Double) value);
                            break;
                        }
                        case "WIDTH": {
                            refrigerator.setWidth((Double) value);
                            break;
                        }
                        default: {
                            throw new IncorrectParameterException("Incorrect parameter in map during creating Appliance");
                        }
                    }

                }
                return refrigerator;
            }

            case "Speakers": {
                Speakers speakers = new Speakers();
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    String name = entry.getKey();
                    Object value = entry.getValue();
                    switch (name) {
                        case "POWER_CONSUMPTION": {
                            speakers.setPowerConsumption((Double) value);
                            break;
                        }
                        case "FREQUENCY_RANGE": {
                            speakers.setFrequencyRange((String) value);
                            break;
                        }
                        case "NUMBER_OF_SPEAKERS": {
                            speakers.setNumberOfSpeakers((Integer) value);
                            break;
                        }
                        case "CORD_LENGTH": {
                            speakers.setCordLength((Double) value);
                            break;
                        }
                        default: {
                            throw new IncorrectParameterException("Incorrect parameter in map during creating Appliance");
                        }
                    }
                }
                return speakers;
            }
            case "TabletPC": {
                TabletPC tabletPC = new TabletPC();
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    String name = entry.getKey();
                    Object value = entry.getValue();
                    switch (name) {
                        case "BATTERY_CAPACITY": {
                            tabletPC.setBatteryCapacity((Double) value);
                            break;
                        }
                        case "DISPLAY_INCHES": {
                            tabletPC.setDisplayInches((Double) value);
                            break;
                        }
                        case "MEMORY_ROM": {
                            tabletPC.setMemoryRom((Double) value);
                            break;
                        }
                        case "FLASH_MEMORY_CAPACITY": {
                            tabletPC.setFlashMemoryCapacity((Double) value);
                            break;
                        }
                        case "COLOR": {
                            tabletPC.setColor((TabletPC.Color) value);
                            break;
                        }
                        default: {
                            throw new IncorrectParameterException("Incorrect parameter in map during creating Appliance");
                        }
                    }
                }
                return tabletPC;
            }

            case "VacuumCleaner": {
                VacuumCleaner vacuumCleaner = new VacuumCleaner();
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    String name = entry.getKey();
                    Object value = entry.getValue();
                    switch (name) {
                        case "POWER_CONSUMPTION": {
                            vacuumCleaner.setPowerConsumption((Double) value);
                            break;
                        }
                        case "FILTER_TYPE": {
                            vacuumCleaner.setFilterType((String) value);
                            break;
                        }
                        case "BAG_TYPE": {
                            vacuumCleaner.setBagType((String) value);
                            break;
                        }
                        case "WAND_TYPE": {
                            vacuumCleaner.setWandType((String) value);
                            break;
                        }
                        case "MOTOR_SPEED_REGULATION": {
                            vacuumCleaner.setMotorSpeedRegulation((Double) value);
                            break;
                        }
                        case "CLEANING_WIDTH": {
                            vacuumCleaner.setCleaningWidth((Double) value);
                            break;
                        }
                        default: {
                            throw new IncorrectParameterException("Incorrect parameter in map during creating Appliance");
                        }
                    }
                }
                return vacuumCleaner;
            }

            default:
                return null;

        }

    }
}

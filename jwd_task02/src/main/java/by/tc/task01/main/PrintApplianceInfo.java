package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {

    public static void print(Appliance appliance) {
        System.out.println(appliance.toString());

    }
    public static void print(List<Appliance> appliances){
        appliances.stream().forEach(System.out::println);
        System.out.println();
    }

    // you may add your own code here

}

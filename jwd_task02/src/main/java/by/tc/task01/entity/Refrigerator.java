package by.tc.task01.entity;

import java.io.Serializable;
import java.util.Objects;

public class Refrigerator extends Appliance implements Serializable {
    private double powerConsumption;
    private double weight;
    private double freezerCapacity;
    private double overallCapacity;
    private double height;
    private double width;

    public Refrigerator() {
    }

    public Refrigerator(double powerConsumption, double weight, double freezerCapacity, double overallCapacity, double height,
                        double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
    }

    //setters
    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setFreezerCapacity(double freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " : POWER_CONSUMPTION=" + powerConsumption + ", " + "WEIGHT=" + weight
                + ", " + "FREEZER_CAPACITY=" + freezerCapacity + "OVERALL_CAPACITY=" + overallCapacity + ", " + "HEIGHT=" + height + ", " + "WIDTH="
                + width;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Refrigerator refrigerator = (Refrigerator) obj;
        if (Double.compare(refrigerator.powerConsumption, powerConsumption) == 0
                && Double.compare(refrigerator.freezerCapacity, freezerCapacity) == 0
                && Double.compare(refrigerator.overallCapacity, overallCapacity) == 0
                && Double.compare(refrigerator.height, height) == 0
                && Double.compare(refrigerator.weight, weight) == 0
                && Double.compare(refrigerator.width, width) == 0)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
    }
}

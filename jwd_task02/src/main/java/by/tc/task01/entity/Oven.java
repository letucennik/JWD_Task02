package by.tc.task01.entity;

import java.io.Serializable;
import java.util.Objects;

public class Oven extends Appliance implements Serializable {
    private double powerConsumption;
    private double weight;
    private double capacity;
    private double depth;
    private double height;
    private double width;

    public Oven() {
    }

    public Oven(double powerConsumption, double weight, double capacity, double depth, double height, double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    //getters
    public double getPowerConsumption() {
        return powerConsumption;
    }

    //setters
    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " : POWER_CONSUMPTION=" + powerConsumption + ", " + "WEIGHT=" + weight
                + ", " + "CAPACITY=" + capacity + ", " + "DEPTH=" + depth + ", " + "HEIGHT=" + height + ", " + "WIDTH="
                + width;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Oven oven = (Oven) obj;
        if (Double.compare(oven.powerConsumption, powerConsumption) == 0
                && Double.compare(oven.weight, weight) == 0
                && Double.compare(oven.capacity, capacity) == 0
                && Double.compare(oven.depth, depth) == 0
                && Double.compare(oven.height, height) == 0
                && Double.compare(oven.width, width) == 0)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, weight, capacity, depth, height);
    }
}

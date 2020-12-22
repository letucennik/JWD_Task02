package by.tc.task01.entity;

import by.tc.task01.entity.exception.IncorrectParameterException;

import java.io.Serializable;
import java.util.Objects;

public class TabletPC extends Appliance implements Serializable {
    private double batteryCapacity;
    private double displayInches;
    private double memoryRom;
    private double flashMemoryCapacity;
    private Color color;

    public TabletPC() {
    }

    public TabletPC(double batteryCapacity, double displayInches, double memoryRom, double flashMemoryCapacity, Color color) {
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryRom = memoryRom;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }
    //setters

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public double getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(double flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }
    //getters

    public double getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(double memoryRom) {
        this.memoryRom = memoryRom;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " : BATTERY_CAPACITY=" + batteryCapacity + ", " + "DISPLAY_INCHES=" + displayInches
                + ", " + "MEMORY_ROM=" + memoryRom + ", " + "FLASH_MEMORY_CAPACITY=" + flashMemoryCapacity + ", " + "COLOR=" + color.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        TabletPC tabletPC = (TabletPC) obj;
        if (Double.compare(tabletPC.batteryCapacity, batteryCapacity) == 0
                && Double.compare(tabletPC.displayInches, displayInches) == 0
                && tabletPC.color.equals(color)
                && Double.compare(tabletPC.flashMemoryCapacity, flashMemoryCapacity) == 0
                && Double.compare(tabletPC.memoryRom, memoryRom) == 0)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
    }

    public enum Color {
        RED,
        GREEN,
        BLUE;

        public static Color fromString(String s) throws IncorrectParameterException {
            switch (s) {
                case "RED":
                    return RED;
                case "GREEN":
                    return GREEN;
                case "BLUE":
                    return BLUE;
                default:
                    throw new IncorrectParameterException("There is no such color");
            }
        }
    }
}

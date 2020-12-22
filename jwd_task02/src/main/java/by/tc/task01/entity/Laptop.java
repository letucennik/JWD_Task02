package by.tc.task01.entity;

import by.tc.task01.entity.exception.IncorrectParameterException;

import java.io.Serializable;
import java.util.Objects;

public class Laptop extends Appliance implements Serializable {
    private double batteryCapacity;
    private OS os;
    private double memoryRom;
    private double systemMemory;
    private double cpu;
    private double displayInches;

    public Laptop() {
    }

    public Laptop(double batteryCapacity, OS os, double memoryRom, double systemMemory, double cpu, double displayInches) {
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
    }

    //getters
    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    //setters
    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public double getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(double memoryRom) {
        this.memoryRom = memoryRom;
    }

    public double getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(double systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " : BATTERY_CAPACITY=" + batteryCapacity + ", " + " OS=" + os.toString()
                + ", " + "MEMORY_ROM=" + memoryRom + ", " + "SYSTEM_MEMORY=" + systemMemory + ", " + "CPU=" + cpu + ", " + " DISPLAY_INCHS="
                + displayInches;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Laptop laptop = (Laptop) obj;
        if (Double.compare(laptop.batteryCapacity, batteryCapacity) == 0
                && Double.compare(laptop.memoryRom, memoryRom) == 0
                && Double.compare(laptop.systemMemory, systemMemory) == 0
                && Double.compare(laptop.cpu, cpu) == 0
                && Double.compare(laptop.displayInches, displayInches) == 0
                && laptop.os.equals(os))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, os, memoryRom, systemMemory, cpu, displayInches);
    }

    public enum OS {
        WINDOWS,
        LINUX,
        IOS;

        public static OS fromString(String s) throws IncorrectParameterException {
            switch (s) {
                case "WINDOWS":
                    return WINDOWS;
                case "LINUX":
                    return LINUX;
                case "IOS":
                    return IOS;
                default:
                    throw new IncorrectParameterException("There is no such OS");
            }
        }
    }
}

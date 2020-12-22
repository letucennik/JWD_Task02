package by.tc.task01.entity;

import java.io.Serializable;
import java.util.Objects;

public class Speakers extends Appliance implements Serializable {
    private double powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private double cordLength;

    public Speakers() {
    }

    public Speakers(double powerConsumption, int numberOfSpeakers, String frequencyRange,
                    double cordLength) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    //getters
    public double getPowerConsumption() {
        return powerConsumption;
    }

    //setters
    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public double getCordLength() {
        return cordLength;
    }

    public void setCordLength(double cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " : POWER_CONSUMPTION=" + powerConsumption + ", " + "NUMBER_OF_SPEAKERS=" + numberOfSpeakers
                + ", " + "FREQUENCY_RANGE=" + frequencyRange + ", " + "CORD_LENGTH=" + cordLength;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Speakers speakers = (Speakers) obj;
        if (Double.compare(speakers.powerConsumption, powerConsumption) == 0
                && speakers.numberOfSpeakers == numberOfSpeakers
                && speakers.frequencyRange.equals(frequencyRange)
                && Double.compare(speakers.cordLength, cordLength) == 0)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, numberOfSpeakers, frequencyRange, cordLength);
    }
}

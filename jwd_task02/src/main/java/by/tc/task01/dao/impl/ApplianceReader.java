package by.tc.task01.dao.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.ApplianceFactory;
import by.tc.task01.entity.exception.IncorrectParameterException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApplianceReader implements Iterable {
    private final int NUMBER_OF_STRING_TO_READ = 10;
    BufferedReader bufferedReader;
    private List<Appliance> appliancesToIterate;
    private File fileToRead;
    private String lineFromFile;
    private FileReader fileReader;

    public ApplianceReader() {
        appliancesToIterate = new ArrayList<>();
    }

    public ApplianceReader(File file) throws IOException {
        fileToRead = file;
        appliancesToIterate = new ArrayList<>();
        fileReader = new FileReader(fileToRead);
        bufferedReader = new BufferedReader(fileReader);
    }

    public ApplianceIterator iterator() {
        return new ApplianceIterator();
    }

    class ApplianceIterator implements Iterator {

        @Override
        public boolean hasNext() {
            if (appliancesToIterate.isEmpty()) {
                return true;
            }
            return lineFromFile != null;
        }

        @Override
        public List<Appliance> next() {
            List<Appliance> applianceDataBlock;
            ApplianceFactory applianceFactory;
            try {
                lineFromFile = bufferedReader.readLine();
                applianceDataBlock = new ArrayList<>();
                applianceFactory = new ApplianceFactory();
                for (int i = 0; i < NUMBER_OF_STRING_TO_READ; i++) {
                    if ("".equals(lineFromFile)) {
                        continue;
                    }
                    if (lineFromFile == null) {
                        break;
                    }
                    String[] parameters = lineFromFile.split("[:;\\s,=]+");
                    appliancesToIterate.add(applianceFactory.createAppliance(parameters[0], applianceFactory.createMapFromString(lineFromFile)));
                    applianceDataBlock.add(applianceFactory.createAppliance(parameters[0], applianceFactory.createMapFromString(lineFromFile)));
                    lineFromFile = bufferedReader.readLine();
                }
                return applianceDataBlock;
            } catch (IOException e) {
                return null;
            } catch (IncorrectParameterException e) {
                return null;
            }


        }
    }
}

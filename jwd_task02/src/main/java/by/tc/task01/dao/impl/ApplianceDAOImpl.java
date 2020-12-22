package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {
    @Override
    public List<Appliance> find(Criteria criteria) throws IOException {
        ApplianceReader applianceReader = new ApplianceReader(new File("appliances_db.txt"));
        ApplianceSearchFilter applianceSearchFilter = new ApplianceSearchFilter();

        List<Appliance> appliancesDataBlock;
        List<Appliance> filteredApplianceData;
        List<Appliance> foundAppliances = new ArrayList<>();
        ApplianceReader.ApplianceIterator iterator = applianceReader.iterator();

        while (iterator.hasNext()) {
            appliancesDataBlock = iterator.next();
            filteredApplianceData = applianceSearchFilter.filter(criteria, appliancesDataBlock);
            foundAppliances.addAll(filteredApplianceData);
        }
        return foundAppliances;
    }
}

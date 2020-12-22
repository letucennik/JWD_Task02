package by.tc.task01.dao.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.ArrayList;
import java.util.List;

public class ApplianceSearchFilter {
    public ApplianceSearchFilter() {
    }

    public List<Appliance> filter(Criteria criteria, List<Appliance> applianceDataBlock) {
        List<Appliance> filteredApplianceData = new ArrayList<>();
        List<String> regexExpressionsForCriteria = criteria.regexCriteria();
        if (regexExpressionsForCriteria.size() == 0) {
            return null;
        }
        for (Appliance app : applianceDataBlock) {
            int count = 0;
            for (int i = 0; i < regexExpressionsForCriteria.size(); i++) {
                if (app.toString().matches(regexExpressionsForCriteria.get(i))) {
                    count++;
                }
                if (count == regexExpressionsForCriteria.size()) {
                    filteredApplianceData.add(app);
                }
            }
        }

        return filteredApplianceData;
    }
}

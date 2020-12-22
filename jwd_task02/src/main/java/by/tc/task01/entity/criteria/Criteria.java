package by.tc.task01.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Criteria {

    private String groupSearchName;

    private Map<String, Object> criteria = new HashMap<String, Object>();

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public void add(String searchCriteria, Object value) {
        if (value.toString().matches("[\\d]*[.][0]*"))
            criteria.put(searchCriteria, Math.round((Double) value));
        else
            criteria.put(searchCriteria, value);
    }

    // you may add your own code here
    public Map<String, Object> getCriteria() {
        return criteria;
    }

    public List<String> regexCriteria() {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            if(entry.getValue() instanceof Number) {
                list.add(this.groupSearchName + ".*\\b" + entry.getKey() + "=" + entry.getValue() +"[0.]*"+ "\\b[,\\s].*");
            }
            else{
                list.add(this.groupSearchName + ".*\\b" + entry.getKey() + "=" + entry.getValue() + "\\b.*");
            }

        }
        return list;
    }

}

package cxp.ingest;

/**
 * Created by markmo on 13/04/15.
 */
public class EventPropertyType {

    private int id;
    private String name;
    private SecurityClassification securityClassification;
    private String valueTypeName;
    private String description;
    private String mappingExpression;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SecurityClassification getSecurityClassification() {
        return securityClassification;
    }

    public String getValueTypeName() {
        return valueTypeName;
    }

    public String getDescription() {
        return description;
    }

    public String getMappingExpression() {
        return mappingExpression;
    }
}

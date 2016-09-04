package cxp.ingest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by markmo on 4/04/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventType {

    private int id;
    private String name;
    private String namespace;
    private String description;
    private String valueTypeName;
    private String nestedDocumentExpression;
    private Integer customerIdType1Id;
    private String customerIdExpression1;
    private Integer customerIdType2Id;
    private String customerIdExpression2;
    private String filterExpression;
    private String valueExpression;
    private String tsExpression;
    private String datetimeFormat;
    private String timezone;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getDescription() {
        return description;
    }

    public String getValueTypeName() {
        return valueTypeName;
    }

    public String getNestedDocumentExpression() {
        return nestedDocumentExpression;
    }

    public Integer getCustomerIdType1Id() {
        return customerIdType1Id;
    }

    public String getCustomerIdExpression1() {
        return customerIdExpression1;
    }

    public Integer getCustomerIdType2Id() {
        return customerIdType2Id;
    }

    public String getCustomerIdExpression2() {
        return customerIdExpression2;
    }

    public String getFilterExpression() {
        return filterExpression;
    }

    public String getValueExpression() {
        return valueExpression;
    }

    public String getTsExpression() {
        return tsExpression;
    }

    public String getDatetimeFormat() {
        return datetimeFormat;
    }

    public String getTimezone() {
        return timezone;
    }
}

package cxp.ingest;

/**
 * Created by markmo on 13/04/15.
 */
public class CustomerEventProperty {

    private int propertyTypeId;
    private String valueTypeName;
    private String value;

    public CustomerEventProperty(int propertyTypeId, String valueTypeName, String value) {
        this.propertyTypeId = propertyTypeId;
        this.valueTypeName = valueTypeName;
        this.value = value;
    }

    public int getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(int propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    public String getValueTypeName() {
        return valueTypeName;
    }

    public void setValueTypeName(String valueTypeName) {
        this.valueTypeName = valueTypeName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

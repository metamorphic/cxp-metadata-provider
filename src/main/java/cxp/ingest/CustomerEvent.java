package cxp.ingest;

import com.google.common.base.Joiner;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markmo on 4/04/15.
 */
public class CustomerEvent {

    private int customerIdTypeId;
    private String customerId;
    private int eventTypeId;
    private String valueTypeName;
    private Object value;
    private LocalDateTime ts;
    private Long jobId;
    private List<CustomerEventProperty> properties;
    private String sourceKey;

    public CustomerEvent(int customerIdTypeId, String customerId, int eventTypeId, String valueTypeName, Object value, LocalDateTime ts, Long jobId, String sourceKey) {
        this.customerIdTypeId = customerIdTypeId;
        this.customerId = customerId;
        this.eventTypeId = eventTypeId;
        this.valueTypeName = valueTypeName;
        this.value = value;
        this.ts = ts;
        this.jobId = jobId;
        this.sourceKey = sourceKey;
    }

    public int getCustomerIdTypeId() {
        return customerIdTypeId;
    }

    public void setCustomerIdTypeId(int customerIdTypeId) {
        this.customerIdTypeId = customerIdTypeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getValueTypeName() {
        return valueTypeName;
    }

    public void setValueTypeName(String valueTypeName) {
        this.valueTypeName = valueTypeName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public LocalDateTime getTs() {
        return ts;
    }

    public void setTs(LocalDateTime ts) {
        this.ts = ts;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public List<CustomerEventProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<CustomerEventProperty> properties) {
        this.properties = properties;
    }

    public void addProperty(CustomerEventProperty property) {
        if (properties == null) {
            properties = new ArrayList<>();
        }
        properties.add(property);
    }

    public String getSourceKey() {
        return sourceKey;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }

    public String inspect() {
        return "{customerIdTypeId: " + customerIdTypeId + ", customerId: \"" + customerId + "\", eventTypeId: " + eventTypeId + ", value: \"" + value + "\", ts: \"" + ts + "\"}";
    }

    @Override
    public String toString() {
        return Joiner.on(',').join(customerIdTypeId, customerId, eventTypeId, ts, 1, value);
    }
}

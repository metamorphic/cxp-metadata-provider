package cxp.ingest;


/**
 * Created by markmo on 30/04/15.
 */
public class Error {

    private String message;
    private boolean skipped;
    private Integer eventTypeId;
    private Long datasetId;
    private String sourceKey;
    private String value;

    public Error(String message, boolean skipped, Integer eventTypeId,
                 Long datasetId, String sourceKey, String value) {
        this.message = message;
        this.skipped = skipped;
        this.eventTypeId = eventTypeId;
        this.datasetId = datasetId;
        this.sourceKey = sourceKey;
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSkipped() {
        return skipped;
    }

    public void setSkipped(boolean skipped) {
        this.skipped = skipped;
    }

    public Integer getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public Long getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Long datasetId) {
        this.datasetId = datasetId;
    }

    public String getSourceKey() {
        return sourceKey;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Error{" +
                "message='" + message + '\'' +
                ", skipped=" + skipped +
                ", eventTypeId=" + eventTypeId +
                ", datasetId=" + datasetId +
                ", sourceKey='" + sourceKey + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

package cxp.ingest;

import java.util.Date;

/**
 * Created by markmo on 14/04/15.
 */
public class Job {

    enum Status {
        RUNNING,
        FINISHED,
        ERROR
    }

    private Long id;
    private Long datasetId;
    private String dataset;
    private String sourceFilename;
    private String processName;
    private Date start;
    private Date end;
    private Status status;
    private String exitMessage;
    private Long recordsProcessed;
    private Long recordsSkipped;
    private Long eventsCreated;
    private Long errorsLogged;

    public Job() {
        this.start = new Date();
        this.status = Status.RUNNING;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Long datasetId) {
        this.datasetId = datasetId;
        this.dataset = "http://localhost:8080/api/file-datasets/" + datasetId;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public String getSourceFilename() {
        return sourceFilename;
    }

    public void setSourceFilename(String sourceFilename) {
        this.sourceFilename = sourceFilename;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getExitMessage() {
        return exitMessage;
    }

    public void setExitMessage(String exitMessage) {
        this.exitMessage = exitMessage;
    }

    public Long getRecordsProcessed() {
        return recordsProcessed;
    }

    public void setRecordsProcessed(Long recordsProcessed) {
        this.recordsProcessed = recordsProcessed;
    }

    public Long getRecordsSkipped() {
        return recordsSkipped;
    }

    public void setRecordsSkipped(Long recordsSkipped) {
        this.recordsSkipped = recordsSkipped;
    }

    public Long getEventsCreated() {
        return eventsCreated;
    }

    public void setEventsCreated(Long eventsCreated) {
        this.eventsCreated = eventsCreated;
    }

    public Long getErrorsLogged() {
        return errorsLogged;
    }

    public void setErrorsLogged(Long errorsLogged) {
        this.errorsLogged = errorsLogged;
    }
}

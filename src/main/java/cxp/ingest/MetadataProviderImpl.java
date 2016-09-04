package cxp.ingest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;
import java.util.Map;

/**
 * Created by markmo on 11/04/15.
 */
public class MetadataProviderImpl implements MetadataProvider {

    private static final Log log = LogFactory.getLog(MetadataProviderImpl.class);

    static final String JSON_TYPE = "JSON";

    JdbcTemplate jdbcTemplate;
    RestTemplate restTemplate;

    String datasetUrl;
    String idResolutionUrl;
    String jobUrl;
    String testJobUrl;
    String dateFormatsUrl;

    FileDataset fileDataset;
    String filename;

    Job job;
    URI jobEntity;
    Long jobId;
    Long recordsProcessed = 0L;
    Long recordsSkipped = 0L;
    Long eventsCreated = 0L;
    Long errorsLogged = 0L;
    boolean test = true;

    private static final String PROCESS_NAME = "cxp-ingest-1.0";

    private static final String INSERT_ERROR_SQL = "INSERT INTO meta.err_events (error_message, skipped, event_type_id, dataset_id, source_filename, source_key, value, job_id, process_name, created_ts) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public void setFilename(String filename) {
        this.filename = filename;
        restTemplate = new RestTemplate();
        fileDataset = restTemplate.getForObject(datasetUrl + filename, FileDataset.class);
    }

    public boolean isJson() {
        return fileDataset != null && JSON_TYPE.equals(fileDataset.getFileType());
    }

    public String[] getDateFormats() {
        Map setting = restTemplate.getForObject(dateFormatsUrl, Map.class);
        String formats = (String)setting.get("value");
        return formats.split("\\n");
    }

    // TODO
    // there is already useful job information written by Spring Batch
    // look to extend
    public void startJob() {
        RestTemplate restTemplate = new RestTemplate();
        job = new Job();
        String url = test ? testJobUrl : jobUrl;
        jobEntity = restTemplate.postForLocation(url, job);
        String jobStr = jobEntity.toString();
        jobId = Long.parseLong(jobStr.substring(jobStr.lastIndexOf('/') + 1));
        recordsProcessed = 0L;
        recordsSkipped = 0L;
        eventsCreated = 0L;
        errorsLogged = 0L;
    }

    public void endJob() {
        RestTemplate restTemplate = new RestTemplate();

        // TODO
        // job ref is lost when job is restarted from Spring XD Admin

        // TODO
        // should be done at start of job
        job.setDatasetId(fileDataset.getId());

        // remove .processing suffix
        String fname = filename.substring(0, filename.lastIndexOf(".processing"));
        job.setSourceFilename(fname);

        job.setProcessName(PROCESS_NAME);
        job.setEnd(new Date());
        job.setStatus(Job.Status.FINISHED);
        job.setRecordsProcessed(recordsProcessed);
        job.setRecordsSkipped(recordsSkipped);
        job.setEventsCreated(eventsCreated);
        job.setErrorsLogged(errorsLogged);
        restTemplate.put(jobEntity, job);
    }

    public void writeError(Error error) {
        if (jdbcTemplate != null) {
            if (log.isDebugEnabled()) {
                log.debug("Writing error:");
                log.debug(INSERT_ERROR_SQL);
                log.debug(error);
            }
            jdbcTemplate.update(INSERT_ERROR_SQL,
                    error.getMessage(), error.isSkipped(),
                    error.getEventTypeId(), error.getDatasetId(),
                    filename, error.getSourceKey(), error.getValue(),
                    jobId, PROCESS_NAME);
            errorsLogged += 1;
        }
    }

    public void incrementRecordsProcessed(int k) {
        recordsProcessed += k;
    }

    public void incrementRecordsSkipped(int k) {
        recordsSkipped += k;
    }

    public void incrementEventsCreated(int k) {
        eventsCreated += k;
    }

    public FileDataset getFileDataset() {
        return fileDataset;
    }

    public String getFilename() {
        return filename;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setDatasetUrl(String datasetUrl) {
        this.datasetUrl = datasetUrl;
    }

    public void setIdResolutionUrl(String idResolutionUrl) {
        this.idResolutionUrl = idResolutionUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    public void setTestJobUrl(String testJobUrl) {
        this.testJobUrl = testJobUrl;
    }

    public void setDateFormatsUrl(String dateFormatsUrl) {
        this.dateFormatsUrl = dateFormatsUrl;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

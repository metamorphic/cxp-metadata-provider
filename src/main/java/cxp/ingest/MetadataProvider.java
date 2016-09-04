package cxp.ingest;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by markmo on 13/06/15.
 */
public interface MetadataProvider {

    boolean isTest();

    void setTest(boolean test);

    void setFilename(String filename);

    boolean isJson();

    String[] getDateFormats();

    void startJob();

    void endJob();

    void writeError(Error error);

    void incrementRecordsProcessed(int k);

    void incrementRecordsSkipped(int k);

    void incrementEventsCreated(int k);

    FileDataset getFileDataset();

    String getFilename();

    Long getJobId();

    void setDatasetUrl(String datasetUrl);

    void setIdResolutionUrl(String idResolutionUrl);

    void setJobUrl(String jobUrl);

    void setTestJobUrl(String testJobUrl);

    void setDateFormatsUrl(String dateFormatsUrl);

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}

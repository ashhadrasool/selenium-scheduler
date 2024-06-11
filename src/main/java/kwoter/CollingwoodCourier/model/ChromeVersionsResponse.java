package kwoter.CollingwoodCourier.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class ChromeVersionsResponse {

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("versions")
    private List<Version> versions;

    // Getters and setters

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }


    public static class Version {

        @JsonProperty("version")
        private String version;

        @JsonProperty("revision")
        private String revision;

        @JsonProperty("downloads")
        private Map<String, List<Download>> downloads;

        // Getters and setters

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getRevision() {
            return revision;
        }

        public void setRevision(String revision) {
            this.revision = revision;
        }

        public Map<String, List<Download>> getDownloads() {
            return downloads;
        }

        public void setDownloads(Map<String, List<Download>> downloads) {
            this.downloads = downloads;
        }
    }
    public static class Download {

        @JsonProperty("platform")
        private String platform;

        @JsonProperty("url")
        private String url;

        // Getters and setters

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}

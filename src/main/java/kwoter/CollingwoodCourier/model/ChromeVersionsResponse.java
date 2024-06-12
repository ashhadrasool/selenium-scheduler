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


    public static class Version implements Comparable {

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


        @Override
        public int compareTo(Object o) {

            if(o.getClass()!=Version.class && o.getClass()!=String.class){
                return -1;
            }
            String a = this.getVersion();
            String b = "";

            if(o.getClass()==Version.class){
                b = ((Version) o).getVersion();
            }else if(o.getClass()==String.class){
                b = (String) o;
            }

            String[] aSplit = a.split("\\.");
            aSplit[3] = String.format("%4s", aSplit[3]).replace(' ', '0');
            Long numA = Long.valueOf(aSplit[0]+aSplit[1]+aSplit[2]+aSplit[3]);

            String[] bSplit = b.split("\\.");
            bSplit[3] = String.format("%4s", bSplit[3]).replace(' ', '0');
            Long numB = Long.valueOf(bSplit[0]+bSplit[1]+bSplit[2]+bSplit[3]);

            return Long.compare(numA, numB);
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

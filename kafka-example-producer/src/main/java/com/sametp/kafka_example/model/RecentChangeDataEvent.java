
package com.sametp.kafka_example.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecentChangeDataEvent {
    @JsonProperty("$schema")
    private String $schema;
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("namespace")
    private Long namespace;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("parsedcomment")
    private String parsedcomment;
    @JsonProperty("category")
    private String category;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("user")
    private String user;
    @JsonProperty("bot")
    private Boolean bot;
    @JsonProperty("server_url")
    private String serverUrl;
    @JsonProperty("server_name")
    private String serverName;
    @JsonProperty("server_script_path")
    private String serverScriptPath;
    @JsonProperty("wiki")
    private String wiki;
    @JsonProperty("minor")
    private Boolean minor;
    @JsonProperty("patrolled")
    private Boolean patrolled;
    @JsonProperty("length")
    private Length length;
    @JsonProperty("revision")
    private Revision revision;
    @JsonProperty("log_id")
    private Long logId;
    @JsonProperty("log_type")
    private String logType;
    @JsonProperty("log_action")
    private String logAction;
    @JsonProperty("log_action_comment")
    private String logActionComment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)

    public static class Revision {

        @JsonProperty("new")
        private Long _new;
        @JsonProperty("old")
        private Long old;

    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)

    public static class Meta {
        @JsonProperty("uri")
        private String uri;
        @JsonProperty("request_id")
        private String requestId;
        @JsonProperty("id")
        private String id;
        @JsonProperty("dt")
        private Date dt;
        @JsonProperty("domain")
        private String domain;
        @JsonProperty("stream")
        private String stream;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)

    public static class Length {
        @JsonProperty("old")
        private Long old;
        @JsonProperty("new")
        private Long _new;


    }
}
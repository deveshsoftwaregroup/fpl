package com.sportmgmt.api.football.response;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "time",
    "home_scorer",
    "score",
    "away_scorer"
})
public class Goalscorer {

    @JsonProperty("time")
    private String time;
    @JsonProperty("home_scorer")
    private String homeScorer;
    @JsonProperty("score")
    private String score;
    @JsonProperty("away_scorer")
    private String awayScorer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("home_scorer")
    public String getHomeScorer() {
        return homeScorer;
    }

    @JsonProperty("home_scorer")
    public void setHomeScorer(String homeScorer) {
        this.homeScorer = homeScorer;
    }

    @JsonProperty("score")
    public String getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(String score) {
        this.score = score;
    }

    @JsonProperty("away_scorer")
    public String getAwayScorer() {
        return awayScorer;
    }

    @JsonProperty("away_scorer")
    public void setAwayScorer(String awayScorer) {
        this.awayScorer = awayScorer;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

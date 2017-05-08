package com.sportmgmt.api.football.response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "match_id",
    "country_id",
    "country_name",
    "league_id",
    "league_name",
    "match_date",
    "match_status",
    "match_time",
    "match_hometeam_name",
    "match_hometeam_score",
    "match_awayteam_name",
    "match_awayteam_score",
    "match_live",
    "goalscorer"
})
public class MatchDetail {

    @JsonProperty("match_id")
    private String matchId;
    @JsonProperty("country_id")
    private String countryId;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("league_id")
    private String leagueId;
    @JsonProperty("league_name")
    private String leagueName;
    @JsonProperty("match_date")
    private String matchDate;
    @JsonProperty("match_status")
    private String matchStatus;
    @JsonProperty("match_time")
    private String matchTime;
    @JsonProperty("match_hometeam_name")
    private String matchHometeamName;
    @JsonProperty("match_hometeam_score")
    private String matchHometeamScore;
    @JsonProperty("match_awayteam_name")
    private String matchAwayteamName;
    @JsonProperty("match_awayteam_score")
    private String matchAwayteamScore;
    @JsonProperty("match_live")
    private String matchLive;
    @JsonProperty("goalscorer")
    private List<Goalscorer> goalscorer = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("match_id")
    public String getMatchId() {
        return matchId;
    }

    @JsonProperty("match_id")
    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    @JsonProperty("country_id")
    public String getCountryId() {
        return countryId;
    }

    @JsonProperty("country_id")
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("country_name")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("country_name")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("league_id")
    public String getLeagueId() {
        return leagueId;
    }

    @JsonProperty("league_id")
    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    @JsonProperty("league_name")
    public String getLeagueName() {
        return leagueName;
    }

    @JsonProperty("league_name")
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    @JsonProperty("match_date")
    public String getMatchDate() {
        return matchDate;
    }

    @JsonProperty("match_date")
    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    @JsonProperty("match_status")
    public String getMatchStatus() {
        return matchStatus;
    }

    @JsonProperty("match_status")
    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    @JsonProperty("match_time")
    public String getMatchTime() {
        return matchTime;
    }

    @JsonProperty("match_time")
    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    @JsonProperty("match_hometeam_name")
    public String getMatchHometeamName() {
        return matchHometeamName;
    }

    @JsonProperty("match_hometeam_name")
    public void setMatchHometeamName(String matchHometeamName) {
        this.matchHometeamName = matchHometeamName;
    }

    @JsonProperty("match_hometeam_score")
    public String getMatchHometeamScore() {
        return matchHometeamScore;
    }

    @JsonProperty("match_hometeam_score")
    public void setMatchHometeamScore(String matchHometeamScore) {
        this.matchHometeamScore = matchHometeamScore;
    }

    @JsonProperty("match_awayteam_name")
    public String getMatchAwayteamName() {
        return matchAwayteamName;
    }

    @JsonProperty("match_awayteam_name")
    public void setMatchAwayteamName(String matchAwayteamName) {
        this.matchAwayteamName = matchAwayteamName;
    }

    @JsonProperty("match_awayteam_score")
    public String getMatchAwayteamScore() {
        return matchAwayteamScore;
    }

    @JsonProperty("match_awayteam_score")
    public void setMatchAwayteamScore(String matchAwayteamScore) {
        this.matchAwayteamScore = matchAwayteamScore;
    }

    @JsonProperty("match_live")
    public String getMatchLive() {
        return matchLive;
    }

    @JsonProperty("match_live")
    public void setMatchLive(String matchLive) {
        this.matchLive = matchLive;
    }

    @JsonProperty("goalscorer")
    public List<Goalscorer> getGoalscorer() {
        return goalscorer;
    }

    @JsonProperty("goalscorer")
    public void setGoalscorer(List<Goalscorer> goalscorer) {
        this.goalscorer = goalscorer;
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

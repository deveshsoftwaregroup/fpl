package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PLAYER_GROUP")
public class PlayerGroup {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="PLAYER_GROUP_ID")
	private Integer playerGroupId;
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="GAME_WEEK_ID")
	private Integer gameWeekId;
	
	@Column(name="GROUP_NAME")
	private String groupName;
	
	@Column(name="GROUP_TYPE")
	private String groupType;
	
	@Column(name="FIELD1")
	private Integer field1;
	
	@Column(name="FILED2")
	private String field2;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="PLAYER_GROUP_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private List<PlayerGroupPlayer> playerList;

	public Integer getPlayerGroupId() {
		return playerGroupId;
	}

	public void setPlayerGroupId(Integer playerGroupId) {
		this.playerGroupId = playerGroupId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public Integer getField1() {
		return field1;
	}

	public void setField1(Integer field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public List<PlayerGroupPlayer> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<PlayerGroupPlayer> playerList) {
		this.playerList = playerList;
	}

	public Integer getGameWeekId() {
		return gameWeekId;
	}

	public void setGameWeekId(Integer gameWeekId) {
		this.gameWeekId = gameWeekId;
	}
	
	
}

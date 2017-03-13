package com.sportmgmt.utility.constrant;

public class QueryConstrant {
public static final String FROM_COUNTRY_STATE_CITY = "FROM CountryStateCity";
public static final String SELECT_ACTIVE_GAME = "FROM Game G WHERE G.isActive =:isActive";
public static final String SELECT_MATCH_BY_GAME = "FROM Match M WHERE M.game =:game";
public static final String SELECT_POINT_BY_GAME = "FROM Point P WHERE P.gameId =:gameId";
public static final String SELECT_PLAYERS_CLUBD_OF_EVENT = "select * from GAME_CLUB_PLAYER where GAME_ID=:gameId";
public static final String SELECT_USER_PLAYER_LIST = "select gcp.game_club_player_id from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
														+" and gcp.game_id =:gameId";
public static final String SELECT_USER_PLAYER_DETAIL_LIST = "select gcp.game_club_player_id, gcp.playing_position, up.is_playing, up.user_player_id,up.player_category,up.seq_num from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
		+" and gcp.game_id =:gameId";

public static final String SELECT_TOTAL_PLAYER_BY_POSITION = "select gcp.playing_position, count(*) from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId"
															 +" and gcp.game_id =:gameId group by gcp.playing_position";

public static final String SELECT_TOTAL_PLAYING_PLAYER_BY_POSITION = "select gcp.playing_position, count(*) from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId"
		 +" and gcp.game_id =:gameId and up.is_playing=:isPlaying group by gcp.playing_position";

public static final String SELECT_USER_TOTAL_PLAYER = "select count(*) from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
		+" and gcp.game_id =:gameId";

public static final String SELECT_USER_TOTAL_ACTIVE_PLAYER = "select count(*) from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
		+" and gcp.game_id =:gameId and up.is_playing=:isPlaying";

public static final String SELECT_USER_PLAYER_TOTAL_PRICE = "select sum(gcp.price) from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
		+" and gcp.game_id =:gameId";

public static final String INSERT_DEFAULT_USER_PLAN = "INSERT INTO USER_PLAN(USER_ID,PLAN_ID,USER_PLAN_DESC,IS_ACTIVE,BALANCE_AMOUNT,PLAN_CURRENCY) VALUES"+
		" (:userId,(SELECT PLAN_ID FROM LEAGUE_PLANS WHERE PLAN_NAME = 'DEFAULT' AND IS_ACTIVE = 'Y'),'Free plan on registration','Y',(SELECT PLAN_AMOUNT FROM LEAGUE_PLANS WHERE"+ 
		" PLAN_NAME = 'DEFAULT' AND IS_ACTIVE = 'Y'),(SELECT PLAN_CURRENCY FROM LEAGUE_PLANS WHERE PLAN_NAME = 'DEFAULT' AND IS_ACTIVE = 'Y'))";

public static final String FETCH_CURRENT_GAME_WEEK = "select game_week_id,start_date from GAME_WEEK where start_date <= :date and end_date >= :date and game_id = :gameId";

public static final String FETCH_START_GAME_WEEK = "select game_week_id,start_date from GAME_WEEK where start_date = (select min(start_date) from GAME_WEEK where start_date > :date and game_id=:gameId) ";

public static final String FETCH_START_MATCH_TIME_OF_GAME_WEEK = "select start_time from MATCH_DETAIL where start_time = (select min(start_time) from MATCH_DETAIL where game_week_id = :gameWeekId)";

public static final String FETCH_END_MATCH_TIME_OF_GAME_WEEK = "select start_time from MATCH_DETAIL where end_time = (select max(end_time) from MATCH_DETAIL where game_week_id = :gameWeekId)";

public static final String FETCH_SORTED_GAME_WEEK = "select game_week_id from GAME_WEEK where game_Id=:gameId order by start_date";

public static final String FETCH_START_AND_END_DATE_OF_GAME_WEEK = "select start_date, end_date from GAME_WEEK where game_week_id=:gameWeekId";

public static final String FETCH_END_DATE_LIST_OF_GAME_WEEK_FROM_TODAY = "select end_date from game_week where (end_date > :date  and start_date < :date ) or (start_date > :date) order by start_date";

public static final String MAKE_USER_PLAN_INACTIVE = "update user_plan set is_active = 'N' where user_id = :userId";

public static final String SELECT_COUNT_OF_PLAYER_BY_USER = "select game_club_player_id,count(*) as user_count from USER_PLAYER where game_club_player_id in (:gameClubPlayerIdList) group by game_club_player_id order by user_count";

public static final String SELECT_PLAYER_WITH_PRICE_IN_ORDER = "select game_club_player_id,price from GAME_CLUB_PLAYER where game_club_player_id in (:gameClubPlayerIdList) order by price";

public static final String SELECT_PLAYER_WITH_TOTAL_POINT_IN_ORDER = "select game_club_player_id,PLAYER_TOTAL_POINT from GAME_CLUB_PLAYER where game_club_player_id in (:gameClubPlayerIdList) order by PLAYER_TOTAL_POINT";

public static final String SELECT_TOTAL_USER_FOR_GAME = "select count(distinct user_id) from USER_PLAYER";

public static final String SELECT_TOTAL_POINT_AND_RANK_OF_USER = "select USER_TOTAL_POINT, RANK from OVERALL_RANK where game_Id=:gameId and user_id=:userId";

public static final String SELECT_LAST_GAME_WEEK = "select game_week_id from GAME_WEEK where end_date = (select max(end_date) from GAME_WEEK where end_date < :date and game_id =:gameId)";

public static final String SELECT_GAME_WEEK_HISTORY_PLAYER_GROUP = "select * from PLAYER_GROUP where USER_ID=:userId and GAME_WEEK_ID=:gameWeekId";
 
public static final String SELECT_USERS_OF_GAME = "select distinct(up.USER_ID) from USER_PLAYER up,GAME_CLUB_PLAYER gcp where gcp.game_id =:gameId and up.GAME_CLUB_PLAYER_ID=gcp.GAME_CLUB_PLAYER_ID";

public static final String SELECT_PLAYER_GROUP = "FROM PlayerGroup PLG WHERE PLG.userId =:userId AND PLG.gameWeekId=:gameWeekId AND PLG.groupType=:groupType";

public static final String SELECT_HIEGHEST_RANK_OF_GAME_WEEK = "select max(week_rank) from game_week_report where game_week_id =:gameWeekId";

public static final String SELECT_AVERAGE_RANK_OF_GAME_WEEK = "select avg(week_rank) from game_week_report where game_week_id =:gameWeekId";

public static final String SELECT_HIEGHEST_POINT_OF_GAME_WEEK = "select max(week_point) from game_week_report where game_week_id =:gameWeekId";

public static final String SELECT_AVERAGE_POINT_OF_GAME_WEEK = "select avg(week_point) from game_week_report where game_week_id =:gameWeekId";
}

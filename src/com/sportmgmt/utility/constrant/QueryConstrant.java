package com.sportmgmt.utility.constrant;

public class QueryConstrant {
public static final String FROM_COUNTRY_STATE_CITY = "FROM CountryStateCity";
public static final String FROM_CLUB = "FROM Club";
public static final String FROM_V_ARTICLE = "FROM V_Article V WHERE V.position_price_id=:position_price_id";
public static final String SELECT_ACTIVE_GAME = "FROM Game G WHERE G.isActive =:isActive";
public static final String SELECT_POSITION_ID_BY_PAGENAME = "select POSITION_ID from V_POSITION P WHERE P.PAGE_NAME =:page_name";
public static final String SELECT_POSITION_PRICE_ID_BY_POSITION_ID = "select POSITION_PRICE_ID from V_POSITION_PRICE P WHERE P.POSITION_ID =:position_id order by P.POSITION_PRIORITY desc";
public static final String SELECT_POSITION_ID_BY_VENDOR_ID = "select DISTINCT POSITION_ID from V_VENDOR_POSITION P WHERE P.VENDOR_ID =:vendorId";
public static final String SELECT_POSITION_PRICE_ID_BY_VENDOR_ID = "select DISTINCT POSITION_PRICE_ID from V_VENDOR_POSITION P WHERE P.VENDOR_ID =:vendorId";
public static final String SELECT_ARTICLE_ID_BY_VENDOR_ID = "select DISTINCT ARTICLE_ID from V_ARTICLE P WHERE P.VENDOR_ID =:vendorId";
public static final String SELECT_POSITION_CODE_BY_POSITION_ID = "select POSITION_CODE from V_POSITION P WHERE P.POSITION_ID =:position_id";
public static final String SELECT_MATCH_BY_GAME = "FROM Match M WHERE M.game =:game";
public static final String SELECT_POINT_BY_GAME = "FROM Point P WHERE P.gameId =:gameId";
public static final String SELECT_PLAYERS_CLUBD_OF_EVENT = "select * from GAME_CLUB_PLAYER where GAME_ID=:gameId";
public static final String SELECT_USER_PLAYER_LIST = "select gcp.game_club_player_id from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
														+" and gcp.game_id =:gameId";
public static final String SELECT_USER_PLAYER_DETAIL_LIST = "select gcp.game_club_player_id, gcp.playing_position, up.is_playing, up.user_player_id,up.player_category,up.seq_num from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
		+" and gcp.game_id =:gameId";
public static final String SELECT_USER_PLAYER_DETAIL_LIST_ELEVEN = "select gcp.game_club_player_id, gcp.playing_position, up.is_playing, up.user_player_id,up.player_category,up.seq_num from GAME_CLUB_PLAYER gcp, D_EL_USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
		+" and gcp.game_id =:gameId";

public static final String SELECT_TOTAL_PLAYER_BY_POSITION = "select gcp.playing_position, count(*) from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId"
															 +" and gcp.game_id =:gameId group by gcp.playing_position";
public static final String SELECT_TOTAL_PLAYER_BY_POSITION_D_EL = "select gcp.playing_position, count(*) from GAME_CLUB_PLAYER gcp, D_EL_USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId"
		 +" and gcp.game_id =:gameId group by gcp.playing_position";

public static final String SELECT_TOTAL_PLAYING_PLAYER_BY_POSITION = "select gcp.playing_position, count(*) from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId"
		 +" and gcp.game_id =:gameId and up.is_playing=:isPlaying group by gcp.playing_position";

public static final String SELECT_TOTAL_PLAYING_PLAYER_BY_POSITION_D_EL = "select gcp.playing_position, count(*) from GAME_CLUB_PLAYER gcp, D_EL_USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId"
		 +" and gcp.game_id =:gameId and up.is_playing=:isPlaying group by gcp.playing_position";
public static final String SELECT_USER_TOTAL_PLAYER = "select count(*) from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
		+" and gcp.game_id =:gameId";
public static final String SELECT_USER_TOTAL_PLAYER_D_EL = "select count(*) from GAME_CLUB_PLAYER gcp, D_EL_USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
		+" and gcp.game_id =:gameId";

public static final String SELECT_USER_TOTAL_ACTIVE_PLAYER = "select count(*) from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
		+" and gcp.game_id =:gameId and up.is_playing=:isPlaying";

public static final String SELECT_USER_PLAYER_TOTAL_PRICE = "select sum(gcp.price) from GAME_CLUB_PLAYER gcp, USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
		+" and gcp.game_id =:gameId";
public static final String SELECT_USER_PLAYER_TOTAL_PRICE_D_EL = "select sum(gcp.price) from GAME_CLUB_PLAYER gcp, D_EL_USER_PLAYER up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =:userId" 
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

public static final String FETCH_END_DATE_LIST_OF_GAME_WEEK_FROM_TODAY = "select end_date from GAME_WEEK where (end_date > :date  and start_date < :date ) or (start_date > :date) order by start_date";

public static final String MAKE_USER_PLAN_INACTIVE = "update USER_PLAN set is_active = 'N' where user_id = :userId";

public static final String SELECT_COUNT_OF_PLAYER_BY_USER = "select game_club_player_id,count(*) as user_count from USER_PLAYER where game_club_player_id in (:gameClubPlayerIdList) group by game_club_player_id order by user_count";

public static final String SELECT_PLAYER_WITH_PRICE_IN_ORDER = "select game_club_player_id,price from GAME_CLUB_PLAYER where game_club_player_id in (:gameClubPlayerIdList) order by price desc";

public static final String SELECT_PLAYER_WITH_TOTAL_POINT_IN_ORDER = "select game_club_player_id,PLAYER_TOTAL_POINT from GAME_CLUB_PLAYER where game_club_player_id in (:gameClubPlayerIdList) order by PLAYER_TOTAL_POINT";

public static final String SELECT_TOTAL_USER_FOR_GAME = "select count(distinct user_id) from USER_PLAYER";

public static final String SELECT_TOTAL_POINT_AND_RANK_OF_USER = "select USER_TOTAL_POINT, RANK from OVERALL_RANK where game_Id=:gameId and user_id=:userId";

public static final String SELECT_LAST_GAME_WEEK = "select game_week_id from GAME_WEEK where end_date = (select max(end_date) from GAME_WEEK where end_date < :date and game_id =:gameId)";

public static final String SELECT_GAME_WEEK_HISTORY_PLAYER_GROUP = "select * from PLAYER_GROUP where USER_ID=:userId and GAME_WEEK_ID=:gameWeekId";
 
public static final String SELECT_USERS_OF_GAME = "select distinct(up.USER_ID) from USER_PLAYER up,GAME_CLUB_PLAYER gcp where gcp.game_id =:gameId and up.GAME_CLUB_PLAYER_ID=gcp.GAME_CLUB_PLAYER_ID";

public static final String SELECT_USERS_OF_GAME_FOR_DE = "select distinct(up.USER_ID) from D_EL_USER_PLAYER up,GAME_CLUB_PLAYER gcp where gcp.game_id =:gameId and up.GAME_CLUB_PLAYER_ID=gcp.GAME_CLUB_PLAYER_ID";

public static final String SELECT_PLAYER_GROUP = "FROM PlayerGroup PLG WHERE PLG.userId =:userId AND PLG.gameWeekId=:gameWeekId AND PLG.groupType=:groupType";

public static final String SELECT_HIEGHEST_RANK_OF_GAME_WEEK = "select max(week_rank) from GAME_WEEK_REPORT where game_week_id =:gameWeekId";

public static final String SELECT_AVERAGE_RANK_OF_GAME_WEEK = "select avg(week_rank) from GAME_WEEK_REPORT where game_week_id =:gameWeekId";

public static final String SELECT_HIEGHEST_POINT_OF_GAME_WEEK = "select max(week_point) from GAME_WEEK_REPORT where game_week_id =:gameWeekId";

public static final String SELECT_AVERAGE_POINT_OF_GAME_WEEK = "select avg(week_point) from GAME_WEEK_REPORT where game_week_id =:gameWeekId";

public static final String SELECT_TOTAL_LIMIT_OF_OFFER ="select limit_total from OFFER where user_id =:userId and game_id =:gameId and game_week_id =:gameWeekId and offer_type =:offerType and is_active = 'Y'";

public static final String SELECT_TOTAL_USED_OF_COUPON_LIST ="select coupon_id,count(*) from COUPON_USED where coupon_id in (:couponList) and game_week_id =:gameWeekId group by coupon_id";

public static final String SELECT_TOTAL_USED_OF_COUPON_FOR_GAME_WEEK ="select count(*) from COUPON_USED where coupon_id=:couponId and game_week_id =:gameWeekId";

public static final String SELECT_TOTAL_USED_COUPON_BY_USER_FOR_GAME_WEEK ="select count(*) from COUPON_USED where user_id=:userId and game_week_id =:gameWeekId";

public static final String SELECT_TOTAL_USED_COUPON_BY_USER_FOR_GAME_WEEK_BY_CATEGORY ="select count(*) from COUPON_USED where user_id=:userId and game_week_id =:gameWeekId and coupon_category_id=:couponCategoryId";

public static final String SELECT_PLAYERS_CLUBD_OF_GAME_FOR_MATCH = "select gcp.* from GAME_CLUB_PLAYER gcp,MATCH_DETAIL md where gcp.game_id =:gameId and md.match_id =:matchId and (gcp.club_id=md.club_one or gcp.club_id=md.club_two)";

public static final String SELECT_PLAYERS_IN_ORDER_BY_NAME = "select gcp.game_club_player_id from GAME_CLUB_PLAYER gcp,PLAYER pl where gcp.player_id = pl.player_id and gcp.game_club_player_id in (:gameClubPlayerIdList) order by pl.player_name";

public static final String SELECT_USER_LIST_OF_PLAYER = "select user_Id from USER_PLAYER where game_club_player_id =:gameClubPlayerId";

public static final String SELECT_PLANID_FROM_DE_GAME_WEEK_REPORT = "select V.planId from DeGameWeekReport V WHERE V.userId =:userId and V.gameWeekId =:gameWeekId  ";
}

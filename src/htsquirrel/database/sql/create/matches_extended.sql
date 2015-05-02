CREATE TABLE MATCHES_EXTENDED (
    MATCH_ID BIGINT,
    TEAM_ID INT,
    TEAM_NAME VARCHAR(255),
    OPPONENT_TEAM_ID INT,
    OPPONENT_TEAM_NAME VARCHAR(255),
    GOALS_FOR INT,
    GOALS_AGAINST INT,
    MATCH_TYPE INT,
    MATCH_CONTEXT_ID INT,
    LEAGUE_LEVEL_UNIT_ID INT,
    LEAGUE_LEVEL INT,
    LEAGUE_LEVEL_UNIT_NAME VARCHAR(255),
    CUP_NAME VARCHAR(255),
    CUP_LEAGUE_LEVEL INT,
    CUP_LEVEL INT,
    CUP_LEVEL_INDEX INT,
    SEASON INT,
    MATCH_DATE TIMESTAMP,
    FINISHED_DATE TIMESTAMP,
    VENUE VARCHAR(255),
    ARENA_ID INT,
    ARENA_NAME VARCHAR(255),
    SOLD_TOTAL INT,
    SOLD_TERRACES INT,
    SOLD_BASIC INT,
    SOLD_ROOF INT,
    SOLD_VIP INT,
    WEATHER_ID INT,
    DRESS_URI VARCHAR(255),
    FORMATION VARCHAR(255),
    TACTIC_TYPE INT,
    TACTIC_SKILL INT,
    TEAM_ATTITUDE INT,
    RATING_M INT,
    RATING_RD INT,
    RATING_CD INT,
    RATING_LD INT,
    RATING_RA INT,
    RATING_CA INT,
    RATING_LA INT,
    RATING_ISPD INT,
    RATING_ISPA INT,
    POSSESSION_1 INT,
    POSSESSION_2 INT,
    OPPONENT_DRESS_URI VARCHAR(255),
    OPPONENT_FORMATION VARCHAR(255),
    OPPONENT_TACTIC_TYPE INT,
    OPPONENT_TACTIC_SKILL INT,
    OPPONENT_RATING_M INT,
    OPPONENT_RATING_RD INT,
    OPPONENT_RATING_CD INT,
    OPPONENT_RATING_LD INT,
    OPPONENT_RATING_RA INT,
    OPPONENT_RATING_CA INT,
    OPPONENT_RATING_LA INT,
    OPPONENT_RATING_ISPD INT,
    OPPONENT_RATING_ISPA INT,
    OPPONENT_POSSESSION_1 INT,
    OPPONENT_POSSESSION_2 INT
)

INSERT INTO MATCHES_EXTENDED
SELECT

    T1.MATCH_ID,

    T1.TEAM_ID,
    T1.TEAM_NAME,
    T1.OPPONENT_TEAM_ID,
    T1.OPPONENT_TEAM_NAME,
    T1.GOALS_FOR,
    T1.GOALS_AGAINST,

    T1.MATCH_TYPE,
    T1.MATCH_CONTEXT_ID,

    T2.LEAGUE_LEVEL_UNIT_ID,
    T2.LEAGUE_LEVEL,
    T2.LEAGUE_LEVEL_UNIT_NAME,

    T3.CUP_NAME,
    T3.CUP_LEAGUE_LEVEL,
    T3.CUP_LEVEL,
    T3.CUP_LEVEL_INDEX,

    T1.SEASON,
    T1.MATCH_DATE,
    T1.FINISHED_DATE,

    T1.VENUE,
    T1.ARENA_ID,
    T1.ARENA_NAME,
    T1.SOLD_TOTAL,
    T1.SOLD_TERRACES,
    T1.SOLD_BASIC,
    T1.SOLD_ROOF,
    T1.SOLD_VIP,
    T1.WEATHER_ID,

    T1.DRESS_URI,
    T1.FORMATION,
    T1.TACTIC_TYPE,
    T1.TACTIC_SKILL,
    T1.TEAM_ATTITUDE,
    T1.RATING_M,
    T1.RATING_RD,
    T1.RATING_CD,
    T1.RATING_LD,
    T1.RATING_RA,
    T1.RATING_CA,
    T1.RATING_LA,
    T1.RATING_ISPD,
    T1.RATING_ISPA,
    T1.POSSESSION_1,
    T1.POSSESSION_2,
    T1.OPPONENT_DRESS_URI,
    T1.OPPONENT_FORMATION,
    T1.OPPONENT_TACTIC_TYPE,
    T1.OPPONENT_TACTIC_SKILL,
    T1.OPPONENT_RATING_M,
    T1.OPPONENT_RATING_RD,
    T1.OPPONENT_RATING_CD,
    T1.OPPONENT_RATING_LD,
    T1.OPPONENT_RATING_RA,
    T1.OPPONENT_RATING_CA,
    T1.OPPONENT_RATING_LA,
    T1.OPPONENT_RATING_ISPD,
    T1.OPPONENT_RATING_ISPA,
    T1.OPPONENT_POSSESSION_1,
    T1.OPPONENT_POSSESSION_2

FROM
    MATCH_DETAILS T1
LEFT JOIN
    LEAGUES T2
ON
    T1.TEAM_ID = T2.TEAM_ID
    AND T1.SEASON = T2.SEASON
LEFT JOIN
    CUPS T3
ON
    T1.TEAM_ID = T3.TEAM_ID
    AND T1.MATCH_TYPE = T3.MATCH_TYPE
    AND T1.MATCH_CONTEXT_ID = T3.CUP_ID

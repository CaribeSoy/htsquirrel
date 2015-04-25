SELECT
    T1.TEAM_ID,
    T1.SEASON,
    T2.MATCH_CONTEXT_ID
FROM
    (
        SELECT DISTINCT
            TEAM_ID,
            SEASON
        FROM
            MATCHES
        WHERE
            TEAM_ID = VALUE_TEAM_ID
    ) T1
LEFT JOIN
    (
        SELECT DISTINCT
            TEAM_ID,
            SEASON,
            MATCH_CONTEXT_ID
        FROM
            MATCHES
        WHERE
            MATCH_TYPE = 1
    ) T2
ON
    T1.TEAM_ID = T2.TEAM_ID
    AND T1.SEASON = T2.SEASON
ORDER BY
    T1.TEAM_ID,
    T1.SEASON

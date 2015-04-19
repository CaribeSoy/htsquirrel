SELECT
    *
FROM
    MATCHES T1
WHERE
    T1.TEAM_ID = VALUE_TEAM_ID AND
    NOT EXISTS
    (
        SELECT
            0
        FROM
            MATCH_DETAILS T2
        WHERE
            T2.TEAM_ID = T1.TEAM_ID AND
            T2.MATCH_ID = T1.MATCH_ID
    )

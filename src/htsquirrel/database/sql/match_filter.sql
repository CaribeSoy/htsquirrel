WHERE
    TEAM_ID = V_TEAM_ID
    AND (MATCH_TYPE = V_MATCH_TYPE_L
        OR MATCH_TYPE = V_MATCH_TYPE_Q
        OR MATCH_TYPE = V_MATCH_TYPE_HM
        OR MATCH_TYPE = V_MATCH_TYPE_FN
        OR MATCH_TYPE = V_MATCH_TYPE_FC
        OR MATCH_TYPE = V_MATCH_TYPE_IFN
        OR MATCH_TYPE = V_MATCH_TYPE_IFC
        OR (CUP_LEAGUE_LEVEL = 0 AND CUP_LEVEL = V_CUP_LEVEL_N)
        OR (CUP_LEAGUE_LEVEL = 0 AND CUP_LEVEL = 2 AND CUP_LEVEL_INDEX = V_CUP_LEVEL_INDEX_NE)
        OR (CUP_LEAGUE_LEVEL = 0 AND CUP_LEVEL = 2 AND CUP_LEVEL_INDEX = V_CUP_LEVEL_INDEX_NR)
        OR (CUP_LEAGUE_LEVEL = 0 AND CUP_LEVEL = 2 AND CUP_LEVEL_INDEX = V_CUP_LEVEL_INDEX_NS)
        OR (CUP_LEAGUE_LEVEL = 0 AND CUP_LEVEL = V_CUP_LEVEL_NC)
        OR (CUP_LEAGUE_LEVEL IN V_CUP_LEAGUE_LEVEL_D AND CUP_LEVEL = V_CUP_LEVEL_D)
        OR (CUP_LEAGUE_LEVEL IN V_CUP_LEAGUE_LEVEL_D AND CUP_LEVEL = 2 AND CUP_LEVEL_INDEX = V_CUP_LEVEL_INDEX_DE)
        OR (CUP_LEAGUE_LEVEL IN V_CUP_LEAGUE_LEVEL_D AND CUP_LEVEL = 2 AND CUP_LEVEL_INDEX = V_CUP_LEVEL_INDEX_DR)
        OR (CUP_LEAGUE_LEVEL IN V_CUP_LEAGUE_LEVEL_D AND CUP_LEVEL = 2 AND CUP_LEVEL_INDEX = V_CUP_LEVEL_INDEX_DS)
        OR (CUP_LEAGUE_LEVEL IN V_CUP_LEAGUE_LEVEL_D AND CUP_LEVEL = V_CUP_LEVEL_DC))
WHERE
    TEAM_ID = #team_id#
    AND (MATCH_TYPE = #match_type_l#
        OR MATCH_TYPE = #match_type_q#
        OR MATCH_TYPE = #match_type_hm#
        OR MATCH_TYPE = #match_type_fn#
        OR MATCH_TYPE = #match_type_fc#
        OR MATCH_TYPE = #match_type_ifn#
        OR MATCH_TYPE = #match_type_ifc#
        OR (CUP_LEAGUE_LEVEL = 0 AND CUP_LEVEL = #cup_level_n#)
        OR (CUP_LEAGUE_LEVEL = 0 AND CUP_LEVEL = 2 AND CUP_LEVEL_INDEX = #cup_level_index_ne#)
        OR (CUP_LEAGUE_LEVEL = 0 AND CUP_LEVEL = 2 AND CUP_LEVEL_INDEX = #cup_level_index_nr#)
        OR (CUP_LEAGUE_LEVEL = 0 AND CUP_LEVEL = 2 AND CUP_LEVEL_INDEX = #cup_level_index_ns#)
        OR (CUP_LEAGUE_LEVEL = 0 AND CUP_LEVEL = #cup_level_nc#)
        OR (CUP_LEAGUE_LEVEL IN #cup_league_level_d# AND CUP_LEVEL = #cup_level_d#)
        OR (CUP_LEAGUE_LEVEL IN #cup_league_level_d# AND CUP_LEVEL = 2 AND CUP_LEVEL_INDEX = #cup_level_index_de#)
        OR (CUP_LEAGUE_LEVEL IN #cup_league_level_d# AND CUP_LEVEL = 2 AND CUP_LEVEL_INDEX = #cup_level_index_dr#)
        OR (CUP_LEAGUE_LEVEL IN #cup_league_level_d# AND CUP_LEVEL = 2 AND CUP_LEVEL_INDEX = #cup_level_index_ds#)
        OR (CUP_LEAGUE_LEVEL IN #cup_league_level_d# AND CUP_LEVEL = #cup_level_dc#))
    AND SEASON BETWEEN #season_from# AND #season_to#
    AND MATCH_DATE BETWEEN '#match_date_from#' AND '#match_date_to#'
    AND LEAGUE_LEVEL BETWEEN #league_level_from# AND #league_level_to#
    AND LEAGUE_LEVEL_UNIT_NAME LIKE ('#league_level_unit_name#')
    AND VENUE IN #venue#
    AND SOLD_TOTAL BETWEEN #sold_total_from# AND #sold_total_to#
    AND SOLD_TERRACES BETWEEN #sold_terraces_from# AND #sold_terraces_to#
    AND SOLD_BASIC BETWEEN #sold_basic_from# AND #sold_basic_to#
    AND SOLD_ROOF BETWEEN #sold_roof_from# AND #sold_roof_to#
    AND SOLD_VIP BETWEEN #sold_vip_from# AND #sold_vip_to#
    AND WEATHER_ID IN #weather_id#
    AND (FORMATION IN #formation#
        OR FORMATION NOT IN ('5-5-0', '5-4-1', '5-3-2', '5-2-3', '4-5-1', '4-4-2', '4-3-3', '3-5-2', '3-4-3', '2-5-3'))
    AND (OPPONENT_FORMATION IN #opponent_formation#
        OR OPPONENT_FORMATION NOT IN ('5-5-0', '5-4-1', '5-3-2', '5-2-3', '4-5-1', '4-4-2', '4-3-3', '3-5-2', '3-4-3', '2-5-3'))
    AND ((TACTIC_TYPE IN #tactic_type_1# AND TACTIC_SKILL BETWEEN #tactic_skill_from# AND #tactic_skill_to#)
        OR TACTIC_TYPE IN #tactic_type_2#)
    AND TEAM_ATTITUDE IN #team_attitude#
    AND ((OPPONENT_TACTIC_TYPE IN #opponent_tactic_type_1# AND OPPONENT_TACTIC_SKILL BETWEEN #opponent_tactic_skill_from# AND #opponent_tactic_skill_to#)
        OR OPPONENT_TACTIC_TYPE IN #opponent_tactic_type_2#)

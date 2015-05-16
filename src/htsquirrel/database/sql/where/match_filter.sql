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

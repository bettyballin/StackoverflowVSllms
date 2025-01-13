SELECT ts.s_name, ts.description, \n       tl.l_name AS length_name, \n       tw.w_name AS width_name, \n       th.h_name AS height_name\nFROM table_solid ts\nJOIN table_s_l tsl ON ts.s_id = tsl.s_id\nJOIN table_length tl ON tsl.l_id = tl.l_id\nJOIN table_s_w tsw ON ts.s_id = tsw.s_id\nJOIN table_width tw ON tsw.w_id = tw.w_id\nJOIN table_s_h tsh ON ts.s_id = tsh.s_id\nJOIN table_height th ON tsh.h_id = th.h_id\nWHERE tl.l_name = 'specific_length' \n  AND tw.w_name = 'specific_width' \n  AND th.h_name = 'specific_height';
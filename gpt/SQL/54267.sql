SELECT \n    s.s_id, s.s_name, s.description, \n    l.l_name AS length, \n    w.w_name AS width, \n    h.h_name AS height\nFROM \n    table_solid s\nJOIN \n    table_s_l sl ON s.s_id = sl.s_id\nJOIN \n    table_length l ON sl.l_id = l.l_id\nJOIN \n    table_s_w sw ON s.s_id = sw.s_id\nJOIN \n    table_width w ON sw.w_id = w.w_id\nJOIN \n    table_s_h sh ON s.s_id = sh.s_id\nJOIN \n    table_height h ON sh.h_id = h.h_id\nWHERE \n    l.l_name = 'desired_length_value' AND\n    w.w_name = 'desired_width_value' AND\n    h.h_name = 'desired_height_value';
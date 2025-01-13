DECLARE\n  c_kilometers NUMBER;\n  cursor_t SYS_REFCURSOR;\nBEGIN\n  ...\n  FOR cur_rec IN cursor_t LOOP\n    SELECT t.kilometers + (SELECT g.kilometers \n                            FROM table_name \n                            WHERE l.code = cur_rec.code_aff) \n    INTO c_kilometers\n    FROM table_name \n    WHERE l.code = cur_rec.code_att;\n    ...\n  END LOOP;\nEND;
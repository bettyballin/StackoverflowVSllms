DECLARE\n    c_kilometers NUMBER;\n    temp_kilometers1 NUMBER;\n    temp_kilometers2 NUMBER;\nBEGIN\n    OPEN cursor_t;\n    LOOP\n        FETCH cursor_t INTO your_cursor_variables; -- Ensure to define and fetch other necessary columns\n        EXIT WHEN cursor_t%NOTFOUND;\n\n        SELECT t.kilometers INTO temp_kilometers1\n        FROM table_name t WHERE t.code = cursor_t.code_att;\n\n        SELECT g.kilometers INTO temp_kilometers2\n        FROM table_name g WHERE g.code = cursor_t.code_aff;\n\n        c_kilometers := temp_kilometers1 + temp_kilometers2;\n        \n        -- Do something with c_kilometers here\n\n    END LOOP;\n    CLOSE cursor_t;\nEND;
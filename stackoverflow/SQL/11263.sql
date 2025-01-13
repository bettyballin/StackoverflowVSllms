CREATE TYPE number_table_type AS TABLE OF NUMBER;\n\nPROCEDURE GetOrderbyCustName(\n      p_name       IN        VARCHAR2,\n      curReturn    OUT       sys_refcursor\n   )\n   IS\n      cursor_source_table  number_table_type := number_table_type();\n      single_site_cursor  sys_refcursor;\n      orderID  NUMBER;\n   BEGIN\n      FOR rec in SELECT site_id FROM customers WHERE name LIKE p_name\n      LOOP \n      -- This will replace curReturn in each iteration\n      -- how do I append instead?\n        GetOrder(rec.site_id,\n                   single_site_cursor\n                  );\n\n        -- Fetch all rows from the refcursor and append them to the nested table in memory\n        LOOP\n          FETCH single_site_cursor INTO orderID;\n          EXIT WHEN single_site_cursor%NOTFOUND;\n          cursor_source_table.extend();\n          cursor_source_table( cursor_source_table.COUNT+1) := orderID;\n        END LOOP;\n      END LOOP;\n\n      OPEN curReturn FOR\n        SELECT * FROM TABLE( cursor_source_table );\n\n   END GetOrderbyCustName;
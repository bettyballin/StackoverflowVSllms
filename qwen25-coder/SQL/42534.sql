-- Find earliest records for each ID from table1\nSELECT t.id, t.status, t.date_this_status\nFROM table1 t\nINNER JOIN (\n    SELECT id, MIN(date_this_status) AS min_date\n    FROM table1\n    GROUP BY id\n) sub ON t.id = sub.id AND t.date_this_status = sub.min_date\n\nUNION ALL\n\n-- Find earliest records for each ID from table1_hist\nSELECT h.id, h.status, h.date_this_status\nFROM table1_hist h\nINNER JOIN (\n    SELECT id, MIN(date_this_status) AS min_date\n    FROM table1_hist\n    GROUP BY id\n) sub ON h.id = sub.id AND h.date_this_status = sub.min_date
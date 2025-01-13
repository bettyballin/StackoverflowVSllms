SELECT t.id, t.status, t.date_this_status\nFROM (\n  SELECT id, status, date_this_status\n  FROM table1\n  UNION ALL\n  SELECT id, status, date_this_status\n  FROM table1_hist\n) t\nINNER JOIN (\n  SELECT id, MIN(date_this_status) as min_date\n  FROM (\n    SELECT id, date_this_status\n    FROM table1\n    UNION ALL\n    SELECT id, date_this_status\n    FROM table1_hist\n  ) sub\n  GROUP BY id\n) m\nON t.id = m.id AND t.date_this_status = m.min_date
SELECT \n  d.date, \n  COALESCE(COUNT(i.incident_id), 0) AS "Calls", \n  MAX(i.open_time) AS max_open_time\nFROM generate_series(CURRENT_DATE - INTERVAL '7 day', CURRENT_DATE, INTERVAL '1 day') d(date)\nLEFT JOIN (\n  SELECT \n    incident_id, \n    open_time - INTERVAL '9 hour' AS open_time, \n    EXTRACT(DAY FROM (open_time - INTERVAL '9 hour')) AS open_day\n  FROM incidentsm1 \n  WHERE open_time - INTERVAL '9 hour' > CURRENT_DATE - INTERVAL '7 day'\n) i ON d.date = i.open_time\nGROUP BY d.date\nORDER BY d.date;
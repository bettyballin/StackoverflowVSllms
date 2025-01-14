SELECT t.*\nFROM team t\nLEFT JOIN signup s ON t.team_id = s.team_id\nJOIN schedule sch ON t.schedule_id = sch.schedule_id\nJOIN event e ON sch.event_id = e.event_id\nWHERE e.event_id = 183 AND s.signup_id IS NULL;
INSERT INTO Events (event_name, event_date) VALUES ('Sample Event', '2023-10-10');\n\nINSERT INTO EventRepeatInfo (event_id, repeat_type, repeat_interval, repeat_weekdays)\nVALUES (LAST_INSERT_ID(), 'week', 2, 'Mon,Wed');
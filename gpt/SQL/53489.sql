-- Delete non-matching records from the second dataset\nDELETE FROM temp_progress_records\nWHERE subsNumber NOT IN (SELECT subsNumber FROM temp_proper_records);
SELECT COALESCE((SELECT value FROM your_table), 'default_value') AS value;
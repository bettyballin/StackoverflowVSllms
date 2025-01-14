SELECT\n    CASE\n        WHEN processed_timestamp IS NULL THEN 'NULL'\n        ELSE 'NOT NULL'\n    END AS timestamp_status,\n    COUNT(*) AS record_count\nFROM your_table\nGROUP BY timestamp_status;
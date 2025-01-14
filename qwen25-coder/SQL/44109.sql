SELECT AVG(time_diff) AS avg_time_difference\nFROM (\n    SELECT \n        @prev timestamp,\n        TIMESTAMPDIFF(SECOND, @prev, timestamp) AS time_diff,\n        @prev := timestamp\n    FROM your_table_name, (SELECT @prev := NULL) var\n    GROUP BY timestamp -- removes duplicates\n    ORDER BY timestamp\n) AS differences;
SELECT MIN(time_diff) AS min_time_difference\nFROM (\n    SELECT \n        TIMESTAMPDIFF(SECOND, LAG(`time`) OVER (ORDER BY `time`), `time`) AS time_diff\n    FROM temperatures\n) AS timediffs\nWHERE time_diff IS NOT NULL;
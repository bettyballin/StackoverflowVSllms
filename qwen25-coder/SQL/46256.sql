-- Assuming you want to generate between these two dates\nSET @start_date = '2009-01-01';\nSET @end_date = '2009-01-13';\n\nWITH RECURSIVE date_series AS (\n    SELECT @start_date as `date`\n    UNION ALL\n    SELECT DATE_ADD(`date`, INTERVAL 1 DAY)\n    FROM date_series\n    WHERE DATE_ADD(`date`, INTERVAL 1 DAY) <= @end_date\n)\nSELECT `date` \nFROM date_series;
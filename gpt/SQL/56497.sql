SELECT column_name, COUNT(*)\n    FROM your_table\n    GROUP BY column_name\n    HAVING COUNT(*) > 1;
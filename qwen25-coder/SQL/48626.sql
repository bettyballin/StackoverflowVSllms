WITH RankedDays AS (\n    SELECT \n        your_date_column,\n        ROW_NUMBER() OVER (ORDER BY DATE(your_date_column) DESC) as row_num\n    FROM (\n        SELECT DISTINCT DATE(your_date_column) as your_date_column\n        FROM your_table\n        ORDER BY DATE(your_date_column) DESC\n    ) DistinctDates\n)\nSELECT *\nFROM your_table\nWHERE DATE(your_date_column) IN (\n    SELECT your_date_column\n    FROM RankedDays\n    WHERE row_num <= 5\n);
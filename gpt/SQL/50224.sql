WITH RECURSIVE date_series AS (\n    SELECT DATE_FORMAT(DATE_SUB(? , INTERVAL 1 MONTH), '%Y-%m') AS month\n    UNION ALL\n    SELECT DATE_FORMAT(DATE_ADD(month, INTERVAL 1 MONTH), '%Y-%m')\n    FROM date_series\n    WHERE month < DATE_FORMAT(? , '%Y-%m')\n)\nSELECT \n    ds.month,\n    COALESCE(mt.count, 0) AS count,\n    COALESCE(mt.important_data, 0) AS important_data\nFROM \n    date_series ds\nLEFT JOIN (\n    SELECT \n        month,\n        COUNT(*) AS count, \n        SUM(important_data) AS important_data\n    FROM \n        my_table\n    WHERE \n        date >= ? AND date <= ?\n    GROUP BY \n        month\n) mt ON ds.month = mt.month\nORDER BY \n    ds.month DESC;
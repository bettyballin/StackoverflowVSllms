-- Create a derived table with all 24 hours\nWITH Hours AS (\n    SELECT 0 AS hour UNION ALL\n    SELECT 1 UNION ALL\n    SELECT 2 UNION ALL\n    SELECT 3 UNION ALL\n    SELECT 4 UNION ALL\n    SELECT 5 UNION ALL\n    SELECT 6 UNION ALL\n    SELECT 7 UNION ALL\n    SELECT 8 UNION ALL\n    SELECT 9 UNION ALL\n    SELECT 10 UNION ALL\n    SELECT 11 UNION ALL\n    SELECT 12 UNION ALL\n    SELECT 13 UNION ALL\n    SELECT 14 UNION ALL\n    SELECT 15 UNION ALL\n    SELECT 16 UNION ALL\n    SELECT 17 UNION ALL\n    SELECT 18 UNION ALL\n    SELECT 19 UNION ALL\n    SELECT 20 UNION ALL\n    SELECT 21 UNION ALL\n    SELECT 22 UNION ALL\n    SELECT 23\n)\nSELECT\n    H.hour,\n    COALESCE(SUM(O.order_id), 0) AS total_orders\nFROM\n    Hours H\nLEFT JOIN\n    ORDERS O\nON\n    H.hour = DATEPART(hh, O.order_date)\nGROUP BY\n    H.hour\nORDER BY\n    H.hour;
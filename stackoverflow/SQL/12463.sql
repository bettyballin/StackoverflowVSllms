SELECT\n    CASE WHEN COUNT(DISTINCT city) = 1 THEN MAX(city) ELSE NULL END AS city,\n    CASE WHEN COUNT(DISTINCT state) = 1 THEN MAX(state) ELSE NULL END AS state,\n    CASE WHEN COUNT(DISTINCT zip) = 1 THEN MAX(zip) ELSE NULL END AS zip\nFROM Users\nWHERE ID IN(1,2,3,4,5,6)
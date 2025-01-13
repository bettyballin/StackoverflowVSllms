WITH ranked AS (\n  SELECT name, points,\n         DENSE_RANK() OVER (ORDER BY points DESC) AS rank\n  FROM your_table\n)\nSELECT name, points, rank\nFROM ranked\nWHERE rank BETWEEN ? AND ?;  -- replace ? with your desired rank interval
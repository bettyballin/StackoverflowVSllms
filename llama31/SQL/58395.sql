ORDER BY CASE \n    WHEN @WebName LIKE '%EB%' THEN [Longitude] \n    WHEN @WebName LIKE '%WB%' THEN [Longitude] \n    WHEN @WebName LIKE '%NB%' THEN [Latitude] \n    WHEN @WebName LIKE '%SB%' THEN [Latitude] \nEND
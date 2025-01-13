SELECT * FROM Requirements\nWHERE Requirements.Release NOT LIKE '%Obsolete%'\nORDER BY \n  CAST(SUBSTRING_INDEX(ReqNum, '.', 1) AS UNSIGNED) ASC,\n  CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(ReqNum, '.', 2), '.', -1) AS UNSIGNED) ASC,\n  CAST(SUBSTRING_INDEX(ReqNum, '.', -1) AS UNSIGNED) ASC;
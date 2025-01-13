SELECT A.*\nFROM "EVENT" A\nWHERE EXISTS (\n  SELECT 1\n  FROM "EVENT" B\n  WHERE A."GROUPID" = B."GROUPID"\n  GROUP BY B."GROUPID"\n  HAVING COUNT(B."GROUPID") <> 5\n)
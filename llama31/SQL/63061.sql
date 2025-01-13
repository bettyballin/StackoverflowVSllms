SELECT MIN(t1.id) AS id, t1.custId, t1.date\nFROM t_order t1\nWHERE t1.date IS NULL\n  AND t1.custId NOT IN (\n    SELECT t2.custId\n    FROM t_order t2\n    WHERE t2.date IS NOT NULL\n  )\nGROUP BY t1.custId
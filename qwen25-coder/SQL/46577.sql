SELECT eid\n   FROM t\n   GROUP BY eid\n   HAVING SUM(CASE WHEN fid = 'B' THEN 1 ELSE 0 END) > 0\n      AND SUM(CASE WHEN fid = 'A' THEN 1 ELSE 0 END) = 0;
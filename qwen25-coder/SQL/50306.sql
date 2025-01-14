WITH DuplicateCounts AS (\n    SELECT \n        dupcol1, \n        dupcol2, \n        COUNT(*) as cnt\n    FROM \n        your_table_name\n    GROUP BY \n        dupcol1, \n        dupcol2\n    HAVING \n        COUNT(*) > 3\n)\nDELETE t1\nFROM \n    your_table_name t1\nJOIN \n    DuplicateCounts dc ON t1.dupcol1 = dc.dupcol1 AND t1.dupcol2 = dc.dupcol2\nWHERE \n    t1.id NOT IN (\n        SELECT id \n        FROM (\n            SELECT \n                id, \n                ROW_NUMBER() OVER(PARTITION BY dupcol1, dupcol2 ORDER BY id) as rn\n            FROM \n                your_table_name t2\n            WHERE \n                t2.dupcol1 = dc.dupcol1 AND t2.dupcol2 = dc.dupcol2\n        ) subquery\n        WHERE rn <= 3\n    );
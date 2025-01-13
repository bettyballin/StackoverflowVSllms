CREATE PROCEDURE sp_GetAgeBands\nAS\nBEGIN\n    SELECT \n        CASE \n            WHEN PersonAge <= 12 THEN '12 and under'\n            WHEN PersonAge BETWEEN 13 AND 17 THEN '13-17'\n            WHEN PersonAge BETWEEN 18 AND 25 THEN '18-25'\n            ELSE '25 and over'\n        END AS 'Age Band',\n        COUNT(*) AS Total\n    FROM \n        Person\n    GROUP BY \n        CASE \n            WHEN PersonAge <= 12 THEN '12 and under'\n            WHEN PersonAge BETWEEN 13 AND 17 THEN '13-17'\n            WHEN PersonAge BETWEEN 18 AND 25 THEN '18-25'\n            ELSE '25 and over'\n        END\n    ORDER BY \n        'Age Band'\nEND
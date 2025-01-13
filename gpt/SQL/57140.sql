SELECT *\nFROM tasks\nORDER BY \n    done ASC,\n    CASE \n        WHEN done = 0 THEN priority\n        ELSE NULL\n    END DESC,\n    CASE \n        WHEN done = 1 THEN date\n        ELSE NULL\n    END DESC;
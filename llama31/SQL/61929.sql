SELECT \n    CASE \n        WHEN x < -708.396418532264 THEN NULL  -- or a default value\n        ELSE EXP(x)\n    END AS result;
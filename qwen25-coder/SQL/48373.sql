SELECT EXP(SUM(LN(X))) AS PRODUCT_X\nFROM (\n    SELECT 3 X FROM DUAL\n    UNION ALL \n    SELECT 5 X FROM DUAL\n    UNION ALL\n    SELECT 2 X FROM DUAL\n);
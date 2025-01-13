SELECT r.CODE, r.AMOUNT\nFROM RegisteredCodes r\nWHERE EXISTS (\n    SELECT 1\n    FROM CodeVariations v\n    WHERE r.CODE LIKE REPLACE(v.CODE, '_', '%')\n);
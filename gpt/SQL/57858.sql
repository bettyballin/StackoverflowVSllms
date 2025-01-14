/* using CROSS APPLY */\nSELECT *\nFROM Person p\nCROSS APPLY (\n    SELECT *\n    FROM Company c\n    WHERE p.companyid = c.companyId\n) Czip;\n\n/* the equivalent query using INNER JOIN */\nSELECT *\nFROM Person p\nINNER JOIN Company c ON p.companyid = c.companyId;
-- Using a custom PL/SQL function or direct approach in SQL\nWITH RECURSIVE num_to_hex(n) AS (\n    SELECT 6719 FROM dual UNION ALL\n    SELECT FLOOR(n / 16), MOD(n, 16)\n    FROM num_to_hex\n    WHERE n > 0\n)\nSELECT LISTAGG(\n           CASE d WHEN 15 THEN 'F' WHEN 14 THEN 'E' WHEN 13 THEN 'D'\n                WHEN 12 THEN 'C' WHEN 11 THEN 'B' WHEN 10 THEN 'A'\n                ELSE TO_CHAR(d) END, ''\n       ) WITHIN GROUP (ORDER BY LEVEL DESC) AS hex_value\nFROM num_to_hex CONNECT BY PRIOR n > 0 AND PRIOR SYS_GUID() IS NOT NULL;
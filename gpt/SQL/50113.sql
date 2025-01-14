-- Assuming the table is named 'YourTable' and the column is named 'YourDateColumn'\n\nSELECT YourDateColumn\nFROM YourTable\nWHERE ISDATE(\n    CASE\n        WHEN LEN(YourDateColumn) = 10 AND SUBSTRING(YourDateColumn, 3, 1) = '/' AND SUBSTRING(YourDateColumn, 6, 1) = '/'\n        THEN SUBSTRING(YourDateColumn, 4, 2) + '/' + SUBSTRING(YourDateColumn, 1, 2) + '/' + SUBSTRING(YourDateColumn, 7, 4)\n        ELSE 'Invalid'\n    END\n) = 0\nAND YourDateColumn IS NOT NULL;
SELECT \n    CASE \n        WHEN unsigned_value & 0x80000000 THEN unsigned_value - 0x100000000\n        ELSE unsigned_value\n    END AS signed_value\nFROM your_table;
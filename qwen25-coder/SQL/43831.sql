WITH prefixes AS (\n    SELECT value\n    FROM (\n        VALUES ('a%'), ('b%'), ('c%')\n    ) t(value)\n)\nSELECT b.a\nFROM b\nJOIN prefixes ON b.a LIKE prefixes.value;
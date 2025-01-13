-- For equality comparison\nSELECT \n    A, B,\n    (A = B) OR (A IS NULL AND B IS NULL) AS equal\nFROM (\n    VALUES\n    (NULL, NULL),\n    (NULL, 'john'),\n    (NULL, 'paul'),\n    ('john', NULL),\n    ('john', 'john'),\n    ('john', 'paul'),\n    ('paul', NULL),\n    ('paul', 'john'),\n    ('paul', 'paul')\n) AS x(A, B);\n\n-- For inequality comparison\nSELECT \n    A, B,\n    (A <> B) OR ((A IS NULL OR B IS NULL) AND (A IS NOT NULL OR B IS NOT NULL)) AS not_equal\nFROM (\n    VALUES\n    (NULL, NULL),\n    (NULL, 'john'),\n    (NULL, 'paul'),\n    ('john', NULL),\n    ('john', 'john'),\n    ('john', 'paul'),\n    ('paul', NULL),\n    ('paul', 'john'),\n    ('paul', 'paul')\n) AS x(A, B);
SELECT \n    A, B,\n    A IS DISTINCT FROM B AS not_equal\nFROM (\n    VALUES\n    (NULL, NULL),\n    (NULL, 'john'),\n    (NULL, 'paul'),\n    ('john', NULL),\n    ('john', 'john'),\n    ('john', 'paul'),\n    ('paul', NULL),\n    ('paul', 'john'),\n    ('paul', 'paul')\n) AS x(A, B);
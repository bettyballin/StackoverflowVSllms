-- subquery\nSELECT a FROM x WHERE x.b NOT IN (SELECT b FROM y);\n-- predefined list\nSELECT a FROM x WHERE x.b NOT IN (1, 2, 3, 6);
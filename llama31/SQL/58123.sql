SELECT * FROM (SELECT 'xyz' AS txt FROM dual WHERE 1=2);\n-- returns no rows\n\nSELECT * FROM (SELECT COUNT(*), 'xyz' AS txt FROM dual WHERE 1=2);\n-- returns 1 row with count=0 and txt='xyz'
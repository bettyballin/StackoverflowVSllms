-- Example if table name is defined with mixed case\nCREATE TABLE "Site" (\n    site_id INT,\n    ...\n);\n\n-- Correct query using exact case\nSELECT * FROM "Site" WHERE site_id = 3;
INSERT INTO POP (population) SELECT DISTINCT pop FROM temp_data ON DUPLICATE KEY UPDATE population=population;\nINSERT INTO MARKER (rsid) SELECT DISTINCT marker FROM temp_data ON DUPLICATE KEY UPDATE rsid=rsid;\n\n-- Populate IND table after setting up foreign key values\nINSERT INTO IND (fk_pop, name)\nSELECT p.id, td.individual\nFROM temp_data AS td\nJOIN POP AS p ON td.pop = p.population\nON DUPLICATE KEY UPDATE fk_pop=fk_pop;
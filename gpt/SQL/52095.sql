SET LONG 10000\n   SET PAGESIZE 1000\n   SET HEAD OFF\n   SET FEEDBACK OFF\n   SPOOL proc.sql\n   SELECT TEXT \n   FROM ALL_SOURCE \n   WHERE NAME = 'YOUR_PROCEDURE_NAME' AND TYPE = 'PROCEDURE'\n   ORDER BY LINE;\n   SPOOL OFF
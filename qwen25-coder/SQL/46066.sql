SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY_CURSOR('sql_id', child_number, 'ALLSTATS LAST +FORMAT ALL'));
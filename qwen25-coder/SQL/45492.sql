SELECT CASE \n         WHEN DBMS_LOB.GETLENGTH(bom_course_id) IS NOT NULL THEN -- Oracle specific check\n           SUBSTR(bom_course_id, INSTR(bom_course_id, '.') + 1)\n         ELSE -- Assume MS SQL Server if not Oracle\n           SUBSTRING(bom_course_id, CHARINDEX('.', bom_course_id) + 1)\n       END AS course_suffix\nFROM your_table;
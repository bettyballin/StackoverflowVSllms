SELECT DISTINCT key, id, link\n  FROM the_table\n  START WITH id = 'AA'\n  CONNECT BY id = 'MASTER' and link = PRIOR link and 'AA' = PRIOR ID
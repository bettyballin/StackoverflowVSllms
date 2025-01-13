WITH synonym_chain (synonym_name, table_owner, table_name, level) AS (\n      SELECT synonym_name, table_owner, table_name, 1\n      FROM all_synonyms\n      WHERE table_owner <> 'SYS'\n      UNION ALL\n      SELECT s.synonym_name, s.table_owner, s.table_name, sc.level + 1\n      FROM all_synonyms s\n      JOIN synonym_chain sc\n      ON s.synonym_name = sc.table_name AND s.table_owner = sc.table_owner\n      WHERE s.table_owner <> 'SYS'\n    )\n    SELECT *\n    FROM synonym_chain\n    WHERE synonym_name = table_name\n    ORDER BY level;
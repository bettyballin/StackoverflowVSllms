SELECT key\nFROM source_table s\nWHERE NOT EXISTS (\n  SELECT 1\n  FROM target_table t\n  WHERE s.key = t.key\n  AND DBMS_LOB.COMPARE(s.clob_value, t.clob_value) = 0\n);
WITH ResultSet AS (\n  SELECT * FROM TABLE1 WHERE <SomeCondition>\n  UNION ALL\n  SELECT * FROM TABLE2 WHERE NOT <SomeCondition>\n)\nSELECT * FROM ResultSet\nUNION\nSELECT * FROM TABLE3
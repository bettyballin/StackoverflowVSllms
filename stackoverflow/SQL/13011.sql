SELECT\n  atype, \n  SUM(CASE btype WHEN 'x' THEN 1 ELSE 0 END) AS x,\n  SUM(CASE btype WHEN 'y' THEN 1 ELSE 0 END) AS y,\n  SUM(CASE btype WHEN 'z' THEN 1 ELSE 0 END) AS z\nFROM\n  #tmp\ngroup by \n  atype\norder by \n  atype
ALTER SESSION SET GLOBAL_NAMES = TRUE;\n\nSELECT T1.Id\n  FROM S1.Table1 T1\n  JOIN S2.Table2@DB2 T2\n  ON T1.Id = T2.refId;
CREATE PROCEDURE GetJoinedData\n   AS\n   BEGIN\n       SELECT Table1.*, Table3.*\n       FROM Table1\n       INNER JOIN Table2 ON Table1.ID = Table2.T1ID\n       INNER JOIN Table3 ON Table2.T3ID = Table3.PK\n   END
-- SQL Server\n   WITH MyCTE AS (\n       SELECT ID, Name FROM MyTable WHERE ID < 10\n   )\n   SELECT * FROM MyCTE;\n\n   -- Oracle\n   WITH MyCTE AS (\n       SELECT ID, Name FROM MyTable WHERE ID < 10\n   )\n   SELECT * FROM MyCTE;
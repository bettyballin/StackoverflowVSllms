SELECT \n  Date,\n  SUM(CASE WHEN Project = 'A' THEN Time ELSE 0 END) AS "Project A Time",\n  SUM(CASE WHEN Project = 'B' THEN Time ELSE 0 END) AS "Project B Time",\n  SUM(CASE WHEN Project = 'C' THEN Time ELSE 0 END) AS "Project C Time"\nFROM \n  your_table\nGROUP BY \n  Date
WITH stuff1 AS (\n  SELECT name, startdate, id FROM employees WHERE startdate > 0\n),\nstuff2 AS (\n  SELECT name, startdate, id FROM stuff1\n)\nSELECT * FROM stuff2 WHERE id > 10;
SELECT \n    (SELECT COUNT(*) FROM MyTable) AS TotalCount,\n    (SELECT COUNT(*)\n     FROM MyTable mt\n     JOIN MyOtherTable mot ON mt.id = mot.id\n     WHERE {conditions}) AS QualifiedCount;
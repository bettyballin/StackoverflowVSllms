SELECT *\n   FROM Thing\n   WHERE ID IN (SELECT max(ID) FROM Thing \n                   WHERE ThingID IN (1,2,3,4)\n                   GROUP BY ThingID)
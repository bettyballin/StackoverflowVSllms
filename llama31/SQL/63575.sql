SELECT \n  A.id AS aid, \n  GROUP_CONCAT(DISTINCT B.id) AS bid, \n  GROUP_CONCAT(DISTINCT C.id) AS cid\nFROM \n  A\n  LEFT JOIN B ON B.aid = A.id\n  LEFT JOIN C ON C.aid = A.id\nWHERE \n  A.id = 1\nGROUP BY \n  A.id
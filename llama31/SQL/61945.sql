SELECT \n  COALESCE(A.itemid, B.itemid) AS itemid, \n  A.mark AS A_mark, \n  B.mark AS B_mark\nFROM \n  A \n  LEFT JOIN B ON A.itemid = B.itemid\nUNION ALL\nSELECT \n  COALESCE(A.itemid, B.itemid) AS itemid, \n  A.mark AS A_mark, \n  B.mark AS B_mark\nFROM \n  B \n  LEFT JOIN A ON A.itemid = B.itemid\nWHERE A.itemid IS NULL
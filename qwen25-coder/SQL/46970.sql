SELECT A.itemid, A.mark AS A_mark, B.mark AS B_mark\nFROM A\nLEFT JOIN B ON A.itemid = B.itemid\n\nUNION\n\nSELECT B.itemid, A.mark AS A_mark, B.mark AS B_mark\nFROM B\nLEFT JOIN A ON B.itemid = A.itemid\nWHERE A.itemid IS NULL;
SELECT A.name, B.marks \nFROM A\nJOIN B ON A.num = B.num\n\nUNION ALL\n\nSELECT A.name, B.marks \nFROM A, B\nWHERE A.num = 0;
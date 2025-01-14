SELECT \n    *\nFROM\n    o1, \n    o2\nWHERE\n    o1.from < (o2.to - (o2.to - o2.from) / 2)\n    AND\n    o1.to > (o2.to - (o2.to - o2.from) / 2);
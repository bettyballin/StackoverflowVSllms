SELECT \n  level,\n  empid, \n  parentid\nFROM usertable\nCONNECT BY NOCYCLE PRIOR parentid = empid\nSTART WITH empid = 50\nUNION ALL\nSELECT \n  4, \n  parentid, \n  parentid\nFROM usertable\nWHERE empid = 50
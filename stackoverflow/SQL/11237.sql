FROM \n  TABLE_A A LEFT OUTER JOIN TABLE_B HIST ON\n      HIST.COL1 = A.COL1\n  LEFT OUTER JOIN TABLE_D H ON \n      H.COL3 = A.STATE\n  LEFT OUTER JOIN TABLE_C B ON H.COL2 = B.COL2\nWHERE\n  A.BRANCH = 'Data'
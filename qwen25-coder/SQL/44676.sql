SELECT \n    *\nFROM\n    o1, \n    o2\nWHERE\n    o1.from < (o2.to - NUMTODSINTERVAL((TO_NUMBER(TO_CHAR(o2.to - o2.from)) / 2), 'SECOND'))\n    AND\n    o1.to > (o2.to - NUMTODSINTERVAL((TO_NUMBER(TO_CHAR(o2.to - o2.from)) / 2), 'SECOND'));
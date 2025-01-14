WITH hierarchy AS (\n    SELECT \n        LEVEL,\n        empid, \n        parentid\n    FROM usertable\n    START WITH empid = 50\n    CONNECT BY NOCYCLE PRIOR parentid = empid\n    UNION ALL\n    SELECT \n        1 AS LEVEL,\n        empid, \n        parentid\n    FROM usertable\n    WHERE empid = 50 AND empid = parentid\n)\nSELECT * \nFROM hierarchy\nORDER BY level, empid;
-- All equivalent in this specific scenario\nSELECT t1.x, t2.y FROM t1, t2 WHERE t1.a = t2.a AND t1.b = t2.b AND t1.c = t2.c;\nSELECT t1.x, t2.y FROM t1 JOIN t2 ON t1.a = t2.a WHERE t1.b = t2.b AND t1.c = t2.c;\nSELECT t1.x, t2.y FROM t1 JOIN t2 ON t1.a = t2.a AND t1.b = t2.b WHERE t1.c = t2.c;\nSELECT t1.x, t2.y FROM t1 JOIN t2 ON t1.a = t2.a AND t1.b = t2.b AND t1.c = t2.c;
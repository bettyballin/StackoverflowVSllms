SELECT t1.x, t2.y \n    FROM t1 \n    JOIN t2 ON t1.a = t2.a \n    WHERE t1.b = t2.b AND t1.c = t2.c;
mysql> select * from foo;\n+----+-----+\n| id | col |\n+----+-----+\n|  1 | Bar | \n|  1 | Foo | \n|  2 | Foo | \n|  3 | Bar | \n|  4 | Bar | \n|  4 | Foo | \n+----+-----+\n\nSELECT id\n     , col\n  FROM foo f1 \n WHERE col = 'Foo' \n  OR ( col = 'Bar' AND NOT EXISTS( SELECT * \n                                     FROM foo f2\n                                    WHERE f1.id  = f2.id \n                                      AND f2.col = 'Foo' \n                                 ) \n     ); \n\n+----+-----+\n| id | col |\n+----+-----+\n|  1 | Foo | \n|  2 | Foo | \n|  3 | Bar | \n|  4 | Foo | \n+----+-----+
SELECT A, B, C, 1 AS query_order FROM table WHERE field LIKE 'query%'\nUNION ALL\nSELECT A, B, C, 2 AS query_order FROM table WHERE field LIKE '%query'\nUNION ALL\nSELECT A, B, C, 3 AS query_order FROM table WHERE field LIKE '%query%'\nORDER BY query_order, B ASC\nLIMIT 5;
-- DB2 UDB syntax with INCLUDE keyword\nCREATE UNIQUE INDEX I_0004 ON TABLENAME (a) INCLUDE (b, c, d);\n\n-- DB2 for OS/390 without INCLUDE keyword\nCREATE UNIQUE INDEX I_0004 ON TABLENAME (a);\nCREATE INDEX I_0005 ON TABLENAME (a, b, c, d);\n\n-- These are not entirely equivalent, as the INCLUDE keyword allows the index to cover more queries.
mysql> CREATE TABLE tbl( row CHAR(128) NOT NULL );\nQuery OK, 0 rows affected (0.05 sec)\n\nmysql> INSERT INTO tbl VALUES( 'not empty' ), ( '' );\nQuery OK, 2 rows affected (0.02 sec)\nRecords: 2  Duplicates: 0  Warnings: 0\n\nmysql> SELECT row, row IS NULL FROM tbl;\n+-----------+-------------+\n| row       | row IS NULL |\n+-----------+-------------+\n| not empty |           0 | \n|           |           0 | \n+-----------+-------------+\n2 rows in set (0.00 sec)\n\nmysql> INSERT INTO tbl VALUES( NULL );\nERROR 1048 (23000): Column 'row' cannot be null
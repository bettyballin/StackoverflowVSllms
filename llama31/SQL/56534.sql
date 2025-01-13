-- DISTINCT\nEXPLAIN SELECT DISTINCT theField FROM theTable;\n\n+----+-------------+-------+-------+---------------+-------+---------+------+------+-------+\n| id | select_type | table | type  | possible_keys | key   | key_len | ref  | rows | filtered |\n+----+-------------+-------+-------+---------------+-------+---------+------+------+-------+\n| 1  | SIMPLE      | theTable | index | PRIMARY       | PRIMARY | 4       | NULL | 1000 | 100.00  |\n+----+-------------+-------+-------+---------------+-------+---------+------+------+-------+\n\n-- GROUP BY\nEXPLAIN SELECT theField FROM theTable GROUP BY theField;\n\n+----+-------------+-------+-------+---------------+-------+---------+------+------+-------+\n| id | select_type | table | type  | possible_keys | key   | key_len | ref  | rows | filtered |\n+----+-------------+-------+-------+---------------+-------+---------+------+------+-------+\n| 1  | SIMPLE      | theTable | index | PRIMARY       | PRIMARY | 4       | NULL | 1000 | 100.00  |\n| 2  | GROUP BY    |         |       |               |         |         |      |      |         |\n+----+-------------+-------+-------+---------------+-------+---------+------+------+-------+
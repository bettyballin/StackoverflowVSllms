+----+-------------+------------+-------+---------------+-----------------+---------+------+------+--------+-----------------------+\n| id | select_type | table      | type  | possible_keys | key             | key_len | ref  | rows | Extra                 |\n+----+-------------+------------+-------+---------------+-----------------+---------+------+------+--------+-----------------------+\n| 1  | SIMPLE      | large_table| range | idx_some_string_field | idx_some_string_field | 767     | NULL | 100  | Using index condition |\n+----+-------------+------------+-------+---------------+-----------------+---------+------+------+--------+-----------------------+
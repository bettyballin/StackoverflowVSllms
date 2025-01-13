SELECT t1.user, t1.data, t1.sequence\nFROM your_table t1\nJOIN (\n  SELECT user, MAX(sequence) AS max_sequence\n  FROM your_table\n  GROUP BY user\n) t2\nON t1.user = t2.user AND t1.sequence = t2.max_sequence;
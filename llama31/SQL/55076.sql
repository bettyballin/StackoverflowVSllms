SELECT \n  FLOOR(score / 10) * 10 AS score_range,\n  COUNT(*) AS num_occurrences\nFROM your_table\nGROUP BY score_range\nORDER BY score_range;
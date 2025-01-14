SELECT \n  score,\n  COUNT(students) AS students,\n  COUNT(finished) AS finished,\n  ROUND(COUNT(finished) / COUNT(students) * 100, 2) AS percentage_finished\nFROM now_calc \nGROUP BY score\nORDER BY score;
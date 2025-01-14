SELECT c.id,\n       c.date,\n       c.time,\n       c.duration,\n       c.location\nFROM #tmp q\nINNER JOIN call_table c (NOLOCK)\nON q.id = c.id \n   AND q.date = c.date\n   AND q.time = c.time\n   AND q.duration = c.duration\n   AND q.location = c.location;
SELECT c.id, c.date, c.time, c.duration, c.location\nFROM #tmp q\nINNER JOIN call_table c WITH (NOLOCK)\nON q.id = c.id\nAND q.date = c.date\nAND q.time = c.time\nAND q.duration = c.duration\nAND q.location = c.location\nGROUP BY c.id, c.date, c.time, c.duration, c.location;
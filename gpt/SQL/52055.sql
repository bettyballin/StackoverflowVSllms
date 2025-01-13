SELECT *\nFROM Table1\nJOIN Table2 ON Table1.Table2Id = Table2.Id\nWHERE Table2.StartTime < :starttime\n  AND Table2.StartTime + (Table2.Duration / 24) > :endtime;
WITH precalc AS (\n  SELECT id, starttime, starttime + duration/24 AS endtime\n  FROM Table2\n)\nSELECT * \nFROM Table1 \nJOIN precalc \n  ON Table2Id = precalc.Id \n  AND starttime < :starttime \n  AND endtime > :endtime;
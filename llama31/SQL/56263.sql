SELECT *\nFROM LogTable l\nJOIN OtherTable o\nON DATEDIFF(SECOND, l.datetimefield, o.datetimefield) BETWEEN -3 AND 3
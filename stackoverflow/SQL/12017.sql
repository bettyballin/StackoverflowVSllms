SELECT ISNULL(COUNT(*), 0)\nFROM Calendar\nWHERE [DATE] > DateOne \n    AND [DATE] < DateTwo\n    AND IsWeekDay = 1\n    AND IsHoliday = 0
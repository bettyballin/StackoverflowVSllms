SELECT datecol, timecol\nFROM OldTable\nWHERE \n    ISDATE(datecol) = 0 OR\n    LEN(datecol) != 8 OR\n    ISNUMERIC(datecol) = 0 OR\n    LEFT(timecol, 2) NOT BETWEEN '00' AND '23' OR\n    RIGHT(timecol, 2) NOT BETWEEN '00' AND '59' OR\n    LEN(timecol) != 4 OR\n    ISNUMERIC(timecol) = 0
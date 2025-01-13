SELECT \n    COUNT(IIF(lunch = True, 1, Null)) AS LunchCount,\n    COUNT(IIF(snacks = True, 1, Null)) AS SnacksCount,\n    COUNT(IIF(tea = True, 1, Null)) AS TeaCount\nFROM \n    YourTableName\nWHERE \n    Month(eventDate) = [Enter Month Number] AND Year(eventDate) = [Enter Year];
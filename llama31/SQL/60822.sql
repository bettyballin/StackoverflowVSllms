SELECT ID, \n       IIF(Date1 > Date2, Date1, Date2) AS MostRecentDate\nFROM YourTable;
FROM Table1\nLEFT OUTER JOIN Table2 ON Table1.T2FK = Table2.T2PK\nLEFT OUTER JOIN Table4 ON Table3.T3PK = Table4.T3PK\nLEFT OUTER JOIN Table5 ON Table4.T3FK = Table5.T3FK AND Table4.T2FK = Table5.T2FK\nLEFT OUTER JOIN Table7 ON Table6.T6PK = Table7.T6FK\nLEFT OUTER JOIN Table9 ON Table8.T8PK = Table9.T8FK\nLEFT OUTER JOIN Table9 ON Table7.T9FK = Table9.T9PK\nLEFT OUTER JOIN Table4 ON Table4.T7FK = Table7.T7PK\nLEFT OUTER JOIN Table10 ON Table4.T4PK = Table10.T4FK AND Table2.T2PK = Table4.T2PK\nLEFT OUTER JOIN TableA ON (TableA.PK = @PK) AND (TableA.Date BETWEEN @StartDate AND @EndDate)
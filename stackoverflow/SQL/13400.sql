INSERT INTO Table2(LongIntColumn2, CurrencyColumn2)\nSELECT LongIntColumn1, Avg(CurrencyColumn) as CurrencyColumn1 FROM Table1 GROUP BY LongIntColumn1;
SELECT \n  m.MDate, \n  s.SDate, \n  s.Symbol, \n  s.Open, \n  s.High, \n  s.Low, \n  s.Close, \n  s.Volume\nFROM \n  Masterdates m\n  LEFT JOIN Stockdata s ON m.MDate = s.SDate AND s.Symbol = 'Foo'\nWHERE \n  m.MDate >= (SELECT MIN(SDate) FROM Stockdata WHERE Symbol = 'Foo')\n  AND m.MDate <= (SELECT MAX(SDate) FROM Stockdata WHERE Symbol = 'Foo')\nORDER BY \n  m.MDate;
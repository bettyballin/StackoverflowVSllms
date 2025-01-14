WITH AlphabetSequence AS (\n    SELECT CHAR(ASCII('A') + Number) AS Letter\n    FROM master..spt_values\n    WHERE Type = 'P' AND Number BETWEEN 0 AND 25\n)\n, OrderedLetters AS (\n    SELECT Letter,\n           ROW_NUMBER() OVER (ORDER BY Date, Letter) AS RowNum\n    FROM YourTable\n)\nSELECT a.Letter AS MissingLetter\nFROM AlphabetSequence a\nLEFT OUTER JOIN OrderedLetters o ON a.RowNum = o.RowNum AND a.Letter = o.Letter\nWHERE o.Letter IS NULL\nAND EXISTS (\n    SELECT 1\n    FROM OrderedLetters o2\n    WHERE o2.Letter <= a.Letter\n) AND EXISTS (\n    SELECT 1\n    FROM OrderedLetters o3\n    WHERE o3.Letter >= a.Letter\n);
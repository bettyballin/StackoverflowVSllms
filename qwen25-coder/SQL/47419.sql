WITH RankedEvents AS (\n    SELECT \n        EventTime,\n        EventValue,\n        ROW_NUMBER() OVER (ORDER BY EventTime) AS rn\n    FROM Events\n)\nSELECT e1.EventTime, e1.EventValue\nFROM RankedEvents e1\nLEFT OUTER JOIN RankedEvents e2 ON e2.rn = e1.rn - 1 AND e2.EventValue = e1.EventValue\nWHERE e2.rn IS NULL\nORDER BY e1.EventTime;
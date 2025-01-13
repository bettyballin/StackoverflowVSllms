WITH DuplicateRows AS (\n  SELECT ID, Value, Signal, Read, Firmware, Date, Time,\n         ROW_NUMBER() OVER (PARTITION BY ID ORDER BY Time DESC) AS RowNum\n  FROM YourTable\n)\nSELECT ID, Value, Signal, Read, Firmware, Date, Time\nFROM DuplicateRows\nWHERE RowNum = 1;
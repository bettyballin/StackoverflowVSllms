WITH RankedRecords AS (\n    SELECT \n        ID, \n        Value, \n        Signal, \n        Read, \n        Firmware, \n        Date, \n        Time,\n        ROW_NUMBER() OVER (PARTITION BY ID ORDER BY Date DESC, Time DESC) AS rn\n    FROM \n        YourTableName\n)\nSELECT \n    ID, \n    Value, \n    Signal, \n    Read, \n    Firmware, \n    Date, \n    Time\nFROM \n    RankedRecords\nWHERE \n    rn = 1;
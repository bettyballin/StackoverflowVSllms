SELECT\n    ChargeNum,\n    CategoryID,\n    SUM(Hours) AS Hours\nFROM\n    KnownHours\nGROUP BY\n    ChargeNum,\n    CategoryID\n\nUNION ALL\n\nSELECT\n    ChargeNum,\n    'Unknown' AS CategoryID,\n    SUM(Hours) AS Hours\nFROM\n    UnknownHours\nGROUP BY\n    ChargeNum\nORDER BY\n    ChargeNum,\n    CategoryID;
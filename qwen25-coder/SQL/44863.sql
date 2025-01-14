WITH SequenceCheck AS (\n    SELECT \n        "Order",\n        "Group",\n        "Sequence",\n        ROW_NUMBER() OVER (PARTITION BY "Group" ORDER BY "Sequence") AS ExpectedSequence\n    FROM \n        YourTableName\n)\nSELECT \n    "Order"\nFROM \n    SequenceCheck\nWHERE \n    ExpectedSequence != ("Sequence" - MIN("Sequence") OVER (PARTITION BY "Group"));
WITH OrderedSequences AS (\n    SELECT\n        "Order",\n        "Group",\n        "Sequence",\n        LAG("Sequence") OVER (PARTITION BY "Group" ORDER BY "Sequence") AS PrevSequence\n    FROM\n        your_table\n)\nSELECT\n    "Order"\nFROM\n    OrderedSequences\nWHERE\n    PrevSequence IS NOT NULL\n    AND "Sequence" != PrevSequence + 1;
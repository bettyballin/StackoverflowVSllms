WITH RankedQueue AS (\n    SELECT \n        id,\n        identifier,\n        priority_number,\n        timestamp,\n        description,\n        ROW_NUMBER() OVER (ORDER BY priority_number ASC, timestamp ASC) as rn\n    FROM \n        queue_manager\n)\nSELECT \n    id,\n    identifier,\n    priority_number,\n    timestamp,\n    description\nFROM \n    RankedQueue\nWHERE \n    rn = 1;
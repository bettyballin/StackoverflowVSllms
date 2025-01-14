SELECT \n    t1.type,\n    COALESCE(COUNT(t2.record_id), 0) AS record_count\nFROM \n    type_table t1\nLEFT JOIN \n    records_table t2 ON t1.type = t2.type_id\nGROUP BY \n    t1.type;
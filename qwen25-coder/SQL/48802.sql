SELECT \n    CASE WHEN COUNT(CASE WHEN field1 IS NOT NULL THEN 1 END) > 0 THEN 'field1' ELSE NULL END AS field1,\n    CASE WHEN COUNT(CASE WHEN field2 IS NOT NULL THEN 1 END) > 0 THEN 'field2' ELSE NULL END AS field2,\n    -- Repeat for all fields\n    CASE WHEN COUNT(CASE WHEN field70 IS NOT NULL THEN 1 END) > 0 THEN 'field70' ELSE NULL END AS field70\nFROM \n    series \nWHERE \n    t_stamp BETWEEN x AND y;
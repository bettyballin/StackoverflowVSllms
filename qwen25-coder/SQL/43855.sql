WITH RECURSIVE SubTree AS (\n    -- Anchor member: select the root node or any specific node you are interested in\n    SELECT id, parentid, data1, ..., dataN\n    FROM your_table_name\n    WHERE id = :node_id  -- Replace :node_id with the ID of the node you want to start from\n\n    UNION ALL\n\n    -- Recursive member: select child nodes\n    SELECT t.id, t.parentid, t.data1, ..., t.dataN\n    FROM your_table_name t\n    INNER JOIN SubTree s ON t.parentid = s.id\n)\nSELECT \n    id,\n    SUM(data1) AS total_data1,\n    SUM(data2) AS total_data2,\n    -- Add more data columns as necessary\n    SUM(dataN) AS total_dataN\nFROM SubTree\nGROUP BY id\nORDER BY id;
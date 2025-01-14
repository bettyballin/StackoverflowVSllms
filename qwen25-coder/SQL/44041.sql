SELECT i.id, i.name -- Adjust columns as per your requirements\nFROM items i\nJOIN item_tags it ON i.id = it.item_id\nJOIN tags t ON it.tag_id = t.id\nWHERE t.name IN ('p1', 'p2')\nGROUP BY i.id, i.name\nHAVING COUNT(DISTINCT CASE WHEN t.name IN ('p1', 'p2') THEN t.name END) = 2 -- Match all p1 AND p2\nAND NOT EXISTS (\n    SELECT 1 FROM item_tags it_ex\n    JOIN tags t_ex ON it_ex.tag_id = t_ex.id\n    WHERE it_ex.item_id = i.id AND t_ex.name IN ('n1', 'n2')\n);
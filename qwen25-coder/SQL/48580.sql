SELECT item_id\nFROM ItemTags\nWHERE tag_id = t1\nINTERSECT\nSELECT item_id\nFROM ItemTags\nWHERE tag_id = t2\n-- Repeat INTERSECT for each tag tn\nINTERSECT\nSELECT item_id\nFROM ItemTags\nWHERE tag_id = tn;
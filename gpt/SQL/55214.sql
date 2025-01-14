SELECT DISTINCT p2c.product_id\nFROM TABLE_PRODUCT_TO_CATEGORY p2c\nINNER JOIN TABLE_PRODUCT p ON p2c.product_id = p.id\nINNER JOIN TABLE_PRODUCT_TAG pt ON p.id = pt.product_id\nINNER JOIN TABLE_TAG_TYPE tt ON pt.tag_type_id = tt.id\nWHERE p.status = 1\nAND tt.id = PRODUCT_TAG_TYPE_FREE_TAG\nAND (\n    (pt.value = 'cats' AND EXISTS (\n        SELECT 1 FROM TABLE_PRODUCT_TAG pt2 \n        WHERE pt2.product_id = p.id AND pt2.value = 'kittens'\n    ))\n    OR (pt.value IN ('kittens', 'dogs') AND EXISTS (\n        SELECT 1 FROM TABLE_PRODUCT_TAG pt3 \n        WHERE pt3.product_id = p.id AND pt3.value = 'cats'\n    ))\n)\nAND NOT EXISTS (\n    SELECT 1 FROM TABLE_PRODUCT_TAG pt4 \n    WHERE pt4.product_id = p.id AND pt4.value = 'parrots'\n);
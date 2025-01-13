WITH RECURSIVE combinations AS (\n    SELECT \n        1 AS level,\n        item,\n        price,\n        CAST(CONCAT(item, ':', price) AS CHAR(1000)) AS items_list,\n        price AS total_price\n    FROM items\n    UNION ALL\n    SELECT\n        c.level + 1,\n        i.item,\n        i.price,\n        CONCAT(c.items_list, ', ', i.item, ':', i.price),\n        c.total_price + i.price\n    FROM \n        combinations c\n    JOIN \n        items i ON c.items_list NOT LIKE CONCAT('%', i.item, ':', i.price, '%')\n)\nSELECT \n    items_list,\n    total_price\nFROM \n    combinations\nWHERE \n    total_price = 30;
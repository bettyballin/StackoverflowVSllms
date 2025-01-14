SELECT item.id,\n       item.part_number,\n       lang.data AS name,\n       lang2.data AS description\n  FROM item\n  LEFT JOIN language lang ON item.id = lang.item AND lang.language = 'fr'\n  LEFT JOIN language lang2 ON item.id = lang2.item AND lang2.language = 'fr'\n WHERE item.part_number = '34KM003KL'\n\nUNION ALL\n\nSELECT item.id,\n       item.part_number,\n       lang.data AS name,\n       lang2.data AS description\n  FROM item\n  LEFT JOIN language lang ON item.id = lang.item AND lang.language = 'en' AND NOT EXISTS (\n    SELECT 1\n    FROM language l\n    WHERE item.id = l.item\n      AND l.language = 'fr'\n  )\n  LEFT JOIN language lang2 ON item.id = lang2.item AND lang2.language = 'en' AND NOT EXISTS (\n    SELECT 1\n    FROM language l\n    WHERE item.id = l.item\n      AND l.language = 'fr'\n  )\n WHERE item.part_number = '34KM003KL'\n   AND NOT EXISTS (\n     SELECT 1\n     FROM language l\n     WHERE item.id = l.item\n       AND l.language = 'fr'\n   );
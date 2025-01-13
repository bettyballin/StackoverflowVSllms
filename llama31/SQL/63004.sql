SELECT \n  item.id,\n  item.part_number,\n  COALESCE(lang_fr.data, lang_en.data) AS name,\n  COALESCE(lang2_fr.data, lang2_en.data) AS description\nFROM \n  item\n  LEFT JOIN language lang_fr\n    ON item.id = lang_fr.item AND lang_fr.language = 'fr'\n  LEFT JOIN language lang_en\n    ON item.id = lang_en.item AND lang_en.language = 'en'\n  LEFT JOIN language lang2_fr\n    ON item.id = lang2_fr.item AND lang2_fr.language = 'fr'\n  LEFT JOIN language lang2_en\n    ON item.id = lang2_en.item AND lang2_en.language = 'en'\nWHERE \n  item.part_number = '34KM003KL'
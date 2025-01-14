SELECT \n    t1.product_id,\n    t2_translated_name.translated_text AS name,\n    t2_translated_description.translated_text AS description\nFROM \n    products t1\nJOIN \n    translations t2_translated_name ON t1.name_key = t2_translated_name.key_name AND t2_translated_name.language_code = 'fr'\nJOIN \n    translations t2_translated_description ON t1.description_key = t2_translated_description.key_name AND t2_translated_description.language_code = 'fr';
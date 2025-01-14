WITH ranked_products AS (\n    SELECT \n        ID, \n        PRODUCT_NAME,\n        COLOR, \n        SALE_COUNT,\n        CASE WHEN lower(PRODUCT_NAME) = lower('mp3 player') THEN 0 ELSE 1 END as exact_match,\n        ROW_NUMBER() OVER (PARTITION BY lower(replace(PRODUCT_NAME, ' ', '')) ORDER BY sale_count DESC) as rn\n    FROM product_table\n    WHERE lower(PRODUCT_NAME) LIKE lower('%mp3 player%')\n)\nSELECT \n    ID, \n    PRODUCT_NAME,\n    COLOR, \n    SALE_COUNT\nFROM ranked_products\nWHERE (exact_match = 0 OR rn = 1)\nORDER BY exact_match, sale_count DESC;
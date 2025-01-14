WITH RankedImages AS (\n    SELECT \n        pm.property_name,\n        im.property_id_ref,\n        im.image_file,\n        ROW_NUMBER() OVER (PARTITION BY im.property_id_ref ORDER BY NEWID()) AS rn\n    FROM property_master pm\n    INNER JOIN image_master im ON pm.property_id = im.property_id_ref\n    INNER JOIN customer_master cm ON pm.customer_id = cm.customer_id\n)\nSELECT \n    property_id_ref,\n    image_file,\n    property_name\nFROM RankedImages\nWHERE rn = 1\nORDER BY NEWID()
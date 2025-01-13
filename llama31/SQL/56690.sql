SELECT streetNames\nFROM Customers\nORDER BY CAST(REGEXP_REPLACE(streetNames, '[^0-9]', '') AS INTEGER),\n         streetNames;
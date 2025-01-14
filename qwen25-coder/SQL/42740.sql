SELECT \n    product_brand, \n    (CASE WHEN COUNT(product_brand) > 50 THEN 1 ELSE 0 END) AS brand_count \nFROM \n    products \nGROUP BY \n    product_brand\nHAVING \n    COUNT(product_brand) > 50;
SELECT \n    p.name AS ProductName,\n    STRING_AGG(c.name, ', ' ORDER BY c.id) AS Categories\nFROM \n    product p\nJOIN \n    product_to_category ptc ON p.id = ptc.prod_id\nJOIN \n    category c ON ptc.cat_id = c.id\nGROUP BY \n    p.id, p.name;
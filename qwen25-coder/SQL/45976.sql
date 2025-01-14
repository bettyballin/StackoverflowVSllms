SELECT DISTINCT pt.productID \nFROM products_tree pt\nWHERE pt.categoryID IN (1040, 1050, 1168)\nAND NOT EXISTS (\n    SELECT 1 \n    FROM products_tree \n    WHERE productID = pt.productID\n      AND categoryID NOT IN (1040, 1050, 1168)\n);
WITH q AS\n        (\n        SELECT  c.*, p.id AS Unowned,\n                ROW_NUMBER() OVER (PARTITION BY p.id ORDER BY c.id) AS rn\n        FROM    Customers c\n        CROSS JOIN\n                Products p\n        LEFT JOIN \n                CustomerProducts cp\n        ON      cp.customer = c.id\n                AND cp.product = p.id\n        WHERE   cp.customer IS NULL\n        )\nUPDATE  q\nSET     UnownedProduct = Unowned\nWHERE   rn = 1